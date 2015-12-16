/**
 * (c) 2003-2015 MuleSoft, Inc. The software in this package is published under
 * the terms of the CPAL v1.0 license, a copy of which has been included with this
 * distribution in the LICENSE.md file.
 */

package org.mule.modules.taleo.automation.testcases;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.mule.api.MuleEvent;
import org.mule.api.processor.MessageProcessor;
import org.mule.modules.taleo.model.DepartmentBean;

import java.util.HashMap;
import java.util.UUID;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class GetDepartmentByNameTestCases extends TaleoTestParent {

    private String departmentName = UUID.randomUUID().toString();

    @Before
    public void setUp() {

        testObjects = new HashMap<String, Object>();

        DepartmentBean departmentBean = (DepartmentBean) context.getBean("getDepartmentByNameDepartmentBean");
        departmentBean.setDepartmentName(departmentName);
        testObjects.put("departmentName", departmentName);

        testObjects.put("departmentRef", departmentBean);

        MessageProcessor flow = lookupFlowConstruct("create-department");

        try {

            MuleEvent response = flow.process(getTestEvent(testObjects));
            testObjects.put("departmentId", (Long) response.getMessage().getPayload());

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            fail();
        }

    }


    @After
    public void tearDown() {

        MessageProcessor flow = lookupFlowConstruct("delete-department");

        try {

            if (testObjects.containsKey("departmentId")) {

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
    public void testGetDepartmentByName() {

        MessageProcessor flow = lookupFlowConstruct("get-departments");

        try {

            MuleEvent response = flow.process(getTestEvent(testObjects));
            DepartmentBean departmentBean = (DepartmentBean) response.getMessage().getPayload();

            assertEquals(departmentBean.getDepartmentName(), departmentName);

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            fail();
        }

    }

}