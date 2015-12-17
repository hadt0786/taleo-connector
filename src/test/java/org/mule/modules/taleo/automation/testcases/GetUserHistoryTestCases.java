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
import org.mule.modules.taleo.model.ArrayOfHistoryBean;
import org.mule.modules.taleo.model.HistoryBean;
import org.mule.modules.taleo.model.HistoryBeanArr;

import java.util.HashMap;
import java.util.List;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

public class GetUserHistoryTestCases extends TaleoTestParent {

    @Category({RegressionTests.class})
    @Test
    public void testGetUserHistory() {

        testObjects = (HashMap<String, Object>) context.getBean("getUserHistoryTestData");

        MessageProcessor flow = lookupFlowConstruct("get-user-history");

        try {

            MuleEvent response = flow.process(getTestEvent(testObjects));
            HistoryBeanArr historyBeanArr = (HistoryBeanArr) response.getMessage().getPayload();

            ArrayOfHistoryBean arrayOfHistoryBean = historyBeanArr.getArray();
            List<HistoryBean> historyBeans = arrayOfHistoryBean.getItem();
            HistoryBean historyBean = (HistoryBean) historyBeans.get(0);

            assertTrue(historyBean.getUserName().equals(testObjects.get("expectedUsername").toString()));

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            fail();
        }

    }

}