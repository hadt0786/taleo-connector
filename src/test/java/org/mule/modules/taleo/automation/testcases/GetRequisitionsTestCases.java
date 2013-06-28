/**
 * Mule Taleo Cloud Connector
 *
 * Copyright (c) MuleSoft, Inc. All rights reserved. http://www.mulesoft.com
 */

package org.mule.modules.taleo.automation.testcases;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

import javax.xml.datatype.DatatypeFactory;

import org.joda.time.DateTime;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.mule.api.MuleEvent;
import org.mule.api.processor.MessageProcessor;
import org.mule.modules.taleo.model.ArrayOfXsdLong;
import org.mule.modules.taleo.model.RequisitionBean;
import org.mule.modules.taleo.model.CandidateBean;
import org.mule.modules.taleo.model.LongArr;


public class GetRequisitionsTestCases extends TaleoTestParent {
	
	private List<Long> expectedRequisitionIds = new ArrayList<Long>();
	private int expectedRequisitionsAmount = (Integer) context.getBean("getRequisitionsRequisitionsAmount");
	
	@Before
	public void setUp() {
    	
		LongArr requisitionIdsLongArray = new LongArr();
		ArrayOfXsdLong arrayOfXsdLong = new ArrayOfXsdLong();
		
		MuleEvent createCandidateResponse, createRequisitionResponse;
		
		MessageProcessor createCandidateFlow = lookupFlowConstruct("create-candidate");
		MessageProcessor createRequisitionFlow = lookupFlowConstruct("create-requisition");
		MessageProcessor upsertCandidateToRequisitionFlow = lookupFlowConstruct("upsert-candidate-to-requisitions");
	
    	CandidateBean candidateBean = (CandidateBean) context.getBean("getRequisitionsCandidateBean");
    	candidateBean.setEmail(String.format("%s@email.com", UUID.randomUUID().toString().substring(0, 8)));
    	
    	testObjects =  new HashMap<String,Object>();
    	testObjects.put("candidateRef", candidateBean);
    
		try {

			createCandidateResponse = createCandidateFlow.process(getTestEvent(testObjects));
			Long candidateId = (Long) createCandidateResponse.getMessage().getPayload();
			testObjects.put("candidateId", candidateId);
			
			for (int index=0; index<expectedRequisitionsAmount; index++) {
				
				RequisitionBean requisitionBean = (RequisitionBean) context.getBean("getRequisitionsRequisitionBean");
				requisitionBean.setOpenedDate(DatatypeFactory.newInstance().newXMLGregorianCalendar(new DateTime().toGregorianCalendar()));
		    	testObjects.put("requisitionRef", requisitionBean);
				
				createRequisitionResponse = createRequisitionFlow.process(getTestEvent(testObjects));
				Long requisitionId = (Long) createRequisitionResponse.getMessage().getPayload();
				
				expectedRequisitionIds.add(requisitionId);
				arrayOfXsdLong.getItem().add(requisitionId);
				
			}
			
			requisitionIdsLongArray.setArray(arrayOfXsdLong);
			
			HashMap<String,Object> upsertCandidateToRequisitionsTestObjects = (HashMap<String,Object>) context.getBean("getRequisitionsUpsertCandidateToRequisitions");
			upsertCandidateToRequisitionsTestObjects.putAll(testObjects);
			upsertCandidateToRequisitionsTestObjects.put("requisitionIdsRef",requisitionIdsLongArray);
			upsertCandidateToRequisitionFlow.process(getTestEvent(upsertCandidateToRequisitionsTestObjects));
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail();
		}
     
	}
	
	@After
	public void tearDown() {
		
		MessageProcessor removeCandidateFlow = lookupFlowConstruct("remove-candidate");
		MessageProcessor deleteRequisitionFlow = lookupFlowConstruct("delete-requisition");
		MessageProcessor deleteCandidateFlow = lookupFlowConstruct("delete-candidate");
		
		try {		

			if (!expectedRequisitionIds.isEmpty() && testObjects.containsKey("candidateId")) {
				 for (int index=0; index<expectedRequisitionsAmount; index++){
					 testObjects.put("requisitionId", expectedRequisitionIds.get(index));
					 removeCandidateFlow.process(getTestEvent(testObjects));	
					 deleteRequisitionFlow.process(getTestEvent(testObjects));
				 }
			}
			
			if (testObjects.containsKey("candidateId")) {	
				deleteCandidateFlow.process(getTestEvent(testObjects));	
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
				e.printStackTrace();
				fail();
		}
		
	}

    @Category({SmokeTests.class, RegressionTests.class})
	@Test
	public void testGetRequisitions() {
    	
		MessageProcessor flow = lookupFlowConstruct("get-requisitions");
    	
		try {

			MuleEvent response = flow.process(getTestEvent(testObjects));
			LongArr longArr = (LongArr) response.getMessage().getPayload();
			ArrayOfXsdLong arrayOfXsdLong = longArr.getArray();
			List<Long> retrievedInterviewIds = arrayOfXsdLong.getItem();
			
			assertTrue(retrievedInterviewIds.containsAll(expectedRequisitionIds));

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail();
		}
     
	}
    
}