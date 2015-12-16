/**
 * (c) 2003-2015 MuleSoft, Inc. The software in this package is published under
 * the terms of the CPAL v1.0 license, a copy of which has been included with this
 * distribution in the LICENSE.md file.
 */

package org.mule.modules.taleo.automation.testcases;

import org.joda.time.DateTime;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.mule.api.MuleEvent;
import org.mule.api.processor.MessageProcessor;
import org.mule.modules.taleo.model.ArrayOfXsdLong;
import org.mule.modules.taleo.model.CandidateBean;
import org.mule.modules.taleo.model.LongArr;
import org.mule.modules.taleo.model.RequisitionBean;

import javax.xml.datatype.DatatypeFactory;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.fail;


public class RemoveCandidateTestCases extends TaleoTestParent {

    private List<Long> associatedRequisitionIds = new ArrayList<Long>();
    private int associatedRequisitionsAmount = (Integer) context.getBean("removeCandidateRequisitionsAmount");

    @Before
    public void setUp() {

        LongArr requisitionIdsLongArray = new LongArr();
        ArrayOfXsdLong arrayOfXsdLong = new ArrayOfXsdLong();

        MuleEvent createCandidateResponse, createRequisitionResponse;

        MessageProcessor createCandidateFlow = lookupFlowConstruct("create-candidate");
        MessageProcessor createRequisitionFlow = lookupFlowConstruct("create-requisition");

        CandidateBean candidateBean = (CandidateBean) context.getBean("removeCandidateCandidateBean");
        candidateBean.setEmail(String.format("%s@email.com", UUID.randomUUID().toString().substring(0, 8)));

        testObjects = new HashMap<String, Object>();
        testObjects.put("candidateRef", candidateBean);

        try {

            createCandidateResponse = createCandidateFlow.process(getTestEvent(testObjects));
            Long candidateId = (Long) createCandidateResponse.getMessage().getPayload();
            testObjects.put("candidateId", candidateId);

            for (int index = 0; index < associatedRequisitionsAmount; index++) {

                RequisitionBean requisitionBean = (RequisitionBean) context.getBean("removeCandidateRequisitionBean");
                requisitionBean.setOpenedDate(DatatypeFactory.newInstance().newXMLGregorianCalendar(new DateTime().toGregorianCalendar()));
                testObjects.put("requisitionRef", requisitionBean);

                createRequisitionResponse = createRequisitionFlow.process(getTestEvent(testObjects));
                Long requisitionId = (Long) createRequisitionResponse.getMessage().getPayload();

                associatedRequisitionIds.add(requisitionId);
                arrayOfXsdLong.getItem().add(requisitionId);

            }

            requisitionIdsLongArray.setArray(arrayOfXsdLong);
            testObjects.put("requisitionIdsRef", requisitionIdsLongArray);

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            fail();
        }

    }

    @After
    public void tearDown() {

        MessageProcessor deleteRequisitionFlow = lookupFlowConstruct("delete-requisition");
        MessageProcessor deleteCandidateFlow = lookupFlowConstruct("delete-candidate");

        try {

            if (!associatedRequisitionIds.isEmpty() && testObjects.containsKey("candidateId")) {
                for (int index = 0; index < associatedRequisitionsAmount; index++) {
                    testObjects.put("requisitionId", associatedRequisitionIds.get(index));
                    deleteRequisitionFlow.process(getTestEvent(testObjects));
                }
            }

            if (testObjects.containsKey("candidateId")) {
                deleteCandidateFlow.process(getTestEvent(testObjects));
            }

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            fail();
        }

    }

    @Category({RegressionTests.class})
    @Test
    public void testRemoveCandidate() {

        MessageProcessor submitCandidateFlow = lookupFlowConstruct("submit-candidate");
        MessageProcessor removeCandidateFlow = lookupFlowConstruct("remove-candidate");
        MessageProcessor getRequisitionsFlow = lookupFlowConstruct("get-requisitions");

        try {

            submitCandidateFlow.process(getTestEvent(testObjects));

            for (int index = 0; index < associatedRequisitionsAmount; index++) {

                long associatedRequisitionId = associatedRequisitionIds.get(index);

                testObjects.put("requisitionId", associatedRequisitionId);

                removeCandidateFlow.process(getTestEvent(testObjects));

                MuleEvent response = getRequisitionsFlow.process(getTestEvent(testObjects));
                LongArr longArr = (LongArr) response.getMessage().getPayload();
                ArrayOfXsdLong arrayOfXsdLong = longArr.getArray();
                List<Long> candidateRequisitionIds = arrayOfXsdLong.getItem();

                assertFalse(candidateRequisitionIds.contains(associatedRequisitionId));

            }

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            fail();
        }

    }

}