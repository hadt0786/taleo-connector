
package org.mule.modules.taleo.model.holders;

import javax.annotation.Generated;
import org.mule.modules.taleo.model.ArrayOfXsdLong;
import org.mule.modules.taleo.model.ArrayOfXsdString;
import org.mule.modules.taleo.model.Map;

@SuppressWarnings("all")
@Generated(value = "Mule DevKit Version 3.6.1", date = "2015-12-18T03:06:03-03:00", comments = "Build UNNAMED.2405.44720b7")
public class LocationBeanExpressionHolder
    extends AddressEntityBeanExpressionHolder
{

    protected Object additionalProperties;
    protected Map _additionalPropertiesType;
    protected Object directions;
    protected String _directionsType;
    protected Object locationId;
    protected long _locationIdType;
    protected Object locationName;
    protected String _locationNameType;
    protected Object regionId;
    protected long _regionIdType;
    protected Object timeZone;
    protected String _timeZoneType;
    protected Object interviewRooms;
    protected ArrayOfXsdString _interviewRoomsType;
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
     * Sets directions
     * 
     * @param value Value to set
     */
    public void setDirections(Object value) {
        this.directions = value;
    }

    /**
     * Retrieves directions
     * 
     */
    public Object getDirections() {
        return this.directions;
    }

    /**
     * Sets locationId
     * 
     * @param value Value to set
     */
    public void setLocationId(Object value) {
        this.locationId = value;
    }

    /**
     * Retrieves locationId
     * 
     */
    public Object getLocationId() {
        return this.locationId;
    }

    /**
     * Sets locationName
     * 
     * @param value Value to set
     */
    public void setLocationName(Object value) {
        this.locationName = value;
    }

    /**
     * Retrieves locationName
     * 
     */
    public Object getLocationName() {
        return this.locationName;
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
     * Sets timeZone
     * 
     * @param value Value to set
     */
    public void setTimeZone(Object value) {
        this.timeZone = value;
    }

    /**
     * Retrieves timeZone
     * 
     */
    public Object getTimeZone() {
        return this.timeZone;
    }

    /**
     * Sets interviewRooms
     * 
     * @param value Value to set
     */
    public void setInterviewRooms(Object value) {
        this.interviewRooms = value;
    }

    /**
     * Retrieves interviewRooms
     * 
     */
    public Object getInterviewRooms() {
        return this.interviewRooms;
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
