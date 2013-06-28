/**
 * Mule Taleo Cloud Connector
 *
 * Copyright (c) MuleSoft, Inc. All rights reserved. http://www.mulesoft.com
 */

package org.mule.modules.taleo.automation.testcases;

import static org.junit.Assert.fail;

import java.util.HashMap;
import java.util.UUID;

import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.mule.api.MuleEvent;
import org.mule.api.processor.MessageProcessor;
import org.mule.modules.taleo.model.CandidateBean;

public class DeleteCandidateTestCases extends TaleoTestParent {
	
	@Before
	public void setUp() {
		
    	CandidateBean candidateBean = (CandidateBean) context.getBean("deleteCandidateCandidateBean");
    	candidateBean.setEmail(String.format("%s@email.com", UUID.randomUUID().toString().substring(0, 8)));
    	
    	testObjects =  new HashMap<String,Object>();
    	testObjects.put("candidateRef", candidateBean);
    	
		MessageProcessor flow = lookupFlowConstruct("create-candidate");
    	
		try {

			MuleEvent response = flow.process(getTestEvent(testObjects));
			testObjects.put("candidateId", (Long) response.getMessage().getPayload());
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail();
		}
		
	}	
	
	
    @Category({SmokeTests.class, RegressionTests.class})
	@Test(expected=org.mule.api.MessagingException.class)
	public void testDeleteCandidate() throws Exception {
		
		MessageProcessor deleteCandidateFlow = lookupFlowConstruct("delete-candidate");
		deleteCandidateFlow.process(getTestEvent(testObjects));

		MessageProcessor getCandidateByIdFlow = lookupFlowConstruct("get-candidate-by-id");
		getCandidateByIdFlow.process(getTestEvent(testObjects));

	}
}