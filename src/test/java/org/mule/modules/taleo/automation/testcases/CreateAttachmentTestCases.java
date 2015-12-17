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

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;


public class CreateAttachmentTestCases extends TaleoTestParent {


    @Before
    public void setUp() {

        testObjects = new HashMap<String, Object>();
        CandidateBean candidateBean = (CandidateBean) context.getBean("createAttachmentCandidateBean");
        candidateBean.setEmail(String.format("%s@email.com", UUID.randomUUID().toString().substring(0, 8)));

        testObjects.put("candidateRef", candidateBean);

        MessageProcessor flow = lookupFlowConstruct("create-candidate");

        try {

            MuleEvent response = flow.process(getTestEvent(testObjects));
            Long candidateId = (Long) response.getMessage().getPayload();

            testObjects = (HashMap<String, Object>) context.getBean("createAttachmentTestData");
            testObjects.put("candidateId", candidateId);

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            fail();
        }

    }

    @After
    public void tearDown() {

        MessageProcessor deleteCandidateFlow = lookupFlowConstruct("delete-candidate");
        MessageProcessor deleteAttachmentFlow = lookupFlowConstruct("delete-attachment");

        try {

            if (testObjects.containsKey("attachmentId")) {
                deleteAttachmentFlow.process(getTestEvent(testObjects));
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

    @Category({SmokeTests.class, RegressionTests.class})
    @Test
    public void testCreateAttachment() {

        MessageProcessor flow = lookupFlowConstruct("create-attachment");

        try {

            testObjects.put("attachmentDescription", String.format("%s.docx", UUID.randomUUID().toString().substring(0, 10)));
            testObjects.put("attachmentName", String.format("%s.docx", UUID.randomUUID().toString().substring(0, 10)));

            MuleEvent response = flow.process(getTestEvent(testObjects));
            Long attachmentId = (Long) response.getMessage().getPayload();

            assertNotNull(attachmentId);

            testObjects.put("attachmentId", attachmentId);

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            fail();
        }

    }

}