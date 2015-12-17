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
import org.mule.modules.taleo.model.RequisitionBean;

import javax.xml.datatype.DatatypeFactory;
import java.util.HashMap;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class UpdateRequisitionTestCases extends TaleoTestParent {

    @Before
    public void setUp() {

        testObjects = new HashMap<String, Object>();
        MessageProcessor flow = lookupFlowConstruct("create-requisition");

        try {

            RequisitionBean requisitionBean = (RequisitionBean) context.getBean("updateRequisitionRequisitionBean");
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
    public void testUpdateRequisition() {

        String UPDATED_DESCRIPTION = "TESTING";

        MessageProcessor getRequisitionByIdFLow = lookupFlowConstruct("get-requisition-by-id");
        MessageProcessor updateRequisitionFlow = lookupFlowConstruct("update-requisition");

        MuleEvent getRequisitionByResponse;
        RequisitionBean requisitionBean, updatedRequisitionBean;

        try {

            getRequisitionByResponse = getRequisitionByIdFLow.process(getTestEvent(testObjects));
            requisitionBean = (RequisitionBean) getRequisitionByResponse.getMessage().getPayload();

            requisitionBean.setDescription(UPDATED_DESCRIPTION);
            testObjects.put("requisitionRef", requisitionBean);

            updateRequisitionFlow.process(getTestEvent(testObjects));

            getRequisitionByResponse = getRequisitionByIdFLow.process(getTestEvent(testObjects));
            updatedRequisitionBean = (RequisitionBean) getRequisitionByResponse.getMessage().getPayload();

            assertEquals(UPDATED_DESCRIPTION, updatedRequisitionBean.getDescription());

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            fail();
        }

    }

}