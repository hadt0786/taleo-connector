/**
 * (c) 2003-2015 MuleSoft, Inc. The software in this package is published under
 * the terms of the CPAL v1.0 license, a copy of which has been included with this
 * distribution in the LICENSE.md file.
 */

package org.mule.modules.taleo.automation.testcases;

import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.mule.api.MuleEvent;
import org.mule.api.processor.MessageProcessor;
import org.mule.modules.taleo.model.UserBean;

import java.util.HashMap;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

public class GetUserByIdTestCases extends TaleoTestParent {

    @Category({RegressionTests.class})
    @Test
    public void testGetUserById() {

        testObjects = (HashMap<String, Object>) context.getBean("getUserByIdTestData");

        MessageProcessor flow = lookupFlowConstruct("get-user-by-id");

        try {

            MuleEvent response = flow.process(getTestEvent(testObjects));
            UserBean userBean = (UserBean) response.getMessage().getPayload();

            assertTrue(userBean.getEmail().equals(testObjects.get("expectedEmail").toString()));

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            fail();
        }

    }

}