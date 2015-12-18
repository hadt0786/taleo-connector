
package org.mule.modules.taleo.config;

import javax.annotation.Generated;
import org.mule.config.MuleManifest;
import org.mule.modules.taleo.model.holders.ArrayOfFlexFieldBeanExpressionHolder;
import org.mule.modules.taleo.model.holders.FlexFieldBeanExpressionHolder;
import org.mule.modules.taleo.model.holders.ReferenceBeanExpressionHolder;
import org.mule.modules.taleo.processors.CreateReferenceMessageProcessor;
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
public class CreateReferenceDefinitionParser
    extends AbstractDevkitBasedDefinitionParser
{

    private static Logger logger = LoggerFactory.getLogger(CreateReferenceDefinitionParser.class);

    private BeanDefinitionBuilder getBeanDefinitionBuilder(ParserContext parserContext) {
        try {
            return BeanDefinitionBuilder.rootBeanDefinition(CreateReferenceMessageProcessor.class.getName());
        } catch (NoClassDefFoundError noClassDefFoundError) {
            String muleVersion = "";
            try {
                muleVersion = MuleManifest.getProductVersion();
            } catch (Exception _x) {
                logger.error("Problem while reading mule version");
            }
            logger.error(("Cannot launch the mule app, the @Processor [create-reference] within the connector [taleo] is not supported in mule "+ muleVersion));
            throw new BeanDefinitionParsingException(new Problem(("Cannot launch the mule app, the @Processor [create-reference] within the connector [taleo] is not supported in mule "+ muleVersion), new Location(parserContext.getReaderContext().getResource()), null, noClassDefFoundError));
        }
    }

    public BeanDefinition parse(Element element, ParserContext parserContext) {
        BeanDefinitionBuilder builder = getBeanDefinitionBuilder(parserContext);
        builder.addConstructorArgValue("createReference");
        builder.setScope(BeanDefinition.SCOPE_PROTOTYPE);
        if (!hasAttribute(element, "config-ref")) {
            throw new BeanDefinitionParsingException(new Problem("It seems that the config-ref for @Processor [create-reference] within the connector [taleo] is null or missing. Please, fill the value with the correct global element.", new Location(parserContext.getReaderContext().getResource()), null));
        }
        parseConfigRef(element, builder);
        if (!parseObjectRefWithDefault(element, builder, "reference", "reference", "#[payload]")) {
            BeanDefinitionBuilder referenceBuilder = BeanDefinitionBuilder.rootBeanDefinition(ReferenceBeanExpressionHolder.class.getName());
            Element referenceChildElement = DomUtils.getChildElementByTagName(element, "reference");
            if (referenceChildElement!= null) {
                if (hasAttribute(referenceChildElement, "creationDate-ref")) {
                    if (referenceChildElement.getAttribute("creationDate-ref").startsWith("#")) {
                        referenceBuilder.addPropertyValue("creationDate", referenceChildElement.getAttribute("creationDate-ref"));
                    } else {
                        referenceBuilder.addPropertyValue("creationDate", (("#[registry:"+ referenceChildElement.getAttribute("creationDate-ref"))+"]"));
                    }
                }
                if (!parseObjectRef(referenceChildElement, referenceBuilder, "flex-values", "flexValues")) {
                    BeanDefinitionBuilder __flexValuesBuilder = BeanDefinitionBuilder.rootBeanDefinition(ArrayOfFlexFieldBeanExpressionHolder.class.getName());
                    Element __flexValuesChildElement = DomUtils.getChildElementByTagName(referenceChildElement, "flex-values");
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
                        referenceBuilder.addPropertyValue("flexValues", __flexValuesBuilder.getBeanDefinition());
                    }
                }
                parseProperty(referenceBuilder, referenceChildElement, "id", "id");
                if (hasAttribute(referenceChildElement, "lastUpdated-ref")) {
                    if (referenceChildElement.getAttribute("lastUpdated-ref").startsWith("#")) {
                        referenceBuilder.addPropertyValue("lastUpdated", referenceChildElement.getAttribute("lastUpdated-ref"));
                    } else {
                        referenceBuilder.addPropertyValue("lastUpdated", (("#[registry:"+ referenceChildElement.getAttribute("lastUpdated-ref"))+"]"));
                    }
                }
                parseProperty(referenceBuilder, referenceChildElement, "status", "status");
                parseProperty(referenceBuilder, referenceChildElement, "candidateId", "candidateId");
                parseProperty(referenceBuilder, referenceChildElement, "comments", "comments");
                parseProperty(referenceBuilder, referenceChildElement, "creator", "creator");
                parseProperty(referenceBuilder, referenceChildElement, "employer", "employer");
                parseProperty(referenceBuilder, referenceChildElement, "refEmail", "refEmail");
                parseProperty(referenceBuilder, referenceChildElement, "refName", "refName");
                parseProperty(referenceBuilder, referenceChildElement, "refPhone", "refPhone");
                parseProperty(referenceBuilder, referenceChildElement, "refTitle", "refTitle");
                parseProperty(referenceBuilder, referenceChildElement, "relToCandidate", "relToCandidate");
                builder.addPropertyValue("reference", referenceBuilder.getBeanDefinition());
            }
        }
        BeanDefinition definition = builder.getBeanDefinition();
        setNoRecurseOnDefinition(definition);
        attachProcessorDefinition(parserContext, definition);
        return definition;
    }

}
