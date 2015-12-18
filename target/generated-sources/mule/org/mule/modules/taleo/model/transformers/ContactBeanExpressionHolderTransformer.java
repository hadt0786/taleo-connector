
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
import org.mule.modules.taleo.model.ContactBean;
import org.mule.modules.taleo.model.holders.ContactBeanExpressionHolder;
import org.mule.modules.taleo.model.holders.EntityBeanExpressionHolder;
import org.mule.transformer.types.DataTypeFactory;

@SuppressWarnings("all")
@Generated(value = "Mule DevKit Version 3.6.1", date = "2015-12-18T03:06:03-03:00", comments = "Build UNNAMED.2405.44720b7")
public class ContactBeanExpressionHolderTransformer
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
        return (aClass == ContactBeanExpressionHolder.class);
    }

    public boolean isSourceDataTypeSupported(DataType<?> dataType) {
        return (dataType.getType() == ContactBeanExpressionHolder.class);
    }

    public List<Class<?>> getSourceTypes() {
        return Arrays.asList(new Class<?> [] {ContactBeanExpressionHolder.class });
    }

    public List<DataType<?>> getSourceDataTypes() {
        return Arrays.asList(new DataType<?> [] {DataTypeFactory.create(ContactBeanExpressionHolder.class)});
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
        return ContactBean.class;
    }

    public void setReturnDataType(DataType<?> type) {
        throw new UnsupportedOperationException();
    }

    public DataType<?> getReturnDataType() {
        return DataTypeFactory.create(ContactBean.class);
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
        ContactBeanExpressionHolder holder = ((ContactBeanExpressionHolder) src);
        ContactBean result = new ContactBean();
        try {
            final Long _transformedAccountId = ((Long) evaluateAndTransform(this.muleContext, event, ContactBeanExpressionHolder.class.getDeclaredField("_accountIdType").getGenericType(), null, holder.getAccountId()));
            result.setAccountId(_transformedAccountId);
            final String _transformedAddress = ((String) evaluateAndTransform(this.muleContext, event, ContactBeanExpressionHolder.class.getDeclaredField("_addressType").getGenericType(), null, holder.getAddress()));
            result.setAddress(_transformedAddress);
            final String _transformedAssistantEmail = ((String) evaluateAndTransform(this.muleContext, event, ContactBeanExpressionHolder.class.getDeclaredField("_assistantEmailType").getGenericType(), null, holder.getAssistantEmail()));
            result.setAssistantEmail(_transformedAssistantEmail);
            final String _transformedAssistantName = ((String) evaluateAndTransform(this.muleContext, event, ContactBeanExpressionHolder.class.getDeclaredField("_assistantNameType").getGenericType(), null, holder.getAssistantName()));
            result.setAssistantName(_transformedAssistantName);
            final String _transformedAssistantPhone = ((String) evaluateAndTransform(this.muleContext, event, ContactBeanExpressionHolder.class.getDeclaredField("_assistantPhoneType").getGenericType(), null, holder.getAssistantPhone()));
            result.setAssistantPhone(_transformedAssistantPhone);
            final String _transformedCellPhone = ((String) evaluateAndTransform(this.muleContext, event, ContactBeanExpressionHolder.class.getDeclaredField("_cellPhoneType").getGenericType(), null, holder.getCellPhone()));
            result.setCellPhone(_transformedCellPhone);
            final String _transformedCity = ((String) evaluateAndTransform(this.muleContext, event, ContactBeanExpressionHolder.class.getDeclaredField("_cityType").getGenericType(), null, holder.getCity()));
            result.setCity(_transformedCity);
            final String _transformedContactType = ((String) evaluateAndTransform(this.muleContext, event, ContactBeanExpressionHolder.class.getDeclaredField("_contactTypeType").getGenericType(), null, holder.getContactType()));
            result.setContactType(_transformedContactType);
            final String _transformedCountry = ((String) evaluateAndTransform(this.muleContext, event, ContactBeanExpressionHolder.class.getDeclaredField("_countryType").getGenericType(), null, holder.getCountry()));
            result.setCountry(_transformedCountry);
            final String _transformedCreator = ((String) evaluateAndTransform(this.muleContext, event, ContactBeanExpressionHolder.class.getDeclaredField("_creatorType").getGenericType(), null, holder.getCreator()));
            result.setCreator(_transformedCreator);
            final String _transformedDepartment = ((String) evaluateAndTransform(this.muleContext, event, ContactBeanExpressionHolder.class.getDeclaredField("_departmentType").getGenericType(), null, holder.getDepartment()));
            result.setDepartment(_transformedDepartment);
            final String _transformedDescription = ((String) evaluateAndTransform(this.muleContext, event, ContactBeanExpressionHolder.class.getDeclaredField("_descriptionType").getGenericType(), null, holder.getDescription()));
            result.setDescription(_transformedDescription);
            final String _transformedEmail = ((String) evaluateAndTransform(this.muleContext, event, ContactBeanExpressionHolder.class.getDeclaredField("_emailType").getGenericType(), null, holder.getEmail()));
            result.setEmail(_transformedEmail);
            final String _transformedFax = ((String) evaluateAndTransform(this.muleContext, event, ContactBeanExpressionHolder.class.getDeclaredField("_faxType").getGenericType(), null, holder.getFax()));
            result.setFax(_transformedFax);
            final String _transformedFirstName = ((String) evaluateAndTransform(this.muleContext, event, ContactBeanExpressionHolder.class.getDeclaredField("_firstNameType").getGenericType(), null, holder.getFirstName()));
            result.setFirstName(_transformedFirstName);
            final String _transformedLastName = ((String) evaluateAndTransform(this.muleContext, event, ContactBeanExpressionHolder.class.getDeclaredField("_lastNameType").getGenericType(), null, holder.getLastName()));
            result.setLastName(_transformedLastName);
            final String _transformedPhone = ((String) evaluateAndTransform(this.muleContext, event, ContactBeanExpressionHolder.class.getDeclaredField("_phoneType").getGenericType(), null, holder.getPhone()));
            result.setPhone(_transformedPhone);
            final Long _transformedReportsToId = ((Long) evaluateAndTransform(this.muleContext, event, ContactBeanExpressionHolder.class.getDeclaredField("_reportsToIdType").getGenericType(), null, holder.getReportsToId()));
            result.setReportsToId(_transformedReportsToId);
            final String _transformedState = ((String) evaluateAndTransform(this.muleContext, event, ContactBeanExpressionHolder.class.getDeclaredField("_stateType").getGenericType(), null, holder.getState()));
            result.setState(_transformedState);
            final String _transformedTitle = ((String) evaluateAndTransform(this.muleContext, event, ContactBeanExpressionHolder.class.getDeclaredField("_titleType").getGenericType(), null, holder.getTitle()));
            result.setTitle(_transformedTitle);
            final String _transformedZipCode = ((String) evaluateAndTransform(this.muleContext, event, ContactBeanExpressionHolder.class.getDeclaredField("_zipCodeType").getGenericType(), null, holder.getZipCode()));
            result.setZipCode(_transformedZipCode);
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
