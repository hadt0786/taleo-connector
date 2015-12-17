/**
 * (c) 2003-2015 MuleSoft, Inc. The software in this package is published under
 * the terms of the CPAL v1.0 license, a copy of which has been included with this
 * distribution in the LICENSE.md file.
 */

package org.mule.modules.taleo.automation.testcases;

import org.joda.time.DateTime;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.mule.api.MuleEvent;
import org.mule.api.processor.MessageProcessor;
import org.mule.modules.taleo.model.AccountBean;
import org.mule.modules.taleo.model.RequisitionBean;

import javax.xml.datatype.DatatypeFactory;
import java.util.HashMap;

import static org.junit.Assert.fail;

public class CreateLinkTestCases extends TaleoTestParent {

    @Before
    public void setUp() {

        testObjects = new HashMap<String, Object>();
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

        try {

            createLink.process(getTestEvent(testObjects));

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            fail();
        }

    }

}