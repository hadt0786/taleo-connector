/**
 * Mule Taleo Cloud Connector
 *
 * Copyright (c) MuleSoft, Inc. All rights reserved. http://www.mulesoft.com
 */

package org.mule.modules.taleo.automation.testcases;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import java.util.HashMap;
import java.util.UUID;

import org.junit.After;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.mule.api.MuleEvent;
import org.mule.api.processor.MessageProcessor;
import org.mule.modules.taleo.model.DepartmentBean;


public class CreateDepartmentTestCases extends TaleoTestParent {
	
	@After
	public void tearDown() {
		
		MessageProcessor flow = lookupFlowConstruct("delete-department");
		
		try {		
			
			if (testObjects.containsKey("departmentId")) {
				
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
	public void testCreateDepartment() {

    	testObjects =  new HashMap<String,Object>();
    	
    	DepartmentBean departmentBean = (DepartmentBean) context.getBean("createDepartmentDepartmentBean");
    	departmentBean.setDepartmentName(UUID.randomUUID().toString());
    	
    	testObjects.put("departmentRef", departmentBean);
    	
		MessageProcessor flow = lookupFlowConstruct("create-department");
    	
		try {

			MuleEvent response = flow.process(getTestEvent(testObjects));
			Long departmentId = (Long) response.getMessage().getPayload();
			
			assertNotNull(departmentId);
			
			testObjects.put("departmentId", departmentId);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail();
		}
     
	}
    
}