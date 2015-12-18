
package org.mule.modules.taleo.config;

import javax.annotation.Generated;
import org.mule.config.MuleManifest;
import org.mule.modules.taleo.model.holders.ByteArrExpressionHolder;
import org.mule.modules.taleo.processors.CreateAttachmentMessageProcessor;
import org.mule.security.oauth.config.AbstractDevkitBasedDefinitionParser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.parsing.BeanDefinitionParsingException;
import org.springframework.beans.factory.parsing.Location;
import org.springframework.beans.factory.parsing.Problem;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.xml.ParserContext;
import org.springframework.util.xml.DomUtils;
import org.w3c.dom.Element;

@SuppressWarnings("all")
@Generated(value = "Mule DevKit Version 3.6.1", date = "2015-12-18T03:06:03-03:00", comments = "Build UNNAMED.2405.44720b7")
public class CreateAttachmentDefinitionParser
    extends AbstractDevkitBasedDefinitionParser
{

    private static Logger logger = LoggerFactory.getLogger(CreateAttachmentDefinitionParser.class);

    private BeanDefinitionBuilder getBeanDefinitionBuilder(ParserContext parserContext) {
        try {
            return BeanDefinitionBuilder.rootBeanDefinition(CreateAttachmentMessageProcessor.class.getName());
        } catch (NoClassDefFoundError noClassDefFoundError) {
            String muleVersion = "";
            try {
                muleVersion = MuleManifest.getProductVersion();
            } catch (Exception _x) {
                logger.error("Problem while reading mule version");
            }
            logger.error(("Cannot launch the mule app, the @Processor [create-attachment] within the connector [taleo] is not supported in mule "+ muleVersion));
            throw new BeanDefinitionParsingException(new Problem(("Cannot launch the mule app, the @Processor [create-attachment] within the connector [taleo] is not supported in mule "+ muleVersion), new Location(parserContext.getReaderContext().getResource()), null, noClassDefFoundError));
        }
    }

    public BeanDefinition parse(Element element, ParserContext parserContext) {
        BeanDefinitionBuilder builder = getBeanDefinitionBuilder(parserContext);
        builder.addConstructorArgValue("createAttachment");
        builder.setScope(BeanDefinition.SCOPE_PROTOTYPE);
        if (!hasAttribute(element, "config-ref")) {
            throw new BeanDefinitionParsingException(new Problem("It seems that the config-ref for @Processor [create-attachment] within the connector [taleo] is null or missing. Please, fill the value with the correct global element.", new Location(parserContext.getReaderContext().getResource()), null));
        }
        parseConfigRef(element, builder);
        parseProperty(builder, element, "candidateId", "candidateId");
        parseProperty(builder, element, "attachmentDescription", "attachmentDescription");
        parseProperty(builder, element, "attachmentName", "attachmentName");
        parseProperty(builder, element, "contentType", "contentType");
        if (!parseObjectRefWithDefault(element, builder, "binary-resume", "binaryResume", "#[payload]")) {
            BeanDefinitionBuilder binaryResumeBuilder = BeanDefinitionBuilder.rootBeanDefinition(ByteArrExpressionHolder.class.getName());
            Element binaryResumeChildElement = DomUtils.getChildElementByTagName(element, "binary-resume");
            if (binaryResumeChildElement!= null) {
                if (hasAttribute(binaryResumeChildElement, "array-ref")) {
                    if (binaryResumeChildElement.getAttribute("array-ref").startsWith("#")) {
                        binaryResumeBuilder.addPropertyValue("array", binaryResumeChildElement.getAttribute("array-ref"));
                    } else {
                        binaryResumeBuilder.addPropertyValue("array", (("#[registry:"+ binaryResumeChildElement.getAttribute("array-ref"))+"]"));
                    }
                }
                builder.addPropertyValue("binaryResume", binaryResumeBuilder.getBeanDefinition());
            }
        }
        BeanDefinition definition = builder.getBeanDefinition();
        setNoRecurseOnDefinition(definition);
        attachProcessorDefinition(parserContext, definition);
        return definition;
    }

}
