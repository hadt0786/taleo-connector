/**
 * (c) 2003-2015 MuleSoft, Inc. The software in this package is published under
 * the terms of the CPAL v1.0 license, a copy of which has been included with this
 * distribution in the LICENSE.md file.
 */

package org.mule.modules.taleo.automation.testcases;

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

import javax.xml.datatype.DatatypeFactory;
import java.util.HashMap;
import java.util.List;

import static org.junit.Assert.*;

public class AssociatedUserTestCases extends TaleoTestParent {

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Before
    public void setUp() {

        testObjects = new HashMap<String, Object>();
        MessageProcessor flow = lookupFlowConstruct("create-requisition");

        try {

            RequisitionBean requisitionBean = (RequisitionBean) context.getBean("associatedUserRequisitionBean");
            requisitionBean.setOpenedDate(DatatypeFactory.newInstance().newXMLGregorianCalendar(new DateTime().toGregorianCalendar()));
            testObjects.put("requisitionRef", requisitionBean);

            MuleEvent response = flow.process(getTestEvent(testObjects));
            testObjects.put("requisitionId", (Long) response.getMessage().getPayload());
            testObjects.putAll((HashMap<String, Object>) context.getBean("associatedUserTestData"));

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