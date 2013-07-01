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
import org.mule.modules.taleo.model.BackgroundCheckBean;
import org.mule.modules.taleo.model.CandidateBean;
import org.mule.modules.taleo.model.LongArr;


public class GetBackgroundChecksByCandidateTestCases extends TaleoTestParent {
	
	private List<Long> expectedBackgroundChecksIds = new ArrayList<Long>();
	private int expectedBackgroundChecksAmount = (Integer) context.getBean("getBackgroundChecksByCandidateBackgroundChecksAmount");
	
	@Before
	public void setUp() {
    	
		MuleEvent createCandidateResponse, createBackgroundCheckResponse;
		
		MessageProcessor createCandidateFlow = lookupFlowConstruct("create-candidate");
		MessageProcessor createBackgroundCheckFlow = lookupFlowConstruct("create-background-check");
	
    	CandidateBean candidateBean = (CandidateBean) context.getBean("getBackgroundChecksByCandidateCandidateBean");
    	candidateBean.setEmail(String.format("%s@email.com", UUID.randomUUID().toString().substring(0, 8)));
    	
    	testObjects =  new HashMap<String,Object>();
    	testObjects.put("candidateRef", candidateBean);
    
		try {

			createCandidateResponse = createCandidateFlow.process(getTestEvent(testObjects));
			Long candidateId = (Long) createCandidateResponse.getMessage().getPayload();
			testObjects.put("candidateId", candidateId);
			
			BackgroundCheckBean backgroundCheckBean = (BackgroundCheckBean) context.getBean("getBackgroundChecksByCandidateBackgroundCheckBean");
			backgroundCheckBean.setCandidateId(candidateId);
			testObjects.put("backgroundCheckRef", backgroundCheckBean);

			for (int index=0; index<expectedBackgroundChecksAmount; index++) {
				
				createBackgroundCheckResponse = createBackgroundCheckFlow.process(getTestEvent(testObjects));
				Long backgroundCheckId = (Long) createBackgroundCheckResponse.getMessage().getPayload();	
				
				expectedBackgroundChecksIds.add(backgroundCheckId);
				
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
		MessageProcessor deleteBackgroundCheckFlow = lookupFlowConstruct("delete-background-check");
		
		try {		

			if (!expectedBackgroundChecksIds.isEmpty()) {
				 for (int index=0; index<expectedBackgroundChecksAmount; index++){
					 testObjects.put("backgroundCheckId", expectedBackgroundChecksIds.get(index));
					 deleteBackgroundCheckFlow.process(getTestEvent(testObjects));
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
	public void testGetBackgroundChecksByCandidate() {
    	
		MessageProcessor flow = lookupFlowConstruct("get-background-checks-by-candidate");
    	
		try {

			MuleEvent response = flow.process(getTestEvent(testObjects));
			LongArr longArr = (LongArr) response.getMessage().getPayload();
			ArrayOfXsdLong arrayOfXsdLong = longArr.getArray();
			List<Long> retrievedBackgroundChecksIds = arrayOfXsdLong.getItem();
			
			assertTrue(retrievedBackgroundChecksIds.containsAll(expectedBackgroundChecksIds));

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail();
		}
     
	}
    
}