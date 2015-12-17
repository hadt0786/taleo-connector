/**
 * (c) 2003-2015 MuleSoft, Inc. The software in this package is published under
 * the terms of the CPAL v1.0 license, a copy of which has been included with this
 * distribution in the LICENSE.md file.
 */

package org.mule.modules.taleo.automation.testcases;

import org.junit.After;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.mule.api.MuleEvent;
import org.mule.api.processor.MessageProcessor;
import org.mule.modules.taleo.model.DepartmentBean;

import java.util.HashMap;
import java.util.UUID;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;


public class CreateDepartmentTestCases extends TaleoTestParent {

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

    @Category({SmokeTests.class, RegressionTests.class})
    @Test
    public void testCreateDepartment() {

        testObjects = new HashMap<String, Object>();

        DepartmentBean departmentBean = (DepartmentBean) context.getBean("createDepartmentDepartmentBean");
        departmentBean.setDepartmentName(UUID.randomUUID().toString());

        testObjects.put("departmentRef", departmentBean);

        MessageProcessor flow = lookupFlowConstruct("create-department");

        try {

            MuleEvent response = flow.process(getTestEvent(testObjects));
            Long departmentId = (Long) response.getMessage().getPayload();

            assertNotNull(departmentId);

            testObjects.put("departmentId", departmentId);

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            fail();
        }

    }

}