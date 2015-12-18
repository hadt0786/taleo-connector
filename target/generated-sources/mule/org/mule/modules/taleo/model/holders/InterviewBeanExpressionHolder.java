
package org.mule.modules.taleo.model.holders;

import javax.annotation.Generated;
import javax.xml.datatype.XMLGregorianCalendar;
import org.mule.modules.taleo.model.ArrayOfParticipantBean;

@SuppressWarnings("all")
@Generated(value = "Mule DevKit Version 3.6.1", date = "2015-12-18T03:06:03-03:00", comments = "Build UNNAMED.2405.44720b7")
public class InterviewBeanExpressionHolder
    extends EntityBeanExpressionHolder
{

    protected Object candidateId;
    protected long _candidateIdType;
    protected Object comments;
    protected String _commentsType;
    protected Object creator;
    protected String _creatorType;
    protected Object interviewRoom;
    protected String _interviewRoomType;
    protected Object interviewType;
    protected String _interviewTypeType;
    protected Object participants;
    protected ArrayOfParticipantBean _participantsType;
    protected Object requisitionId;
    protected long _requisitionIdType;
    protected Object startDate;
    protected XMLGregorianCalendar _startDateType;

    /**
     * Sets candidateId
     * 
     * @param value Value to set
     */
    public void setCandidateId(Object value) {
        this.candidateId = value;
    }

    /**
     * Retrieves candidateId
     * 
     */
    public Object getCandidateId() {
        return this.candidateId;
    }

    /**
     * Sets comments
     * 
     * @param value Value to set
     */
    public void setComments(Object value) {
        this.comments = value;
    }

    /**
     * Retrieves comments
     * 
     */
    public Object getComments() {
        return this.comments;
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
     * Sets interviewRoom
     * 
     * @param value Value to set
     */
    public void setInterviewRoom(Object value) {
        this.interviewRoom = value;
    }

    /**
     * Retrieves interviewRoom
     * 
     */
    public Object getInterviewRoom() {
        return this.interviewRoom;
    }

    /**
     * Sets interviewType
     * 
     * @param value Value to set
     */
    public void setInterviewType(Object value) {
        this.interviewType = value;
    }

    /**
     * Retrieves interviewType
     * 
     */
    public Object getInterviewType() {
        return this.interviewType;
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
     * Sets requisitionId
     * 
     * @param value Value to set
     */
    public void setRequisitionId(Object value) {
        this.requisitionId = value;
    }

    /**
     * Retrieves requisitionId
     * 
     */
    public Object getRequisitionId() {
        return this.requisitionId;
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

}
