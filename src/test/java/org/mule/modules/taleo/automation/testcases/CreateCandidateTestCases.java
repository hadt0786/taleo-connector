/**
 * (c) 2003-2015 MuleSoft, Inc. The software in this package is published under
 * the terms of the CPAL v1.0 license, a copy of which has been included with this
 * distribution in the LICENSE.md file.
 */

package org.mule.modules.taleo.automation.testcases;

import org.junit.After;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.mule.api.MuleEvent;
import org.mule.api.processor.MessageProcessor;
import org.mule.modules.taleo.model.CandidateBean;

import java.util.HashMap;
import java.util.UUID;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;


public class CreateCandidateTestCases extends TaleoTestParent {

    @After
    public void tearDown() {

        MessageProcessor flow = lookupFlowConstruct("delete-candidate");

        try {

            if (testObjects.containsKey("candidateId")) {

                MuleEvent response = flow.process(getTestEvent(testObjects));

            }

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            fail();
        }

    }

    @Category({SmokeTests.class, RegressionTests.class})
    @Test
    public void testCreateCandidate() {

        CandidateBean candidateBean = (CandidateBean) context.getBean("createCandidateCandidateBean");
        candidateBean.setEmail(String.format("%s@email.com", UUID.randomUUID().toString().substring(0, 8)));

        testObjects = new HashMap<String, Object>();
        testObjects.put("candidateRef", candidateBean);

        MessageProcessor flow = lookupFlowConstruct("create-candidate");

        try {

            MuleEvent response = flow.process(getTestEvent(testObjects));
            Long candidateId = (Long) response.getMessage().getPayload();

            assertNotNull(candidateId);

            testObjects.put("candidateId", candidateId);

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            fail();
        }

    }

}