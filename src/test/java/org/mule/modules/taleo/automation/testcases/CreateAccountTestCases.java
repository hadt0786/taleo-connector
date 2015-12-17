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
import org.mule.modules.taleo.model.AccountBean;

import java.util.HashMap;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

public class CreateAccountTestCases extends TaleoTestParent {

    @After
    public void tearDown() {

        MessageProcessor flow = lookupFlowConstruct("delete-account");

        try {

            if (testObjects.containsKey("accountId")) {

                MuleEvent response = flow.process(getTestEvent(testObjects));

            }

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            fail();
        }

    }

    @Category({SmokeTests.class, RegressionTests.class})
    @Test
    public void testCreateAccount() {

        testObjects = new HashMap<String, Object>();
        testObjects.put("accountRef", (AccountBean) context.getBean("createAccountAccountBean"));

        MessageProcessor flow = lookupFlowConstruct("create-account");

        try {

            MuleEvent response = flow.process(getTestEvent(testObjects));
            Long accountId = (Long) response.getMessage().getPayload();

            assertNotNull(accountId);

            testObjects.put("accountId", accountId);

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            fail();
        }

    }

}