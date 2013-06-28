/**
 * Mule Taleo Cloud Connector
 *
 * Copyright (c) MuleSoft, Inc. All rights reserved. http://www.mulesoft.com
 */

package org.mule.modules.taleo.automation.testcases;

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
import org.mule.modules.taleo.model.ArrayOfXsdLong;
import org.mule.modules.taleo.model.CandidateBean;
import org.mule.modules.taleo.model.LongArr;


public class GetEntityAttachmentTestCases extends TaleoTestParent {
	
	private List<Long> expectedAttachmentIds = new ArrayList<Long>();
	private int attachmentsAmount = (Integer) context.getBean("getEntityAttachmentsAttachmentsAmount"); 
	
	@Before
	public void setUp() {
    	
		MuleEvent response;
		
    	testObjects =  new HashMap<String,Object>();
    	CandidateBean candidateBean = (CandidateBean) context.getBean("getEntityAttachmentsCandidateBean");
    	candidateBean.setEmail(String.format("%s@email.com", UUID.randomUUID().toString().substring(0, 8)));
    	
    	testObjects.put("candidateRef", candidateBean);
    	
		MessageProcessor createCandidateFlow = lookupFlowConstruct("create-candidate");
    	
		try {

			response = createCandidateFlow.process(getTestEvent(testObjects));
			Long candidateId = (Long) response.getMessage().getPayload();

			testObjects = (HashMap<String,Object>) context.getBean("getEntityAttachmentsTestData");
			testObjects.put("candidateId", candidateId);
			testObjects.put("entityId", candidateId);
			
			MessageProcessor createEntityAttachmentFlow = lookupFlowConstruct("create-entity-attachment");
			
			for (int index=0; index<attachmentsAmount; index++) {
				
				testObjects.put("attachmentDescription", String.format("%s.docx", UUID.randomUUID().toString().substring(0, 10)));
				testObjects.put("attachmentName", String.format("%s.docx", UUID.randomUUID().toString().substring(0, 10)));
				
				MuleEvent createEntityAttachmentResponse = createEntityAttachmentFlow.process(getTestEvent(testObjects));
				Long attachmentId = (Long) createEntityAttachmentResponse.getMessage().getPayload();
				
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
	public void testGetEntityAttachments() {
    	
		MessageProcessor flow = lookupFlowConstruct("get-entity-attachments");
    	
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