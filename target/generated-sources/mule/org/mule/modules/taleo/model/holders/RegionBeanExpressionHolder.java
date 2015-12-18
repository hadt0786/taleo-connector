
package org.mule.modules.taleo.model.holders;

import javax.annotation.Generated;
import javax.xml.datatype.XMLGregorianCalendar;
import org.mule.modules.taleo.model.ArrayOfXsdLong;
import org.mule.modules.taleo.model.ArrayOfXsdString;
import org.mule.modules.taleo.model.Map;

@SuppressWarnings("all")
@Generated(value = "Mule DevKit Version 3.6.1", date = "2015-12-18T03:06:03-03:00", comments = "Build UNNAMED.2405.44720b7")
public class RegionBeanExpressionHolder {

    protected Object additionalProperties;
    protected Map _additionalPropertiesType;
    protected Object creationDate;
    protected XMLGregorianCalendar _creationDateType;
    protected Object lastUpdated;
    protected XMLGregorianCalendar _lastUpdatedType;
    protected Object regionId;
    protected long _regionIdType;
    protected Object regionName;
    protected String _regionNameType;
    protected Object associatedLocations;
    protected ArrayOfXsdString _associatedLocationsType;
    protected Object associatedUsers;
    protected ArrayOfXsdLong _associatedUsersType;
    protected Object defaultApprovers;
    protected ArrayOfXsdLong _defaultApproversType;

    /**
     * Sets additionalProperties
     * 
     * @param value Value to set
     */
    public void setAdditionalProperties(Object value) {
        this.additionalProperties = value;
    }

    /**
     * Retrieves additionalProperties
     * 
     */
    public Object getAdditionalProperties() {
        return this.additionalProperties;
    }

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
     * Sets regionId
     * 
     * @param value Value to set
     */
    public void setRegionId(Object value) {
        this.regionId = value;
    }

    /**
     * Retrieves regionId
     * 
     */
    public Object getRegionId() {
        return this.regionId;
    }

    /**
     * Sets regionName
     * 
     * @param value Value to set
     */
    public void setRegionName(Object value) {
        this.regionName = value;
    }

    /**
     * Retrieves regionName
     * 
     */
    public Object getRegionName() {
        return this.regionName;
    }

    /**
     * Sets associatedLocations
     * 
     * @param value Value to set
     */
    public void setAssociatedLocations(Object value) {
        this.associatedLocations = value;
    }

    /**
     * Retrieves associatedLocations
     * 
     */
    public Object getAssociatedLocations() {
        return this.associatedLocations;
    }

    /**
     * Sets associatedUsers
     * 
     * @param value Value to set
     */
    public void setAssociatedUsers(Object value) {
        this.associatedUsers = value;
    }

    /**
     * Retrieves associatedUsers
     * 
     */
    public Object getAssociatedUsers() {
        return this.associatedUsers;
    }

    /**
     * Sets defaultApprovers
     * 
     * @param value Value to set
     */
    public void setDefaultApprovers(Object value) {
        this.defaultApprovers = value;
    }

    /**
     * Retrieves defaultApprovers
     * 
     */
    public Object getDefaultApprovers() {
        return this.defaultApprovers;
    }

}
