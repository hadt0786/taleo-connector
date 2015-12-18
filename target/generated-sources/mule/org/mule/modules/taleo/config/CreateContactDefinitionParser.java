
package org.mule.modules.taleo.config;

import javax.annotation.Generated;
import org.mule.config.MuleManifest;
import org.mule.modules.taleo.model.holders.ArrayOfFlexFieldBeanExpressionHolder;
import org.mule.modules.taleo.model.holders.ContactBeanExpressionHolder;
import org.mule.modules.taleo.model.holders.FlexFieldBeanExpressionHolder;
import org.mule.modules.taleo.processors.CreateContactMessageProcessor;
import org.mule.security.oauth.config.AbstractDevkitBasedDefinitionParser;
import org.mule.security.oauth.config.AbstractDevkitBasedDefinitionParser.ParseDelegate;
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
public class CreateContactDefinitionParser
    extends AbstractDevkitBasedDefinitionParser
{

    private static Logger logger = LoggerFactory.getLogger(CreateContactDefinitionParser.class);

    private BeanDefinitionBuilder getBeanDefinitionBuilder(ParserContext parserContext) {
        try {
            return BeanDefinitionBuilder.rootBeanDefinition(CreateContactMessageProcessor.class.getName());
        } catch (NoClassDefFoundError noClassDefFoundError) {
            String muleVersion = "";
            try {
                muleVersion = MuleManifest.getProductVersion();
            } catch (Exception _x) {
                logger.error("Problem while reading mule version");
            }
            logger.error(("Cannot launch the mule app, the @Processor [create-contact] within the connector [taleo] is not supported in mule "+ muleVersion));
            throw new BeanDefinitionParsingException(new Problem(("Cannot launch the mule app, the @Processor [create-contact] within the connector [taleo] is not supported in mule "+ muleVersion), new Location(parserContext.getReaderContext().getResource()), null, noClassDefFoundError));
        }
    }

    public BeanDefinition parse(Element element, ParserContext parserContext) {
        BeanDefinitionBuilder builder = getBeanDefinitionBuilder(parserContext);
        builder.addConstructorArgValue("createContact");
        builder.setScope(BeanDefinition.SCOPE_PROTOTYPE);
        if (!hasAttribute(element, "config-ref")) {
            throw new BeanDefinitionParsingException(new Problem("It seems that the config-ref for @Processor [create-contact] within the connector [taleo] is null or missing. Please, fill the value with the correct global element.", new Location(parserContext.getReaderContext().getResource()), null));
        }
        parseConfigRef(element, builder);
        if (!parseObjectRefWithDefault(element, builder, "contact", "contact", "#[payload]")) {
            BeanDefinitionBuilder contactBuilder = BeanDefinitionBuilder.rootBeanDefinition(ContactBeanExpressionHolder.class.getName());
            Element contactChildElement = DomUtils.getChildElementByTagName(element, "contact");
            if (contactChildElement!= null) {
                if (hasAttribute(contactChildElement, "creationDate-ref")) {
                    if (contactChildElement.getAttribute("creationDate-ref").startsWith("#")) {
                        contactBuilder.addPropertyValue("creationDate", contactChildElement.getAttribute("creationDate-ref"));
                    } else {
                        contactBuilder.addPropertyValue("creationDate", (("#[registry:"+ contactChildElement.getAttribute("creationDate-ref"))+"]"));
                    }
                }
                if (!parseObjectRef(contactChildElement, contactBuilder, "flex-values", "flexValues")) {
                    BeanDefinitionBuilder __flexValuesBuilder = BeanDefinitionBuilder.rootBeanDefinition(ArrayOfFlexFieldBeanExpressionHolder.class.getName());
                    Element __flexValuesChildElement = DomUtils.getChildElementByTagName(contactChildElement, "flex-values");
                    if (__flexValuesChildElement!= null) {
                        parseListAndSetProperty(__flexValuesChildElement, __flexValuesBuilder, "item", "item", "item", new ParseDelegate<BeanDefinition>() {


                            public BeanDefinition parse(Element element) {
                                BeanDefinitionBuilder builder = BeanDefinitionBuilder.rootBeanDefinition(FlexFieldBeanExpressionHolder.class);
                                parseProperty(builder, element, "fieldName", "fieldName");
                                parseProperty(builder, element, "valueBool", "valueBool");
                                if (hasAttribute(element, "valueDate-ref")) {
                                    if (element.getAttribute("valueDate-ref").startsWith("#")) {
                                        builder.addPropertyValue("valueDate", element.getAttribute("valueDate-ref"));
                                    } else {
                                        builder.addPropertyValue("valueDate", (("#[registry:"+ element.getAttribute("valueDate-ref"))+"]"));
                                    }
                                }
                                parseProperty(builder, element, "valueDbl", "valueDbl");
                                parseProperty(builder, element, "valueInt", "valueInt");
                                parseProperty(builder, element, "valueLong", "valueLong");
                                parseProperty(builder, element, "valueStr", "valueStr");
                                return builder.getBeanDefinition();
                            }

                        }
                        );
                        contactBuilder.addPropertyValue("flexValues", __flexValuesBuilder.getBeanDefinition());
                    }
                }
                parseProperty(contactBuilder, contactChildElement, "id", "id");
                if (hasAttribute(contactChildElement, "lastUpdated-ref")) {
                    if (contactChildElement.getAttribute("lastUpdated-ref").startsWith("#")) {
                        contactBuilder.addPropertyValue("lastUpdated", contactChildElement.getAttribute("lastUpdated-ref"));
                    } else {
                        contactBuilder.addPropertyValue("lastUpdated", (("#[registry:"+ contactChildElement.getAttribute("lastUpdated-ref"))+"]"));
                    }
                }
                parseProperty(contactBuilder, contactChildElement, "status", "status");
                parseProperty(contactBuilder, contactChildElement, "accountId", "accountId");
                parseProperty(contactBuilder, contactChildElement, "address", "address");
                parseProperty(contactBuilder, contactChildElement, "assistantEmail", "assistantEmail");
                parseProperty(contactBuilder, contactChildElement, "assistantName", "assistantName");
                parseProperty(contactBuilder, contactChildElement, "assistantPhone", "assistantPhone");
                parseProperty(contactBuilder, contactChildElement, "cellPhone", "cellPhone");
                parseProperty(contactBuilder, contactChildElement, "city", "city");
                parseProperty(contactBuilder, contactChildElement, "contactType", "contactType");
                parseProperty(contactBuilder, contactChildElement, "country", "country");
                parseProperty(contactBuilder, contactChildElement, "creator", "creator");
                parseProperty(contactBuilder, contactChildElement, "department", "department");
                parseProperty(contactBuilder, contactChildElement, "description", "description");
                parseProperty(contactBuilder, contactChildElement, "email", "email");
                parseProperty(contactBuilder, contactChildElement, "fax", "fax");
                parseProperty(contactBuilder, contactChildElement, "firstName", "firstName");
                parseProperty(contactBuilder, contactChildElement, "lastName", "lastName");
                parseProperty(contactBuilder, contactChildElement, "phone", "phone");
                parseProperty(contactBuilder, contactChildElement, "reportsToId", "reportsToId");
                parseProperty(contactBuilder, contactChildElement, "state", "state");
                parseProperty(contactBuilder, contactChildElement, "title", "title");
                parseProperty(contactBuilder, contactChildElement, "zipCode", "zipCode");
                builder.addPropertyValue("contact", contactBuilder.getBeanDefinition());
            }
        }
        BeanDefinition definition = builder.getBeanDefinition();
        setNoRecurseOnDefinition(definition);
        attachProcessorDefinition(parserContext, definition);
        return definition;
    }

}
