/**
 * (c) 2003-2012 MuleSoft, Inc. This software is protected under international
 * copyright law. All use of this software is subject to MuleSoft's Master
 * Subscription Agreement (or other Terms of Service) separately entered
 * into between you and MuleSoft. If such an agreement is not in
 * place, you may not use the software.
 */

package org.mule.modules.taleo.automation.testcases;

import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.mule.api.MuleEvent;
import org.mule.api.processor.MessageProcessor;
import org.mule.modules.taleo.model.ContactBean;
import org.mule.modules.taleo.model.ArrayOfSearchResultBean;
import org.mule.modules.taleo.model.SearchResultArr;
import org.mule.modules.taleo.model.SearchResultBean;

public class SearchContactTestCases extends TaleoTestParent {
	
	@Before
	public void setUp() {
		
		testObjects = new HashMap<String,Object>();
		testObjects.put("contactRef", (ContactBean) context.getBean("searchContactContactBean"));
		testObjects.put("searchParamsRef", (HashMap<String,Object>) context.getBean("searchContactSearchParams"));
    	
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
	
	
	@After
	public void tearDown() {
		
		MessageProcessor flow = lookupFlowConstruct("delete-contact");
		
		try {		
			
			if (testObjects.containsKey("contactId")) {
				
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
	public void testSearchContact() {
    	
		MessageProcessor flow = lookupFlowConstruct("search-contact");
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
			
			retrievedIds.contains((Long) testObjects.get("contactId"));			

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail();
		}
     
	}
    
}