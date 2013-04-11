/**
 * Mule Taleo Cloud Connector
 *
 * Copyright (c) MuleSoft, Inc. All rights reserved. http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.md file.
 */

package org.mule.modules;

import org.junit.BeforeClass;
import org.junit.Test;
import org.mule.api.ConnectionException;
import org.mule.modules.client.core.TaleoException;

public class TaleoConnectorTestDriver {

	private static TaleoConnector connector;
	@BeforeClass
	public static void setup(){
		connector=new TaleoConnector();
		//connector.setDispatcherUrl("http://localhost:8088/geturl");
		connector.setCompanyCode("CODE");
	}
	
	@Test
	public void getUrlTest() throws TaleoException, ConnectionException{
		connector.connect("dummyUser", "dummyPass");
		connector.disconnect();
	}
}
