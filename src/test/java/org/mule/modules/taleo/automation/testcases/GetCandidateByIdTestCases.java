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
import org.mule.modules.taleo.model.CandidateBean;

public class GetCandidateByIdTestCases extends TaleoTestParent {
	
	private Long expectedCandidateId;
	private String expectedCandidateEmail;
	
	@Before
	public void setUp() {
		
    	CandidateBean candidateBean = (CandidateBean) context.getBean("getCandidateByIdCandidateBean");
    	expectedCandidateEmail = String.format("%s@email.com", UUID.randomUUID().toString().substring(0, 8));
    	candidateBean.setEmail(expectedCandidateEmail);
    	
    	testObjects =  new HashMap<String,Object>();
    	testObjects.put("candidateRef", candidateBean);
    	
		MessageProcessor flow = lookupFlowConstruct("create-candidate");
    	
		try {

			MuleEvent response = flow.process(getTestEvent(testObjects));
			expectedCandidateId = (Long) response.getMessage().getPayload();
			testObjects.put("candidateId", expectedCandidateId);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail();
		}
		
	}	
	
	
	@After
	public void tearDown() {
		
		MessageProcessor flow = lookupFlowConstruct("delete-candidate");
		
		try {		
			
			if (testObjects.containsKey("candidateId")) {
				
				flow.process(getTestEvent(testObjects));
				
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
				e.printStackTrace();
				fail();
		}
		
	}

    @Category({RegressionTests.class})
	@Test
	public void testGetCandidateById() {
    	
		MessageProcessor flow = lookupFlowConstruct("get-candidate-by-id");
    	
		try {

			MuleEvent response = flow.process(getTestEvent(testObjects));
			CandidateBean candidateBean = (CandidateBean) response.getMessage().getPayload();

			assertEquals((Long) candidateBean.getId(), expectedCandidateId);
			assertEquals(candidateBean.getEmail(), expectedCandidateEmail);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail();
		}
     
	}
    
}