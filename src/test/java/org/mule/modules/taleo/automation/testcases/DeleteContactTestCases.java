/**
 * (c) 2003-2015 MuleSoft, Inc. The software in this package is published under
 * the terms of the CPAL v1.0 license, a copy of which has been included with this
 * distribution in the LICENSE.md file.
 */

package org.mule.modules.taleo.automation.testcases;

import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.mule.api.MuleEvent;
import org.mule.api.processor.MessageProcessor;
import org.mule.modules.taleo.model.ContactBean;

import java.util.HashMap;

import static org.junit.Assert.fail;

public class DeleteContactTestCases extends TaleoTestParent {

    @Before
    public void setUp() {

        testObjects = new HashMap<String, Object>();
        testObjects.put("contactRef", (ContactBean) context.getBean("deleteContactContactBean"));

        MessageProcessor flow = lookupFlowConstruct("create-contact");

        try {

            MuleEvent response = flow.process(getTestEvent(testObjects));
            testObjects.put("contactId", (Long) response.getMessage().getPayload());

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            fail();
        }

    }


    @Category({SmokeTests.class, RegressionTests.class})
    @Test(expected = org.mule.api.MessagingException.class)
    public void testDeleteContact() throws Exception {

        MessageProcessor deleteContactFlow = lookupFlowConstruct("delete-contact");
        deleteContactFlow.process(getTestEvent(testObjects));

        MessageProcessor getContactByIdFlow = lookupFlowConstruct("get-contact-by-id");
        getContactByIdFlow.process(getTestEvent(testObjects));

    }
}