
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
import org.mule.modules.taleo.model.CandidateBean;
import org.mule.modules.taleo.model.holders.CandidateBeanExpressionHolder;
import org.mule.modules.taleo.model.holders.EntityBeanExpressionHolder;
import org.mule.transformer.types.DataTypeFactory;

@SuppressWarnings("all")
@Generated(value = "Mule DevKit Version 3.6.1", date = "2015-12-18T03:06:03-03:00", comments = "Build UNNAMED.2405.44720b7")
public class CandidateBeanExpressionHolderTransformer
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
        return (aClass == CandidateBeanExpressionHolder.class);
    }

    public boolean isSourceDataTypeSupported(DataType<?> dataType) {
        return (dataType.getType() == CandidateBeanExpressionHolder.class);
    }

    public List<Class<?>> getSourceTypes() {
        return Arrays.asList(new Class<?> [] {CandidateBeanExpressionHolder.class });
    }

    public List<DataType<?>> getSourceDataTypes() {
        return Arrays.asList(new DataType<?> [] {DataTypeFactory.create(CandidateBeanExpressionHolder.class)});
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
        return CandidateBean.class;
    }

    public void setReturnDataType(DataType<?> type) {
        throw new UnsupportedOperationException();
    }

    public DataType<?> getReturnDataType() {
        return DataTypeFactory.create(CandidateBean.class);
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
        CandidateBeanExpressionHolder holder = ((CandidateBeanExpressionHolder) src);
        CandidateBean result = new CandidateBean();
        try {
            final String _transformedAddress = ((String) evaluateAndTransform(this.muleContext, event, CandidateBeanExpressionHolder.class.getDeclaredField("_addressType").getGenericType(), null, holder.getAddress()));
            result.setAddress(_transformedAddress);
            final String _transformedCellPhone = ((String) evaluateAndTransform(this.muleContext, event, CandidateBeanExpressionHolder.class.getDeclaredField("_cellPhoneType").getGenericType(), null, holder.getCellPhone()));
            result.setCellPhone(_transformedCellPhone);
            final String _transformedCity = ((String) evaluateAndTransform(this.muleContext, event, CandidateBeanExpressionHolder.class.getDeclaredField("_cityType").getGenericType(), null, holder.getCity()));
            result.setCity(_transformedCity);
            final String _transformedCountry = ((String) evaluateAndTransform(this.muleContext, event, CandidateBeanExpressionHolder.class.getDeclaredField("_countryType").getGenericType(), null, holder.getCountry()));
            result.setCountry(_transformedCountry);
            final String _transformedEmail = ((String) evaluateAndTransform(this.muleContext, event, CandidateBeanExpressionHolder.class.getDeclaredField("_emailType").getGenericType(), null, holder.getEmail()));
            result.setEmail(_transformedEmail);
            final String _transformedFirstName = ((String) evaluateAndTransform(this.muleContext, event, CandidateBeanExpressionHolder.class.getDeclaredField("_firstNameType").getGenericType(), null, holder.getFirstName()));
            result.setFirstName(_transformedFirstName);
            final String _transformedGender = ((String) evaluateAndTransform(this.muleContext, event, CandidateBeanExpressionHolder.class.getDeclaredField("_genderType").getGenericType(), null, holder.getGender()));
            result.setGender(_transformedGender);
            final XMLGregorianCalendar _transformedHiredDate = ((XMLGregorianCalendar) evaluateAndTransform(this.muleContext, event, CandidateBeanExpressionHolder.class.getDeclaredField("_hiredDateType").getGenericType(), null, holder.getHiredDate()));
            result.setHiredDate(_transformedHiredDate);
            final String _transformedLastName = ((String) evaluateAndTransform(this.muleContext, event, CandidateBeanExpressionHolder.class.getDeclaredField("_lastNameType").getGenericType(), null, holder.getLastName()));
            result.setLastName(_transformedLastName);
            final String _transformedLegalStatus = ((String) evaluateAndTransform(this.muleContext, event, CandidateBeanExpressionHolder.class.getDeclaredField("_legalStatusType").getGenericType(), null, holder.getLegalStatus()));
            result.setLegalStatus(_transformedLegalStatus);
            final String _transformedMiddleInitial = ((String) evaluateAndTransform(this.muleContext, event, CandidateBeanExpressionHolder.class.getDeclaredField("_middleInitialType").getGenericType(), null, holder.getMiddleInitial()));
            result.setMiddleInitial(_transformedMiddleInitial);
            final String _transformedPassword = ((String) evaluateAndTransform(this.muleContext, event, CandidateBeanExpressionHolder.class.getDeclaredField("_passwordType").getGenericType(), null, holder.getPassword()));
            result.setPassword(_transformedPassword);
            final String _transformedPhone = ((String) evaluateAndTransform(this.muleContext, event, CandidateBeanExpressionHolder.class.getDeclaredField("_phoneType").getGenericType(), null, holder.getPhone()));
            result.setPhone(_transformedPhone);
            final String _transformedRace = ((String) evaluateAndTransform(this.muleContext, event, CandidateBeanExpressionHolder.class.getDeclaredField("_raceType").getGenericType(), null, holder.getRace()));
            result.setRace(_transformedRace);
            final Integer _transformedRank = ((Integer) evaluateAndTransform(this.muleContext, event, CandidateBeanExpressionHolder.class.getDeclaredField("_rankType").getGenericType(), null, holder.getRank()));
            result.setRank(_transformedRank);
            final String _transformedReasonRejected = ((String) evaluateAndTransform(this.muleContext, event, CandidateBeanExpressionHolder.class.getDeclaredField("_reasonRejectedType").getGenericType(), null, holder.getReasonRejected()));
            result.setReasonRejected(_transformedReasonRejected);
            final String _transformedReferredBy = ((String) evaluateAndTransform(this.muleContext, event, CandidateBeanExpressionHolder.class.getDeclaredField("_referredByType").getGenericType(), null, holder.getReferredBy()));
            result.setReferredBy(_transformedReferredBy);
            final String _transformedResumeFileName = ((String) evaluateAndTransform(this.muleContext, event, CandidateBeanExpressionHolder.class.getDeclaredField("_resumeFileNameType").getGenericType(), null, holder.getResumeFileName()));
            result.setResumeFileName(_transformedResumeFileName);
            final String _transformedSource = ((String) evaluateAndTransform(this.muleContext, event, CandidateBeanExpressionHolder.class.getDeclaredField("_sourceType").getGenericType(), null, holder.getSource()));
            result.setSource(_transformedSource);
            final XMLGregorianCalendar _transformedStartDate = ((XMLGregorianCalendar) evaluateAndTransform(this.muleContext, event, CandidateBeanExpressionHolder.class.getDeclaredField("_startDateType").getGenericType(), null, holder.getStartDate()));
            result.setStartDate(_transformedStartDate);
            final String _transformedState = ((String) evaluateAndTransform(this.muleContext, event, CandidateBeanExpressionHolder.class.getDeclaredField("_stateType").getGenericType(), null, holder.getState()));
            result.setState(_transformedState);
            final String _transformedSubmittedBy = ((String) evaluateAndTransform(this.muleContext, event, CandidateBeanExpressionHolder.class.getDeclaredField("_submittedByType").getGenericType(), null, holder.getSubmittedBy()));
            result.setSubmittedBy(_transformedSubmittedBy);
            final String _transformedTextResume = ((String) evaluateAndTransform(this.muleContext, event, CandidateBeanExpressionHolder.class.getDeclaredField("_textResumeType").getGenericType(), null, holder.getTextResume()));
            result.setTextResume(_transformedTextResume);
            final String _transformedVeteran = ((String) evaluateAndTransform(this.muleContext, event, CandidateBeanExpressionHolder.class.getDeclaredField("_veteranType").getGenericType(), null, holder.getVeteran()));
            result.setVeteran(_transformedVeteran);
            final String _transformedZipCode = ((String) evaluateAndTransform(this.muleContext, event, CandidateBeanExpressionHolder.class.getDeclaredField("_zipCodeType").getGenericType(), null, holder.getZipCode()));
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
