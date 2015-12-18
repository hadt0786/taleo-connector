
package org.mule.modules.taleo.config;

import javax.annotation.Generated;
import org.mule.config.MuleManifest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.FatalBeanException;
import org.springframework.beans.factory.xml.NamespaceHandlerSupport;


/**
 * Registers bean definitions parsers for handling elements in <code>http://www.mulesoft.org/schema/mule/taleo</code>.
 * 
 */
@SuppressWarnings("all")
@Generated(value = "Mule DevKit Version 3.6.1", date = "2015-12-18T03:06:03-03:00", comments = "Build UNNAMED.2405.44720b7")
public class TaleoNamespaceHandler
    extends NamespaceHandlerSupport
{

    private static Logger logger = LoggerFactory.getLogger(TaleoNamespaceHandler.class);

    private void handleException(String beanName, String beanScope, NoClassDefFoundError noClassDefFoundError) {
        String muleVersion = "";
        try {
            muleVersion = MuleManifest.getProductVersion();
        } catch (Exception _x) {
            logger.error("Problem while reading mule version");
        }
        logger.error(((((("Cannot launch the mule app, the  "+ beanScope)+" [")+ beanName)+"] within the connector [taleo] is not supported in mule ")+ muleVersion));
        throw new FatalBeanException(((((("Cannot launch the mule app, the  "+ beanScope)+" [")+ beanName)+"] within the connector [taleo] is not supported in mule ")+ muleVersion), noClassDefFoundError);
    }

    /**
     * Invoked by the {@link DefaultBeanDefinitionDocumentReader} after construction but before any custom elements are parsed. 
     * @see NamespaceHandlerSupport#registerBeanDefinitionParser(String, BeanDefinitionParser)
     * 
     */
    public void init() {
        try {
            this.registerBeanDefinitionParser("config", new TaleoConnectorTaleoConnectorConnectionManagementConfigDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("config", "@Config", ex);
        }
        try {
            this.registerBeanDefinitionParser("upsert-employee", new UpsertEmployeeDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("upsert-employee", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("set-binary-resume", new SetBinaryResumeDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("set-binary-resume", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("delete-offer", new DeleteOfferDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("delete-offer", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("search-requisition", new SearchRequisitionDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("search-requisition", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("delete-contact-log", new DeleteContactLogDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("delete-contact-log", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("get-event-by-id", new GetEventByIdDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("get-event-by-id", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("create-email-log", new CreateEmailLogDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("create-email-log", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("get-enabled-services", new GetEnabledServicesDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("get-enabled-services", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("update-candidate", new UpdateCandidateDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("update-candidate", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("create-requisition", new CreateRequisitionDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("create-requisition", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("get-lookup", new GetLookupDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("get-lookup", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("delete-candidate", new DeleteCandidateDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("delete-candidate", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("get-department-by-name", new GetDepartmentByNameDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("get-department-by-name", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("update-contact", new UpdateContactDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("update-contact", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("get-user-history", new GetUserHistoryDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("get-user-history", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("get-account-history", new GetAccountHistoryDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("get-account-history", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("upsert-region", new UpsertRegionDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("upsert-region", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("get-offer-by-id", new GetOfferByIdDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("get-offer-by-id", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("get-contact-log-by-id", new GetContactLogByIdDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("get-contact-log-by-id", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("get-interview-by-id", new GetInterviewByIdDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("get-interview-by-id", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("get-system-props", new GetSystemPropsDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("get-system-props", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("get-metadata", new GetMetadataDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("get-metadata", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("get-public-events", new GetPublicEventsDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("get-public-events", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("get-binary-resume", new GetBinaryResumeDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("get-binary-resume", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("get-background-checks-by-candidate", new GetBackgroundChecksByCandidateDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("get-background-checks-by-candidate", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("upsert-location", new UpsertLocationDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("upsert-location", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("update-attachment", new UpdateAttachmentDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("update-attachment", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("create-user", new CreateUserDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("create-user", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("login-partner", new LoginPartnerDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("login-partner", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("create-offer", new CreateOfferDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("create-offer", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("get-candidate-details-by-id", new GetCandidateDetailsByIdDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("get-candidate-details-by-id", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("update-contact-log", new UpdateContactLogDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("update-contact-log", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("create-email-sent-log", new CreateEmailSentLogDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("create-email-sent-log", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("create-contact-log", new CreateContactLogDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("create-contact-log", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("get-attachment-data", new GetAttachmentDataDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("get-attachment-data", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("get-regions", new GetRegionsDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("get-regions", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("create-candidate", new CreateCandidateDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("create-candidate", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("get-location-by-id", new GetLocationByIdDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("get-location-by-id", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("create-department", new CreateDepartmentDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("create-department", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("search-contact", new SearchContactDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("search-contact", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("update-reference", new UpdateReferenceDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("update-reference", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("get-locations", new GetLocationsDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("get-locations", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("get-references-by-candidate", new GetReferencesByCandidateDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("get-references-by-candidate", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("get-user-by-id", new GetUserByIdDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("get-user-by-id", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("get-task-by-entity", new GetTaskByEntityDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("get-task-by-entity", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("remove-candidate", new RemoveCandidateDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("remove-candidate", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("get-department-by-id", new GetDepartmentByIdDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("get-department-by-id", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("create-employee", new CreateEmployeeDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("create-employee", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("get-task-by-id", new GetTaskByIdDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("get-task-by-id", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("get-contact-logs-by-entity", new GetContactLogsByEntityDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("get-contact-logs-by-entity", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("delete-reference", new DeleteReferenceDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("delete-reference", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("get-reference-by-id", new GetReferenceByIdDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("get-reference-by-id", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("create-region", new CreateRegionDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("create-region", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("delete-contact", new DeleteContactDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("delete-contact", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("get-candidates-by-requisition", new GetCandidatesByRequisitionDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("get-candidates-by-requisition", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("get-background-check-by-id", new GetBackgroundCheckByIdDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("get-background-check-by-id", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("remove-associated-user", new RemoveAssociatedUserDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("remove-associated-user", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("get-requisition-by-id", new GetRequisitionByIdDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("get-requisition-by-id", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("update-requisition", new UpdateRequisitionDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("update-requisition", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("get-offers", new GetOffersDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("get-offers", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("delete-account", new DeleteAccountDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("delete-account", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("set-binary-offer", new SetBinaryOfferDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("set-binary-offer", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("create-contact", new CreateContactDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("create-contact", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("get-candidate-work-history", new GetCandidateWorkHistoryDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("get-candidate-work-history", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("submit-candidate", new SubmitCandidateDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("submit-candidate", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("create-entity-attachment", new CreateEntityAttachmentDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("create-entity-attachment", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("delete-interview", new DeleteInterviewDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("delete-interview", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("post-requisition", new PostRequisitionDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("post-requisition", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("get-interviews-by-candidate", new GetInterviewsByCandidateDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("get-interviews-by-candidate", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("parse-resume-into-candidate", new ParseResumeIntoCandidateDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("parse-resume-into-candidate", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("delete-requisition", new DeleteRequisitionDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("delete-requisition", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("delete-department", new DeleteDepartmentDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("delete-department", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("get-employee-by-number", new GetEmployeeByNumberDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("get-employee-by-number", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("update-event", new UpdateEventDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("update-event", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("create-reference", new CreateReferenceDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("create-reference", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("get-attachments", new GetAttachmentsDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("get-attachments", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("delete-task", new DeleteTaskDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("delete-task", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("update-task", new UpdateTaskDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("update-task", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("get-event-by-entity", new GetEventByEntityDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("get-event-by-entity", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("delete-employee-by-number", new DeleteEmployeeByNumberDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("delete-employee-by-number", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("update-offer", new UpdateOfferDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("update-offer", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("get-rolling-entities", new GetRollingEntitiesDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("get-rolling-entities", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("get-candidate-history", new GetCandidateHistoryDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("get-candidate-history", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("create-event", new CreateEventDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("create-event", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("get-task-by-user", new GetTaskByUserDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("get-task-by-user", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("get-login-token", new GetLoginTokenDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("get-login-token", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("delete-region", new DeleteRegionDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("delete-region", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("update-background-check", new UpdateBackgroundCheckDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("update-background-check", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("create-location", new CreateLocationDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("create-location", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("get-associated-users", new GetAssociatedUsersDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("get-associated-users", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("create-interview", new CreateInterviewDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("create-interview", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("update-account", new UpdateAccountDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("update-account", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("get-requisition-history", new GetRequisitionHistoryDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("get-requisition-history", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("unpost-requisition", new UnpostRequisitionDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("unpost-requisition", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("get-entity-attachments", new GetEntityAttachmentsDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("get-entity-attachments", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("update-employee", new UpdateEmployeeDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("update-employee", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("create-account", new CreateAccountDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("create-account", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("delete-attachment", new DeleteAttachmentDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("delete-attachment", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("create-user-with-permissions", new CreateUserWithPermissionsDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("create-user-with-permissions", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("search-user", new SearchUserDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("search-user", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("upsert-department", new UpsertDepartmentDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("upsert-department", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("delete-employee", new DeleteEmployeeDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("delete-employee", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("get-contact-by-id", new GetContactByIdDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("get-contact-by-id", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("delete-rolling-entity", new DeleteRollingEntityDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("delete-rolling-entity", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("get-candidate-by-id", new GetCandidateByIdDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("get-candidate-by-id", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("get-requisitions", new GetRequisitionsDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("get-requisitions", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("remove-link", new RemoveLinkDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("remove-link", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("get-location-by-name", new GetLocationByNameDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("get-location-by-name", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("create-task", new CreateTaskDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("create-task", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("upsert-rolling-entity", new UpsertRollingEntityDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("upsert-rolling-entity", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("delete-background-check", new DeleteBackgroundCheckDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("delete-background-check", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("get-account-by-id", new GetAccountByIdDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("get-account-by-id", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("upsert-candidate-to-requisitions", new UpsertCandidateToRequisitionsDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("upsert-candidate-to-requisitions", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("get-departments", new GetDepartmentsDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("get-departments", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("delete-location", new DeleteLocationDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("delete-location", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("get-attachment", new GetAttachmentDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("get-attachment", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("parse-resume", new ParseResumeDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("parse-resume", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("create-background-check", new CreateBackgroundCheckDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("create-background-check", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("search-account", new SearchAccountDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("search-account", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("update-user", new UpdateUserDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("update-user", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("create-attachment", new CreateAttachmentDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("create-attachment", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("get-contact-history", new GetContactHistoryDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("get-contact-history", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("update-interview", new UpdateInterviewDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("update-interview", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("create-requisition-template", new CreateRequisitionTemplateDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("create-requisition-template", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("get-cand-req-status", new GetCandReqStatusDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("get-cand-req-status", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("get-region-by-name", new GetRegionByNameDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("get-region-by-name", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("get-employee-by-id", new GetEmployeeByIdDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("get-employee-by-id", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("search-candidate", new SearchCandidateDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("search-candidate", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("get-binary-offer", new GetBinaryOfferDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("get-binary-offer", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("search-employee", new SearchEmployeeDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("search-employee", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("get-region-by-id", new GetRegionByIdDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("get-region-by-id", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("delete-user", new DeleteUserDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("delete-user", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("delete-event", new DeleteEventDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("delete-event", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("create-link", new CreateLinkDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("create-link", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("set-associated-user", new SetAssociatedUserDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("set-associated-user", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("get-url", new GetUrlDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("get-url", "@Processor", ex);
        }
    }

}
