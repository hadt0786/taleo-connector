/**
 * Mule Taleo Cloud Connector
 *
 * Copyright (c) MuleSoft, Inc. All rights reserved. http://www.mulesoft.com
 */

package org.mule.modules.taleo.automation.testcases;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.mule.api.MuleEvent;
import org.mule.api.processor.MessageProcessor;
import org.mule.modules.taleo.model.AccountBean;
import org.mule.modules.taleo.model.ArrayOfXsdLong;
import org.mule.modules.taleo.model.AttachmentBean;
import org.mule.modules.taleo.model.CandidateBean;
import org.mule.modules.taleo.model.LongArr;


public class GetAttachmentsTestCases extends TaleoTestParent {
	
	private List<Long> expectedAttachmentIds = new ArrayList<Long>();
	private int attachmentsAmount = (Integer) context.getBean("getAttachmentsAttachmentsAmount");
	
	@Before
	public void setUp() {
    	
		MessageProcessor createCandidateFlow = lookupFlowConstruct("create-candidate");
		MessageProcessor createAttachmentFlow = lookupFlowConstruct("create-attachment");;
		
		MuleEvent createCandidateResponse, createAttachmentResponse;
		
    	testObjects =  new HashMap<String,Object>();
    	CandidateBean candidateBean = (CandidateBean) context.getBean("getAttachmentsCandidateBean");
    	candidateBean.setEmail(String.format("%s@email.com", UUID.randomUUID().toString().substring(0, 9)));
    	
    	testObjects.put("candidateRef", candidateBean);
    
		try {

			createCandidateResponse = createCandidateFlow.process(getTestEvent(testObjects));
			Long candidateId = (Long) createCandidateResponse.getMessage().getPayload();

			testObjects = (HashMap<String,Object>) context.getBean("getAttachmentsTestData");
			testObjects.put("candidateId", candidateId);

			for (int index=0; index<attachmentsAmount; index++) {
				
				testObjects.put("attachmentDescription", String.format("%s.docx", UUID.randomUUID().toString().substring(0, 10)));
				testObjects.put("attachmentName", String.format("%s.docx", UUID.randomUUID().toString().substring(0, 10)));
				
				createAttachmentResponse = createAttachmentFlow.process(getTestEvent(testObjects));
				Long attachmentId = (Long) createAttachmentResponse.getMessage().getPayload();
				
				expectedAttachmentIds.add(attachmentId);
				
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
		MessageProcessor deleteAttachmentFlow = lookupFlowConstruct("delete-attachment");
		
		try {		

			if (!expectedAttachmentIds.isEmpty()) {
				 for (int index=0; index<attachmentsAmount; index++){
					 testObjects.put("attachmentId", expectedAttachmentIds.get(index));
					 deleteAttachmentFlow.process(getTestEvent(testObjects));
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

    @Category({SmokeTests.class, RegressionTests.class})
	@Test
	public void testGetAttachments() {
    	
		MessageProcessor flow = lookupFlowConstruct("get-attachments");
    	
		try {

			MuleEvent response = flow.process(getTestEvent(testObjects));
			LongArr longArr = (LongArr) response.getMessage().getPayload();
			ArrayOfXsdLong arrayOfXsdLong = longArr.getArray();
			List<Long> retrievedAttachmentId = arrayOfXsdLong.getItem();
			
			assertTrue(retrievedAttachmentId.containsAll(expectedAttachmentIds));

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail();
		}
     
	}
    
}