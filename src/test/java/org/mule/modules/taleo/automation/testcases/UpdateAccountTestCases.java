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

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.mule.api.MuleEvent;
import org.mule.api.processor.MessageProcessor;
import org.mule.modules.taleo.model.AccountBean;

public class UpdateAccountTestCases extends TaleoTestParent {
	
	@Before
	public void setUp() {
		
		testObjects = new HashMap<String,Object>();
		testObjects.put("accountRef", (AccountBean) context.getBean("updateAccountAccountBean"));
    	
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
	public void testUpdateAccount() {
    	
    	String UPDATED_PHONE_NUMBER = "111-111-1111";
    	
		MessageProcessor getAccountByIdFLow = lookupFlowConstruct("get-account-by-id");
		MessageProcessor updateAccountFlow = lookupFlowConstruct("update-account");
    	
		MuleEvent getAccountByResponse;
		AccountBean accountBean, updatedAccountBean;
		
		try {

			getAccountByResponse = getAccountByIdFLow.process(getTestEvent(testObjects));
			accountBean = (AccountBean) getAccountByResponse.getMessage().getPayload();
			
			accountBean.setPhone(UPDATED_PHONE_NUMBER);
			testObjects.put("accountRef", accountBean);
			
			updateAccountFlow.process(getTestEvent(testObjects));
			
			getAccountByResponse = getAccountByIdFLow.process(getTestEvent(testObjects));
			updatedAccountBean = (AccountBean) getAccountByResponse.getMessage().getPayload();
			
			assertEquals(UPDATED_PHONE_NUMBER, updatedAccountBean.getPhone());

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail();
		}
     
	}
    
}