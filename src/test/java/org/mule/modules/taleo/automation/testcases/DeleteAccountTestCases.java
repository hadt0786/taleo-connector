/**
 * (c) 2003-2015 MuleSoft, Inc. The software in this package is published under
 * the terms of the CPAL v1.0 license, a copy of which has been included with this
 * distribution in the LICENSE.md file.
 */

package org.mule.modules.taleo.automation.testcases;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.rules.ExpectedException;
import org.mule.api.MuleEvent;
import org.mule.api.processor.MessageProcessor;
import org.mule.modules.taleo.model.AccountBean;

import java.util.HashMap;

import static org.junit.Assert.fail;

public class DeleteAccountTestCases extends TaleoTestParent {

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Before
    public void setUp() {

        testObjects = new HashMap<String, Object>();
        testObjects.put("accountRef", (AccountBean) context.getBean("deleteAccountAccountBean"));

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


    @Category({SmokeTests.class, RegressionTests.class})
    @Test(expected = org.mule.api.MessagingException.class)
    public void testDeleteAccount() throws Exception {

        MessageProcessor deleteAccountFlow = lookupFlowConstruct("delete-account");
        deleteAccountFlow.process(getTestEvent(testObjects));

        MessageProcessor getAccountByIdFlow = lookupFlowConstruct("get-account-by-id");
        getAccountByIdFlow.process(getTestEvent(testObjects));

    }
}