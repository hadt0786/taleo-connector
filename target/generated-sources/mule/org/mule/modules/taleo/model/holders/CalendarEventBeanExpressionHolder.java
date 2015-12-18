
package org.mule.modules.taleo.model.holders;

import javax.annotation.Generated;
import javax.xml.datatype.XMLGregorianCalendar;
import org.mule.modules.taleo.model.ArrayOfParticipantBean;

@SuppressWarnings("all")
@Generated(value = "Mule DevKit Version 3.6.1", date = "2015-12-18T03:06:03-03:00", comments = "Build UNNAMED.2405.44720b7")
public class CalendarEventBeanExpressionHolder
    extends EntityBeanExpressionHolder
{

    protected Object creator;
    protected String _creatorType;
    protected Object description;
    protected String _descriptionType;
    protected Object duration;
    protected long _durationType;
    protected Object entityId;
    protected long _entityIdType;
    protected Object entityType;
    protected String _entityTypeType;
    protected Object isPrivate;
    protected boolean _isPrivateType;
    protected Object location;
    protected String _locationType;
    protected Object participants;
    protected ArrayOfParticipantBean _participantsType;
    protected Object startDate;
    protected XMLGregorianCalendar _startDateType;
    protected Object subject;
    protected String _subjectType;

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
     * Sets duration
     * 
     * @param value Value to set
     */
    public void setDuration(Object value) {
        this.duration = value;
    }

    /**
     * Retrieves duration
     * 
     */
    public Object getDuration() {
        return this.duration;
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
     * Sets isPrivate
     * 
     * @param value Value to set
     */
    public void setIsPrivate(Object value) {
        this.isPrivate = value;
    }

    /**
     * Retrieves isPrivate
     * 
     */
    public Object getIsPrivate() {
        return this.isPrivate;
    }

    /**
     * Sets location
     * 
     * @param value Value to set
     */
    public void setLocation(Object value) {
        this.location = value;
    }

    /**
     * Retrieves location
     * 
     */
    public Object getLocation() {
        return this.location;
    }

    /**
     * Sets participants
     * 
     * @param value Value to set
     */
    public void setParticipants(Object value) {
        this.participants = value;
    }

    /**
     * Retrieves participants
     * 
     */
    public Object getParticipants() {
        return this.participants;
    }

    /**
     * Sets startDate
     * 
     * @param value Value to set
     */
    public void setStartDate(Object value) {
        this.startDate = value;
    }

    /**
     * Retrieves startDate
     * 
     */
    public Object getStartDate() {
        return this.startDate;
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
