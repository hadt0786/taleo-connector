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
import java.util.List;

import javax.xml.datatype.DatatypeFactory;

import org.joda.time.DateTime;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.mule.api.MuleEvent;
import org.mule.api.processor.MessageProcessor;
import org.mule.modules.taleo.model.ArrayOfHistoryBean;
import org.mule.modules.taleo.model.HistoryBean;
import org.mule.modules.taleo.model.HistoryBeanArr;
import org.mule.modules.taleo.model.RequisitionBean;

public class GetRequisitionHistoryTestCases extends TaleoTestParent {
	
	@Before
	public void setUp() {
		
		testObjects = new HashMap<String,Object>();
		MessageProcessor flow = lookupFlowConstruct("create-requisition");
    	
		try {
			
			RequisitionBean requisitionBean = (RequisitionBean) context.getBean("getRequisitionHistoryRequisitionBean");
	    	requisitionBean.setOpenedDate(DatatypeFactory.newInstance().newXMLGregorianCalendar(new DateTime().toGregorianCalendar()));
	    	testObjects.put("requisitionRef", requisitionBean);

			MuleEvent response = flow.process(getTestEvent(testObjects));
			testObjects.put("requisitionId", (Long) response.getMessage().getPayload());
			
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

    @Category({RegressionTests.class})
	@Test
	public void testGetRequisitionHistory() {
    	
    	String UPDATED_DESCRIPTION = "TESTING";
    	
		MessageProcessor getRequisitionByIdFLow = lookupFlowConstruct("get-requisition-by-id");
		MessageProcessor updateRequisitionFlow = lookupFlowConstruct("update-requisition");
		MessageProcessor getRequisitionHistoryFlow = lookupFlowConstruct("get-requisition-history");
    	
		MuleEvent getRequisitionByResponse, updateRequisitionResponse, getRequisitionHistoryResponse;
		RequisitionBean requisitionBean;
		
		try {

			getRequisitionByResponse = getRequisitionByIdFLow.process(getTestEvent(testObjects));
			requisitionBean = (RequisitionBean) getRequisitionByResponse.getMessage().getPayload();
			
			requisitionBean.setDescription(UPDATED_DESCRIPTION);
			testObjects.put("requisitionRef", requisitionBean);
			
			updateRequisitionResponse = updateRequisitionFlow.process(getTestEvent(testObjects));
			updateRequisitionResponse.getMessage().getPayload();
			
			getRequisitionHistoryResponse = getRequisitionHistoryFlow.process(getTestEvent(testObjects));
			HistoryBeanArr historyBeanArr = (HistoryBeanArr) getRequisitionHistoryResponse.getMessage().getPayload();
			
			ArrayOfHistoryBean arrayOfHistoryBean = historyBeanArr.getArray();
			
			List<HistoryBean> historyBeans = arrayOfHistoryBean.getItem(); 

			HistoryBean historyBean = (HistoryBean) historyBeans.get(0);
			assertTrue(historyBean.getText().contains("Requisition data updated"));

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail();
		}
     
	}
    
}