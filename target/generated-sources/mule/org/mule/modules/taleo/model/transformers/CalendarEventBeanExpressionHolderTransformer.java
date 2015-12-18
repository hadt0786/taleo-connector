
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
import org.mule.modules.taleo.model.ArrayOfParticipantBean;
import org.mule.modules.taleo.model.CalendarEventBean;
import org.mule.modules.taleo.model.holders.CalendarEventBeanExpressionHolder;
import org.mule.modules.taleo.model.holders.EntityBeanExpressionHolder;
import org.mule.transformer.types.DataTypeFactory;

@SuppressWarnings("all")
@Generated(value = "Mule DevKit Version 3.6.1", date = "2015-12-18T03:06:03-03:00", comments = "Build UNNAMED.2405.44720b7")
public class CalendarEventBeanExpressionHolderTransformer
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
        return (aClass == CalendarEventBeanExpressionHolder.class);
    }

    public boolean isSourceDataTypeSupported(DataType<?> dataType) {
        return (dataType.getType() == CalendarEventBeanExpressionHolder.class);
    }

    public List<Class<?>> getSourceTypes() {
        return Arrays.asList(new Class<?> [] {CalendarEventBeanExpressionHolder.class });
    }

    public List<DataType<?>> getSourceDataTypes() {
        return Arrays.asList(new DataType<?> [] {DataTypeFactory.create(CalendarEventBeanExpressionHolder.class)});
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
        return CalendarEventBean.class;
    }

    public void setReturnDataType(DataType<?> type) {
        throw new UnsupportedOperationException();
    }

    public DataType<?> getReturnDataType() {
        return DataTypeFactory.create(CalendarEventBean.class);
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
        CalendarEventBeanExpressionHolder holder = ((CalendarEventBeanExpressionHolder) src);
        CalendarEventBean result = new CalendarEventBean();
        try {
            final String _transformedCreator = ((String) evaluateAndTransform(this.muleContext, event, CalendarEventBeanExpressionHolder.class.getDeclaredField("_creatorType").getGenericType(), null, holder.getCreator()));
            result.setCreator(_transformedCreator);
            final String _transformedDescription = ((String) evaluateAndTransform(this.muleContext, event, CalendarEventBeanExpressionHolder.class.getDeclaredField("_descriptionType").getGenericType(), null, holder.getDescription()));
            result.setDescription(_transformedDescription);
            final Long _transformedDuration = ((Long) evaluateAndTransform(this.muleContext, event, CalendarEventBeanExpressionHolder.class.getDeclaredField("_durationType").getGenericType(), null, holder.getDuration()));
            result.setDuration(_transformedDuration);
            final Long _transformedEntityId = ((Long) evaluateAndTransform(this.muleContext, event, CalendarEventBeanExpressionHolder.class.getDeclaredField("_entityIdType").getGenericType(), null, holder.getEntityId()));
            result.setEntityId(_transformedEntityId);
            final String _transformedEntityType = ((String) evaluateAndTransform(this.muleContext, event, CalendarEventBeanExpressionHolder.class.getDeclaredField("_entityTypeType").getGenericType(), null, holder.getEntityType()));
            result.setEntityType(_transformedEntityType);
            final Boolean _transformedIsPrivate = ((Boolean) evaluateAndTransform(this.muleContext, event, CalendarEventBeanExpressionHolder.class.getDeclaredField("_isPrivateType").getGenericType(), null, holder.getIsPrivate()));
            result.setIsPrivate(_transformedIsPrivate);
            final String _transformedLocation = ((String) evaluateAndTransform(this.muleContext, event, CalendarEventBeanExpressionHolder.class.getDeclaredField("_locationType").getGenericType(), null, holder.getLocation()));
            result.setLocation(_transformedLocation);
            final ArrayOfParticipantBean _transformedParticipants = ((ArrayOfParticipantBean) evaluateAndTransform(this.muleContext, event, CalendarEventBeanExpressionHolder.class.getDeclaredField("_participantsType").getGenericType(), null, holder.getParticipants()));
            result.setParticipants(_transformedParticipants);
            final XMLGregorianCalendar _transformedStartDate = ((XMLGregorianCalendar) evaluateAndTransform(this.muleContext, event, CalendarEventBeanExpressionHolder.class.getDeclaredField("_startDateType").getGenericType(), null, holder.getStartDate()));
            result.setStartDate(_transformedStartDate);
            final String _transformedSubject = ((String) evaluateAndTransform(this.muleContext, event, CalendarEventBeanExpressionHolder.class.getDeclaredField("_subjectType").getGenericType(), null, holder.getSubject()));
            result.setSubject(_transformedSubject);
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
