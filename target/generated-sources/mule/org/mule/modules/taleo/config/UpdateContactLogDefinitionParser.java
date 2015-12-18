
package org.mule.modules.taleo.config;

import javax.annotation.Generated;
import org.mule.config.MuleManifest;
import org.mule.modules.taleo.model.holders.ContactLogBeanExpressionHolder;
import org.mule.modules.taleo.processors.UpdateContactLogMessageProcessor;
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
public class UpdateContactLogDefinitionParser
    extends AbstractDevkitBasedDefinitionParser
{

    private static Logger logger = LoggerFactory.getLogger(UpdateContactLogDefinitionParser.class);

    private BeanDefinitionBuilder getBeanDefinitionBuilder(ParserContext parserContext) {
        try {
            return BeanDefinitionBuilder.rootBeanDefinition(UpdateContactLogMessageProcessor.class.getName());
        } catch (NoClassDefFoundError noClassDefFoundError) {
            String muleVersion = "";
            try {
                muleVersion = MuleManifest.getProductVersion();
            } catch (Exception _x) {
                logger.error("Problem while reading mule version");
            }
            logger.error(("Cannot launch the mule app, the @Processor [update-contact-log] within the connector [taleo] is not supported in mule "+ muleVersion));
            throw new BeanDefinitionParsingException(new Problem(("Cannot launch the mule app, the @Processor [update-contact-log] within the connector [taleo] is not supported in mule "+ muleVersion), new Location(parserContext.getReaderContext().getResource()), null, noClassDefFoundError));
        }
    }

    public BeanDefinition parse(Element element, ParserContext parserContext) {
        BeanDefinitionBuilder builder = getBeanDefinitionBuilder(parserContext);
        builder.addConstructorArgValue("updateContactLog");
        builder.setScope(BeanDefinition.SCOPE_PROTOTYPE);
        if (!hasAttribute(element, "config-ref")) {
            throw new BeanDefinitionParsingException(new Problem("It seems that the config-ref for @Processor [update-contact-log] within the connector [taleo] is null or missing. Please, fill the value with the correct global element.", new Location(parserContext.getReaderContext().getResource()), null));
        }
        parseConfigRef(element, builder);
        if (!parseObjectRefWithDefault(element, builder, "contact-log", "contactLog", "#[payload]")) {
            BeanDefinitionBuilder contactLogBuilder = BeanDefinitionBuilder.rootBeanDefinition(ContactLogBeanExpressionHolder.class.getName());
            Element contactLogChildElement = DomUtils.getChildElementByTagName(element, "contact-log");
            if (contactLogChildElement!= null) {
                parseProperty(contactLogBuilder, contactLogChildElement, "comments", "comments");
                if (hasAttribute(contactLogChildElement, "contactDate-ref")) {
                    if (contactLogChildElement.getAttribute("contactDate-ref").startsWith("#")) {
                        contactLogBuilder.addPropertyValue("contactDate", contactLogChildElement.getAttribute("contactDate-ref"));
                    } else {
                        contactLogBuilder.addPropertyValue("contactDate", (("#[registry:"+ contactLogChildElement.getAttribute("contactDate-ref"))+"]"));
                    }
                }
                if (hasAttribute(contactLogChildElement, "creationDate-ref")) {
                    if (contactLogChildElement.getAttribute("creationDate-ref").startsWith("#")) {
                        contactLogBuilder.addPropertyValue("creationDate", contactLogChildElement.getAttribute("creationDate-ref"));
                    } else {
                        contactLogBuilder.addPropertyValue("creationDate", (("#[registry:"+ contactLogChildElement.getAttribute("creationDate-ref"))+"]"));
                    }
                }
                parseProperty(contactLogBuilder, contactLogChildElement, "creator", "creator");
                parseProperty(contactLogBuilder, contactLogChildElement, "entityId", "entityId");
                parseProperty(contactLogBuilder, contactLogChildElement, "entityType", "entityType");
                parseProperty(contactLogBuilder, contactLogChildElement, "id", "id");
                if (hasAttribute(contactLogChildElement, "lastUpdated-ref")) {
                    if (contactLogChildElement.getAttribute("lastUpdated-ref").startsWith("#")) {
                        contactLogBuilder.addPropertyValue("lastUpdated", contactLogChildElement.getAttribute("lastUpdated-ref"));
                    } else {
                        contactLogBuilder.addPropertyValue("lastUpdated", (("#[registry:"+ contactLogChildElement.getAttribute("lastUpdated-ref"))+"]"));
                    }
                }
                parseProperty(contactLogBuilder, contactLogChildElement, "subject", "subject");
                parseProperty(contactLogBuilder, contactLogChildElement, "typeNo", "typeNo");
                builder.addPropertyValue("contactLog", contactLogBuilder.getBeanDefinition());
            }
        }
        BeanDefinition definition = builder.getBeanDefinition();
        setNoRecurseOnDefinition(definition);
        attachProcessorDefinition(parserContext, definition);
        return definition;
    }

}
