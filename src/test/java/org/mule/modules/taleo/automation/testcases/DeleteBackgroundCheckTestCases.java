/**
 * (c) 2003-2015 MuleSoft, Inc. The software in this package is published under
 * the terms of the CPAL v1.0 license, a copy of which has been included with this
 * distribution in the LICENSE.md file.
 */

package org.mule.modules.taleo.automation.testcases;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.mule.api.MuleEvent;
import org.mule.api.processor.MessageProcessor;
import org.mule.modules.taleo.model.BackgroundCheckBean;
import org.mule.modules.taleo.model.CandidateBean;

import java.util.HashMap;
import java.util.UUID;

import static org.junit.Assert.fail;


public class DeleteBackgroundCheckTestCases extends TaleoTestParent {


    @Before
    public void setUp() {

        testObjects = new HashMap<String, Object>();
        CandidateBean candidateBean = (CandidateBean) context.getBean("deleteBackgroundCheckCandidateBean");
        candidateBean.setEmail(String.format("%s@email.com", UUID.randomUUID().toString().substring(0, 8)));

        testObjects.put("candidateRef", candidateBean);

        MessageProcessor flow = lookupFlowConstruct("create-candidate");

        try {

            MuleEvent response = flow.process(getTestEvent(testObjects));
            Long candidateId = (Long) response.getMessage().getPayload();
            testObjects.put("candidateId", candidateId);

            BackgroundCheckBean backgroundCheckBean = (BackgroundCheckBean) context.getBean("deleteBackgroundCheckBackgroundCheckBean");
            backgroundCheckBean.setCandidateId(candidateId);
            testObjects.put("backgroundCheckRef", backgroundCheckBean);

            MessageProcessor createBackgroundCheckFlow = lookupFlowConstruct("create-background-check");
            MuleEvent createBackgroundCheckResponse = createBackgroundCheckFlow.process(getTestEvent(testObjects));
            testObjects.put("backgroundCheckId", (Long) createBackgroundCheckResponse.getMessage().getPayload());

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
    public void testDeleteBackgroundCheck() throws Exception {

        MessageProcessor deleteBackgroundCheckFlow = lookupFlowConstruct("delete-background-check");
        deleteBackgroundCheckFlow.process(getTestEvent(testObjects));

        MessageProcessor getBackgroundCheckByIdFlow = lookupFlowConstruct("get-background-check-by-id");
        getBackgroundCheckByIdFlow.process(getTestEvent(testObjects));

    }

}