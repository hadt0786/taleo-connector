/**
 * (c) 2003-2012 MuleSoft, Inc. This software is protected under international
 * copyright law. All use of this software is subject to MuleSoft's Master
 * Subscription Agreement (or other Terms of Service) separately entered
 * into between you and MuleSoft. If such an agreement is not in
 * place, you may not use the software.
 */

package org.mule.modules.taleo.automation.testcases;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.Arrays;
import java.util.HashMap;
import java.util.UUID;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.mule.api.MuleEvent;
import org.mule.api.processor.MessageProcessor;
import org.mule.modules.taleo.model.ByteArr;
import org.mule.modules.taleo.model.CandidateBean;


public class GetAttachmentDataTestCases extends TaleoTestParent {
	
	 
	@Before
	public void setUp() {
    	
		MessageProcessor createCandidateFlow = lookupFlowConstruct("create-candidate");
		MessageProcessor createAttachmentFlow = lookupFlowConstruct("create-attachment");;
		
		MuleEvent createCandidateResponse, createAttachmentResponse;
		
    	testObjects =  new HashMap<String,Object>();
    	CandidateBean candidateBean = (CandidateBean) context.getBean("getAttachmentDataCandidateBean");
    	candidateBean.setEmail(String.format("%s@email.com", UUID.randomUUID().toString().substring(0, 8)));
    	
    	testObjects.put("candidateRef", candidateBean);
    
		try {

			createCandidateResponse = createCandidateFlow.process(getTestEvent(testObjects));
			Long candidateId = (Long) createCandidateResponse.getMessage().getPayload();

			testObjects = (HashMap<String,Object>) context.getBean("getAttachmentDataTestData");
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
	public void testGetAttachmentData() {
    	
		MessageProcessor flow = lookupFlowConstruct("get-attachment-data");
    	
		try {

			MuleEvent response = flow.process(getTestEvent(testObjects));
			ByteArr actualByteArr = (ByteArr) response.getMessage().getPayload();
			byte[] actualByteArray = actualByteArr.getArray();
			
			ByteArr expectedByteArr = (ByteArr) testObjects.get("binaryResumeRef");
			byte[] expectedByteArray = expectedByteArr.getArray();
			
			assertTrue(Arrays.equals(actualByteArray, expectedByteArray));

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail();
		}
     
	}
    
}