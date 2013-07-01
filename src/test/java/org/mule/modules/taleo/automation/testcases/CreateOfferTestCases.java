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

import javax.xml.datatype.DatatypeFactory;

import org.joda.time.DateTime;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.mule.api.MuleEvent;
import org.mule.api.processor.MessageProcessor;
import org.mule.modules.taleo.model.CandidateBean;
import org.mule.modules.taleo.model.OfferBean;
import org.mule.modules.taleo.model.RequisitionBean;

public class CreateOfferTestCases extends TaleoTestParent {

	@Before
	public void setUp() {
		setupForOffer("createOfferCandidateBean","createOfferRequisitionBean");
	}

	private void setupForOffer(String candidateBeanVariableName, String requisitionBeanVariableName) {
		MuleEvent createCandidateResponse, createRequisitionResponse;

		MessageProcessor createCandidateFlow = lookupFlowConstruct("create-candidate");
		MessageProcessor createRequisitionFlow = lookupFlowConstruct("create-requisition");

		CandidateBean candidateBean = (CandidateBean) context
				.getBean(candidateBeanVariableName);
		candidateBean.setEmail(String.format("%s@email.com", UUID.randomUUID()
				.toString().substring(0, 8)));

		testObjects = new HashMap<String, Object>();
		testObjects.put("candidateRef", candidateBean);

		try {

			createCandidateResponse = createCandidateFlow
					.process(getTestEvent(testObjects));
			Long candidateId = (Long) createCandidateResponse.getMessage()
					.getPayload();
			testObjects.put("candidateId", candidateId);

			RequisitionBean requisitionBean = (RequisitionBean) context
					.getBean(requisitionBeanVariableName);
			requisitionBean.setOpenedDate(DatatypeFactory.newInstance()
					.newXMLGregorianCalendar(
							new DateTime().toGregorianCalendar()));
			testObjects.put("requisitionRef", requisitionBean);

			createRequisitionResponse = createRequisitionFlow
					.process(getTestEvent(testObjects));
			Long requisitionId = (Long) createRequisitionResponse.getMessage()
					.getPayload();
			testObjects.put("requisitionId", requisitionId);
		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}
	}

	@After
	public void tearDown() {

		MessageProcessor flow = lookupFlowConstruct("delete-offer");
		MessageProcessor deleteRequisitionFlow = lookupFlowConstruct("delete-requisition");
		MessageProcessor deleteCandidateFlow = lookupFlowConstruct("delete-candidate");
		try {

			if (testObjects.containsKey("offerId")) {

				flow.process(getTestEvent(testObjects));
			}

			if (testObjects.containsKey("requisitionId")) {
				deleteRequisitionFlow.process(getTestEvent(testObjects));
			}

			if (testObjects.containsKey("candidateId")) {
				deleteCandidateFlow.process(getTestEvent(testObjects));
			}

		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}
	}

	@Category({ SmokeTests.class, RegressionTests.class })
	@Test
	public void testCreateOffer() {

		OfferBean offer=(OfferBean) context.getBean("createOfferOfferBean");
		offer.setCandidateId((Long) testObjects.get("candidateId"));
		offer.setRequisitionId((Long) testObjects.get("requisitionId"));
		testObjects.put("offerRef",offer);

		MessageProcessor flow = lookupFlowConstruct("create-offer");

		try {

			MuleEvent response = flow.process(getTestEvent(testObjects));
			Long offerId = (Long) response.getMessage().getPayload();

			assertNotNull(offerId);

			testObjects.put("offerId", offerId);

		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}

	}

}