/**
 * Mule Taleo Cloud Connector
 *
 * Copyright (c) MuleSoft, Inc. All rights reserved. http://www.mulesoft.com
 */

package org.mule.modules.taleo.automation.testcases;

import static org.junit.Assert.fail;

import java.util.HashMap;

import javax.xml.datatype.DatatypeFactory;

import org.joda.time.DateTime;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.mule.api.MuleEvent;
import org.mule.api.processor.MessageProcessor;
import org.mule.modules.taleo.model.AccountBean;
import org.mule.modules.taleo.model.RequisitionBean;

public class CreateDeleteLinkTestCases extends TaleoTestParent {
	
	@Before
	public void setUp() {
		
		testObjects = new HashMap<String,Object>();
		testObjects.put("accountRef", (AccountBean) context.getBean("createLinkAccountBean"));

		MessageProcessor createAccountFlow = lookupFlowConstruct("create-account");
		MessageProcessor createRequisitionFlow = lookupFlowConstruct("create-requisition");
		MuleEvent createAccountResponse, createRequisitionResponse;
    	
		try {

			createAccountResponse = createAccountFlow.process(getTestEvent(testObjects));
			Long accountId = (Long) createAccountResponse.getMessage().getPayload();
			testObjects.put("accountId", accountId);
			testObjects.put("entityIdOne", accountId);
			testObjects.put("entityTypeOne", "ACCT");

			RequisitionBean requisitionBean = (RequisitionBean) context.getBean("createLinkRequisitionBean");
	    	requisitionBean.setOpenedDate(DatatypeFactory.newInstance().newXMLGregorianCalendar(new DateTime().toGregorianCalendar()));
	    	testObjects.put("requisitionRef", requisitionBean);

			createRequisitionResponse = createRequisitionFlow.process(getTestEvent(testObjects));
			Long requisitionId = (Long) createRequisitionResponse.getMessage().getPayload();
			testObjects.put("requisitionId", requisitionId);
			testObjects.put("entityIdTwo", requisitionId);
			testObjects.put("entityTypeTwo", "REQU");
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail();
		}
		
	}	
	
	
	@After
	public void tearDown() {
		
		MessageProcessor deleteAccountFlow = lookupFlowConstruct("delete-account");
		MessageProcessor deleteRequisitionFlow = lookupFlowConstruct("delete-requisition");
		
		try {		
			
			
			
			if (testObjects.containsKey("accountId")) {
				
				deleteAccountFlow.process(getTestEvent(testObjects));
				
			}
			
			if (testObjects.containsKey("requisitionId")) {

				deleteRequisitionFlow.process(getTestEvent(testObjects));
				
			}
			
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
				e.printStackTrace();
				fail();
		}
		
	}

    @Category({SmokeTests.class, RegressionTests.class})
	@Test
	public void testCreateDeleteLink() {
    	
		MessageProcessor createLink = lookupFlowConstruct("create-link");
		MessageProcessor deleteLink = lookupFlowConstruct("delete-link");
    	
		try {

			createLink.process(getTestEvent(testObjects));
			deleteLink.process(getTestEvent(testObjects));

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail();
		}
     
	}
    
}