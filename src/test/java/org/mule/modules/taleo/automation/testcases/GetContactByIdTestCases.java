/**
 * Mule Taleo Cloud Connector
 *
 * Copyright (c) MuleSoft, Inc. All rights reserved. http://www.mulesoft.com
 */

package org.mule.modules.taleo.automation.testcases;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import java.util.HashMap;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.mule.api.MuleEvent;
import org.mule.api.processor.MessageProcessor;
import org.mule.modules.taleo.model.ContactBean;

public class GetContactByIdTestCases extends TaleoTestParent {
	
	@Before
	public void setUp() {
		
		testObjects = new HashMap<String,Object>();
		testObjects.put("contactRef", (ContactBean) context.getBean("getContactByIdContactBean"));
    	
		MessageProcessor flow = lookupFlowConstruct("create-contact");
    	
		try {

			MuleEvent response = flow.process(getTestEvent(testObjects));
			testObjects.put("contactId", (Long) response.getMessage().getPayload());
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail();
		}
		
	}	
	
	
	@After
	public void tearDown() {
		
		MessageProcessor flow = lookupFlowConstruct("delete-contact");
		
		try {		
			
			if (testObjects.containsKey("contactId")) {
				
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
	public void testGetContactById() {
    	
		MessageProcessor flow = lookupFlowConstruct("get-contact-by-id");
    	
		try {

			MuleEvent response = flow.process(getTestEvent(testObjects));
			ContactBean contactBean = (ContactBean) response.getMessage().getPayload();
			
			assertEquals((Long) contactBean.getId(), (Long) testObjects.get("contactId"));

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail();
		}
     
	}
    
}