/**
 * (c) 2003-2012 MuleSoft, Inc. This software is protected under international
 * copyright law. All use of this software is subject to MuleSoft's Master
 * Subscription Agreement (or other Terms of Service) separately entered
 * into between you and MuleSoft. If such an agreement is not in
 * place, you may not use the software.
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
import org.mule.modules.taleo.model.BackgroundCheckBean;
import org.mule.modules.taleo.model.CandidateBean;


public class GetBackgroundCheckByIdTestCases extends TaleoTestParent {
	
	@Before
	public void setUp() {
    	
		MessageProcessor flow;
		MuleEvent response;
		
    	testObjects =  new HashMap<String,Object>();
    	CandidateBean candidateBean = (CandidateBean) context.getBean("getBackgroundCheckByIdCandidateBean");
    	candidateBean.setEmail(String.format("%s@email.com", UUID.randomUUID().toString().substring(0, 8)));
    	
    	testObjects.put("candidateRef", candidateBean);

		try {

			flow = lookupFlowConstruct("create-candidate");
			response = flow.process(getTestEvent(testObjects));
			Long candidateId = (Long) response.getMessage().getPayload();
			testObjects.put("candidateId", candidateId);
			
			BackgroundCheckBean backgroundCheckBean = (BackgroundCheckBean) context.getBean("getBackgroundCheckByIdBackgroundCheckBean");
			backgroundCheckBean.setCandidateId(candidateId);
			testObjects.put("backgroundCheckRef", backgroundCheckBean);
			
			flow = lookupFlowConstruct("create-background-check");
			response = flow.process(getTestEvent(testObjects));
			Long backgroundCheckId = (Long) response.getMessage().getPayload();	
			testObjects.put("backgroundCheckId", backgroundCheckId);
			
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
	
    @Category({RegressionTests.class})
	@Test
	public void testGetBackgroundCheckById() {
    	
		MessageProcessor flow = lookupFlowConstruct("get-background-check-by-id");
    	
		try {

			MuleEvent response = flow.process(getTestEvent(testObjects));
			BackgroundCheckBean backgroundCheckBean = (BackgroundCheckBean) response.getMessage().getPayload();
			
			assertEquals((Long) backgroundCheckBean.getCandidateId(), (Long) testObjects.get("candidateId"));

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail();
		}
     
	}
    
}