/**
 * (c) 2003-2012 MuleSoft, Inc. This software is protected under international
 * copyright law. All use of this software is subject to MuleSoft's Master
 * Subscription Agreement (or other Terms of Service) separately entered
 * into between you and MuleSoft. If such an agreement is not in
 * place, you may not use the software.
 */

package org.mule.modules.taleo.automation.testcases;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.HashMap;
import java.util.List;

import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.mule.api.MuleEvent;
import org.mule.api.processor.MessageProcessor;
import org.mule.modules.taleo.model.ArrayOfSearchResultBean;
import org.mule.modules.taleo.model.SearchResultArr;
import org.mule.modules.taleo.model.SearchResultBean;

public class SearchUserTestCases extends TaleoTestParent {

    @Category({RegressionTests.class})
	@Test
	public void testSearchUser() {
    	
    	testObjects = (HashMap<String,Object>) context.getBean("searchUserTestData");
    	
		MessageProcessor flow = lookupFlowConstruct("search-user");
    	
		try {

			MuleEvent response = flow.process(getTestEvent(testObjects));
			SearchResultArr searchResultArr = (SearchResultArr) response.getMessage().getPayload();
			
			ArrayOfSearchResultBean arrayOfSearchResultBean = searchResultArr.getArray();
			List<SearchResultBean> searchResultBeans = arrayOfSearchResultBean.getItem(); 
			SearchResultBean singleResultBean = (SearchResultBean) searchResultBeans.get(0);
			
			Long expectedUserId = singleResultBean.getId();
			Long actualUserId = Long.valueOf(testObjects.get("expectedUserId").toString());
			
			assertEquals(expectedUserId,actualUserId);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail();
		}
     
	}
    
}