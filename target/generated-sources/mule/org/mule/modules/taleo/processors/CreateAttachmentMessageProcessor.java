
package org.mule.modules.taleo.processors;

import java.util.List;
import javax.annotation.Generated;
import org.mule.api.MuleEvent;
import org.mule.api.MuleException;
import org.mule.api.config.ConfigurationException;
import org.mule.api.devkit.ProcessAdapter;
import org.mule.api.devkit.ProcessTemplate;
import org.mule.api.lifecycle.InitialisationException;
import org.mule.api.processor.MessageProcessor;
import org.mule.api.registry.RegistrationException;
import org.mule.common.DefaultResult;
import org.mule.common.FailureType;
import org.mule.common.Result;
import org.mule.common.metadata.ConnectorMetaDataEnabled;
import org.mule.common.metadata.DefaultMetaData;
import org.mule.common.metadata.DefaultPojoMetaDataModel;
import org.mule.common.metadata.DefaultSimpleMetaDataModel;
import org.mule.common.metadata.MetaData;
import org.mule.common.metadata.MetaDataKey;
import org.mule.common.metadata.MetaDataModel;
import org.mule.common.metadata.OperationMetaDataEnabled;
import org.mule.common.metadata.datatype.DataType;
import org.mule.common.metadata.datatype.DataTypeFactory;
import org.mule.devkit.processor.DevkitBasedMessageProcessor;
import org.mule.modules.taleo.TaleoConnector;
import org.mule.modules.taleo.model.ByteArr;
import org.mule.security.oauth.callback.ProcessCallback;


/**
 * CreateAttachmentMessageProcessor invokes the {@link org.mule.modules.taleo.TaleoConnector#createAttachment(long, java.lang.String, java.lang.String, java.lang.String, org.mule.modules.taleo.model.ByteArr)} method in {@link TaleoConnector }. For each argument there is a field in this processor to match it.  Before invoking the actual method the processor will evaluate and transform where possible to the expected argument type.
 * 
 */
@SuppressWarnings("all")
@Generated(value = "Mule DevKit Version 3.6.1", date = "2015-12-18T03:06:03-03:00", comments = "Build UNNAMED.2405.44720b7")
public class CreateAttachmentMessageProcessor
    extends DevkitBasedMessageProcessor
    implements MessageProcessor, OperationMetaDataEnabled
{

    protected Object candidateId;
    protected long _candidateIdType;
    protected Object attachmentDescription;
    protected String _attachmentDescriptionType;
    protected Object attachmentName;
    protected String _attachmentNameType;
    protected Object contentType;
    protected String _contentTypeType;
    protected Object binaryResume;
    protected ByteArr _binaryResumeType;

    public CreateAttachmentMessageProcessor(String operationName) {
        super(operationName);
    }

    /**
     * Obtains the expression manager from the Mule context and initialises the connector. If a target object  has not been set already it will search the Mule registry for a default one.
     * 
     * @throws InitialisationException
     */
    public void initialise()
        throws InitialisationException
    {
    }

    @Override
    public void start()
        throws MuleException
    {
        super.start();
    }

    @Override
    public void stop()
        throws MuleException
    {
        super.stop();
    }

    @Override
    public void dispose() {
        super.dispose();
    }

    /**
     * Sets candidateId
     * 
     * @param value Value to set
     */
    public void setCandidateId(Object value) {
        this.candidateId = value;
    }

    /**
     * Sets attachmentDescription
     * 
     * @param value Value to set
     */
    public void setAttachmentDescription(Object value) {
        this.attachmentDescription = value;
    }

    /**
     * Sets binaryResume
     * 
     * @param value Value to set
     */
    public void setBinaryResume(Object value) {
        this.binaryResume = value;
    }

    /**
     * Sets contentType
     * 
     * @param value Value to set
     */
    public void setContentType(Object value) {
        this.contentType = value;
    }

    /**
     * Sets attachmentName
     * 
     * @param value Value to set
     */
    public void setAttachmentName(Object value) {
        this.attachmentName = value;
    }

    /**
     * Invokes the MessageProcessor.
     * 
     * @param event MuleEvent to be processed
     * @throws Exception
     */
    public MuleEvent doProcess(final MuleEvent event)
        throws Exception
    {
        Object moduleObject = null;
        try {
            moduleObject = findOrCreate(null, false, event);
            final Long _transformedCandidateId = ((Long) evaluateAndTransform(getMuleContext(), event, CreateAttachmentMessageProcessor.class.getDeclaredField("_candidateIdType").getGenericType(), null, candidateId));
            final String _transformedAttachmentDescription = ((String) evaluateAndTransform(getMuleContext(), event, CreateAttachmentMessageProcessor.class.getDeclaredField("_attachmentDescriptionType").getGenericType(), null, attachmentDescription));
            final String _transformedAttachmentName = ((String) evaluateAndTransform(getMuleContext(), event, CreateAttachmentMessageProcessor.class.getDeclaredField("_attachmentNameType").getGenericType(), null, attachmentName));
            final String _transformedContentType = ((String) evaluateAndTransform(getMuleContext(), event, CreateAttachmentMessageProcessor.class.getDeclaredField("_contentTypeType").getGenericType(), null, contentType));
            final ByteArr _transformedBinaryResume = ((ByteArr) evaluateAndTransform(getMuleContext(), event, CreateAttachmentMessageProcessor.class.getDeclaredField("_binaryResumeType").getGenericType(), null, binaryResume));
            Object resultPayload;
            final ProcessTemplate<Object, Object> processTemplate = ((ProcessAdapter<Object> ) moduleObject).getProcessTemplate();
            resultPayload = processTemplate.execute(new ProcessCallback<Object,Object>() {


                public List<Class<? extends Exception>> getManagedExceptions() {
                    return null;
                }

                public boolean isProtected() {
                    return false;
                }

                public Object process(Object object)
                    throws Exception
                {
                    return ((TaleoConnector) object).createAttachment(_transformedCandidateId, _transformedAttachmentDescription, _transformedAttachmentName, _transformedContentType, _transformedBinaryResume);
                }

            }
            , this, event);
            event.getMessage().setPayload(resultPayload);
            return event;
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public Result<MetaData> getInputMetaData() {
        return new DefaultResult<MetaData>(new DefaultMetaData(getPojoOrSimpleModel(ByteArr.class)));
    }

    @Override
    public Result<MetaData> getOutputMetaData(MetaData inputMetadata) {
        return new DefaultResult<MetaData>(new DefaultMetaData(getPojoOrSimpleModel(long.class)));
    }

    private MetaDataModel getPojoOrSimpleModel(Class clazz) {
        DataType dataType = DataTypeFactory.getInstance().getDataType(clazz);
        if (DataType.POJO.equals(dataType)) {
            return new DefaultPojoMetaDataModel(clazz);
        } else {
            return new DefaultSimpleMetaDataModel(dataType);
        }
    }

    public Result<MetaData> getGenericMetaData(MetaDataKey metaDataKey) {
        ConnectorMetaDataEnabled connector;
        try {
            connector = ((ConnectorMetaDataEnabled) findOrCreate(null, false, null));
            try {
                Result<MetaData> metadata = connector.getMetaData(metaDataKey);
                if ((Result.Status.FAILURE).equals(metadata.getStatus())) {
                    return metadata;
                }
                if (metadata.get() == null) {
                    return new DefaultResult<MetaData>(null, (Result.Status.FAILURE), "There was an error processing metadata at TaleoConnector at createAttachment retrieving was successful but result is null");
                }
                return metadata;
            } catch (Exception e) {
                return new DefaultResult<MetaData>(null, (Result.Status.FAILURE), e.getMessage(), FailureType.UNSPECIFIED, e);
            }
        } catch (ClassCastException cast) {
            return new DefaultResult<MetaData>(null, (Result.Status.FAILURE), "There was an error getting metadata, there was no connection manager available. Maybe you're trying to use metadata from an Oauth connector");
        } catch (ConfigurationException e) {
            return new DefaultResult<MetaData>(null, (Result.Status.FAILURE), e.getMessage(), FailureType.UNSPECIFIED, e);
        } catch (RegistrationException e) {
            return new DefaultResult<MetaData>(null, (Result.Status.FAILURE), e.getMessage(), FailureType.UNSPECIFIED, e);
        } catch (IllegalAccessException e) {
            return new DefaultResult<MetaData>(null, (Result.Status.FAILURE), e.getMessage(), FailureType.UNSPECIFIED, e);
        } catch (InstantiationException e) {
            return new DefaultResult<MetaData>(null, (Result.Status.FAILURE), e.getMessage(), FailureType.UNSPECIFIED, e);
        } catch (Exception e) {
            return new DefaultResult<MetaData>(null, (Result.Status.FAILURE), e.getMessage(), FailureType.UNSPECIFIED, e);
        }
    }

}
