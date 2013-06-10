/**
 * Mule Taleo Cloud Connector
 *
 * Copyright (c) MuleSoft, Inc. All rights reserved. http://www.mulesoft.com
 *
 */

package org.mule.modules.client.core;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringReader;
import java.io.StringWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.GregorianCalendar;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.soap.SOAPException;
import javax.xml.ws.BindingProvider;
import javax.xml.ws.soap.SOAPFaultException;

import org.apache.commons.io.IOUtils;
import org.mule.api.ConnectionException;
import org.mule.modules.taleo.api.EntityTypeEnum;
import org.mule.modules.taleo.model.AccountBean;
import org.mule.modules.taleo.model.AttachmentBean;
import org.mule.modules.taleo.model.BackgroundCheckBean;
import org.mule.modules.taleo.model.ByteArr;
import org.mule.modules.taleo.model.CalendarEventBean;
import org.mule.modules.taleo.model.CandidateBean;
import org.mule.modules.taleo.model.CandidateDetailsBean;
import org.mule.modules.taleo.model.CandidateInsertResultBean;
import org.mule.modules.taleo.model.ContactBean;
import org.mule.modules.taleo.model.ContactLogBean;
import org.mule.modules.taleo.model.DepartmentArr;
import org.mule.modules.taleo.model.DepartmentBean;
import org.mule.modules.taleo.model.EmployeeBean;
import org.mule.modules.taleo.model.FlexRollingEntityBean;
import org.mule.modules.taleo.model.FlexRollingEntityBeanArr;
import org.mule.modules.taleo.model.HistoryBeanArr;
import org.mule.modules.taleo.model.IWebAPI;
import org.mule.modules.taleo.model.IWebAPIService;
import org.mule.modules.taleo.model.InterviewBean;
import org.mule.modules.taleo.model.LocationArr;
import org.mule.modules.taleo.model.LocationBean;
import org.mule.modules.taleo.model.LongArr;
import org.mule.modules.taleo.model.LookupArr;
import org.mule.modules.taleo.model.Map;
import org.mule.modules.taleo.model.MetadataArr;
import org.mule.modules.taleo.model.OfferBean;
import org.mule.modules.taleo.model.ReferenceBean;
import org.mule.modules.taleo.model.RegionArr;
import org.mule.modules.taleo.model.RegionBean;
import org.mule.modules.taleo.model.RequisitionBean;
import org.mule.modules.taleo.model.SearchResultArr;
import org.mule.modules.taleo.model.TaskBean;
import org.mule.modules.taleo.model.UserBean;
import org.mule.modules.taleo.model.WebServicesException_Exception;
import org.mule.modules.taleo.model.WorkHistoryArr;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;

public class TaleoCxfClientImpl implements TaleoClient {

	private IWebAPIService serviceClient;

	private String dispatcherUrl;

	public String getDispatcherUrl() {
		return dispatcherUrl;
	}

	public void setDispatcherUrl(String dispatcherUrl) {
		this.dispatcherUrl = dispatcherUrl;
	}

	private String endpoint;

	private String sessionId;

	private IWebAPI rpc;

	public TaleoCxfClientImpl() throws WebServicesException_Exception,
			TaleoException {

		this.serviceClient = new IWebAPIService(getClass().getResource(
				"/WebAPI.wsdl"));
		;
	}

	@Override
	public boolean isConnected() {
		return rpc != null && sessionId != null && sessionId.length() != 0;
	}

	@Override
	public String connectionId() {
		return sessionId;
	}

	@Override
	public void connect(String username, String password, String companyCode)
			throws ConnectionException {

		try {
			endpoint = this.getUrl(companyCode);
		} catch (TaleoException e) {
			throw new ConnectionException(null, e.getLocalizedMessage(),
					e.getMessage(), e);
		}
		rpc = serviceClient.getPort(IWebAPI.class);

		BindingProvider bindingProvider = ((BindingProvider) this.rpc);
		bindingProvider.getRequestContext().put(
				BindingProvider.ENDPOINT_ADDRESS_PROPERTY, endpoint);

		String loginResult;
		try {
			loginResult = this.rpc.login(companyCode, username, password);
		} catch (WebServicesException_Exception e) {
			throw new ConnectionException(null, e.getLocalizedMessage(),
					e.getMessage(), e);
		}

		sessionId = loginResult;

		bindingProvider.getRequestContext().put(
				BindingProvider.SESSION_MAINTAIN_PROPERTY, sessionId);

		sessionId = loginResult;

	}

	@Override
	public void disconnect() {
		if (sessionId != null) {
			try {
				rpc.logout(sessionId);
			} catch (WebServicesException_Exception e) {
				e.printStackTrace();
			}
		}
		sessionId = null;
		rpc = null;
	}

	@Override
	public long createAccount(AccountBean account) throws TaleoException {
		try {
			return rpc.createAccount(sessionId, account);
		} catch (WebServicesException_Exception e) {
			throw new TaleoException(e);
		}
	}

	@Override
	public void deleteAccount(long accountId) throws TaleoException {
		try {
			rpc.deleteAccount(sessionId, accountId);
		} catch (WebServicesException_Exception e) {
			throw new TaleoException(e);
		}
	}

	@Override
	public AccountBean getAccountById(long accountId) throws TaleoException {
		try {
			return rpc.getAccountById(sessionId, accountId);
		} catch (WebServicesException_Exception e) {
			throw new TaleoException(e);
		}
	}

	@Override
	public HistoryBeanArr getAccountHistory(long accountId)
			throws TaleoException {
		try {
			return rpc.getAccountHistory(sessionId, accountId);
		} catch (WebServicesException_Exception e) {
			throw new TaleoException(e);
		}
	}

	@Override
	public SearchResultArr searchAccount(Map searchParams)
			throws TaleoException {
		try {
			return rpc.searchAccount(sessionId, searchParams);
		} catch (WebServicesException_Exception e) {
			throw new TaleoException(e);
		}
	}

	@Override
	public void updateAccount(AccountBean account) throws TaleoException {
		try {
			rpc.updateAccount(sessionId, account);
		} catch (WebServicesException_Exception e) {
			throw new TaleoException(e);
		}
	}

	@Override
	public long createAttachment(long candidateId, String attachment,
			String attachmentName, String contentType, ByteArr binaryResume)
			throws TaleoException {
		try {
			return rpc.createAttachment(sessionId, candidateId, attachment,
					attachmentName, contentType, binaryResume);
		} catch (WebServicesException_Exception e) {
			throw new TaleoException(e);
		}
	}

	@Override
	public long createEntityAttachment(String entityType, long entityId,
			String description, String fileName, String contentType,
			ByteArr data) throws TaleoException {
		try {
			return rpc.createEntityAttachment(sessionId, entityType, entityId,
					description, fileName, contentType, data);
		} catch (WebServicesException_Exception e) {
			throw new TaleoException(e);
		}
	}

	@Override
	public AttachmentBean getAttachment(long attachmentId)
			throws TaleoException {
		try {
			return rpc.getAttachment(sessionId, attachmentId);
		} catch (WebServicesException_Exception e) {
			throw new TaleoException(e);
		}
	}

	@Override
	public void deleteAttachment(long attachmentId) throws TaleoException {
		try {
			rpc.deleteAttachment(sessionId, attachmentId);
		} catch (WebServicesException_Exception e) {
			throw new TaleoException(e);
		}

	}

	@Override
	public ByteArr getAttachmentData(long attachmentId) throws TaleoException {
		try {
			return rpc.getAttachmentData(sessionId, attachmentId);
		} catch (WebServicesException_Exception e) {
			throw new TaleoException(e);
		}
	}

	@Override
	public LongArr getAttachments(long candidateId) throws TaleoException {
		try {
			return rpc.getAttachments(sessionId, candidateId);
		} catch (WebServicesException_Exception e) {
			throw new TaleoException(e);
		}
	}

	@Override
	public LongArr getEntityAttachments(String entityType, long entityId)
			throws TaleoException {
		try {
			return rpc.getEntityAttachments(sessionId, entityType, entityId);
		} catch (WebServicesException_Exception e) {
			throw new TaleoException(e);
		}
	}

	@Override
	public void updateAttachment(long attachmentId, String description,
			String name, String contentType, ByteArr binaryResume)
			throws TaleoException {
		try {
			rpc.updateAttachment(sessionId, attachmentId, description, name,
					contentType, binaryResume);
		} catch (WebServicesException_Exception e) {
			throw new TaleoException(e);
		}

	}

	@Override
	public long createBackgroundCheck(BackgroundCheckBean backgroundCheck)
			throws TaleoException {
		try {
			return rpc.createBackgroundCheck(sessionId, backgroundCheck);
		} catch (WebServicesException_Exception e) {
			throw new TaleoException(e);
		}
	}

	@Override
	public void deleteBackgroundCheck(long backgroundCheckId)
			throws TaleoException {
		try {
			rpc.deleteBackgroundCheck(sessionId, backgroundCheckId);
		} catch (WebServicesException_Exception e) {
			throw new TaleoException(e);
		}

	}

	@Override
	public BackgroundCheckBean getBackgroundCheckById(long backgroundCheckId)
			throws TaleoException {
		try {
			return rpc.getBackgroundCheckById(sessionId, backgroundCheckId);
		} catch (WebServicesException_Exception e) {
			throw new TaleoException(e);
		}
	}

	@Override
	public LongArr getBackgroundChecksByCandidate(long candidateId)
			throws TaleoException {
		try {
			return rpc.getBackgroundChecksByCandidate(sessionId, candidateId);
		} catch (WebServicesException_Exception e) {
			throw new TaleoException(e);
		}
	}

	@Override
	public void updateBackgroundCheck(BackgroundCheckBean backgroundCheck)
			throws TaleoException {
		try {
			rpc.updateBackgroundCheck(sessionId, backgroundCheck);
		} catch (WebServicesException_Exception e) {
			throw new TaleoException(e);
		}
	}

	@Override
	public long createCandidate(CandidateBean candidate) throws TaleoException {
		try {
			return rpc.createCandidate(sessionId, candidate);
		} catch (WebServicesException_Exception e) {
			throw new TaleoException(e);
		}
	}

	@Override
	public void deleteCandidate(long candidateId) throws TaleoException {
		try {
			rpc.deleteCandidate(sessionId, candidateId);
		} catch (WebServicesException_Exception e) {
			throw new TaleoException(e);
		}

	}

	@Override
	public CandidateBean getCandidateById(long candidateId)
			throws TaleoException {
		try {
			return rpc.getCandidateById(sessionId, candidateId);
		} catch (WebServicesException_Exception e) {
			throw new TaleoException(e);
		}
	}

	@Override
	public CandidateDetailsBean getCandidateDetailsById(long candidateId,
			boolean includeRequisitions, boolean includeInterviews,
			boolean includeReferences, boolean includeHistory,
			boolean includeAttachments, boolean includeOffers)
			throws TaleoException {
		try {
			return rpc.getCandidateDetailsById(sessionId, candidateId,
					includeRequisitions, includeInterviews, includeReferences,
					includeHistory, includeAttachments, includeOffers);
		} catch (WebServicesException_Exception e) {
			throw new TaleoException(e);
		}
	}

	@Override
	public HistoryBeanArr getCandidateHistory(long candidateId)
			throws TaleoException {
		try {
			return rpc.getCandidateHistory(sessionId, candidateId);
		} catch (WebServicesException_Exception e) {
			throw new TaleoException(e);
		}
	}

	@Override
	public LongArr getCandidatesByRequisition(long requisitionId)
			throws TaleoException {
		try {
			return rpc.getCandidatesByRequisition(sessionId, requisitionId);
		} catch (WebServicesException_Exception e) {
			throw new TaleoException(e);
		}
	}

	@Override
	public WorkHistoryArr getCandidateWorkHistory(long candidateId)
			throws TaleoException {
		try {
			return rpc.getCandidateWorkHistory(sessionId, candidateId);
		} catch (WebServicesException_Exception e) {
			throw new TaleoException(e);
		}
	}

	@Override
	public String getCandReqStatus(long candidateId, long requisitionId)
			throws TaleoException {
		try {
			return rpc.getCandReqStatus(sessionId, candidateId, requisitionId);
		} catch (WebServicesException_Exception e) {
			throw new TaleoException(e);
		}
	}

	@Override
	public LongArr getRequisitions(long candidateId) throws TaleoException {
		try {
			return rpc.getRequisitions(sessionId, candidateId);
		} catch (WebServicesException_Exception e) {
			throw new TaleoException(e);
		}
	}

	@Override
	public SearchResultArr searchCandidate(Map searchParams)
			throws TaleoException {
		try {
			return rpc.searchCandidate(sessionId, searchParams);
		} catch (WebServicesException_Exception e) {
			throw new TaleoException(e);
		}
	}

	@Override
	public void submitCandidate(long candidateId, LongArr requisitionIds)
			throws TaleoException {
		try {
			rpc.submitCandidate(sessionId, candidateId, requisitionIds);
		} catch (WebServicesException_Exception e) {
			throw new TaleoException(e);
		}
	}

	@Override
	public void removeCandidate(long candidateId, long requisitionId)
			throws TaleoException {
		try {
			rpc.removeCandidate(sessionId, candidateId, requisitionId);
		} catch (WebServicesException_Exception e) {
			throw new TaleoException(e);
		}
	}

	@Override
	public void updateCandidate(CandidateBean candidate) throws TaleoException {
		try {
			rpc.updateCandidate(sessionId, candidate);
		} catch (WebServicesException_Exception e) {
			throw new TaleoException(e);
		}
	}

	@Override
	public void upsertCandidateToRequisitions(long candidateId,
			LongArr requisitionIds, long statusId, long reasonId,
			boolean doRanking) throws TaleoException {
		try {
			rpc.upsertCandidateToRequisitions(sessionId, candidateId,
					requisitionIds, statusId, reasonId, doRanking);
		} catch (WebServicesException_Exception e) {
			throw new TaleoException(e);
		}
	}

	@Override
	public long createContact(ContactBean contact) throws TaleoException {
		try {
			return rpc.createContact(sessionId, contact);
		} catch (WebServicesException_Exception e) {
			throw new TaleoException(e);
		}
	}

	@Override
	public void deleteContact(long contactId) throws TaleoException {
		try {
			rpc.deleteContact(sessionId, contactId);
		} catch (WebServicesException_Exception e) {
			throw new TaleoException(e);
		}
	}

	@Override
	public ContactBean getContactById(long contactId) throws TaleoException {
		try {
			return rpc.getContactById(sessionId, contactId);
		} catch (WebServicesException_Exception e) {
			throw new TaleoException(e);
		}
	}

	@Override
	public HistoryBeanArr getContactHistory(long contactId)
			throws TaleoException {
		try {
			return rpc.getContactHistory(sessionId, contactId);
		} catch (WebServicesException_Exception e) {
			throw new TaleoException(e);
		}
	}

	@Override
	public SearchResultArr searchContact(Map searchParams)
			throws TaleoException {
		try {
			return rpc.searchContact(sessionId, searchParams);
		} catch (WebServicesException_Exception e) {
			throw new TaleoException(e);
		}
	}

	@Override
	public void updateContact(ContactBean contact) throws TaleoException {
		try {
			rpc.updateContact(sessionId, contact);
		} catch (WebServicesException_Exception e) {
			throw new TaleoException(e);
		}
	}

	@Override
	public long createContactLog(ContactLogBean contactLog)
			throws TaleoException {
		try {
			return rpc.createContactLog(sessionId, contactLog);
		} catch (WebServicesException_Exception e) {
			throw new TaleoException(e);
		}
	}

	@Override
	public void deleteContactLog(long contactLogId) throws TaleoException {
		try {
			rpc.deleteContactLog(sessionId, contactLogId);
		} catch (WebServicesException_Exception e) {
			throw new TaleoException(e);
		}
	}

	@Override
	public ContactLogBean getContactLogById(long contactLogId)
			throws TaleoException {
		try {
			return rpc.getContactLogById(sessionId, contactLogId);
		} catch (WebServicesException_Exception e) {
			throw new TaleoException(e);
		}
	}

	@Override
	public LongArr getContactLogsByEntity(String entityType, long entityId)
			throws TaleoException {
		try {
			return rpc.getContactLogsByEntity(sessionId, entityType, entityId);
		} catch (WebServicesException_Exception e) {
			throw new TaleoException(e);
		}
	}

	@Override
	public void updateContactLog(ContactLogBean contactLog)
			throws TaleoException {
		try {
			rpc.updateContactLog(sessionId, contactLog);
		} catch (WebServicesException_Exception e) {
			throw new TaleoException(e);
		}
	}

	@Override
	public long createDepartment(DepartmentBean department)
			throws TaleoException {
		try {
			return rpc.createDepartment(sessionId, department);
		} catch (WebServicesException_Exception e) {
			throw new TaleoException(e);
		}
	}

	@Override
	public void deleteDepartment(long departmentId) throws TaleoException {
		try {
			rpc.deleteDepartment(sessionId, departmentId);
		} catch (WebServicesException_Exception e) {
			throw new TaleoException(e);
		}
	}

	@Override
	public DepartmentBean getDepartmentById(long departmentId)
			throws TaleoException {
		try {
			return rpc.getDepartmentById(sessionId, departmentId);
		} catch (WebServicesException_Exception e) {
			throw new TaleoException(e);
		}
	}

	@Override
	public DepartmentBean getDepartmentByName(String name)
			throws TaleoException {
		try {
			return rpc.getDepartmentByName(sessionId, name);
		} catch (WebServicesException_Exception e) {
			throw new TaleoException(e);
		}
	}

	@Override
	public DepartmentArr getDepartments() throws TaleoException {
		try {
			return rpc.getDepartments(sessionId);
		} catch (WebServicesException_Exception e) {
			throw new TaleoException(e);
		}
	}

	@Override
	public long upsertDepartment(DepartmentBean department)
			throws TaleoException {
		try {
			return rpc.upsertDepartment(sessionId, department);
		} catch (WebServicesException_Exception e) {
			throw new TaleoException(e);
		}
	}

	@Override
	public long createEmailLog(String email, String subject, String body,
			GregorianCalendar date) throws TaleoException {
		try {
			XMLGregorianCalendar xDate = DatatypeFactory.newInstance()
					.newXMLGregorianCalendar(date);
			return rpc.createEmailLog(sessionId, email, subject, body, xDate);
		} catch (WebServicesException_Exception e) {
			throw new TaleoException(e);
		} catch (DatatypeConfigurationException e) {
			throw new TaleoException(e);
		}
	}

	@Override
	public long createEmailSentLog(String email, String subject, String body,
			GregorianCalendar date) throws TaleoException {
		try {
			XMLGregorianCalendar xDate = DatatypeFactory.newInstance()
					.newXMLGregorianCalendar(date);
			return rpc.createEmailSentLog(sessionId, email, subject, body,
					xDate);
		} catch (WebServicesException_Exception e) {
			throw new TaleoException(e);
		} catch (DatatypeConfigurationException e) {
			throw new TaleoException(e);
		}
	}

	@Override
	public long createEmployee(EmployeeBean employee) throws TaleoException {
		try {
			return rpc.createEmployee(sessionId, employee);
		} catch (WebServicesException_Exception e) {
			throw new TaleoException(e);
		}
	}

	@Override
	public void deleteEmployee(long employeeId) throws TaleoException {
		try {
			rpc.deleteEmployee(sessionId, employeeId);
		} catch (WebServicesException_Exception e) {
			throw new TaleoException(e);
		}
	}

	@Override
	public void deleteEmployeeByNumber(String employeeNumber)
			throws TaleoException {
		try {
			rpc.deleteEmployeeByNumber(sessionId, employeeNumber);
		} catch (WebServicesException_Exception e) {
			throw new TaleoException(e);
		}
	}

	@Override
	public EmployeeBean getEmployeeById(long employeeId) throws TaleoException {
		try {
			// Documentation doesn't mention this last field
			// TODO: Check this against server
			return rpc.getEmployeeById(sessionId, employeeId, null);
		} catch (WebServicesException_Exception e) {
			throw new TaleoException(e);
		}
	}

	@Override
	public EmployeeBean getEmployeeByNumber(String employeeNumber)
			throws TaleoException {
		try {
			// Documentation doesn't mention this last field
			// TODO: Check this against server
			return rpc.getEmployeeByNumber(sessionId, employeeNumber, null);
		} catch (WebServicesException_Exception e) {
			throw new TaleoException(e);
		}
	}

	@Override
	public SearchResultArr searchEmployee(Map searchParams)
			throws TaleoException {
		return rpc.searchEmployee(sessionId, searchParams);
	}

	@Override
	public void updateEmployee(EmployeeBean employee) throws TaleoException {
		try {
			rpc.updateEmployee(sessionId, employee);
		} catch (WebServicesException_Exception e) {
			throw new TaleoException(e);
		}
	}

	@Override
	public long upsertEmployee(String employeeNumber, EmployeeBean employee)
			throws TaleoException {
		try {
			return rpc.upsertEmployee(sessionId, employeeNumber, employee);
		} catch (WebServicesException_Exception e) {
			throw new TaleoException(e);
		}
	}

	@Override
	public long createEvent(CalendarEventBean event) throws TaleoException {
		try {
			return rpc.createEvent(sessionId, event);
		} catch (WebServicesException_Exception e) {
			throw new TaleoException(e);
		}
	}

	@Override
	public void deleteEvent(long eventId) throws TaleoException {
		try {
			rpc.deleteEvent(sessionId, eventId);
		} catch (WebServicesException_Exception e) {
			throw new TaleoException(e);
		}
	}

	@Override
	public CalendarEventBean getEventById(long eventId) throws TaleoException {
		try {
			return rpc.getEventById(sessionId, eventId);
		} catch (WebServicesException_Exception e) {
			throw new TaleoException(e);
		}
	}

	@Override
	public LongArr getEventByEntity(String entityType, long entityId)
			throws TaleoException {
		try {
			return rpc.getEventByEntity(sessionId, entityType, entityId);
		} catch (WebServicesException_Exception e) {
			throw new TaleoException(e);
		}
	}

	@Override
	public LongArr getPublicEvents(GregorianCalendar startDate,
			GregorianCalendar endDate) throws TaleoException {
		try {
			XMLGregorianCalendar xstartDate = DatatypeFactory.newInstance()
					.newXMLGregorianCalendar(startDate);
			XMLGregorianCalendar xendDate = DatatypeFactory.newInstance()
					.newXMLGregorianCalendar(startDate);
			return rpc.getPublicEvents(sessionId, xstartDate, xendDate);
		} catch (WebServicesException_Exception e) {
			throw new TaleoException(e);
		} catch (DatatypeConfigurationException e) {
			throw new TaleoException(e);
		}
	}

	@Override
	public void updateEvent(CalendarEventBean event) throws TaleoException {
		try {
			rpc.updateEvent(sessionId, event);
		} catch (WebServicesException_Exception e) {
			throw new TaleoException(e);
		}
	}

	@Override
	public long createInterview(InterviewBean interview) throws TaleoException {
		try {
			return rpc.createInterview(sessionId, interview);
		} catch (WebServicesException_Exception e) {
			throw new TaleoException(e);
		}
	}

	@Override
	public void deleteInterview(long interviewId) throws TaleoException {
		try {
			rpc.deleteInterview(sessionId, interviewId);
		} catch (WebServicesException_Exception e) {
			throw new TaleoException(e);
		}
	}

	@Override
	public LongArr getInterviewsByCandidate(long candidateId)
			throws TaleoException {
		try {
			return rpc.getInterviewsByCandidate(sessionId, candidateId);
		} catch (WebServicesException_Exception e) {
			throw new TaleoException(e);
		}
	}

	@Override
	public InterviewBean getInterviewById(long interviewId)
			throws TaleoException {
		try {
			return rpc.getInterviewById(sessionId, interviewId);
		} catch (WebServicesException_Exception e) {
			throw new TaleoException(e);
		}
	}

	@Override
	public void updateInterview(InterviewBean interview) throws TaleoException {
		try {
			rpc.updateInterview(sessionId, interview);
		} catch (WebServicesException_Exception e) {
			throw new TaleoException(e);
		}
	}

	@Override
	public void createLink(String entityType1, long entityId1,
			String entityType2, long entityId2) throws TaleoException {
		try {
			rpc.createLink(sessionId, entityType1, entityId1, entityType2,
					entityId2);
		} catch (WebServicesException_Exception e) {
			throw new TaleoException(e);
		}

	}

	@Override
	public void removeLink(String entityType1, long entityId1,
			String entityType2, long entityId2) throws TaleoException {
		try {
			rpc.removeLink(sessionId, entityType1, entityId1, entityType2,
					entityId2);
		} catch (WebServicesException_Exception e) {
			throw new TaleoException(e);
		}
	}

	@Override
	public long createLocation(LocationBean location) throws TaleoException {
		try {
			return rpc.createLocation(sessionId, location);
		} catch (WebServicesException_Exception e) {
			throw new TaleoException(e);
		}
	}

	@Override
	public void deleteLocation(long locationId) throws TaleoException {
		try {
			rpc.deleteLocation(sessionId, locationId);
		} catch (WebServicesException_Exception e) {
			throw new TaleoException(e);
		}
	}

	@Override
	public LocationBean getLocationById(long locationId) throws TaleoException {
		try {
			return rpc.getLocationById(sessionId, locationId);
		} catch (WebServicesException_Exception e) {
			throw new TaleoException(e);
		}
	}

	@Override
	public LocationBean getLocationByName(String locationName)
			throws TaleoException {
		try {
			return rpc.getLocationByName(sessionId, locationName);
		} catch (WebServicesException_Exception e) {
			throw new TaleoException(e);
		}
	}

	@Override
	public LocationArr getLocations() throws TaleoException {
		try {
			return rpc.getLocations(sessionId);
		} catch (WebServicesException_Exception e) {
			throw new TaleoException(e);
		}
	}

	@Override
	public long upsertLocation(LocationBean location) throws TaleoException {
		try {
			return rpc.upsertLocation(sessionId, location);
		} catch (WebServicesException_Exception e) {
			throw new TaleoException(e);
		}
	}

	@Override
	public String getUrl(String companyCode) throws TaleoException {
		String companyUrl = null;
		try {
			URL url = new URL(dispatcherUrl);

			Document response = makeUrlRequest(companyCode, url);

			companyUrl = response.getFirstChild().getTextContent().trim();

		} catch (SOAPFaultException e) {
			throw new TaleoException(e);
		} catch (MalformedURLException e) {
			throw new TaleoException(e);
		} catch (SOAPException e) {
			throw new TaleoException(e);
		} catch (IOException e) {
			throw new TaleoException(e);
		} catch (Exception e) {
			throw new TaleoException(e);
		}
		return companyUrl;
	}

	private Document makeUrlRequest(String companyCode, URL url)
			throws IOException, Exception {
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();
		String message = generateUrlRequest(companyCode);
		connection.setRequestProperty("Content-Length",
				String.valueOf(message.length()));
		connection.setRequestProperty("Content-Type", "text/xml");
		connection.setRequestProperty("Connection", "Close");
		connection.setRequestProperty("SoapAction", "");
		connection.setDoOutput(true);
		PrintWriter pw = new PrintWriter(connection.getOutputStream());
		pw.write(message);
		pw.flush();
		connection.connect();
		StringWriter writer = new StringWriter();
		IOUtils.copy(connection.getInputStream(), writer, "utf-8");
		String xmlString = writer.toString();
		return loadXML(xmlString);
	}

	private String generateUrlRequest(String companyCode) {
		String nsSchema = "http://www.w3.org/2001/XMLSchema";

		String soapSchema = "http://schemas.xmlsoap.org/soap/envelope/";

		String xsiSchema = "http://www.w3.org/2001/XMLSchema-instance";

		String encodingStyle = "http://schemas.xmlsoap.org/soap/encoding/";

		String getUrlRequest = "<soapenv:Envelope " + " xmlns:xsi=\""
				+ xsiSchema + "\" " + " xmlns:soapenv=\"" + soapSchema + "\" "
				+ " xmlns:urn=\"urn:TBEDispatcherAPI\" " + " xmlns:xsd=\""
				+ nsSchema + "\"> " + "<soapenv:Body>"
				+ "   <urn:getURL soapenv:encodingStyle=\"" + encodingStyle
				+ "\">" + "<orgCode xsi:type=\"xsd:string\">" + companyCode
				+ "</orgCode>" + "</urn:getURL>" + "</soapenv:Body>"
				+ "</soapenv:Envelope>";
		return getUrlRequest;
	}

	private Document loadXML(String xml) throws Exception {
		DocumentBuilderFactory fctr = DocumentBuilderFactory.newInstance();
		DocumentBuilder bldr = fctr.newDocumentBuilder();
		InputSource insrc = new InputSource(new StringReader(xml));
		return bldr.parse(insrc);
	}

	@Override
	public String login(String companyCode, String userId, String password)
			throws TaleoException {
		try {
			return rpc.login(companyCode, userId, password);
		} catch (WebServicesException_Exception e) {
			throw new TaleoException(e);
		}
	}

	@Override
	public void logout(String sessionId) throws TaleoException {
		try {
			rpc.logout(sessionId);
		} catch (WebServicesException_Exception e) {
			throw new TaleoException(e);
		}
	}

	@Override
	public String getLoginToken(String sessionId) throws TaleoException {
		try {
			return rpc.getLoginToken(sessionId);
		} catch (WebServicesException_Exception e) {
			throw new TaleoException(e);
		}
	}

	@Override
	public LookupArr getLookup(String fieldName) throws TaleoException {
		try {
			return rpc.getLookup(sessionId, fieldName);
		} catch (WebServicesException_Exception e) {
			throw new TaleoException(e);
		}
	}

	@Override
	public MetadataArr getMetadata(EntityTypeEnum entityType)
			throws TaleoException {
		try {
			return rpc.getMetadata(sessionId, entityType.toString());
		} catch (WebServicesException_Exception e) {
			throw new TaleoException(e);
		}
	}

	@Override
	public long createOffer(OfferBean offer) throws TaleoException {
		try {
			return rpc.createOffer(sessionId, offer);
		} catch (WebServicesException_Exception e) {
			throw new TaleoException(e);
		}
	}

	@Override
	public void deleteOffer(long offerId) throws TaleoException {
		try {
			rpc.deleteOffer(sessionId, offerId);
		} catch (WebServicesException_Exception e) {
			throw new TaleoException(e);
		}
	}

	@Override
	public ByteArr getBinaryOffer(long offerId) throws TaleoException {
		try {
			return rpc.getBinaryOffer(sessionId, offerId);
		} catch (WebServicesException_Exception e) {
			throw new TaleoException(e);
		}
	}

	@Override
	public OfferBean getOfferByID(long offerId) throws TaleoException {
		try {
			return rpc.getOfferById(sessionId, offerId);
		} catch (WebServicesException_Exception e) {
			throw new TaleoException(e);
		}
	}

	@Override
	public LongArr getOffers(long candidateId) throws TaleoException {
		try {
			return rpc.getOffers(sessionId, candidateId);
		} catch (WebServicesException_Exception e) {
			throw new TaleoException(e);
		}
	}

	@Override
	public void setBinaryOffer(long offerId, String fileName, ByteArr content)
			throws TaleoException {
		try {
			rpc.setBinaryOffer(sessionId, offerId, fileName, content);
		} catch (WebServicesException_Exception e) {
			throw new TaleoException(e);
		}
	}

	@Override
	public void updateOffer(OfferBean offer) throws TaleoException {
		try {
			rpc.updateOffer(sessionId, offer);
		} catch (WebServicesException_Exception e) {
			throw new TaleoException(e);
		}
	}

	@Override
	public long createReference(ReferenceBean reference) throws TaleoException {
		try {
			return rpc.createReference(sessionId, reference);
		} catch (WebServicesException_Exception e) {
			throw new TaleoException(e);
		}
	}

	@Override
	public void deleteReference(long referenceId) throws TaleoException {
		try {
			rpc.deleteReference(sessionId, referenceId);
		} catch (WebServicesException_Exception e) {
			throw new TaleoException(e);
		}
	}

	@Override
	public LongArr getReferencesByCandidate(long candidateId)
			throws TaleoException {
		try {
			return rpc.getReferencesByCandidate(sessionId, candidateId);
		} catch (WebServicesException_Exception e) {
			throw new TaleoException(e);
		}
	}

	@Override
	public ReferenceBean getReferenceById(long referenceId)
			throws TaleoException {
		try {
			return rpc.getReferenceById(sessionId, referenceId);
		} catch (WebServicesException_Exception e) {
			throw new TaleoException(e);
		}
	}

	@Override
	public void updateReference(ReferenceBean reference) throws TaleoException {
		try {
			rpc.updateReference(sessionId, reference);
		} catch (WebServicesException_Exception e) {
			throw new TaleoException(e);
		}
	}

	@Override
	public long createRegion(RegionBean region) throws TaleoException {
		try {
			return rpc.createRegion(sessionId, region);
		} catch (WebServicesException_Exception e) {
			throw new TaleoException(e);
		}
	}

	@Override
	public void deleteRegion(long regionId) throws TaleoException {
		try {
			rpc.deleteRegion(sessionId, regionId);
		} catch (WebServicesException_Exception e) {
			throw new TaleoException(e);
		}
	}

	@Override
	public RegionBean getRegionById(long regionId) throws TaleoException {
		try {
			return rpc.getRegionById(sessionId, regionId);
		} catch (WebServicesException_Exception e) {
			throw new TaleoException(e);
		}
	}

	@Override
	public RegionBean getRegionByName(String regionName) throws TaleoException {
		try {
			return rpc.getRegionByName(sessionId, regionName);
		} catch (WebServicesException_Exception e) {
			throw new TaleoException(e);
		}
	}

	@Override
	public RegionArr getRegions() throws TaleoException {
		try {
			return rpc.getRegions(sessionId);
		} catch (WebServicesException_Exception e) {
			throw new TaleoException(e);
		}
	}

	@Override
	public long upsertRegion(RegionBean region) throws TaleoException {
		try {
			return rpc.upsertRegion(sessionId, region);
		} catch (WebServicesException_Exception e) {
			throw new TaleoException(e);
		}
	}

	@Override
	public long createRequisition(RequisitionBean requisition)
			throws TaleoException {
		try {
			return rpc.createRequisition(sessionId, requisition);
		} catch (WebServicesException_Exception e) {
			throw new TaleoException(e);
		}
	}

	@Override
	public long createRequisitionTemplate(RequisitionBean requisition)
			throws TaleoException {
		try {
			return rpc.createRequisitionTemplate(sessionId, requisition);
		} catch (WebServicesException_Exception e) {
			throw new TaleoException(e);
		}
	}

	@Override
	public void deleteRequisition(long requisitionId) throws TaleoException {
		try {
			rpc.deleteRequisition(sessionId, requisitionId);
		} catch (WebServicesException_Exception e) {
			throw new TaleoException(e);
		}
	}

	@Override
	public RequisitionBean getRequisitionById(long requisitionId)
			throws TaleoException {
		try {
			return rpc.getRequisitionById(sessionId, requisitionId);
		} catch (WebServicesException_Exception e) {
			throw new TaleoException(e);
		}
	}

	@Override
	public HistoryBeanArr getRequisitionHistory(long requisitionId)
			throws TaleoException {
		try {
			return rpc.getRequisitionHistory(sessionId, requisitionId);
		} catch (WebServicesException_Exception e) {
			throw new TaleoException(e);
		}
	}

	@Override
	public void postRequisition(long requisitionId, long posterId,
			int formVersion) throws TaleoException {
		try {
			rpc.postRequisition(sessionId, requisitionId, posterId, formVersion);
		} catch (WebServicesException_Exception e) {
			throw new TaleoException(e);
		}
	}

	@Override
	public SearchResultArr searchRequisition(Map searchParameters)
			throws TaleoException {
		try {
			return rpc.searchRequisition(sessionId, searchParameters);
		} catch (WebServicesException_Exception e) {
			throw new TaleoException(e);
		}
	}

	@Override
	public void unpostRequisition(long requisitionId, long posterId)
			throws TaleoException {
		try {
			rpc.unpostRequisition(sessionId, requisitionId, posterId);
		} catch (WebServicesException_Exception e) {
			throw new TaleoException(e);
		}
	}

	@Override
	public void updateRequisition(RequisitionBean requisition)
			throws TaleoException {
		try {
			rpc.updateRequisition(sessionId, requisition);
		} catch (WebServicesException_Exception e) {
			throw new TaleoException(e);
		}
	}

	@Override
	public ByteArr getBinaryResume(long candidateId) throws TaleoException {
		try {
			return rpc.getBinaryResume(sessionId, candidateId);
		} catch (WebServicesException_Exception e) {
			throw new TaleoException(e);
		}
	}

	@Override
	public String parseResume(ByteArr binaryAttachment) throws TaleoException {
		try {
			return rpc.parseResume(sessionId, binaryAttachment);
		} catch (WebServicesException_Exception e) {
			throw new TaleoException(e);
		}
	}

	@Override
	public CandidateInsertResultBean parseResumeIntoCandidate(
			ByteArr binaryAttachment, String referredBy, String fileName)
			throws TaleoException {
		try {
			return rpc.parseResumeIntoCandidate(sessionId, binaryAttachment,
					referredBy, fileName);
		} catch (WebServicesException_Exception e) {
			throw new TaleoException(e);
		}
	}

	@Override
	public void setBinaryResume(long candidateId, String fileName,
			ByteArr binaryAttachment) throws TaleoException {
		try {
			rpc.setBinaryResume(sessionId, candidateId, fileName,
					binaryAttachment);
		} catch (WebServicesException_Exception e) {
			throw new TaleoException(e);
		}
	}

	@Override
	public void deleteRollingEntity(long rollingEntityId) throws TaleoException {
		try {
			rpc.deleteRollingEntity(sessionId, rollingEntityId);
		} catch (WebServicesException_Exception e) {
			throw new TaleoException(e);
		}
	}

	@Override
	public FlexRollingEntityBeanArr getRollingEntities(
			String rollingEntityType, String entityType, long entityId)
			throws TaleoException {
		try {
			return rpc.getRollingEntities(sessionId, rollingEntityType,
					entityType, entityId);
		} catch (WebServicesException_Exception e) {
			throw new TaleoException(e);
		}
	}

	@Override
	public long upsertRollingEntity(FlexRollingEntityBean rollingEntityBean)
			throws TaleoException {
		try {
			return rpc.upsertRollingEntity(sessionId, rollingEntityBean);
		} catch (WebServicesException_Exception e) {
			throw new TaleoException(e);
		}
	}

	@Override
	public String getEnabledServices() throws TaleoException {
		try {
			return rpc.getEnabledServices(sessionId);
		} catch (WebServicesException_Exception e) {
			throw new TaleoException(e);
		}
	}

	@Override
	public Map getSystemProps() throws TaleoException {
		try {
			return rpc.getSystemProps(sessionId);
		} catch (WebServicesException_Exception e) {
			throw new TaleoException(e);
		}
	}

	@Override
	public long createTask(TaskBean task) throws TaleoException {
		try {
			return rpc.createTask(sessionId, task);
		} catch (WebServicesException_Exception e) {
			throw new TaleoException(e);
		}
	}

	@Override
	public void deleteTask(long taskId) throws TaleoException {
		try {
			rpc.deleteTask(sessionId, taskId);
		} catch (WebServicesException_Exception e) {
			throw new TaleoException(e);
		}

	}

	@Override
	public LongArr getTaskByEntity(String entityType, long entityId)
			throws TaleoException {
		try {
			return rpc.getTaskByEntity(sessionId, entityType, entityId);
		} catch (WebServicesException_Exception e) {
			throw new TaleoException(e);
		}
	}

	@Override
	public TaskBean getTaskById(long taskId) throws TaleoException {
		try {
			return rpc.getTaskById(sessionId, taskId);
		} catch (WebServicesException_Exception e) {
			throw new TaleoException(e);
		}
	}

	@Override
	public LongArr getTaskByUser(long userId, GregorianCalendar startDate,
			GregorianCalendar endDate) throws TaleoException {
		try {
			XMLGregorianCalendar xstartDate = DatatypeFactory.newInstance()
					.newXMLGregorianCalendar(startDate);
			XMLGregorianCalendar xendDate = DatatypeFactory.newInstance()
					.newXMLGregorianCalendar(startDate);
			return rpc.getTaskByUser(sessionId, userId, xstartDate, xendDate);
		} catch (WebServicesException_Exception e) {
			throw new TaleoException(e);
		} catch (DatatypeConfigurationException e) {
			throw new TaleoException(e);
		}
	}

	@Override
	public void updateTask(TaskBean task) throws TaleoException {
		try {
			rpc.updateTask(sessionId, task);
		} catch (WebServicesException_Exception e) {
			throw new TaleoException(e);
		}

	}

	@Override
	public LongArr getAssociatedUsers(long requisitionId, String association)
			throws TaleoException {
		try {
			return rpc
					.getAssociatedUsers(sessionId, requisitionId, association);
		} catch (WebServicesException_Exception e) {
			throw new TaleoException(e);
		}
	}

	@Override
	public void removeAssociatedUser(long requisitionId, String association,
			long userId) throws TaleoException {
		try {
			rpc.removeAssociatedUser(sessionId, requisitionId, association,
					userId);
		} catch (WebServicesException_Exception e) {
			throw new TaleoException(e);
		}

	}

	@Override
	public void setAssociatedUser(long requisitionId, String association,
			long userId, int userSequenceNumber) throws TaleoException {
		try {
			rpc.setAssociatedUser(sessionId, requisitionId, association,
					userId, userSequenceNumber);
		} catch (WebServicesException_Exception e) {
			throw new TaleoException(e);
		}

	}

	@Override
	public long createUser(UserBean user) throws TaleoException {
		try {
			return rpc.createUser(sessionId, user);
		} catch (WebServicesException_Exception e) {
			throw new TaleoException(e);
		}
	}

	@Override
	public long createUserWithPermissions(UserBean user, Map additionalEntities)
			throws TaleoException {
		try {
			return rpc.createUserWithPermissions(sessionId, user,
					additionalEntities);
		} catch (WebServicesException_Exception e) {
			throw new TaleoException(e);
		}
	}

	@Override
	public UserBean getUserById(long userId) throws TaleoException {
		try {
			return rpc.getUserById(sessionId, userId);
		} catch (WebServicesException_Exception e) {
			throw new TaleoException(e);
		}
	}

	@Override
	public HistoryBeanArr getUserHistory(long userId) throws TaleoException {
		try {
			return rpc.getUserHistory(sessionId, userId);
		} catch (WebServicesException_Exception e) {
			throw new TaleoException(e);
		}
	}

	@Override
	public void updateUser(UserBean user) throws TaleoException {
		try {
			rpc.updateUser(sessionId, user);
		} catch (WebServicesException_Exception e) {
			throw new TaleoException(e);
		}
	}

	@Override
	public String loginPartner(String orgCode, String partnerCode,
			long currentTimeMillis, String digest) throws TaleoException {
		try {
			return rpc.loginPartner(orgCode, partnerCode, currentTimeMillis,
					digest);
		} catch (WebServicesException_Exception e) {
			throw new TaleoException(e);
		}
	}

	@Override
	public SearchResultArr searchUser(Map searchParams) throws TaleoException {
		try {
			return rpc.searchUser(sessionId, searchParams);
		} catch (WebServicesException_Exception e) {
			throw new TaleoException(e);
		}
	}

	@Override
	public void deleteUser(long userId) throws TaleoException {
		try {
			rpc.deleteUser(sessionId, userId);
		} catch (WebServicesException_Exception e) {
			throw new TaleoException(e);
		}
	}

}
