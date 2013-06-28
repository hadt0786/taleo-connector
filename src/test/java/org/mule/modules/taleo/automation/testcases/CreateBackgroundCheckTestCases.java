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
import org.mule.modules.taleo.model.BackgroundCheckBean;
import org.mule.modules.taleo.model.CandidateBean;


public class CreateBackgroundCheckTestCases extends TaleoTestParent {
	
	 
	@Before
	public void setUp() {
    	
    	testObjects =  new HashMap<String,Object>();
    	CandidateBean candidateBean = (CandidateBean) context.getBean("createBackgroundCheckCandidateBean");
    	candidateBean.setEmail(String.format("%s@email.com", UUID.randomUUID().toString().substring(0, 8)));
    	
    	testObjects.put("candidateRef", candidateBean);

		MessageProcessor flow = lookupFlowConstruct("create-candidate");
    	
		try {

			MuleEvent response = flow.process(getTestEvent(testObjects));
			Long candidateId = (Long) response.getMessage().getPayload();
			testObjects.put("candidateId", candidateId);
			
			BackgroundCheckBean backgroundCheckBean = (BackgroundCheckBean) context.getBean("createBackgroundCheckBackgroundCheckBean");
			backgroundCheckBean.setCandidateId(candidateId);
			testObjects.put("backgroundCheckRef", backgroundCheckBean);
			
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

			if (testObjects.containsKey("backgroundCheckId")) {
				deleteBackgroundCheckFlow.process(getTestEvent(testObjects));	
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
	public void testCreateBackgroundCheck() {
    	
		MessageProcessor flow = lookupFlowConstruct("create-background-check");
    	
		try {

			MuleEvent response = flow.process(getTestEvent(testObjects));
			Long backgroundCheckId = (Long) response.getMessage().getPayload();
			
			assertNotNull(backgroundCheckId);
			
			testObjects.put("backgroundCheckId", backgroundCheckId);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail();
		}
     
	}
    
}