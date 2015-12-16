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
import org.mule.modules.taleo.model.ArrayOfHistoryBean;
import org.mule.modules.taleo.model.HistoryBean;
import org.mule.modules.taleo.model.HistoryBeanArr;
import org.mule.modules.taleo.model.RequisitionBean;

import javax.xml.datatype.DatatypeFactory;
import java.util.HashMap;
import java.util.List;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

public class GetRequisitionHistoryTestCases extends TaleoTestParent {

    @Before
    public void setUp() {

        testObjects = new HashMap<String, Object>();
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