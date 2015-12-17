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

import static org.junit.Assert.fail;

public class PostUnpostRequisitionTestCases extends TaleoTestParent {

    @Before
    public void setUp() {

        testObjects = new HashMap<String, Object>();
        MessageProcessor flow = lookupFlowConstruct("create-requisition");

        try {

            RequisitionBean requisitionBean = (RequisitionBean) context.getBean("postUnpostRequisitionRequisitionBean");
            requisitionBean.setOpenedDate(DatatypeFactory.newInstance().newXMLGregorianCalendar(new DateTime().toGregorianCalendar()));
            testObjects.put("requisitionRef", requisitionBean);

            MuleEvent response = flow.process(getTestEvent(testObjects));
            testObjects.put("requisitionId", (Long) response.getMessage().getPayload());
            testObjects.putAll((HashMap<String, Object>) context.getBean("postUnpostRequisitionTestData"));

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
    public void testPostUnpostRequisition() {

        MessageProcessor postRequisitionFlow = lookupFlowConstruct("post-requisition");
        MessageProcessor unpostRequisitionFlow = lookupFlowConstruct("unpost-requisition");

        try {

            postRequisitionFlow.process(getTestEvent(testObjects));
            unpostRequisitionFlow.process(getTestEvent(testObjects));

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            fail();
        }

    }

}