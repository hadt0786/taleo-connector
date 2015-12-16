/**
 * (c) 2003-2015 MuleSoft, Inc. The software in this package is published under
 * the terms of the CPAL v1.0 license, a copy of which has been included with this
 * distribution in the LICENSE.md file.
 */

package org.mule.modules.taleo.automation.testcases;

import org.joda.time.DateTime;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.rules.ExpectedException;
import org.mule.api.MuleEvent;
import org.mule.api.processor.MessageProcessor;
import org.mule.modules.taleo.model.CandidateBean;
import org.mule.modules.taleo.model.OfferBean;
import org.mule.modules.taleo.model.RequisitionBean;

import javax.xml.datatype.DatatypeFactory;
import java.util.HashMap;
import java.util.UUID;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

public class DeleteOfferTestCases extends TaleoTestParent {

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Before
    public void setUp() {

        setupForOffer("deleteOfferCandidateBean", "deleteOfferRequisitionBean");

        OfferBean offer = (OfferBean) context.getBean("deleteOfferOfferBean");
        offer.setCandidateId((Long) testObjects.get("candidateId"));
        offer.setRequisitionId((Long) testObjects.get("requisitionId"));
        testObjects.put("offerRef", offer);

        MessageProcessor flow = lookupFlowConstruct("create-offer");

        try {

            MuleEvent response = flow.process(getTestEvent(testObjects));
            Long offerId = (Long) response.getMessage().getPayload();

            assertNotNull(offerId);

            testObjects.put("offerId", offerId);

        } catch (Exception e) {
            e.printStackTrace();
            fail();
        }
    }

    private void setupForOffer(String candidateBeanVariableName, String requisitionBeanVariableName) {
        MuleEvent createCandidateResponse, createRequisitionResponse;

        MessageProcessor createCandidateFlow = lookupFlowConstruct("create-candidate");
        MessageProcessor createRequisitionFlow = lookupFlowConstruct("create-requisition");

        CandidateBean candidateBean = (CandidateBean) context
                .getBean(candidateBeanVariableName);
        candidateBean.setEmail(String.format("%s@email.com", UUID.randomUUID()
                .toString().substring(0, 8)));

        testObjects = new HashMap<String, Object>();
        testObjects.put("candidateRef", candidateBean);

        try {

            createCandidateResponse = createCandidateFlow
                    .process(getTestEvent(testObjects));
            Long candidateId = (Long) createCandidateResponse.getMessage()
                    .getPayload();
            testObjects.put("candidateId", candidateId);

            RequisitionBean requisitionBean = (RequisitionBean) context
                    .getBean(requisitionBeanVariableName);
            requisitionBean.setOpenedDate(DatatypeFactory.newInstance()
                    .newXMLGregorianCalendar(
                            new DateTime().toGregorianCalendar()));
            testObjects.put("requisitionRef", requisitionBean);

            createRequisitionResponse = createRequisitionFlow
                    .process(getTestEvent(testObjects));
            Long requisitionId = (Long) createRequisitionResponse.getMessage()
                    .getPayload();
            testObjects.put("requisitionId", requisitionId);
        } catch (Exception e) {
            e.printStackTrace();
            fail();
        }
    }

    @Category({SmokeTests.class, RegressionTests.class})
    @Test(expected = org.mule.api.MessagingException.class)
    public void testDeleteOffer() throws Exception {

        MessageProcessor deleteOfferFlow = lookupFlowConstruct("delete-offer");
        deleteOfferFlow.process(getTestEvent(testObjects));

        MessageProcessor getOfferByIdFlow = lookupFlowConstruct("get-offer-by-id");
        getOfferByIdFlow.process(getTestEvent(testObjects));

    }

    @After
    public void tearDown() {

        MessageProcessor deleteRequisitionFlow = lookupFlowConstruct("delete-requisition");
        MessageProcessor deleteCandidateFlow = lookupFlowConstruct("delete-candidate");
        try {

            if (testObjects.containsKey("requisitionId")) {
                deleteRequisitionFlow.process(getTestEvent(testObjects));
            }

            if (testObjects.containsKey("candidateId")) {
                deleteCandidateFlow.process(getTestEvent(testObjects));
            }

        } catch (Exception e) {
            e.printStackTrace();
            fail();
        }
    }
}