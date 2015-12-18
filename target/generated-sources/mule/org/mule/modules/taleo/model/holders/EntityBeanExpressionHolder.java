
package org.mule.modules.taleo.model.holders;

import javax.annotation.Generated;
import javax.xml.datatype.XMLGregorianCalendar;
import org.mule.modules.taleo.model.ArrayOfFlexFieldBean;

@SuppressWarnings("all")
@Generated(value = "Mule DevKit Version 3.6.1", date = "2015-12-18T03:06:03-03:00", comments = "Build UNNAMED.2405.44720b7")
public class EntityBeanExpressionHolder {

    protected Object creationDate;
    protected XMLGregorianCalendar _creationDateType;
    protected Object flexValues;
    protected ArrayOfFlexFieldBean _flexValuesType;
    protected Object id;
    protected long _idType;
    protected Object lastUpdated;
    protected XMLGregorianCalendar _lastUpdatedType;
    protected Object status;
    protected String _statusType;

    /**
     * Sets creationDate
     * 
     * @param value Value to set
     */
    public void setCreationDate(Object value) {
        this.creationDate = value;
    }

    /**
     * Retrieves creationDate
     * 
     */
    public Object getCreationDate() {
        return this.creationDate;
    }

    /**
     * Sets flexValues
     * 
     * @param value Value to set
     */
    public void setFlexValues(Object value) {
        this.flexValues = value;
    }

    /**
     * Retrieves flexValues
     * 
     */
    public Object getFlexValues() {
        return this.flexValues;
    }

    /**
     * Sets id
     * 
     * @param value Value to set
     */
    public void setId(Object value) {
        this.id = value;
    }

    /**
     * Retrieves id
     * 
     */
    public Object getId() {
        return this.id;
    }

    /**
     * Sets lastUpdated
     * 
     * @param value Value to set
     */
    public void setLastUpdated(Object value) {
        this.lastUpdated = value;
    }

    /**
     * Retrieves lastUpdated
     * 
     */
    public Object getLastUpdated() {
        return this.lastUpdated;
    }

    /**
     * Sets status
     * 
     * @param value Value to set
     */
    public void setStatus(Object value) {
        this.status = value;
    }

    /**
     * Retrieves status
     * 
     */
    public Object getStatus() {
        return this.status;
    }

}
