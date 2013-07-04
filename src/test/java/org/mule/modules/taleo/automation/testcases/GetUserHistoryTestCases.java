/**
 * (c) 2003-2012 MuleSoft, Inc. This software is protected under international
 * copyright law. All use of this software is subject to MuleSoft's Master
 * Subscription Agreement (or other Terms of Service) separately entered
 * into between you and MuleSoft. If such an agreement is not in
 * place, you may not use the software.
 */

package org.mule.modules.taleo.automation.testcases;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.HashMap;
import java.util.List;

import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.mule.api.MuleEvent;
import org.mule.api.processor.MessageProcessor;
import org.mule.modules.taleo.model.ArrayOfHistoryBean;
import org.mule.modules.taleo.model.HistoryBean;
import org.mule.modules.taleo.model.HistoryBeanArr;

public class GetUserHistoryTestCases extends TaleoTestParent {

    @Category({RegressionTests.class})
	@Test
	public void testGetUserHistory() {
    	
    	testObjects = (HashMap<String,Object>) context.getBean("getUserHistoryTestData");
    	
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