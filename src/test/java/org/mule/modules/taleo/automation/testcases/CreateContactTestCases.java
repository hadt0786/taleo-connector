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
import org.mule.modules.taleo.model.ContactBean;

import java.util.HashMap;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;


public class CreateContactTestCases extends TaleoTestParent {

    @After
    public void tearDown() {

        MessageProcessor flow = lookupFlowConstruct("delete-contact");

        try {

            if (testObjects.containsKey("contactId")) {

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
    public void testCreateContact() {

        testObjects = new HashMap<String, Object>();
        testObjects.put("contactRef", (ContactBean) context.getBean("createContactContactBean"));

        MessageProcessor flow = lookupFlowConstruct("create-contact");

        try {

            MuleEvent response = flow.process(getTestEvent(testObjects));
            Long contactId = (Long) response.getMessage().getPayload();

            assertNotNull(contactId);

            testObjects.put("contactId", contactId);

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            fail();
        }

    }

}