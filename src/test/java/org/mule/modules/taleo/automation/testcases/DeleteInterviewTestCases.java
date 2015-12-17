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
import org.mule.modules.taleo.model.CandidateBean;
import org.mule.modules.taleo.model.InterviewBean;

import javax.xml.datatype.DatatypeFactory;
import java.util.HashMap;
import java.util.UUID;

import static org.junit.Assert.fail;


public class DeleteInterviewTestCases extends TaleoTestParent {


    @Before
    public void setUp() {

        testObjects = new HashMap<String, Object>();
        CandidateBean candidateBean = (CandidateBean) context.getBean("createInterviewCandidateBean");
        candidateBean.setEmail(String.format("%s@email.com", UUID.randomUUID().toString().substring(0, 8)));

        testObjects.put("candidateRef", candidateBean);

        MessageProcessor flow = lookupFlowConstruct("create-candidate");

        try {

            MuleEvent response = flow.process(getTestEvent(testObjects));
            Long candidateId = (Long) response.getMessage().getPayload();
            testObjects.put("candidateId", candidateId);

            InterviewBean interviewBean = (InterviewBean) context.getBean("createInterviewInterviewBean");
            interviewBean.setCandidateId(candidateId);
            interviewBean.setStartDate(DatatypeFactory.newInstance().newXMLGregorianCalendar(new DateTime().toGregorianCalendar()));
            testObjects.put("interviewRef", interviewBean);

            MessageProcessor createInterviewFlow = lookupFlowConstruct("create-interview");
            MuleEvent createInterviewResponse = createInterviewFlow.process(getTestEvent(testObjects));
            Long interviewId = (Long) createInterviewResponse.getMessage().getPayload();
            testObjects.put("interviewId", interviewId);

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            fail();
        }

    }

    @After
    public void tearDown() {

        MessageProcessor deleteCandidateFlow = lookupFlowConstruct("delete-candidate");

        try {

            if (testObjects.containsKey("candidateId")) {
                deleteCandidateFlow.process(getTestEvent(testObjects));
            }

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            fail();
        }

    }

    @Category({SmokeTests.class, RegressionTests.class})
    @Test(expected = org.mule.api.MessagingException.class)
    public void testDeleteInterview() throws Exception {

        MessageProcessor deleteBackgroundCheckFlow = lookupFlowConstruct("delete-interview");
        deleteBackgroundCheckFlow.process(getTestEvent(testObjects));

        MessageProcessor getBackgroundCheckByIdFlow = lookupFlowConstruct("get-interview-by-id");
        getBackgroundCheckByIdFlow.process(getTestEvent(testObjects));

    }

}