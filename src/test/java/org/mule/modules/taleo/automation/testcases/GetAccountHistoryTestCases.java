/**
 * Mule Taleo Cloud Connector
 *
 * Copyright (c) MuleSoft, Inc. All rights reserved. http://www.mulesoft.com
 */

package org.mule.modules.taleo.automation.testcases;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.HashMap;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.mule.api.MuleEvent;
import org.mule.api.processor.MessageProcessor;
import org.mule.modules.taleo.model.AccountBean;
import org.mule.modules.taleo.model.ArrayOfHistoryBean;
import org.mule.modules.taleo.model.HistoryBean;
import org.mule.modules.taleo.model.HistoryBeanArr;

public class GetAccountHistoryTestCases extends TaleoTestParent {
	
	@Before
	public void setUp() {
		
		testObjects = new HashMap<String,Object>();
		testObjects.put("accountRef", (AccountBean) context.getBean("getAccountHistoryAccountBean"));
    	
		MessageProcessor flow = lookupFlowConstruct("create-account");
    	
		try {

			MuleEvent response = flow.process(getTestEvent(testObjects));
			testObjects.put("accountId", (Long) response.getMessage().getPayload());
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail();
		}
		
	}	
	
	
	@After
	public void tearDown() {
		
		MessageProcessor flow = lookupFlowConstruct("delete-account");
		
		try {		
			
			if (testObjects.containsKey("accountId")) {
				
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
	public void testGetAccountHistory() {
    	
    	String UPDATED_PHONE_NUMBER = "111-111-1111";
    	
		MessageProcessor getAccountByIdFLow = lookupFlowConstruct("get-account-by-id");
		MessageProcessor updateAccountFlow = lookupFlowConstruct("update-account");
		MessageProcessor getAccountHistoryFlow = lookupFlowConstruct("get-account-history");
    	
		MuleEvent getAccountByResponse, updateAccountResponse, getAccountHistoryResponse;
		AccountBean accountBean;
		
		try {

			getAccountByResponse = getAccountByIdFLow.process(getTestEvent(testObjects));
			accountBean = (AccountBean) getAccountByResponse.getMessage().getPayload();
			
			accountBean.setPhone(UPDATED_PHONE_NUMBER);
			testObjects.put("accountRef", accountBean);
			
			updateAccountResponse = updateAccountFlow.process(getTestEvent(testObjects));
			updateAccountResponse.getMessage().getPayload();
			
			getAccountHistoryResponse = getAccountHistoryFlow.process(getTestEvent(testObjects));
			HistoryBeanArr historyBeanArr = (HistoryBeanArr) getAccountHistoryResponse.getMessage().getPayload();
			
			ArrayOfHistoryBean arrayOfHistoryBean = historyBeanArr.getArray();
			
			List<HistoryBean> historyBeans = arrayOfHistoryBean.getItem(); 

			HistoryBean historyBean = (HistoryBean) historyBeans.get(0);
			assertTrue(historyBean.getText().contains("Account updated"));

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail();
		}
     
	}
    
}