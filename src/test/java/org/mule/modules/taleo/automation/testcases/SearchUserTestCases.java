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
import org.mule.modules.taleo.model.ArrayOfSearchResultBean;
import org.mule.modules.taleo.model.SearchResultArr;
import org.mule.modules.taleo.model.SearchResultBean;

import java.util.HashMap;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class SearchUserTestCases extends TaleoTestParent {

    @Category({RegressionTests.class})
    @Test
    public void testSearchUser() {

        testObjects = (HashMap<String, Object>) context.getBean("searchUserTestData");

        MessageProcessor flow = lookupFlowConstruct("search-user");

        try {

            MuleEvent response = flow.process(getTestEvent(testObjects));
            SearchResultArr searchResultArr = (SearchResultArr) response.getMessage().getPayload();

            ArrayOfSearchResultBean arrayOfSearchResultBean = searchResultArr.getArray();
            List<SearchResultBean> searchResultBeans = arrayOfSearchResultBean.getItem();
            SearchResultBean singleResultBean = (SearchResultBean) searchResultBeans.get(0);

            Long expectedUserId = singleResultBean.getId();
            Long actualUserId = Long.valueOf(testObjects.get("expectedUserId").toString());

            assertEquals(expectedUserId, actualUserId);

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            fail();
        }

    }

}