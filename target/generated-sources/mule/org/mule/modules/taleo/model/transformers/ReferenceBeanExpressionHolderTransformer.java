
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
import org.mule.modules.taleo.model.ReferenceBean;
import org.mule.modules.taleo.model.holders.EntityBeanExpressionHolder;
import org.mule.modules.taleo.model.holders.ReferenceBeanExpressionHolder;
import org.mule.transformer.types.DataTypeFactory;

@SuppressWarnings("all")
@Generated(value = "Mule DevKit Version 3.6.1", date = "2015-12-18T03:06:03-03:00", comments = "Build UNNAMED.2405.44720b7")
public class ReferenceBeanExpressionHolderTransformer
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
        return (aClass == ReferenceBeanExpressionHolder.class);
    }

    public boolean isSourceDataTypeSupported(DataType<?> dataType) {
        return (dataType.getType() == ReferenceBeanExpressionHolder.class);
    }

    public List<Class<?>> getSourceTypes() {
        return Arrays.asList(new Class<?> [] {ReferenceBeanExpressionHolder.class });
    }

    public List<DataType<?>> getSourceDataTypes() {
        return Arrays.asList(new DataType<?> [] {DataTypeFactory.create(ReferenceBeanExpressionHolder.class)});
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
        return ReferenceBean.class;
    }

    public void setReturnDataType(DataType<?> type) {
        throw new UnsupportedOperationException();
    }

    public DataType<?> getReturnDataType() {
        return DataTypeFactory.create(ReferenceBean.class);
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
        ReferenceBeanExpressionHolder holder = ((ReferenceBeanExpressionHolder) src);
        ReferenceBean result = new ReferenceBean();
        try {
            final Long _transformedCandidateId = ((Long) evaluateAndTransform(this.muleContext, event, ReferenceBeanExpressionHolder.class.getDeclaredField("_candidateIdType").getGenericType(), null, holder.getCandidateId()));
            result.setCandidateId(_transformedCandidateId);
            final String _transformedComments = ((String) evaluateAndTransform(this.muleContext, event, ReferenceBeanExpressionHolder.class.getDeclaredField("_commentsType").getGenericType(), null, holder.getComments()));
            result.setComments(_transformedComments);
            final String _transformedCreator = ((String) evaluateAndTransform(this.muleContext, event, ReferenceBeanExpressionHolder.class.getDeclaredField("_creatorType").getGenericType(), null, holder.getCreator()));
            result.setCreator(_transformedCreator);
            final String _transformedEmployer = ((String) evaluateAndTransform(this.muleContext, event, ReferenceBeanExpressionHolder.class.getDeclaredField("_employerType").getGenericType(), null, holder.getEmployer()));
            result.setEmployer(_transformedEmployer);
            final String _transformedRefEmail = ((String) evaluateAndTransform(this.muleContext, event, ReferenceBeanExpressionHolder.class.getDeclaredField("_refEmailType").getGenericType(), null, holder.getRefEmail()));
            result.setRefEmail(_transformedRefEmail);
            final String _transformedRefName = ((String) evaluateAndTransform(this.muleContext, event, ReferenceBeanExpressionHolder.class.getDeclaredField("_refNameType").getGenericType(), null, holder.getRefName()));
            result.setRefName(_transformedRefName);
            final String _transformedRefPhone = ((String) evaluateAndTransform(this.muleContext, event, ReferenceBeanExpressionHolder.class.getDeclaredField("_refPhoneType").getGenericType(), null, holder.getRefPhone()));
            result.setRefPhone(_transformedRefPhone);
            final String _transformedRefTitle = ((String) evaluateAndTransform(this.muleContext, event, ReferenceBeanExpressionHolder.class.getDeclaredField("_refTitleType").getGenericType(), null, holder.getRefTitle()));
            result.setRefTitle(_transformedRefTitle);
            final String _transformedRelToCandidate = ((String) evaluateAndTransform(this.muleContext, event, ReferenceBeanExpressionHolder.class.getDeclaredField("_relToCandidateType").getGenericType(), null, holder.getRelToCandidate()));
            result.setRelToCandidate(_transformedRelToCandidate);
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
