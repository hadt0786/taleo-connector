
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
import org.mule.modules.taleo.model.ContactLogBean;
import org.mule.modules.taleo.model.holders.ContactLogBeanExpressionHolder;
import org.mule.transformer.types.DataTypeFactory;

@SuppressWarnings("all")
@Generated(value = "Mule DevKit Version 3.6.1", date = "2015-12-18T03:06:03-03:00", comments = "Build UNNAMED.2405.44720b7")
public class ContactLogBeanExpressionHolderTransformer
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
        return (aClass == ContactLogBeanExpressionHolder.class);
    }

    public boolean isSourceDataTypeSupported(DataType<?> dataType) {
        return (dataType.getType() == ContactLogBeanExpressionHolder.class);
    }

    public List<Class<?>> getSourceTypes() {
        return Arrays.asList(new Class<?> [] {ContactLogBeanExpressionHolder.class });
    }

    public List<DataType<?>> getSourceDataTypes() {
        return Arrays.asList(new DataType<?> [] {DataTypeFactory.create(ContactLogBeanExpressionHolder.class)});
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
        return ContactLogBean.class;
    }

    public void setReturnDataType(DataType<?> type) {
        throw new UnsupportedOperationException();
    }

    public DataType<?> getReturnDataType() {
        return DataTypeFactory.create(ContactLogBean.class);
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
        ContactLogBeanExpressionHolder holder = ((ContactLogBeanExpressionHolder) src);
        ContactLogBean result = new ContactLogBean();
        try {
            final String _transformedComments = ((String) evaluateAndTransform(this.muleContext, event, ContactLogBeanExpressionHolder.class.getDeclaredField("_commentsType").getGenericType(), null, holder.getComments()));
            result.setComments(_transformedComments);
            final XMLGregorianCalendar _transformedContactDate = ((XMLGregorianCalendar) evaluateAndTransform(this.muleContext, event, ContactLogBeanExpressionHolder.class.getDeclaredField("_contactDateType").getGenericType(), null, holder.getContactDate()));
            result.setContactDate(_transformedContactDate);
            final XMLGregorianCalendar _transformedCreationDate = ((XMLGregorianCalendar) evaluateAndTransform(this.muleContext, event, ContactLogBeanExpressionHolder.class.getDeclaredField("_creationDateType").getGenericType(), null, holder.getCreationDate()));
            result.setCreationDate(_transformedCreationDate);
            final String _transformedCreator = ((String) evaluateAndTransform(this.muleContext, event, ContactLogBeanExpressionHolder.class.getDeclaredField("_creatorType").getGenericType(), null, holder.getCreator()));
            result.setCreator(_transformedCreator);
            final Long _transformedEntityId = ((Long) evaluateAndTransform(this.muleContext, event, ContactLogBeanExpressionHolder.class.getDeclaredField("_entityIdType").getGenericType(), null, holder.getEntityId()));
            result.setEntityId(_transformedEntityId);
            final String _transformedEntityType = ((String) evaluateAndTransform(this.muleContext, event, ContactLogBeanExpressionHolder.class.getDeclaredField("_entityTypeType").getGenericType(), null, holder.getEntityType()));
            result.setEntityType(_transformedEntityType);
            final Long _transformedId = ((Long) evaluateAndTransform(this.muleContext, event, ContactLogBeanExpressionHolder.class.getDeclaredField("_idType").getGenericType(), null, holder.getId()));
            result.setId(_transformedId);
            final XMLGregorianCalendar _transformedLastUpdated = ((XMLGregorianCalendar) evaluateAndTransform(this.muleContext, event, ContactLogBeanExpressionHolder.class.getDeclaredField("_lastUpdatedType").getGenericType(), null, holder.getLastUpdated()));
            result.setLastUpdated(_transformedLastUpdated);
            final String _transformedSubject = ((String) evaluateAndTransform(this.muleContext, event, ContactLogBeanExpressionHolder.class.getDeclaredField("_subjectType").getGenericType(), null, holder.getSubject()));
            result.setSubject(_transformedSubject);
            final Integer _transformedTypeNo = ((Integer) evaluateAndTransform(this.muleContext, event, ContactLogBeanExpressionHolder.class.getDeclaredField("_typeNoType").getGenericType(), null, holder.getTypeNo()));
            result.setTypeNo(_transformedTypeNo);
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
