
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
import org.mule.modules.taleo.model.UserBean;
import org.mule.modules.taleo.model.holders.EntityBeanExpressionHolder;
import org.mule.modules.taleo.model.holders.UserBeanExpressionHolder;
import org.mule.transformer.types.DataTypeFactory;

@SuppressWarnings("all")
@Generated(value = "Mule DevKit Version 3.6.1", date = "2015-12-18T03:06:03-03:00", comments = "Build UNNAMED.2405.44720b7")
public class UserBeanExpressionHolderTransformer
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
        return (aClass == UserBeanExpressionHolder.class);
    }

    public boolean isSourceDataTypeSupported(DataType<?> dataType) {
        return (dataType.getType() == UserBeanExpressionHolder.class);
    }

    public List<Class<?>> getSourceTypes() {
        return Arrays.asList(new Class<?> [] {UserBeanExpressionHolder.class });
    }

    public List<DataType<?>> getSourceDataTypes() {
        return Arrays.asList(new DataType<?> [] {DataTypeFactory.create(UserBeanExpressionHolder.class)});
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
        return UserBean.class;
    }

    public void setReturnDataType(DataType<?> type) {
        throw new UnsupportedOperationException();
    }

    public DataType<?> getReturnDataType() {
        return DataTypeFactory.create(UserBean.class);
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
        UserBeanExpressionHolder holder = ((UserBeanExpressionHolder) src);
        UserBean result = new UserBean();
        try {
            final String _transformedCellPhone = ((String) evaluateAndTransform(this.muleContext, event, UserBeanExpressionHolder.class.getDeclaredField("_cellPhoneType").getGenericType(), null, holder.getCellPhone()));
            result.setCellPhone(_transformedCellPhone);
            final String _transformedEmail = ((String) evaluateAndTransform(this.muleContext, event, UserBeanExpressionHolder.class.getDeclaredField("_emailType").getGenericType(), null, holder.getEmail()));
            result.setEmail(_transformedEmail);
            final String _transformedFax = ((String) evaluateAndTransform(this.muleContext, event, UserBeanExpressionHolder.class.getDeclaredField("_faxType").getGenericType(), null, holder.getFax()));
            result.setFax(_transformedFax);
            final String _transformedFirstName = ((String) evaluateAndTransform(this.muleContext, event, UserBeanExpressionHolder.class.getDeclaredField("_firstNameType").getGenericType(), null, holder.getFirstName()));
            result.setFirstName(_transformedFirstName);
            final XMLGregorianCalendar _transformedLastLogin = ((XMLGregorianCalendar) evaluateAndTransform(this.muleContext, event, UserBeanExpressionHolder.class.getDeclaredField("_lastLoginType").getGenericType(), null, holder.getLastLogin()));
            result.setLastLogin(_transformedLastLogin);
            final String _transformedLastName = ((String) evaluateAndTransform(this.muleContext, event, UserBeanExpressionHolder.class.getDeclaredField("_lastNameType").getGenericType(), null, holder.getLastName()));
            result.setLastName(_transformedLastName);
            final String _transformedLocaleCode = ((String) evaluateAndTransform(this.muleContext, event, UserBeanExpressionHolder.class.getDeclaredField("_localeCodeType").getGenericType(), null, holder.getLocaleCode()));
            result.setLocaleCode(_transformedLocaleCode);
            final String _transformedLocation = ((String) evaluateAndTransform(this.muleContext, event, UserBeanExpressionHolder.class.getDeclaredField("_locationType").getGenericType(), null, holder.getLocation()));
            result.setLocation(_transformedLocation);
            final String _transformedLoginName = ((String) evaluateAndTransform(this.muleContext, event, UserBeanExpressionHolder.class.getDeclaredField("_loginNameType").getGenericType(), null, holder.getLoginName()));
            result.setLoginName(_transformedLoginName);
            final String _transformedManager = ((String) evaluateAndTransform(this.muleContext, event, UserBeanExpressionHolder.class.getDeclaredField("_managerType").getGenericType(), null, holder.getManager()));
            result.setManager(_transformedManager);
            final String _transformedMiddleInitial = ((String) evaluateAndTransform(this.muleContext, event, UserBeanExpressionHolder.class.getDeclaredField("_middleInitialType").getGenericType(), null, holder.getMiddleInitial()));
            result.setMiddleInitial(_transformedMiddleInitial);
            final String _transformedPhone = ((String) evaluateAndTransform(this.muleContext, event, UserBeanExpressionHolder.class.getDeclaredField("_phoneType").getGenericType(), null, holder.getPhone()));
            result.setPhone(_transformedPhone);
            final String _transformedRole = ((String) evaluateAndTransform(this.muleContext, event, UserBeanExpressionHolder.class.getDeclaredField("_roleType").getGenericType(), null, holder.getRole()));
            result.setRole(_transformedRole);
            final String _transformedTimeZoneId = ((String) evaluateAndTransform(this.muleContext, event, UserBeanExpressionHolder.class.getDeclaredField("_timeZoneIdType").getGenericType(), null, holder.getTimeZoneId()));
            result.setTimeZoneId(_transformedTimeZoneId);
            final String _transformedTitle = ((String) evaluateAndTransform(this.muleContext, event, UserBeanExpressionHolder.class.getDeclaredField("_titleType").getGenericType(), null, holder.getTitle()));
            result.setTitle(_transformedTitle);
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
