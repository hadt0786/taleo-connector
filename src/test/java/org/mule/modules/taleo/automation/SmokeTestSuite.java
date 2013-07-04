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
import org.mule.modules.taleo.automation.testcases.*;

@RunWith(Categories.class)
@IncludeCategory(SmokeTests.class)

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

public class SmokeTestSuite {
	
}