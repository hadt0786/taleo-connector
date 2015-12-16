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
import org.mule.modules.taleo.model.ArrayOfSearchResultBean;
import org.mule.modules.taleo.model.CandidateBean;
import org.mule.modules.taleo.model.SearchResultArr;
import org.mule.modules.taleo.model.SearchResultBean;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import static org.junit.Assert.fail;

public class SearchCandidateTestCases extends TaleoTestParent {

    @Before
    public void setUp() {

        testObjects = new HashMap<String, Object>();
        testObjects.put("candidateRef", (CandidateBean) context.getBean("searchCandidateCandidateBean"));
        testObjects.put("searchParamsRef", (HashMap<String, Object>) context.getBean("searchCandidateSearchParams"));

        MessageProcessor flow = lookupFlowConstruct("create-candidate");

        try {

            MuleEvent response = flow.process(getTestEvent(testObjects));
            testObjects.put("candidateId", (Long) response.getMessage().getPayload());

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            fail();
        }

    }


    @After
    public void tearDown() {

        MessageProcessor flow = lookupFlowConstruct("delete-candidate");

        try {

            if (testObjects.containsKey("candidateId")) {

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
    public void testSearchCandidate() {

        MessageProcessor flow = lookupFlowConstruct("search-candidate");
        List<Long> retrievedIds = new ArrayList<Long>();

        try {

            MuleEvent response = flow.process(getTestEvent(testObjects));
            SearchResultArr searchResultArr = (SearchResultArr) response.getMessage().getPayload();

            ArrayOfSearchResultBean arrayOfSearchResultBean = searchResultArr.getArray();
            List<SearchResultBean> searchResultBeans = arrayOfSearchResultBean.getItem();
            Iterator<SearchResultBean> iterator = searchResultBeans.iterator();

            while (iterator.hasNext()) {

                SearchResultBean searchResultBean = (SearchResultBean) iterator.next();
                retrievedIds.add(searchResultBean.getId());

            }

            retrievedIds.contains((Long) testObjects.get("candidateId"));

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            fail();
        }

    }

}