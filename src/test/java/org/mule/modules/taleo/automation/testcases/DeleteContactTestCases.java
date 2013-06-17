/**
 * Mule Taleo Cloud Connector
 *
 * Copyright (c) MuleSoft, Inc. All rights reserved. http://www.mulesoft.com
 */

package org.mule.modules.taleo.automation.testcases;

import static org.junit.Assert.fail;

import java.util.HashMap;

import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.mule.api.MuleEvent;
import org.mule.api.processor.MessageProcessor;
import org.mule.modules.taleo.model.ContactBean;

public class DeleteContactTestCases extends TaleoTestParent {
	
	@Before
	public void setUp() {
		
		testObjects = new HashMap<String,Object>();
		testObjects.put("contactRef", (ContactBean) context.getBean("deleteContactContactBean"));
    	
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
	
	
    @Category({SmokeTests.class, RegressionTests.class})
	@Test(expected=org.mule.api.MessagingException.class)
	public void testDeleteContact() throws Exception {
		
		MessageProcessor deleteContactFlow = lookupFlowConstruct("delete-contact");
		deleteContactFlow.process(getTestEvent(testObjects));

		MessageProcessor getContactByIdFlow = lookupFlowConstruct("get-contact-by-id");
		getContactByIdFlow.process(getTestEvent(testObjects));

	}
}