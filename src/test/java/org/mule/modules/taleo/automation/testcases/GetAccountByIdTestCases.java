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
import org.mule.modules.taleo.model.AccountBean;

import java.util.HashMap;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class GetAccountByIdTestCases extends TaleoTestParent {

    @Before
    public void setUp() {

        testObjects = new HashMap<String, Object>();
        testObjects.put("accountRef", (AccountBean) context.getBean("getAccountByIdAccountBean"));

        MessageProcessor flow = lookupFlowConstruct("create-account");

        try {

            MuleEvent response = flow.process(getTestEvent(testObjects));
            testObjects.put("accountId", (Long) response.getMessage().getPayload());

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            fail();
        }

    }


    @After
    public void tearDown() {

        MessageProcessor flow = lookupFlowConstruct("delete-account");

        try {

            if (testObjects.containsKey("accountId")) {

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
    public void testGetAccountById() {

        MessageProcessor flow = lookupFlowConstruct("get-account-by-id");

        try {

            MuleEvent response = flow.process(getTestEvent(testObjects));
            AccountBean accountBean = (AccountBean) response.getMessage().getPayload();

            assertEquals((Long) accountBean.getId(), (Long) testObjects.get("accountId"));

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            fail();
        }

    }

}