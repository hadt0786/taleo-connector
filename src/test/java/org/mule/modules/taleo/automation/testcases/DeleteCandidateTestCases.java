/**
 * (c) 2003-2015 MuleSoft, Inc. The software in this package is published under
 * the terms of the CPAL v1.0 license, a copy of which has been included with this
 * distribution in the LICENSE.md file.
 */

package org.mule.modules.taleo.automation.testcases;

import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.mule.api.MuleEvent;
import org.mule.api.processor.MessageProcessor;
import org.mule.modules.taleo.model.CandidateBean;

import java.util.HashMap;
import java.util.UUID;

import static org.junit.Assert.fail;

public class DeleteCandidateTestCases extends TaleoTestParent {

    @Before
    public void setUp() {

        CandidateBean candidateBean = (CandidateBean) context.getBean("deleteCandidateCandidateBean");
        candidateBean.setEmail(String.format("%s@email.com", UUID.randomUUID().toString().substring(0, 8)));

        testObjects = new HashMap<String, Object>();
        testObjects.put("candidateRef", candidateBean);

        MessageProcessor flow = lookupFlowConstruct("create-candidate");

        try {

            MuleEvent response = flow.process(getTestEvent(testObjects));
            testObjects.put("candidateId", (Long) response.getMessage().getPayload());

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            fail();
        }

    }


    @Category({SmokeTests.class, RegressionTests.class})
    @Test(expected = org.mule.api.MessagingException.class)
    public void testDeleteCandidate() throws Exception {

        MessageProcessor deleteCandidateFlow = lookupFlowConstruct("delete-candidate");
        deleteCandidateFlow.process(getTestEvent(testObjects));

        MessageProcessor getCandidateByIdFlow = lookupFlowConstruct("get-candidate-by-id");
        getCandidateByIdFlow.process(getTestEvent(testObjects));

    }
}