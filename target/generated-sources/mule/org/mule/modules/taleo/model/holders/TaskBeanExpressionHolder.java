
package org.mule.modules.taleo.model.holders;

import javax.annotation.Generated;
import javax.xml.datatype.XMLGregorianCalendar;
import org.mule.modules.taleo.model.ArrayOfParticipantBean;

@SuppressWarnings("all")
@Generated(value = "Mule DevKit Version 3.6.1", date = "2015-12-18T03:06:03-03:00", comments = "Build UNNAMED.2405.44720b7")
public class TaskBeanExpressionHolder
    extends EntityBeanExpressionHolder
{

    protected Object assignedTo;
    protected ArrayOfParticipantBean _assignedToType;
    protected Object creator;
    protected String _creatorType;
    protected Object description;
    protected String _descriptionType;
    protected Object dueDate;
    protected XMLGregorianCalendar _dueDateType;
    protected Object entityId;
    protected long _entityIdType;
    protected Object entityType;
    protected String _entityTypeType;
    protected Object priority;
    protected String _priorityType;
    protected Object subject;
    protected String _subjectType;

    /**
     * Sets assignedTo
     * 
     * @param value Value to set
     */
    public void setAssignedTo(Object value) {
        this.assignedTo = value;
    }

    /**
     * Retrieves assignedTo
     * 
     */
    public Object getAssignedTo() {
        return this.assignedTo;
    }

    /**
     * Sets creator
     * 
     * @param value Value to set
     */
    public void setCreator(Object value) {
        this.creator = value;
    }

    /**
     * Retrieves creator
     * 
     */
    public Object getCreator() {
        return this.creator;
    }

    /**
     * Sets description
     * 
     * @param value Value to set
     */
    public void setDescription(Object value) {
        this.description = value;
    }

    /**
     * Retrieves description
     * 
     */
    public Object getDescription() {
        return this.description;
    }

    /**
     * Sets dueDate
     * 
     * @param value Value to set
     */
    public void setDueDate(Object value) {
        this.dueDate = value;
    }

    /**
     * Retrieves dueDate
     * 
     */
    public Object getDueDate() {
        return this.dueDate;
    }

    /**
     * Sets entityId
     * 
     * @param value Value to set
     */
    public void setEntityId(Object value) {
        this.entityId = value;
    }

    /**
     * Retrieves entityId
     * 
     */
    public Object getEntityId() {
        return this.entityId;
    }

    /**
     * Sets entityType
     * 
     * @param value Value to set
     */
    public void setEntityType(Object value) {
        this.entityType = value;
    }

    /**
     * Retrieves entityType
     * 
     */
    public Object getEntityType() {
        return this.entityType;
    }

    /**
     * Sets priority
     * 
     * @param value Value to set
     */
    public void setPriority(Object value) {
        this.priority = value;
    }

    /**
     * Retrieves priority
     * 
     */
    public Object getPriority() {
        return this.priority;
    }

    /**
     * Sets subject
     * 
     * @param value Value to set
     */
    public void setSubject(Object value) {
        this.subject = value;
    }

    /**
     * Retrieves subject
     * 
     */
    public Object getSubject() {
        return this.subject;
    }

}
