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
import org.mule.modules.taleo.model.InterviewBean;
import org.mule.modules.taleo.model.LongArr;

import javax.xml.datatype.DatatypeFactory;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;


public class GetInterviewsByCandidateTestCases extends TaleoTestParent {

    private List<Long> expectedInterviewIds = new ArrayList<Long>();
    private int expectedInterviewsAmount = (Integer) context.getBean("getInterviewsByCandidateInterviewsAmount");

    @Before
    public void setUp() {

        MuleEvent createCandidateResponse, createInterviewResponse;

        MessageProcessor createCandidateFlow = lookupFlowConstruct("create-candidate");
        MessageProcessor createInterviewFlow = lookupFlowConstruct("create-interview");

        CandidateBean candidateBean = (CandidateBean) context.getBean("getInterviewsByCandidateCandidateBean");
        candidateBean.setEmail(String.format("%s@email.com", UUID.randomUUID().toString().substring(0, 8)));

        testObjects = new HashMap<String, Object>();
        testObjects.put("candidateRef", candidateBean);

        try {

            createCandidateResponse = createCandidateFlow.process(getTestEvent(testObjects));
            Long candidateId = (Long) createCandidateResponse.getMessage().getPayload();
            testObjects.put("candidateId", candidateId);

            InterviewBean interviewBean = (InterviewBean) context.getBean("getInterviewByIdInterviewBean");
            interviewBean.setCandidateId(candidateId);
            interviewBean.setStartDate(DatatypeFactory.newInstance().newXMLGregorianCalendar(new DateTime().toGregorianCalendar()));
            testObjects.put("interviewRef", interviewBean);

            for (int index = 0; index < expectedInterviewsAmount; index++) {

                createInterviewResponse = createInterviewFlow.process(getTestEvent(testObjects));
                Long interviewId = (Long) createInterviewResponse.getMessage().getPayload();

                expectedInterviewIds.add(interviewId);

            }

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            fail();
        }

    }

    @After
    public void tearDown() {

        MessageProcessor deleteCandidateFlow = lookupFlowConstruct("delete-candidate");
        MessageProcessor deleteInterviewFlow = lookupFlowConstruct("delete-interview");

        try {

            if (!expectedInterviewIds.isEmpty()) {
                for (int index = 0; index < expectedInterviewsAmount; index++) {
                    testObjects.put("interviewId", expectedInterviewIds.get(index));
                    deleteInterviewFlow.process(getTestEvent(testObjects));
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
    public void testGetInterviewsByCandidate() {

        MessageProcessor flow = lookupFlowConstruct("get-interviews-by-candidate");

        try {

            MuleEvent response = flow.process(getTestEvent(testObjects));
            LongArr longArr = (LongArr) response.getMessage().getPayload();
            ArrayOfXsdLong arrayOfXsdLong = longArr.getArray();
            List<Long> retrievedInterviewIds = arrayOfXsdLong.getItem();

            assertTrue(retrievedInterviewIds.containsAll(expectedInterviewIds));

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            fail();
        }

    }

}