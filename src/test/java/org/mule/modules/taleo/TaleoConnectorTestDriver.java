/**
 * (c) 2003-2012 MuleSoft, Inc. This software is protected under international
 * copyright law. All use of this software is subject to MuleSoft's Master
 * Subscription Agreement (or other Terms of Service) separately entered
 * into between you and MuleSoft. If such an agreement is not in
 * place, you may not use the software.
 */

package org.mule.modules.taleo;

import static org.junit.Assert.assertNotNull;

import org.junit.BeforeClass;
import org.junit.Test;
import org.mule.api.ConnectionException;
import org.mule.modules.taleo.client.TaleoException;
import org.mule.modules.taleo.model.DepartmentBean;
import org.mule.modules.taleo.model.RequisitionBean;
import org.mule.modules.taleo.model.UserBean;

public class TaleoConnectorTestDriver {

	private static TaleoConnector connector;
	@BeforeClass
	public static void setup() throws ConnectionException{
		connector=new TaleoConnector();
		connector.setDispatcherUrl("https://tbe.taleo.net/MANAGER/dispatcher/servlet/rpcrouter");
		connector.setCompanyCode( System.getenv("taleo.companyCode"));
		connector.connect( System.getenv("taleo.user"),  System.getenv("taleo.password"));
	}
	
	@Test
	public void getDepartment() throws TaleoException, ConnectionException{
		DepartmentBean department=new DepartmentBean();
		department.setDepartmentName("Foo4Department");
		
		long departmentId = connector.createDepartment(department);
		DepartmentBean departmentRetrieved=connector.getDepartmentById(departmentId);
		assertNotNull(departmentRetrieved);
		connector.deleteDepartment(departmentRetrieved.getDepartmentId());
		
	}
	
	@Test
	public void getUserTest() throws TaleoException, ConnectionException{
		UserBean user=new UserBean();
		user.setLastName("FooTest");
		user.setRole("E");
		user.setLoginName("dummyloginname");
		user.setEmail("foo@foo.com.ar");
		user.setStatus("Hired");
		long userId=connector.createUser(user);
		UserBean userRetrieved=connector.getUserById(userId);
		assertNotNull(userRetrieved);
		connector.deleteUser(userId);	
	}
	
	@Test
	public void getRequisitionTest() throws TaleoException, ConnectionException{
		RequisitionBean req=new RequisitionBean();
		req.setTitle("FooReqTemplate");
		req.setStatus("Waiting for Approval");
		req.setLocation("Headquarters");
		long reqId=connector.createRequisitionTemplate(req);
		RequisitionBean reqRetrieved=connector.getRequisitionById(reqId);
		assertNotNull(reqRetrieved);
		connector.deleteRequisition(reqId);
	}
}
