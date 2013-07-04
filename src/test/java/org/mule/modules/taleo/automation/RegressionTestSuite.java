/**
 * (c) 2003-2012 MuleSoft, Inc. This software is protected under international
 * copyright law. All use of this software is subject to MuleSoft's Master
 * Subscription Agreement (or other Terms of Service) separately entered
 * into between you and MuleSoft. If such an agreement is not in
 * place, you may not use the software.
 */

package org.mule.modules.taleo.automation;

import org.junit.experimental.categories.Categories;
import org.junit.experimental.categories.Categories.IncludeCategory;
import org.junit.runner.RunWith;
import org.junit.runners.Suite.SuiteClasses;
import org.mule.modules.taleo.automation.testcases.AssociatedUserTestCases;
import org.mule.modules.taleo.automation.testcases.CreateAccountTestCases;
import org.mule.modules.taleo.automation.testcases.CreateAttachmentTestCases;
import org.mule.modules.taleo.automation.testcases.CreateBackgroundCheckTestCases;
import org.mule.modules.taleo.automation.testcases.CreateCandidateTestCases;
import org.mule.modules.taleo.automation.testcases.CreateContactTestCases;
import org.mule.modules.taleo.automation.testcases.CreateLinkTestCases;
import org.mule.modules.taleo.automation.testcases.CreateDepartmentTestCases;
import org.mule.modules.taleo.automation.testcases.CreateEntityAttachmentTestCases;
import org.mule.modules.taleo.automation.testcases.CreateInterviewTestCases;
import org.mule.modules.taleo.automation.testcases.CreateOfferTestCases;
import org.mule.modules.taleo.automation.testcases.CreateRequisitionTemplateTestCases;
import org.mule.modules.taleo.automation.testcases.CreateRequisitionTestCases;
import org.mule.modules.taleo.automation.testcases.DeleteAccountTestCases;
import org.mule.modules.taleo.automation.testcases.DeleteAttachmentTestCases;
import org.mule.modules.taleo.automation.testcases.DeleteBackgroundCheckTestCases;
import org.mule.modules.taleo.automation.testcases.DeleteCandidateTestCases;
import org.mule.modules.taleo.automation.testcases.DeleteContactTestCases;
import org.mule.modules.taleo.automation.testcases.DeleteDepartmentTestCases;
import org.mule.modules.taleo.automation.testcases.DeleteInterviewTestCases;
import org.mule.modules.taleo.automation.testcases.DeleteOfferTestCases;
import org.mule.modules.taleo.automation.testcases.DeleteRequisitionTestCases;
import org.mule.modules.taleo.automation.testcases.GetAccountByIdTestCases;
import org.mule.modules.taleo.automation.testcases.GetAccountHistoryTestCases;
import org.mule.modules.taleo.automation.testcases.GetAttachmentDataTestCases;
import org.mule.modules.taleo.automation.testcases.GetAttachmentTestCases;
import org.mule.modules.taleo.automation.testcases.GetAttachmentsTestCases;
import org.mule.modules.taleo.automation.testcases.GetBackgroundCheckByIdTestCases;
import org.mule.modules.taleo.automation.testcases.GetBackgroundChecksByCandidateTestCases;
import org.mule.modules.taleo.automation.testcases.GetCandidateByIdTestCases;
import org.mule.modules.taleo.automation.testcases.GetCandidateHistoryTestCases;
import org.mule.modules.taleo.automation.testcases.GetContactByIdTestCases;
import org.mule.modules.taleo.automation.testcases.GetContactHistoryTestCases;
import org.mule.modules.taleo.automation.testcases.GetDepartmentByIdTestCases;
import org.mule.modules.taleo.automation.testcases.GetDepartmentByNameTestCases;
import org.mule.modules.taleo.automation.testcases.GetDepartmentsTestCases;
import org.mule.modules.taleo.automation.testcases.GetEntityAttachmentTestCases;
import org.mule.modules.taleo.automation.testcases.GetInterviewByIdTestCases;
import org.mule.modules.taleo.automation.testcases.GetInterviewsByCandidateTestCases;
import org.mule.modules.taleo.automation.testcases.GetOfferByIdTestCases;
import org.mule.modules.taleo.automation.testcases.GetRequisitionByIdTestCases;
import org.mule.modules.taleo.automation.testcases.GetRequisitionHistoryTestCases;
import org.mule.modules.taleo.automation.testcases.GetRequisitionsTestCases;
import org.mule.modules.taleo.automation.testcases.GetUserByIdTestCases;
import org.mule.modules.taleo.automation.testcases.GetUserHistoryTestCases;
import org.mule.modules.taleo.automation.testcases.ParseResumeTestCases;
import org.mule.modules.taleo.automation.testcases.PostUnpostRequisitionTestCases;
import org.mule.modules.taleo.automation.testcases.RegressionTests;
import org.mule.modules.taleo.automation.testcases.RemoveCandidateTestCases;
import org.mule.modules.taleo.automation.testcases.SearchAccountTestCases;
import org.mule.modules.taleo.automation.testcases.SearchCandidateTestCases;
import org.mule.modules.taleo.automation.testcases.SearchContactTestCases;
import org.mule.modules.taleo.automation.testcases.SearchRequisitionTestCases;
import org.mule.modules.taleo.automation.testcases.SearchUserTestCases;
import org.mule.modules.taleo.automation.testcases.SubmitCandidateTestCases;
import org.mule.modules.taleo.automation.testcases.UpdateAccountTestCases;
import org.mule.modules.taleo.automation.testcases.UpdateAttachmentTestCases;
import org.mule.modules.taleo.automation.testcases.UpdateBackgroundCheckTestCases;
import org.mule.modules.taleo.automation.testcases.UpdateCandidateTestCases;
import org.mule.modules.taleo.automation.testcases.UpdateContactTestCases;
import org.mule.modules.taleo.automation.testcases.UpdateInterviewTestCases;
import org.mule.modules.taleo.automation.testcases.UpdateOfferTestCases;
import org.mule.modules.taleo.automation.testcases.UpdateRequisitionTestCases;
import org.mule.modules.taleo.automation.testcases.UpsertDepartmentTestCases;

@RunWith(Categories.class)
@IncludeCategory(RegressionTests.class)

@SuiteClasses({
	
	AssociatedUserTestCases.class,
	CreateAccountTestCases.class,
	CreateAttachmentTestCases.class,
	CreateBackgroundCheckTestCases.class,
	CreateCandidateTestCases.class,
	CreateContactTestCases.class,
	CreateLinkTestCases.class,
	CreateDepartmentTestCases.class,
	CreateEntityAttachmentTestCases.class,
	CreateInterviewTestCases.class,
	CreateOfferTestCases.class,
	CreateRequisitionTemplateTestCases.class,
	CreateRequisitionTestCases.class,
	DeleteAccountTestCases.class,
	DeleteAttachmentTestCases.class,
	DeleteBackgroundCheckTestCases.class,
	DeleteCandidateTestCases.class,
	DeleteContactTestCases.class,
	DeleteDepartmentTestCases.class,
	DeleteInterviewTestCases.class,
	DeleteOfferTestCases.class,
	DeleteRequisitionTestCases.class,
	GetAccountByIdTestCases.class,
	GetAccountHistoryTestCases.class,
	GetAttachmentDataTestCases.class,
	GetAttachmentTestCases.class,
	GetAttachmentsTestCases.class,
	GetBackgroundCheckByIdTestCases.class,
	GetBackgroundChecksByCandidateTestCases.class,
	GetCandidateByIdTestCases.class,
	GetCandidateHistoryTestCases.class,
	GetContactByIdTestCases.class,
	GetContactHistoryTestCases.class,
	GetDepartmentByIdTestCases.class,
	GetDepartmentByNameTestCases.class,
	GetDepartmentsTestCases.class,
	GetEntityAttachmentTestCases.class,
	GetInterviewByIdTestCases.class,
	GetInterviewsByCandidateTestCases.class,
	GetOfferByIdTestCases.class,
	GetRequisitionByIdTestCases.class,
	GetRequisitionHistoryTestCases.class,
	GetRequisitionsTestCases.class,
	GetUserByIdTestCases.class,
	GetUserHistoryTestCases.class,
	ParseResumeTestCases.class,
	PostUnpostRequisitionTestCases.class,
	RemoveCandidateTestCases.class,
	SearchAccountTestCases.class,
	SearchCandidateTestCases.class,
	SearchContactTestCases.class,
	SearchRequisitionTestCases.class,
	SearchUserTestCases.class,
	SubmitCandidateTestCases.class,
	UpdateAccountTestCases.class,
	UpdateAttachmentTestCases.class,
	UpdateBackgroundCheckTestCases.class,
	UpdateCandidateTestCases.class,
	UpdateContactTestCases.class,
	UpdateInterviewTestCases.class,
	UpdateOfferTestCases.class,
	UpdateRequisitionTestCases.class,
	UpsertDepartmentTestCases.class
	
		})

public class RegressionTestSuite {
	
	
	
}