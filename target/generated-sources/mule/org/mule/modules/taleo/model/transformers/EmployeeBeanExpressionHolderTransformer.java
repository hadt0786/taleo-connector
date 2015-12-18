
package org.mule.modules.taleo.model.transformers;

import java.util.Arrays;
import java.util.List;
import javax.annotation.Generated;
import javax.xml.datatype.XMLGregorianCalendar;
import org.mule.api.MuleContext;
import org.mule.api.MuleEvent;
import org.mule.api.endpoint.ImmutableEndpoint;
import org.mule.api.lifecycle.InitialisationException;
import org.mule.api.transformer.DataType;
import org.mule.api.transformer.DiscoverableTransformer;
import org.mule.api.transformer.MessageTransformer;
import org.mule.api.transformer.TransformerException;
import org.mule.api.transformer.TransformerMessagingException;
import org.mule.config.i18n.CoreMessages;
import org.mule.devkit.processor.ExpressionEvaluatorSupport;
import org.mule.modules.taleo.model.ArrayOfFlexFieldBean;
import org.mule.modules.taleo.model.EmployeeBean;
import org.mule.modules.taleo.model.Map;
import org.mule.modules.taleo.model.holders.AddressEntityBeanExpressionHolder;
import org.mule.modules.taleo.model.holders.EmployeeBeanExpressionHolder;
import org.mule.modules.taleo.model.holders.EntityBeanExpressionHolder;
import org.mule.transformer.types.DataTypeFactory;

@SuppressWarnings("all")
@Generated(value = "Mule DevKit Version 3.6.1", date = "2015-12-18T03:06:03-03:00", comments = "Build UNNAMED.2405.44720b7")
public class EmployeeBeanExpressionHolderTransformer
    extends ExpressionEvaluatorSupport
    implements DiscoverableTransformer, MessageTransformer
{

    private int weighting = DiscoverableTransformer.DEFAULT_PRIORITY_WEIGHTING;
    private ImmutableEndpoint endpoint;
    private MuleContext muleContext;
    private String name;

    public int getPriorityWeighting() {
        return weighting;
    }

    public void setPriorityWeighting(int weighting) {
        this.weighting = weighting;
    }

    public boolean isSourceTypeSupported(Class<?> aClass) {
        return (aClass == EmployeeBeanExpressionHolder.class);
    }

    public boolean isSourceDataTypeSupported(DataType<?> dataType) {
        return (dataType.getType() == EmployeeBeanExpressionHolder.class);
    }

    public List<Class<?>> getSourceTypes() {
        return Arrays.asList(new Class<?> [] {EmployeeBeanExpressionHolder.class });
    }

    public List<DataType<?>> getSourceDataTypes() {
        return Arrays.asList(new DataType<?> [] {DataTypeFactory.create(EmployeeBeanExpressionHolder.class)});
    }

    public boolean isAcceptNull() {
        return false;
    }

    public boolean isIgnoreBadInput() {
        return false;
    }

    public Object transform(Object src)
        throws TransformerException
    {
        throw new UnsupportedOperationException();
    }

    public Object transform(Object src, String encoding)
        throws TransformerException
    {
        throw new UnsupportedOperationException();
    }

    public void setReturnClass(Class<?> theClass) {
        throw new UnsupportedOperationException();
    }

    public Class<?> getReturnClass() {
        return EmployeeBean.class;
    }

    public void setReturnDataType(DataType<?> type) {
        throw new UnsupportedOperationException();
    }

    public DataType<?> getReturnDataType() {
        return DataTypeFactory.create(EmployeeBean.class);
    }

    public void setEndpoint(ImmutableEndpoint ep) {
        endpoint = ep;
    }

    public ImmutableEndpoint getEndpoint() {
        return endpoint;
    }

    public void dispose() {
    }

    public void initialise()
        throws InitialisationException
    {
    }

    public void setMuleContext(MuleContext context) {
        muleContext = context;
    }

    public void setName(String newName) {
        name = newName;
    }

    public String getName() {
        return name;
    }

    public Object transform(Object src, MuleEvent event)
        throws TransformerMessagingException
    {
        return transform(src, null, event);
    }

    public Object transform(Object src, String encoding, MuleEvent event)
        throws TransformerMessagingException
    {
        if (src == null) {
            return null;
        }
        EmployeeBeanExpressionHolder holder = ((EmployeeBeanExpressionHolder) src);
        EmployeeBean result = new EmployeeBean();
        try {
            final String _transformedEmployeeNumber = ((String) evaluateAndTransform(this.muleContext, event, EmployeeBeanExpressionHolder.class.getDeclaredField("_employeeNumberType").getGenericType(), null, holder.getEmployeeNumber()));
            result.setEmployeeNumber(_transformedEmployeeNumber);
            final String _transformedEmail = ((String) evaluateAndTransform(this.muleContext, event, EmployeeBeanExpressionHolder.class.getDeclaredField("_emailType").getGenericType(), null, holder.getEmail()));
            result.setEmail(_transformedEmail);
            final String _transformedFirstName = ((String) evaluateAndTransform(this.muleContext, event, EmployeeBeanExpressionHolder.class.getDeclaredField("_firstNameType").getGenericType(), null, holder.getFirstName()));
            result.setFirstName(_transformedFirstName);
            final String _transformedMiddleInitial = ((String) evaluateAndTransform(this.muleContext, event, EmployeeBeanExpressionHolder.class.getDeclaredField("_middleInitialType").getGenericType(), null, holder.getMiddleInitial()));
            result.setMiddleInitial(_transformedMiddleInitial);
            final String _transformedLastName = ((String) evaluateAndTransform(this.muleContext, event, EmployeeBeanExpressionHolder.class.getDeclaredField("_lastNameType").getGenericType(), null, holder.getLastName()));
            result.setLastName(_transformedLastName);
            final String _transformedCellPhone = ((String) evaluateAndTransform(this.muleContext, event, EmployeeBeanExpressionHolder.class.getDeclaredField("_cellPhoneType").getGenericType(), null, holder.getCellPhone()));
            result.setCellPhone(_transformedCellPhone);
            final String _transformedTitle = ((String) evaluateAndTransform(this.muleContext, event, EmployeeBeanExpressionHolder.class.getDeclaredField("_titleType").getGenericType(), null, holder.getTitle()));
            result.setTitle(_transformedTitle);
            final XMLGregorianCalendar _transformedHiredDate = ((XMLGregorianCalendar) evaluateAndTransform(this.muleContext, event, EmployeeBeanExpressionHolder.class.getDeclaredField("_hiredDateType").getGenericType(), null, holder.getHiredDate()));
            result.setHiredDate(_transformedHiredDate);
            final XMLGregorianCalendar _transformedStartDate = ((XMLGregorianCalendar) evaluateAndTransform(this.muleContext, event, EmployeeBeanExpressionHolder.class.getDeclaredField("_startDateType").getGenericType(), null, holder.getStartDate()));
            result.setStartDate(_transformedStartDate);
            final String _transformedRace = ((String) evaluateAndTransform(this.muleContext, event, EmployeeBeanExpressionHolder.class.getDeclaredField("_raceType").getGenericType(), null, holder.getRace()));
            result.setRace(_transformedRace);
            final String _transformedGender = ((String) evaluateAndTransform(this.muleContext, event, EmployeeBeanExpressionHolder.class.getDeclaredField("_genderType").getGenericType(), null, holder.getGender()));
            result.setGender(_transformedGender);
            final Boolean _transformedLockedFromEws = ((Boolean) evaluateAndTransform(this.muleContext, event, EmployeeBeanExpressionHolder.class.getDeclaredField("_lockedFromEwsType").getGenericType(), null, holder.getLockedFromEws()));
            result.setLockedFromEws(_transformedLockedFromEws);
            final Long _transformedReviewManagerId = ((Long) evaluateAndTransform(this.muleContext, event, EmployeeBeanExpressionHolder.class.getDeclaredField("_reviewManagerIdType").getGenericType(), null, holder.getReviewManagerId()));
            result.setReviewManagerId(_transformedReviewManagerId);
            final Long _transformedDepartmentId = ((Long) evaluateAndTransform(this.muleContext, event, EmployeeBeanExpressionHolder.class.getDeclaredField("_departmentIdType").getGenericType(), null, holder.getDepartmentId()));
            result.setDepartmentId(_transformedDepartmentId);
            final String _transformedHierarchyPath = ((String) evaluateAndTransform(this.muleContext, event, EmployeeBeanExpressionHolder.class.getDeclaredField("_hierarchyPathType").getGenericType(), null, holder.getHierarchyPath()));
            result.setHierarchyPath(_transformedHierarchyPath);
            final Long _transformedManagerId = ((Long) evaluateAndTransform(this.muleContext, event, EmployeeBeanExpressionHolder.class.getDeclaredField("_managerIdType").getGenericType(), null, holder.getManagerId()));
            result.setManagerId(_transformedManagerId);
            final Long _transformedLocationId = ((Long) evaluateAndTransform(this.muleContext, event, EmployeeBeanExpressionHolder.class.getDeclaredField("_locationIdType").getGenericType(), null, holder.getLocationId()));
            result.setLocationId(_transformedLocationId);
            final String _transformedEwsLogin = ((String) evaluateAndTransform(this.muleContext, event, EmployeeBeanExpressionHolder.class.getDeclaredField("_ewsLoginType").getGenericType(), null, holder.getEwsLogin()));
            result.setEwsLogin(_transformedEwsLogin);
            final String _transformedEwsPassword = ((String) evaluateAndTransform(this.muleContext, event, EmployeeBeanExpressionHolder.class.getDeclaredField("_ewsPasswordType").getGenericType(), null, holder.getEwsPassword()));
            result.setEwsPassword(_transformedEwsPassword);
            final String _transformedJobTitle = ((String) evaluateAndTransform(this.muleContext, event, EmployeeBeanExpressionHolder.class.getDeclaredField("_jobTitleType").getGenericType(), null, holder.getJobTitle()));
            result.setJobTitle(_transformedJobTitle);
            final String _transformedJobCode = ((String) evaluateAndTransform(this.muleContext, event, EmployeeBeanExpressionHolder.class.getDeclaredField("_jobCodeType").getGenericType(), null, holder.getJobCode()));
            result.setJobCode(_transformedJobCode);
            final String _transformedSalaryGrade = ((String) evaluateAndTransform(this.muleContext, event, EmployeeBeanExpressionHolder.class.getDeclaredField("_salaryGradeType").getGenericType(), null, holder.getSalaryGrade()));
            result.setSalaryGrade(_transformedSalaryGrade);
            final Double _transformedSalary = ((Double) evaluateAndTransform(this.muleContext, event, EmployeeBeanExpressionHolder.class.getDeclaredField("_salaryType").getGenericType(), null, holder.getSalary()));
            result.setSalary(_transformedSalary);
            final String _transformedPayFrequency = ((String) evaluateAndTransform(this.muleContext, event, EmployeeBeanExpressionHolder.class.getDeclaredField("_payFrequencyType").getGenericType(), null, holder.getPayFrequency()));
            result.setPayFrequency(_transformedPayFrequency);
            final Boolean _transformedChangePswdOnEwsLogin = ((Boolean) evaluateAndTransform(this.muleContext, event, EmployeeBeanExpressionHolder.class.getDeclaredField("_changePswdOnEwsLoginType").getGenericType(), null, holder.getChangePswdOnEwsLogin()));
            result.setChangePswdOnEwsLogin(_transformedChangePswdOnEwsLogin);
            final Map _transformedAdditionalEntities = ((Map) evaluateAndTransform(this.muleContext, event, EmployeeBeanExpressionHolder.class.getDeclaredField("_additionalEntitiesType").getGenericType(), null, holder.getAdditionalEntities()));
            result.setAdditionalEntities(_transformedAdditionalEntities);
            final String _transformedCity = ((String) evaluateAndTransform(this.muleContext, event, AddressEntityBeanExpressionHolder.class.getDeclaredField("_cityType").getGenericType(), null, holder.getCity()));
            result.setCity(_transformedCity);
            final String _transformedAddress = ((String) evaluateAndTransform(this.muleContext, event, AddressEntityBeanExpressionHolder.class.getDeclaredField("_addressType").getGenericType(), null, holder.getAddress()));
            result.setAddress(_transformedAddress);
            final String _transformedZipCode = ((String) evaluateAndTransform(this.muleContext, event, AddressEntityBeanExpressionHolder.class.getDeclaredField("_zipCodeType").getGenericType(), null, holder.getZipCode()));
            result.setZipCode(_transformedZipCode);
            final String _transformedState = ((String) evaluateAndTransform(this.muleContext, event, AddressEntityBeanExpressionHolder.class.getDeclaredField("_stateType").getGenericType(), null, holder.getState()));
            result.setState(_transformedState);
            final String _transformedCountry = ((String) evaluateAndTransform(this.muleContext, event, AddressEntityBeanExpressionHolder.class.getDeclaredField("_countryType").getGenericType(), null, holder.getCountry()));
            result.setCountry(_transformedCountry);
            final String _transformedPhone = ((String) evaluateAndTransform(this.muleContext, event, AddressEntityBeanExpressionHolder.class.getDeclaredField("_phoneType").getGenericType(), null, holder.getPhone()));
            result.setPhone(_transformedPhone);
            final XMLGregorianCalendar _transformedCreationDate = ((XMLGregorianCalendar) evaluateAndTransform(this.muleContext, event, EntityBeanExpressionHolder.class.getDeclaredField("_creationDateType").getGenericType(), null, holder.getCreationDate()));
            result.setCreationDate(_transformedCreationDate);
            final ArrayOfFlexFieldBean _transformedFlexValues = ((ArrayOfFlexFieldBean) evaluateAndTransform(this.muleContext, event, EntityBeanExpressionHolder.class.getDeclaredField("_flexValuesType").getGenericType(), null, holder.getFlexValues()));
            result.setFlexValues(_transformedFlexValues);
            final Long _transformedId = ((Long) evaluateAndTransform(this.muleContext, event, EntityBeanExpressionHolder.class.getDeclaredField("_idType").getGenericType(), null, holder.getId()));
            result.setId(_transformedId);
            final XMLGregorianCalendar _transformedLastUpdated = ((XMLGregorianCalendar) evaluateAndTransform(this.muleContext, event, EntityBeanExpressionHolder.class.getDeclaredField("_lastUpdatedType").getGenericType(), null, holder.getLastUpdated()));
            result.setLastUpdated(_transformedLastUpdated);
            final String _transformedStatus = ((String) evaluateAndTransform(this.muleContext, event, EntityBeanExpressionHolder.class.getDeclaredField("_statusType").getGenericType(), null, holder.getStatus()));
            result.setStatus(_transformedStatus);
        } catch (NoSuchFieldException e) {
            throw new TransformerMessagingException(CoreMessages.createStaticMessage("internal error"), event, this, e);
        } catch (TransformerException e) {
            throw new TransformerMessagingException(e.getI18nMessage(), event, this, e);
        }
        return result;
    }

    public MuleEvent process(MuleEvent event) {
        return null;
    }

    public String getMimeType() {
        return null;
    }

    public String getEncoding() {
        return null;
    }

    public MuleContext getMuleContext() {
        return muleContext;
    }

}
