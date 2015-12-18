
package org.mule.modules.taleo.config;

import javax.annotation.Generated;
import org.mule.config.MuleManifest;
import org.mule.modules.taleo.model.holders.ArrayOfFlexFieldBeanExpressionHolder;
import org.mule.modules.taleo.model.holders.FlexFieldBeanExpressionHolder;
import org.mule.modules.taleo.model.holders.UserBeanExpressionHolder;
import org.mule.modules.taleo.processors.UpdateUserMessageProcessor;
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
public class UpdateUserDefinitionParser
    extends AbstractDevkitBasedDefinitionParser
{

    private static Logger logger = LoggerFactory.getLogger(UpdateUserDefinitionParser.class);

    private BeanDefinitionBuilder getBeanDefinitionBuilder(ParserContext parserContext) {
        try {
            return BeanDefinitionBuilder.rootBeanDefinition(UpdateUserMessageProcessor.class.getName());
        } catch (NoClassDefFoundError noClassDefFoundError) {
            String muleVersion = "";
            try {
                muleVersion = MuleManifest.getProductVersion();
            } catch (Exception _x) {
                logger.error("Problem while reading mule version");
            }
            logger.error(("Cannot launch the mule app, the @Processor [update-user] within the connector [taleo] is not supported in mule "+ muleVersion));
            throw new BeanDefinitionParsingException(new Problem(("Cannot launch the mule app, the @Processor [update-user] within the connector [taleo] is not supported in mule "+ muleVersion), new Location(parserContext.getReaderContext().getResource()), null, noClassDefFoundError));
        }
    }

    public BeanDefinition parse(Element element, ParserContext parserContext) {
        BeanDefinitionBuilder builder = getBeanDefinitionBuilder(parserContext);
        builder.addConstructorArgValue("updateUser");
        builder.setScope(BeanDefinition.SCOPE_PROTOTYPE);
        if (!hasAttribute(element, "config-ref")) {
            throw new BeanDefinitionParsingException(new Problem("It seems that the config-ref for @Processor [update-user] within the connector [taleo] is null or missing. Please, fill the value with the correct global element.", new Location(parserContext.getReaderContext().getResource()), null));
        }
        parseConfigRef(element, builder);
        if (!parseObjectRefWithDefault(element, builder, "user", "user", "#[payload]")) {
            BeanDefinitionBuilder userBuilder = BeanDefinitionBuilder.rootBeanDefinition(UserBeanExpressionHolder.class.getName());
            Element userChildElement = DomUtils.getChildElementByTagName(element, "user");
            if (userChildElement!= null) {
                if (hasAttribute(userChildElement, "creationDate-ref")) {
                    if (userChildElement.getAttribute("creationDate-ref").startsWith("#")) {
                        userBuilder.addPropertyValue("creationDate", userChildElement.getAttribute("creationDate-ref"));
                    } else {
                        userBuilder.addPropertyValue("creationDate", (("#[registry:"+ userChildElement.getAttribute("creationDate-ref"))+"]"));
                    }
                }
                if (!parseObjectRef(userChildElement, userBuilder, "flex-values", "flexValues")) {
                    BeanDefinitionBuilder __flexValuesBuilder = BeanDefinitionBuilder.rootBeanDefinition(ArrayOfFlexFieldBeanExpressionHolder.class.getName());
                    Element __flexValuesChildElement = DomUtils.getChildElementByTagName(userChildElement, "flex-values");
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
                        userBuilder.addPropertyValue("flexValues", __flexValuesBuilder.getBeanDefinition());
                    }
                }
                parseProperty(userBuilder, userChildElement, "id", "id");
                if (hasAttribute(userChildElement, "lastUpdated-ref")) {
                    if (userChildElement.getAttribute("lastUpdated-ref").startsWith("#")) {
                        userBuilder.addPropertyValue("lastUpdated", userChildElement.getAttribute("lastUpdated-ref"));
                    } else {
                        userBuilder.addPropertyValue("lastUpdated", (("#[registry:"+ userChildElement.getAttribute("lastUpdated-ref"))+"]"));
                    }
                }
                parseProperty(userBuilder, userChildElement, "status", "status");
                parseProperty(userBuilder, userChildElement, "cellPhone", "cellPhone");
                parseProperty(userBuilder, userChildElement, "email", "email");
                parseProperty(userBuilder, userChildElement, "fax", "fax");
                parseProperty(userBuilder, userChildElement, "firstName", "firstName");
                if (hasAttribute(userChildElement, "lastLogin-ref")) {
                    if (userChildElement.getAttribute("lastLogin-ref").startsWith("#")) {
                        userBuilder.addPropertyValue("lastLogin", userChildElement.getAttribute("lastLogin-ref"));
                    } else {
                        userBuilder.addPropertyValue("lastLogin", (("#[registry:"+ userChildElement.getAttribute("lastLogin-ref"))+"]"));
                    }
                }
                parseProperty(userBuilder, userChildElement, "lastName", "lastName");
                parseProperty(userBuilder, userChildElement, "localeCode", "localeCode");
                parseProperty(userBuilder, userChildElement, "location", "location");
                parseProperty(userBuilder, userChildElement, "loginName", "loginName");
                parseProperty(userBuilder, userChildElement, "manager", "manager");
                parseProperty(userBuilder, userChildElement, "middleInitial", "middleInitial");
                parseProperty(userBuilder, userChildElement, "phone", "phone");
                parseProperty(userBuilder, userChildElement, "role", "role");
                parseProperty(userBuilder, userChildElement, "timeZoneId", "timeZoneId");
                parseProperty(userBuilder, userChildElement, "title", "title");
                builder.addPropertyValue("user", userBuilder.getBeanDefinition());
            }
        }
        BeanDefinition definition = builder.getBeanDefinition();
        setNoRecurseOnDefinition(definition);
        attachProcessorDefinition(parserContext, definition);
        return definition;
    }

}
