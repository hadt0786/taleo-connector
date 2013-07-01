/**
 * Mule Taleo Cloud Connector
 *
 * Copyright (c) MuleSoft, Inc. All rights reserved. http://www.mulesoft.com
 */

package org.mule.modules.taleo.automation.testcases;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.HashMap;
import java.util.UUID;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.mule.api.MuleEvent;
import org.mule.api.processor.MessageProcessor;
import org.mule.modules.taleo.model.AttachmentBean;
import org.mule.modules.taleo.model.CandidateBean;


public class GetAttachmentTestCases extends TaleoTestParent {
	
	 
	@Before
	public void setUp() {
    	
		MessageProcessor createCandidateFlow = lookupFlowConstruct("create-candidate");
		MessageProcessor createAttachmentFlow = lookupFlowConstruct("create-attachment");;
		
		MuleEvent createCandidateResponse, createAttachmentResponse;
		
    	testObjects =  new HashMap<String,Object>();
    	CandidateBean candidateBean = (CandidateBean) context.getBean("getAttachmentCandidateBean");
    	candidateBean.setEmail(String.format("%s@email.com", UUID.randomUUID().toString().substring(0, 9)));
    	
    	testObjects.put("candidateRef", candidateBean);
    
		try {

			createCandidateResponse = createCandidateFlow.process(getTestEvent(testObjects));
			Long candidateId = (Long) createCandidateResponse.getMessage().getPayload();

			testObjects = (HashMap<String,Object>) context.getBean("getAttachmentTestData");
			testObjects.put("candidateId", candidateId);

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
	public void testGetAttachment() {
    	
		MessageProcessor flow = lookupFlowConstruct("get-attachment");
    	
		try {

			MuleEvent response = flow.process(getTestEvent(testObjects));
			 AttachmentBean attachmentBean = (AttachmentBean) response.getMessage().getPayload();
			
			 assertEquals((Long) attachmentBean.getId(), (Long) testObjects.get("attachmentId"));

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail();
		}
     
	}
    
}