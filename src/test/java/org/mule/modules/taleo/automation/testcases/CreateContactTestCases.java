/**
 * Mule Taleo Cloud Connector
 *
 * Copyright (c) MuleSoft, Inc. All rights reserved. http://www.mulesoft.com
 */

package org.mule.modules.taleo.automation.testcases;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import java.util.HashMap;

import org.junit.After;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.mule.api.MuleEvent;
import org.mule.api.processor.MessageProcessor;
import org.mule.modules.taleo.model.ContactBean;


public class CreateContactTestCases extends TaleoTestParent {
	
	@After
	public void tearDown() {
		
		MessageProcessor flow = lookupFlowConstruct("delete-contact");
		
		try {		
			
			if (testObjects.containsKey("contactId")) {
				
				MuleEvent response = flow.process(getTestEvent(testObjects));
				
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
				e.printStackTrace();
				fail();
		}
		
	}

    @Category({SmokeTests.class, RegressionTests.class})
	@Test
	public void testCreateContact() {
    	
    	testObjects =  new HashMap<String,Object>();
    	testObjects.put("contact", (ContactBean) context.getBean("createContactContactBean"));
    	
		MessageProcessor flow = lookupFlowConstruct("create-contact");
    	
		try {

			MuleEvent response = flow.process(getTestEvent(testObjects));
			Long contactId = (Long) response.getMessage().getPayload();
			
			assertNotNull(contactId);
			
			testObjects.put("contactId", contactId);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail();
		}
     
	}
    
}