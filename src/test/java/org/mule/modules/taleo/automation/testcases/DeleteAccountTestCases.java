/**
 * Mule Taleo Cloud Connector
 *
 * Copyright (c) MuleSoft, Inc. All rights reserved. http://www.mulesoft.com
 */

package org.mule.modules.taleo.automation.testcases;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.HashMap;
import java.util.UUID;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.mule.api.MuleEvent;
import org.mule.api.MuleException;
import org.mule.api.processor.MessageProcessor;

import org.mule.modules.taleo.model.AccountBean;

public class DeleteAccountTestCases extends TaleoTestParent {
	
	@Before
	public void setUp() {
		
		testObjects = new HashMap<String,Object>();
		testObjects.put("accountRef", (AccountBean) context.getBean("deleteAccountAccountBean"));
    	
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
	
	
    @Category({SmokeTests.class, RegressionTests.class})
	@Test(expected=org.mule.api.MessagingException.class)
	public void testDeleteAccount() throws Exception {
		
		MessageProcessor deleteAccountFlow = lookupFlowConstruct("delete-account");
		deleteAccountFlow.process(getTestEvent(testObjects));

		MessageProcessor getAccountByIdFlow = lookupFlowConstruct("get-account-by-id");
		getAccountByIdFlow.process(getTestEvent(testObjects));
		
			
		
	}
}