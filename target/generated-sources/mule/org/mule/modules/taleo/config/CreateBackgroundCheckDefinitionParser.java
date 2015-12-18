
package org.mule.modules.taleo.config;

import javax.annotation.Generated;
import org.mule.config.MuleManifest;
import org.mule.modules.taleo.model.holders.ArrayOfFlexFieldBeanExpressionHolder;
import org.mule.modules.taleo.model.holders.BackgroundCheckBeanExpressionHolder;
import org.mule.modules.taleo.model.holders.FlexFieldBeanExpressionHolder;
import org.mule.modules.taleo.processors.CreateBackgroundCheckMessageProcessor;
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
public class CreateBackgroundCheckDefinitionParser
    extends AbstractDevkitBasedDefinitionParser
{

    private static Logger logger = LoggerFactory.getLogger(CreateBackgroundCheckDefinitionParser.class);

    private BeanDefinitionBuilder getBeanDefinitionBuilder(ParserContext parserContext) {
        try {
            return BeanDefinitionBuilder.rootBeanDefinition(CreateBackgroundCheckMessageProcessor.class.getName());
        } catch (NoClassDefFoundError noClassDefFoundError) {
            String muleVersion = "";
            try {
                muleVersion = MuleManifest.getProductVersion();
            } catch (Exception _x) {
                logger.error("Problem while reading mule version");
            }
            logger.error(("Cannot launch the mule app, the @Processor [create-background-check] within the connector [taleo] is not supported in mule "+ muleVersion));
            throw new BeanDefinitionParsingException(new Problem(("Cannot launch the mule app, the @Processor [create-background-check] within the connector [taleo] is not supported in mule "+ muleVersion), new Location(parserContext.getReaderContext().getResource()), null, noClassDefFoundError));
        }
    }

    public BeanDefinition parse(Element element, ParserContext parserContext) {
        BeanDefinitionBuilder builder = getBeanDefinitionBuilder(parserContext);
        builder.addConstructorArgValue("createBackgroundCheck");
        builder.setScope(BeanDefinition.SCOPE_PROTOTYPE);
        if (!hasAttribute(element, "config-ref")) {
            throw new BeanDefinitionParsingException(new Problem("It seems that the config-ref for @Processor [create-background-check] within the connector [taleo] is null or missing. Please, fill the value with the correct global element.", new Location(parserContext.getReaderContext().getResource()), null));
        }
        parseConfigRef(element, builder);
        if (!parseObjectRefWithDefault(element, builder, "background-check", "backgroundCheck", "#[payload]")) {
            BeanDefinitionBuilder backgroundCheckBuilder = BeanDefinitionBuilder.rootBeanDefinition(BackgroundCheckBeanExpressionHolder.class.getName());
            Element backgroundCheckChildElement = DomUtils.getChildElementByTagName(element, "background-check");
            if (backgroundCheckChildElement!= null) {
                if (hasAttribute(backgroundCheckChildElement, "creationDate-ref")) {
                    if (backgroundCheckChildElement.getAttribute("creationDate-ref").startsWith("#")) {
                        backgroundCheckBuilder.addPropertyValue("creationDate", backgroundCheckChildElement.getAttribute("creationDate-ref"));
                    } else {
                        backgroundCheckBuilder.addPropertyValue("creationDate", (("#[registry:"+ backgroundCheckChildElement.getAttribute("creationDate-ref"))+"]"));
                    }
                }
                if (!parseObjectRef(backgroundCheckChildElement, backgroundCheckBuilder, "flex-values", "flexValues")) {
                    BeanDefinitionBuilder __flexValuesBuilder = BeanDefinitionBuilder.rootBeanDefinition(ArrayOfFlexFieldBeanExpressionHolder.class.getName());
                    Element __flexValuesChildElement = DomUtils.getChildElementByTagName(backgroundCheckChildElement, "flex-values");
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
                        backgroundCheckBuilder.addPropertyValue("flexValues", __flexValuesBuilder.getBeanDefinition());
                    }
                }
                parseProperty(backgroundCheckBuilder, backgroundCheckChildElement, "id", "id");
                if (hasAttribute(backgroundCheckChildElement, "lastUpdated-ref")) {
                    if (backgroundCheckChildElement.getAttribute("lastUpdated-ref").startsWith("#")) {
                        backgroundCheckBuilder.addPropertyValue("lastUpdated", backgroundCheckChildElement.getAttribute("lastUpdated-ref"));
                    } else {
                        backgroundCheckBuilder.addPropertyValue("lastUpdated", (("#[registry:"+ backgroundCheckChildElement.getAttribute("lastUpdated-ref"))+"]"));
                    }
                }
                parseProperty(backgroundCheckBuilder, backgroundCheckChildElement, "status", "status");
                parseProperty(backgroundCheckBuilder, backgroundCheckChildElement, "candidateId", "candidateId");
                parseProperty(backgroundCheckBuilder, backgroundCheckChildElement, "checkerEmail", "checkerEmail");
                parseProperty(backgroundCheckBuilder, backgroundCheckChildElement, "checkerName", "checkerName");
                parseProperty(backgroundCheckBuilder, backgroundCheckChildElement, "checkerPhone", "checkerPhone");
                parseProperty(backgroundCheckBuilder, backgroundCheckChildElement, "comments", "comments");
                parseProperty(backgroundCheckBuilder, backgroundCheckChildElement, "creator", "creator");
                builder.addPropertyValue("backgroundCheck", backgroundCheckBuilder.getBeanDefinition());
            }
        }
        BeanDefinition definition = builder.getBeanDefinition();
        setNoRecurseOnDefinition(definition);
        attachProcessorDefinition(parserContext, definition);
        return definition;
    }

}
