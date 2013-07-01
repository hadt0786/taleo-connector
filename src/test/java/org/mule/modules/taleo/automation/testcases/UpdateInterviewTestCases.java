/**
 * Mule Taleo Cloud Connector
 *
 * Copyright (c) MuleSoft, Inc. All rights reserved. http://www.mulesoft.com
 */

package org.mule.modules.taleo.automation.testcases;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.HashMap;
import java.util.UUID;

import javax.xml.datatype.DatatypeFactory;

import org.joda.time.DateTime;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.mule.api.MuleEvent;
import org.mule.api.processor.MessageProcessor;
import org.mule.modules.taleo.model.CandidateBean;
import org.mule.modules.taleo.model.InterviewBean;


public class UpdateInterviewTestCases extends TaleoTestParent {
	
	private InterviewBean interviewBean;
	
	@Before
	public void setUp() {
    	
    	testObjects =  new HashMap<String,Object>();
    	CandidateBean candidateBean = (CandidateBean) context.getBean("updateInterviewCandidateBean");
    	candidateBean.setEmail(String.format("%s@email.com", UUID.randomUUID().toString().substring(0, 8)));
    	
    	testObjects.put("candidateRef", candidateBean);

		MessageProcessor flow = lookupFlowConstruct("create-candidate");
    	
		try {

			MuleEvent response = flow.process(getTestEvent(testObjects));
			Long candidateId = (Long) response.getMessage().getPayload();
			testObjects.put("candidateId", candidateId);
			
			interviewBean = (InterviewBean) context.getBean("updateInterviewInterviewBean");
			interviewBean.setCandidateId(candidateId);
			interviewBean.setStartDate(DatatypeFactory.newInstance().newXMLGregorianCalendar(new DateTime().toGregorianCalendar()));
			testObjects.put("interviewRef", interviewBean);
			
			MessageProcessor createInterviewFlow = lookupFlowConstruct("create-interview");
			MuleEvent createInterviewResponse = createInterviewFlow.process(getTestEvent(testObjects));
			Long interviewId = (Long) createInterviewResponse.getMessage().getPayload();
			
			interviewBean.setId(interviewId);
			testObjects.put("interviewId", interviewId);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail();
		}
     
	}
	
	@After
	public void tearDown() {
		
		MessageProcessor deleteCandidateFlow = lookupFlowConstruct("delete-candidate");
		MessageProcessor deleteInterviewFlow = lookupFlowConstruct("delete-interview");
		
		try {		

			if (testObjects.containsKey("interviewId")) {
				deleteInterviewFlow.process(getTestEvent(testObjects));	
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
	
    @Category({RegressionTests.class})
	@Test
	public void testUpdateInterview() {
    	
    	String UPDATED_INTERVIEW_TYPE = "PhoneScreen";
    	
		MessageProcessor getInterviewByIdFLow = lookupFlowConstruct("get-interview-by-id");
		MessageProcessor updateInterviewFlow = lookupFlowConstruct("update-interview");
    	
		MuleEvent getInterviewByIdResponse;
		InterviewBean updatedInterviewBean;
		
		interviewBean.setInterviewRoom(UPDATED_INTERVIEW_TYPE);
		
		try {

			updateInterviewFlow.process(getTestEvent(testObjects));

			getInterviewByIdResponse = getInterviewByIdFLow.process(getTestEvent(testObjects));
			updatedInterviewBean = (InterviewBean) getInterviewByIdResponse.getMessage().getPayload();
			
			assertEquals((Long) updatedInterviewBean.getId(), (Long) interviewBean.getId());
			assertEquals(UPDATED_INTERVIEW_TYPE, updatedInterviewBean.getInterviewRoom());

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail();
		}
     
	}
    
}