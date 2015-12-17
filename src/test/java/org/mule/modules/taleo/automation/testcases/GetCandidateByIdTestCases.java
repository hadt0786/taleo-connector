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
import org.mule.modules.taleo.model.CandidateBean;

import java.util.HashMap;
import java.util.UUID;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class GetCandidateByIdTestCases extends TaleoTestParent {

    private Long expectedCandidateId;
    private String expectedCandidateEmail;

    @Before
    public void setUp() {

        CandidateBean candidateBean = (CandidateBean) context.getBean("getCandidateByIdCandidateBean");
        expectedCandidateEmail = String.format("%s@email.com", UUID.randomUUID().toString().substring(0, 8));
        candidateBean.setEmail(expectedCandidateEmail);

        testObjects = new HashMap<String, Object>();
        testObjects.put("candidateRef", candidateBean);

        MessageProcessor flow = lookupFlowConstruct("create-candidate");

        try {

            MuleEvent response = flow.process(getTestEvent(testObjects));
            expectedCandidateId = (Long) response.getMessage().getPayload();
            testObjects.put("candidateId", expectedCandidateId);

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            fail();
        }

    }


    @After
    public void tearDown() {

        MessageProcessor flow = lookupFlowConstruct("delete-candidate");

        try {

            if (testObjects.containsKey("candidateId")) {

                flow.process(getTestEvent(testObjects));

            }

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            fail();
        }

    }

    @Category({RegressionTests.class})
    @Test
    public void testGetCandidateById() {

        MessageProcessor flow = lookupFlowConstruct("get-candidate-by-id");

        try {

            MuleEvent response = flow.process(getTestEvent(testObjects));
            CandidateBean candidateBean = (CandidateBean) response.getMessage().getPayload();

            assertEquals((Long) candidateBean.getId(), expectedCandidateId);
            assertEquals(candidateBean.getEmail(), expectedCandidateEmail);

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            fail();
        }

    }

}