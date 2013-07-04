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

import java.util.HashMap;
import java.util.List;
import java.util.UUID;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.mule.api.MuleEvent;
import org.mule.api.processor.MessageProcessor;
import org.mule.modules.taleo.model.ArrayOfHistoryBean;
import org.mule.modules.taleo.model.CandidateBean;
import org.mule.modules.taleo.model.HistoryBean;
import org.mule.modules.taleo.model.HistoryBeanArr;

public class GetCandidateHistoryTestCases extends TaleoTestParent {
	
	@Before
	public void setUp() {
		
    	testObjects =  new HashMap<String,Object>();
    	CandidateBean candidateBean = (CandidateBean) context.getBean("getCandidateHistoryCandidateBean");
    	candidateBean.setEmail(String.format("%s@email.com", UUID.randomUUID().toString().substring(0, 8)));
    	
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
	public void testGetCandidateHistory() {
    	
    	String UPDATED_CELLPHONE_NUMBER = "111-111-1111";
    	
		MessageProcessor getCandidateByIdFLow = lookupFlowConstruct("get-candidate-by-id");
		MessageProcessor updateCandidateFlow = lookupFlowConstruct("update-candidate");
		MessageProcessor getCandidateHistoryFlow = lookupFlowConstruct("get-candidate-history");
    	
		MuleEvent getCandidateByResponse, updateCandidateResponse, getCandidateHistoryResponse;
		CandidateBean candidateBean;
		
		try {

			getCandidateByResponse = getCandidateByIdFLow.process(getTestEvent(testObjects));
			candidateBean = (CandidateBean) getCandidateByResponse.getMessage().getPayload();
			
			candidateBean.setPhone(UPDATED_CELLPHONE_NUMBER);
			testObjects.put("candidateRef", candidateBean);
			
			updateCandidateResponse = updateCandidateFlow.process(getTestEvent(testObjects));
			updateCandidateResponse.getMessage().getPayload();
			
			getCandidateHistoryResponse = getCandidateHistoryFlow.process(getTestEvent(testObjects));
			HistoryBeanArr historyBeanArr = (HistoryBeanArr) getCandidateHistoryResponse.getMessage().getPayload();
			
			ArrayOfHistoryBean arrayOfHistoryBean = historyBeanArr.getArray();
			
			List<HistoryBean> historyBeans = arrayOfHistoryBean.getItem(); 

			HistoryBean historyBean = (HistoryBean) historyBeans.get(0);
			assertTrue(historyBean.getText().contains("Candidate data updated"));

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail();
		}
     
	}
    
}