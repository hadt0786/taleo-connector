/**
 * Mule Taleo Cloud Connector
 *
 * Copyright (c) MuleSoft, Inc. All rights reserved. http://www.mulesoft.com
 */

package org.mule.modules.taleo.automation.testcases;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.HashMap;
import java.util.List;

import javax.xml.datatype.DatatypeFactory;

import org.joda.time.DateTime;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.rules.ExpectedException;
import org.mule.api.MuleEvent;
import org.mule.api.processor.MessageProcessor;
import org.mule.modules.taleo.model.LongArr;
import org.mule.modules.taleo.model.RequisitionBean;

public class AssociatedUserTestCases extends TaleoTestParent {
	
	@Rule
    public ExpectedException thrown= ExpectedException.none();
	
	@Before
	public void setUp() {
		
		testObjects = new HashMap<String,Object>();
		MessageProcessor flow = lookupFlowConstruct("create-requisition");
    	
		try {
			
			RequisitionBean requisitionBean = (RequisitionBean) context.getBean("associatedUserRequisitionBean");
	    	requisitionBean.setOpenedDate(DatatypeFactory.newInstance().newXMLGregorianCalendar(new DateTime().toGregorianCalendar()));
	    	testObjects.put("requisitionRef", requisitionBean);

			MuleEvent response = flow.process(getTestEvent(testObjects));
			testObjects.put("requisitionId", (Long) response.getMessage().getPayload());
			testObjects.putAll((HashMap<String,Object>) context.getBean("associatedUserTestData"));
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail();
		}
		
	}	
	
	
	@After
	public void tearDown() {
		
		MessageProcessor flow = lookupFlowConstruct("delete-requisition");
		
		try {		
			
			if (testObjects.containsKey("requisitionId")) {
				
				flow.process(getTestEvent(testObjects));
				
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
				e.printStackTrace();
				fail();
		}
		
	}

    @Category({SmokeTests.class, RegressionTests.class})
	@Test
	public void testAssociatedUser() {
    	
    	MuleEvent response;
    	
		MessageProcessor setAssociatedUserFlow = lookupFlowConstruct("set-associated-user");
		MessageProcessor getAssociatedUsersFlow = lookupFlowConstruct("get-associated-users");
		MessageProcessor removeAssociatedUserFlow = lookupFlowConstruct("remove-associated-user");
		
		try {

			setAssociatedUserFlow.process(getTestEvent(testObjects));
				
			response = getAssociatedUsersFlow.process(getTestEvent(testObjects));
			LongArr longArr = (LongArr) response.getMessage().getPayload();
			List<Long> item = longArr.getArray().getItem();
			
			assertEquals(item.get(0).toString(), testObjects.get("userId"));
			
			removeAssociatedUserFlow.process(getTestEvent(testObjects));

			response = getAssociatedUsersFlow.process(getTestEvent(testObjects));
			
			longArr = (LongArr) response.getMessage().getPayload();
			item = longArr.getArray().getItem();
			
			assertTrue(item.isEmpty());
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail();
		}
     
	}
    
}