/**
 * Mule Taleo Cloud Connector
 *
 * Copyright (c) MuleSoft, Inc. All rights reserved. http://www.mulesoft.com
 */

package org.mule.modules.taleo.automation.testcases;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import java.util.HashMap;
import java.util.UUID;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.mule.api.MuleEvent;
import org.mule.api.processor.MessageProcessor;
import org.mule.modules.taleo.model.AccountBean;
import org.mule.modules.taleo.model.AttachmentBean;
import org.mule.modules.taleo.model.CandidateBean;


public class UpdateAttachmentTestCases extends TaleoTestParent {
	
	 
	@Before
	public void setUp() {
    	
		MessageProcessor createCandidateFlow = lookupFlowConstruct("create-candidate");
		MessageProcessor createAttachmentFlow = lookupFlowConstruct("create-attachment");;
		
		MuleEvent createCandidateResponse, createAttachmentResponse;
		
    	testObjects =  new HashMap<String,Object>();
    	CandidateBean candidateBean = (CandidateBean) context.getBean("updateAttachmentCandidateBean");
    	candidateBean.setEmail(String.format("%s@email.com", UUID.randomUUID().toString().substring(0, 9)));
    	
    	testObjects.put("candidateRef", candidateBean);
    
		try {

			createCandidateResponse = createCandidateFlow.process(getTestEvent(testObjects));
			Long candidateId = (Long) createCandidateResponse.getMessage().getPayload();

			testObjects = (HashMap<String,Object>) context.getBean("updateAttachmentTestData");
			testObjects.put("candidateId", candidateId);
			testObjects.put("attachmentDescription", String.format("%s.docx", UUID.randomUUID().toString().substring(0, 10)));
			testObjects.put("attachmentName", String.format("%s.docx", UUID.randomUUID().toString().substring(0, 10)));

			createAttachmentResponse = createAttachmentFlow.process(getTestEvent(testObjects));
			Long attachmentId = (Long) createAttachmentResponse.getMessage().getPayload();
			
			testObjects.put("attachmentId", attachmentId);
			
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

    @Category({RegressionTests.class})
	@Test
	public void testUpdateAttachment() {
    	
		MessageProcessor updateAttachmentFlow = lookupFlowConstruct("update-attachment");
    	
		try {
			
			testObjects.put("attachmentDescription", String.format("%sUpdated.docx", UUID.randomUUID().toString().substring(0, 10)));

			updateAttachmentFlow.process(getTestEvent(testObjects));
			
			MessageProcessor getAttachmentFlow = lookupFlowConstruct("get-attachment");

			MuleEvent response = getAttachmentFlow.process(getTestEvent(testObjects));
			AttachmentBean attachmentBean = (AttachmentBean) response.getMessage().getPayload();
			
			assertEquals((Long) attachmentBean.getId(), (Long) testObjects.get("attachmentId"));
			assertTrue(attachmentBean.getDescription().toString().equals(testObjects.get("attachmentDescription")));

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail();
		}
     
	}
    
}