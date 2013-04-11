/**
 * Mule Taleo Cloud Connector
 *
 * Copyright (c) MuleSoft, Inc. All rights reserved. http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.md file.
 */

package org.mule.modules.client.core;

import java.util.GregorianCalendar;

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
import org.mule.modules.taleo.model.WorkHistoryArr;

public interface TaleoClient {

	//Connection handling
	boolean isConnected();

	String connectionId();
	
	void connect(String username, String password, String companyCode) throws ConnectionException;
	
	void disconnect();
	//Account
	long createAccount(AccountBean account) throws TaleoException;

	void deleteAccount(long accountId) throws TaleoException;

	AccountBean getAccountById(long accountId) throws TaleoException;

	HistoryBeanArr getAccountHistory(long accountId) throws TaleoException;

	SearchResultArr searchAccount(Map searchParams) throws TaleoException;

	void updateAccount(AccountBean account) throws TaleoException;

	//Attachments
	long createAttachment(long candidateId, String attachment,
			String attachmentName, String contentType, ByteArr binaryResume) throws TaleoException;

	long createEntityAttachment(String entityType, long entityId,
			String description, String fileName, String contentType,
			ByteArr data) throws TaleoException;

	AttachmentBean getAttachment(long attachmentId) throws TaleoException;
	
	void deleteAttachment(long attachmentId) throws TaleoException;

	ByteArr getAttachmentData(long attachmentId) throws TaleoException;

	LongArr getAttachments(long candidateId) throws TaleoException;

	LongArr getEntityAttachments(String entityType, long entityId) throws TaleoException;

	void updateAttachment(long attachmentId, String description, String name,
			String contentType, ByteArr binaryResume) throws TaleoException;

	//BackgroundCheck
	long createBackgroundCheck(BackgroundCheckBean backgroundCheck) throws TaleoException;

	void deleteBackgroundCheck(long backgroundCheckId) throws TaleoException;

	BackgroundCheckBean getBackgroundCheckById(long backgroundCheckId) throws TaleoException;

	LongArr getBackgroundChecksByCandidate(long candidateId) throws TaleoException;

	void updateBackgroundCheck(BackgroundCheckBean backgroundCheck) throws TaleoException;

	//Candidate
	long createCandidate(CandidateBean candidate) throws TaleoException;

	void deleteCandidate(long candidateId) throws TaleoException;

	CandidateBean getCandidateById(long candidateId) throws TaleoException;

	CandidateDetailsBean getCandidateDetailsById(long candidateId,
			boolean includeRequisitions, boolean includeInterviews,
			boolean includeReferences, boolean includeHistory,
			boolean includeAttachments, boolean includeOffers) throws TaleoException;

	HistoryBeanArr getCandidateHistory(long candidateId) throws TaleoException;

	LongArr getCandidatesByRequisition(long requisitionId) throws TaleoException;

	WorkHistoryArr getCandidateWorkHistory(long candidateId) throws TaleoException;

	String getCandReqStatus(long candidateId, long requisitionId) throws TaleoException;

	LongArr getRequisitions(long candidateId) throws TaleoException;

	SearchResultArr searchCandidate(Map searchParams) throws TaleoException;

	void submitCandidate(long candidateId, LongArr requisitionIds) throws TaleoException;

	void removeCandidate(long candidateId, long requisitionId) throws TaleoException;

	void updateCandidate(CandidateBean candidate) throws TaleoException;

	void upsertCandidateToRequisitions(long candidateId,
			LongArr requisitionIds, long statusId, long reasonId,
			boolean doRanking) throws TaleoException;

	//Contact
	long createContact(ContactBean contact) throws TaleoException;

	void deleteContact(long contactId) throws TaleoException;

	ContactBean getContactById(long contactId) throws TaleoException;

	HistoryBeanArr getContactHistory(long contactId) throws TaleoException;

	SearchResultArr searchContact(Map searchParams) throws TaleoException;

	void updateContact(ContactBean contact) throws TaleoException;

	//Contact Log
	long createContactLog(ContactLogBean contactLog) throws TaleoException;

	void deleteContactLog(long contactLogId) throws TaleoException;

	ContactLogBean getContactLogById(long contactLogId) throws TaleoException;

	LongArr getContactLogsByEntity(String entityType, long entityId) throws TaleoException;

	void updateContactLog(ContactLogBean contactLog) throws TaleoException;

	//Department
	long createDepartment(DepartmentBean department) throws TaleoException;

	void deleteDepartment(long departmentId) throws TaleoException;

	DepartmentBean getDepartmentById(long departmentId) throws TaleoException;

	DepartmentBean getDepartmentByName(String name) throws TaleoException;

	DepartmentArr getDepartments() throws TaleoException;

	long upsertDepartment(DepartmentBean department) throws TaleoException;

	long createEmailLog(String email, String subject, String body,
			GregorianCalendar date) throws TaleoException;

	long createEmailSentLog(String email, String subject, String body, 
			GregorianCalendar date) throws TaleoException;

	//Employee
	long createEmployee(EmployeeBean employee) throws TaleoException;

	void deleteEmployee(long employeeId) throws TaleoException;

	void deleteEmployeeByNumber(String employeeNumber) throws TaleoException;

	EmployeeBean getEmployeeById(long employeeId) throws TaleoException;

	EmployeeBean getEmployeeByNumber(String employeeNumber) throws TaleoException;

	SearchResultArr searchEmployee(Map searchParams) throws TaleoException;

	void updateEmployee(EmployeeBean employee) throws TaleoException;

	long upsertEmployee(String employeeNumber, EmployeeBean employee) throws TaleoException;

	//Event
	long createEvent(CalendarEventBean event) throws TaleoException;

	void deleteEvent(long eventId) throws TaleoException;

	CalendarEventBean getEventById(long eventId) throws TaleoException;

	LongArr getEventByEntity(String entityType, long entityId) throws TaleoException;

	LongArr getPublicEvents(GregorianCalendar startDate,
			GregorianCalendar endDate) throws TaleoException;

	void updateEvent(CalendarEventBean event) throws TaleoException;

	//Interview
	long createInterview(InterviewBean interview) throws TaleoException;

	void deleteInterview(long interviewId) throws TaleoException;

	LongArr getInterviewsByCandidate(long candidateId) throws TaleoException;

	InterviewBean getInterviewById(long interviewId) throws TaleoException;

	void updateInterview(InterviewBean interview) throws TaleoException;

	//Link
	void createLink(String entityType1, long entityId1, String entityType2,
			long entityId2) throws TaleoException;

	void removeLink(String entityType1, long entityId1, String entityType2,
			long entityId2) throws TaleoException;

	//Location
	long createLocation(LocationBean location) throws TaleoException;

	void deleteLocation(long locationId) throws TaleoException;

	LocationBean getLocationById(long locationId) throws TaleoException;

	LocationBean getLocationByName(String locationName) throws TaleoException;

	LocationArr getLocations() throws TaleoException;

	long upsertLocation(LocationBean location) throws TaleoException;

	//Login
	String getUrl(String companyCode) throws TaleoException;

	String login(String companyCode, String userId, String password) throws TaleoException;
	
	void logout(String sessionId) throws TaleoException;

	String getLoginToken(String sessionId) throws TaleoException;

	//Meta-data
	LookupArr getLookup(String fieldName) throws TaleoException;

	MetadataArr getMetadata(EntityTypeEnum entityType) throws TaleoException;

	//Offer
	long createOffer(OfferBean offer) throws TaleoException;

	void deleteOffer(long offerId) throws TaleoException;

	ByteArr getBinaryOffer(long offerId) throws TaleoException;

	OfferBean getOfferByID(long offerId) throws TaleoException;

	LongArr getOffers(long candidateId) throws TaleoException;

	void setBinaryOffer(long offerId, String fileName, ByteArr content) throws TaleoException;

	void updateOffer(OfferBean offer) throws TaleoException;
	
	//Reference
	long createReference(ReferenceBean reference) throws TaleoException;

	void deleteReference(long referenceId) throws TaleoException;

	LongArr getReferencesByCandidate(long candidateId) throws TaleoException;

	ReferenceBean getReferenceById(long referenceId) throws TaleoException;

	void updateReference(ReferenceBean reference) throws TaleoException;

	//Region
	long createRegion(RegionBean region) throws TaleoException;

	void deleteRegion(long regionId) throws TaleoException;

	RegionBean getRegionById(long regionId) throws TaleoException;

	RegionBean getRegionByName(String regionName) throws TaleoException;

	RegionArr getRegions() throws TaleoException;

	long upsertRegion(RegionBean region) throws TaleoException;

	//Requisition
	long createRequisition(RequisitionBean requisition) throws TaleoException;

	long createRequisitionTemplate(RequisitionBean requisition) throws TaleoException;

	void deleteRequisition(long requisitionId) throws TaleoException;

	RequisitionBean getRequisitionById(long requisitionId) throws TaleoException;

	HistoryBeanArr getRequisitionHistory(long requisitionId) throws TaleoException;

	void postRequisition(long requisitionId, long posterId, int formVersion) throws TaleoException;

	SearchResultArr searchRequisition(Map searchParameters) throws TaleoException;

	void unpostRequisition(long requisitionId, long posterId) throws TaleoException;

	void updateRequisition(RequisitionBean requisition) throws TaleoException;

	//Resume
	ByteArr getBinaryResume(long candidateId) throws TaleoException;

	String parseResume(ByteArr binaryAttachment) throws TaleoException;

	CandidateInsertResultBean parseResumeIntoCandidate(
			ByteArr binaryAttachment, String referredBy, String fileName) throws TaleoException;

	void setBinaryResume(long candidateId, String fileName,
			ByteArr binaryAttachment) throws TaleoException;

	//RollingEntity
	void deleteRollingEntity(long rollingEntityId) throws TaleoException;

	FlexRollingEntityBeanArr getRollingEntities(String rollingEntityType,
			String entityType, long entityId) throws TaleoException;

	long upsertRollingEntity(FlexRollingEntityBean rollingEntityBean) throws TaleoException;

	//System
	String getEnabledServices() throws TaleoException;

	Map getSystemProps() throws TaleoException;

	//Task
	long createTask(TaskBean task) throws TaleoException;

	void deleteTask(long taskId) throws TaleoException;

	LongArr getTaskByEntity(String entityType, long entityId) throws TaleoException;

	TaskBean getTaskById(long taskId) throws TaleoException;

	LongArr getTaskByUser(long userId, GregorianCalendar startDate,
			GregorianCalendar endDate) throws TaleoException;

	void updateTask(TaskBean task) throws TaleoException;

	//Associate
	LongArr getAssociatedUsers(long requisitionId, String association) throws TaleoException;
	
	void removeAssociatedUser(long requisitionId, String association,
			long userId) throws TaleoException;
	
	void setAssociatedUser(long requisitionId, String association, long userId,
			int userSequenceNumber) throws TaleoException;

	//User
	long createUser(UserBean user) throws TaleoException;

	long createUserWithPermissions(UserBean user, Map additionalEntities) throws TaleoException;

	void deleteUser(long userId) throws TaleoException;

	UserBean getUserById(long userId) throws TaleoException;

	HistoryBeanArr getUserHistory(long userId) throws TaleoException;

	void updateUser(UserBean user) throws TaleoException;

	String loginPartner(String orgCode, String partnerCode,
			long currentTimeMillis, String digest) throws TaleoException;

	SearchResultArr searchUser(Map searchParams) throws TaleoException;

}
