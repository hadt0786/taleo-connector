
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
import org.mule.modules.taleo.model.RequisitionBean;
import org.mule.modules.taleo.model.holders.EntityBeanExpressionHolder;
import org.mule.modules.taleo.model.holders.RequisitionBeanExpressionHolder;
import org.mule.transformer.types.DataTypeFactory;

@SuppressWarnings("all")
@Generated(value = "Mule DevKit Version 3.6.1", date = "2015-12-18T03:06:03-03:00", comments = "Build UNNAMED.2405.44720b7")
public class RequisitionBeanExpressionHolderTransformer
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
        return (aClass == RequisitionBeanExpressionHolder.class);
    }

    public boolean isSourceDataTypeSupported(DataType<?> dataType) {
        return (dataType.getType() == RequisitionBeanExpressionHolder.class);
    }

    public List<Class<?>> getSourceTypes() {
        return Arrays.asList(new Class<?> [] {RequisitionBeanExpressionHolder.class });
    }

    public List<DataType<?>> getSourceDataTypes() {
        return Arrays.asList(new DataType<?> [] {DataTypeFactory.create(RequisitionBeanExpressionHolder.class)});
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
        return RequisitionBean.class;
    }

    public void setReturnDataType(DataType<?> type) {
        throw new UnsupportedOperationException();
    }

    public DataType<?> getReturnDataType() {
        return DataTypeFactory.create(RequisitionBean.class);
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
        RequisitionBeanExpressionHolder holder = ((RequisitionBeanExpressionHolder) src);
        RequisitionBean result = new RequisitionBean();
        try {
            final String _transformedCity = ((String) evaluateAndTransform(this.muleContext, event, RequisitionBeanExpressionHolder.class.getDeclaredField("_cityType").getGenericType(), null, holder.getCity()));
            result.setCity(_transformedCity);
            final String _transformedDescription = ((String) evaluateAndTransform(this.muleContext, event, RequisitionBeanExpressionHolder.class.getDeclaredField("_descriptionType").getGenericType(), null, holder.getDescription()));
            result.setDescription(_transformedDescription);
            final String _transformedDuration = ((String) evaluateAndTransform(this.muleContext, event, RequisitionBeanExpressionHolder.class.getDeclaredField("_durationType").getGenericType(), null, holder.getDuration()));
            result.setDuration(_transformedDuration);
            final XMLGregorianCalendar _transformedFilledDate = ((XMLGregorianCalendar) evaluateAndTransform(this.muleContext, event, RequisitionBeanExpressionHolder.class.getDeclaredField("_filledDateType").getGenericType(), null, holder.getFilledDate()));
            result.setFilledDate(_transformedFilledDate);
            final String _transformedJobCategory = ((String) evaluateAndTransform(this.muleContext, event, RequisitionBeanExpressionHolder.class.getDeclaredField("_jobCategoryType").getGenericType(), null, holder.getJobCategory()));
            result.setJobCategory(_transformedJobCategory);
            final String _transformedJobCode = ((String) evaluateAndTransform(this.muleContext, event, RequisitionBeanExpressionHolder.class.getDeclaredField("_jobCodeType").getGenericType(), null, holder.getJobCode()));
            result.setJobCode(_transformedJobCode);
            final String _transformedLocation = ((String) evaluateAndTransform(this.muleContext, event, RequisitionBeanExpressionHolder.class.getDeclaredField("_locationType").getGenericType(), null, holder.getLocation()));
            result.setLocation(_transformedLocation);
            final Integer _transformedNumOpen = ((Integer) evaluateAndTransform(this.muleContext, event, RequisitionBeanExpressionHolder.class.getDeclaredField("_numOpenType").getGenericType(), null, holder.getNumOpen()));
            result.setNumOpen(_transformedNumOpen);
            final XMLGregorianCalendar _transformedOpenedDate = ((XMLGregorianCalendar) evaluateAndTransform(this.muleContext, event, RequisitionBeanExpressionHolder.class.getDeclaredField("_openedDateType").getGenericType(), null, holder.getOpenedDate()));
            result.setOpenedDate(_transformedOpenedDate);
            final String _transformedPayRange = ((String) evaluateAndTransform(this.muleContext, event, RequisitionBeanExpressionHolder.class.getDeclaredField("_payRangeType").getGenericType(), null, holder.getPayRange()));
            result.setPayRange(_transformedPayRange);
            final String _transformedState = ((String) evaluateAndTransform(this.muleContext, event, RequisitionBeanExpressionHolder.class.getDeclaredField("_stateType").getGenericType(), null, holder.getState()));
            result.setState(_transformedState);
            final String _transformedTitle = ((String) evaluateAndTransform(this.muleContext, event, RequisitionBeanExpressionHolder.class.getDeclaredField("_titleType").getGenericType(), null, holder.getTitle()));
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
