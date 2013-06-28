/**
 * Mule Taleo Cloud Connector
 *
 * Copyright (c) MuleSoft, Inc. All rights reserved. http://www.mulesoft.com
 */

package org.mule.modules.taleo.automation.testcases;

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
import org.mule.modules.taleo.model.CandidateBean;


public class DeleteAttachmentTestCases extends TaleoTestParent {
	
	 
	@Before
	public void setUp() {
    	
    	testObjects =  new HashMap<String,Object>();
    	CandidateBean candidateBean = (CandidateBean) context.getBean("deleteAttachmentCandidateBean");
    	candidateBean.setEmail(String.format("%s@email.com", UUID.randomUUID().toString().substring(0, 8)));
    	
    	testObjects.put("candidateRef", candidateBean);
    	
		MessageProcessor createCandidateFlow = lookupFlowConstruct("create-candidate");
    	
		try {

			MuleEvent createCandidateResponse = createCandidateFlow.process(getTestEvent(testObjects));
			Long candidateId = (Long) createCandidateResponse.getMessage().getPayload();

			testObjects = (HashMap<String,Object>) context.getBean("deleteAttachmentTestData");
			testObjects.put("candidateId", candidateId);
			
			MessageProcessor deleteAttachmentFlow = lookupFlowConstruct("create-attachment");
			
			testObjects.put("attachmentDescription", String.format("%s.docx", UUID.randomUUID().toString().substring(0, 10)));
			testObjects.put("attachmentName", String.format("%s.docx", UUID.randomUUID().toString().substring(0, 10)));

			MuleEvent deleteAttachmentResponse = deleteAttachmentFlow.process(getTestEvent(testObjects));
			Long attachmentId = (Long) deleteAttachmentResponse.getMessage().getPayload();
			
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
	@Test(expected=org.mule.api.MessagingException.class)
	public void testDeleteAttachment() throws Exception {
		
		MessageProcessor deleteAttachmentFlow = lookupFlowConstruct("delete-attachment");
		deleteAttachmentFlow.process(getTestEvent(testObjects));

		MessageProcessor getAttachmentFlow = lookupFlowConstruct("get-attachment");
		getAttachmentFlow.process(getTestEvent(testObjects));

	}
    
}