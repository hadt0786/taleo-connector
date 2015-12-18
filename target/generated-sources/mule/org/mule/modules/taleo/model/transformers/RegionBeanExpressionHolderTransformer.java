
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
import org.mule.modules.taleo.model.ArrayOfXsdLong;
import org.mule.modules.taleo.model.ArrayOfXsdString;
import org.mule.modules.taleo.model.Map;
import org.mule.modules.taleo.model.RegionBean;
import org.mule.modules.taleo.model.holders.RegionBeanExpressionHolder;
import org.mule.transformer.types.DataTypeFactory;

@SuppressWarnings("all")
@Generated(value = "Mule DevKit Version 3.6.1", date = "2015-12-18T03:06:03-03:00", comments = "Build UNNAMED.2405.44720b7")
public class RegionBeanExpressionHolderTransformer
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
        return (aClass == RegionBeanExpressionHolder.class);
    }

    public boolean isSourceDataTypeSupported(DataType<?> dataType) {
        return (dataType.getType() == RegionBeanExpressionHolder.class);
    }

    public List<Class<?>> getSourceTypes() {
        return Arrays.asList(new Class<?> [] {RegionBeanExpressionHolder.class });
    }

    public List<DataType<?>> getSourceDataTypes() {
        return Arrays.asList(new DataType<?> [] {DataTypeFactory.create(RegionBeanExpressionHolder.class)});
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
        return RegionBean.class;
    }

    public void setReturnDataType(DataType<?> type) {
        throw new UnsupportedOperationException();
    }

    public DataType<?> getReturnDataType() {
        return DataTypeFactory.create(RegionBean.class);
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
        RegionBeanExpressionHolder holder = ((RegionBeanExpressionHolder) src);
        RegionBean result = new RegionBean();
        try {
            final Map _transformedAdditionalProperties = ((Map) evaluateAndTransform(this.muleContext, event, RegionBeanExpressionHolder.class.getDeclaredField("_additionalPropertiesType").getGenericType(), null, holder.getAdditionalProperties()));
            result.setAdditionalProperties(_transformedAdditionalProperties);
            final XMLGregorianCalendar _transformedCreationDate = ((XMLGregorianCalendar) evaluateAndTransform(this.muleContext, event, RegionBeanExpressionHolder.class.getDeclaredField("_creationDateType").getGenericType(), null, holder.getCreationDate()));
            result.setCreationDate(_transformedCreationDate);
            final XMLGregorianCalendar _transformedLastUpdated = ((XMLGregorianCalendar) evaluateAndTransform(this.muleContext, event, RegionBeanExpressionHolder.class.getDeclaredField("_lastUpdatedType").getGenericType(), null, holder.getLastUpdated()));
            result.setLastUpdated(_transformedLastUpdated);
            final Long _transformedRegionId = ((Long) evaluateAndTransform(this.muleContext, event, RegionBeanExpressionHolder.class.getDeclaredField("_regionIdType").getGenericType(), null, holder.getRegionId()));
            result.setRegionId(_transformedRegionId);
            final String _transformedRegionName = ((String) evaluateAndTransform(this.muleContext, event, RegionBeanExpressionHolder.class.getDeclaredField("_regionNameType").getGenericType(), null, holder.getRegionName()));
            result.setRegionName(_transformedRegionName);
            final ArrayOfXsdString _transformedAssociatedLocations = ((ArrayOfXsdString) evaluateAndTransform(this.muleContext, event, RegionBeanExpressionHolder.class.getDeclaredField("_associatedLocationsType").getGenericType(), null, holder.getAssociatedLocations()));
            result.setAssociatedLocations(_transformedAssociatedLocations);
            final ArrayOfXsdLong _transformedAssociatedUsers = ((ArrayOfXsdLong) evaluateAndTransform(this.muleContext, event, RegionBeanExpressionHolder.class.getDeclaredField("_associatedUsersType").getGenericType(), null, holder.getAssociatedUsers()));
            result.setAssociatedUsers(_transformedAssociatedUsers);
            final ArrayOfXsdLong _transformedDefaultApprovers = ((ArrayOfXsdLong) evaluateAndTransform(this.muleContext, event, RegionBeanExpressionHolder.class.getDeclaredField("_defaultApproversType").getGenericType(), null, holder.getDefaultApprovers()));
            result.setDefaultApprovers(_transformedDefaultApprovers);
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
