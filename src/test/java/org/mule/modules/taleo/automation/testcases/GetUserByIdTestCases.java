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

import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.mule.api.MuleEvent;
import org.mule.api.processor.MessageProcessor;
import org.mule.modules.taleo.model.UserBean;

public class GetUserByIdTestCases extends TaleoTestParent {

    @Category({RegressionTests.class})
	@Test
	public void testGetUserById() {
    	
    	testObjects = (HashMap<String,Object>) context.getBean("getUserByIdTestData");
    	
		MessageProcessor flow = lookupFlowConstruct("get-user-by-id");
    	
		try {

			MuleEvent response = flow.process(getTestEvent(testObjects));
			UserBean userBean = (UserBean) response.getMessage().getPayload();
			
			assertTrue(userBean.getEmail().equals(testObjects.get("expectedEmail").toString()));

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail();
		}
     
	}
    
}