
package org.mule.modules.taleo.config;

import javax.annotation.Generated;
import org.mule.config.MuleManifest;
import org.mule.modules.taleo.model.holders.ArrayOfFlexFieldBeanExpressionHolder;
import org.mule.modules.taleo.model.holders.FlexFieldBeanExpressionHolder;
import org.mule.modules.taleo.model.holders.OfferBeanExpressionHolder;
import org.mule.modules.taleo.processors.UpdateOfferMessageProcessor;
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
public class UpdateOfferDefinitionParser
    extends AbstractDevkitBasedDefinitionParser
{

    private static Logger logger = LoggerFactory.getLogger(UpdateOfferDefinitionParser.class);

    private BeanDefinitionBuilder getBeanDefinitionBuilder(ParserContext parserContext) {
        try {
            return BeanDefinitionBuilder.rootBeanDefinition(UpdateOfferMessageProcessor.class.getName());
        } catch (NoClassDefFoundError noClassDefFoundError) {
            String muleVersion = "";
            try {
                muleVersion = MuleManifest.getProductVersion();
            } catch (Exception _x) {
                logger.error("Problem while reading mule version");
            }
            logger.error(("Cannot launch the mule app, the @Processor [update-offer] within the connector [taleo] is not supported in mule "+ muleVersion));
            throw new BeanDefinitionParsingException(new Problem(("Cannot launch the mule app, the @Processor [update-offer] within the connector [taleo] is not supported in mule "+ muleVersion), new Location(parserContext.getReaderContext().getResource()), null, noClassDefFoundError));
        }
    }

    public BeanDefinition parse(Element element, ParserContext parserContext) {
        BeanDefinitionBuilder builder = getBeanDefinitionBuilder(parserContext);
        builder.addConstructorArgValue("updateOffer");
        builder.setScope(BeanDefinition.SCOPE_PROTOTYPE);
        if (!hasAttribute(element, "config-ref")) {
            throw new BeanDefinitionParsingException(new Problem("It seems that the config-ref for @Processor [update-offer] within the connector [taleo] is null or missing. Please, fill the value with the correct global element.", new Location(parserContext.getReaderContext().getResource()), null));
        }
        parseConfigRef(element, builder);
        if (!parseObjectRefWithDefault(element, builder, "offer", "offer", "#[payload]")) {
            BeanDefinitionBuilder offerBuilder = BeanDefinitionBuilder.rootBeanDefinition(OfferBeanExpressionHolder.class.getName());
            Element offerChildElement = DomUtils.getChildElementByTagName(element, "offer");
            if (offerChildElement!= null) {
                if (hasAttribute(offerChildElement, "creationDate-ref")) {
                    if (offerChildElement.getAttribute("creationDate-ref").startsWith("#")) {
                        offerBuilder.addPropertyValue("creationDate", offerChildElement.getAttribute("creationDate-ref"));
                    } else {
                        offerBuilder.addPropertyValue("creationDate", (("#[registry:"+ offerChildElement.getAttribute("creationDate-ref"))+"]"));
                    }
                }
                if (!parseObjectRef(offerChildElement, offerBuilder, "flex-values", "flexValues")) {
                    BeanDefinitionBuilder __flexValuesBuilder = BeanDefinitionBuilder.rootBeanDefinition(ArrayOfFlexFieldBeanExpressionHolder.class.getName());
                    Element __flexValuesChildElement = DomUtils.getChildElementByTagName(offerChildElement, "flex-values");
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
                        offerBuilder.addPropertyValue("flexValues", __flexValuesBuilder.getBeanDefinition());
                    }
                }
                parseProperty(offerBuilder, offerChildElement, "id", "id");
                if (hasAttribute(offerChildElement, "lastUpdated-ref")) {
                    if (offerChildElement.getAttribute("lastUpdated-ref").startsWith("#")) {
                        offerBuilder.addPropertyValue("lastUpdated", offerChildElement.getAttribute("lastUpdated-ref"));
                    } else {
                        offerBuilder.addPropertyValue("lastUpdated", (("#[registry:"+ offerChildElement.getAttribute("lastUpdated-ref"))+"]"));
                    }
                }
                parseProperty(offerBuilder, offerChildElement, "status", "status");
                parseProperty(offerBuilder, offerChildElement, "candidateId", "candidateId");
                parseProperty(offerBuilder, offerChildElement, "creator", "creator");
                parseProperty(offerBuilder, offerChildElement, "employmentType", "employmentType");
                if (hasAttribute(offerChildElement, "expirationDate-ref")) {
                    if (offerChildElement.getAttribute("expirationDate-ref").startsWith("#")) {
                        offerBuilder.addPropertyValue("expirationDate", offerChildElement.getAttribute("expirationDate-ref"));
                    } else {
                        offerBuilder.addPropertyValue("expirationDate", (("#[registry:"+ offerChildElement.getAttribute("expirationDate-ref"))+"]"));
                    }
                }
                parseProperty(offerBuilder, offerChildElement, "manager", "manager");
                parseProperty(offerBuilder, offerChildElement, "offerFileName", "offerFileName");
                parseProperty(offerBuilder, offerChildElement, "payRate", "payRate");
                parseProperty(offerBuilder, offerChildElement, "requisitionId", "requisitionId");
                if (hasAttribute(offerChildElement, "startDate-ref")) {
                    if (offerChildElement.getAttribute("startDate-ref").startsWith("#")) {
                        offerBuilder.addPropertyValue("startDate", offerChildElement.getAttribute("startDate-ref"));
                    } else {
                        offerBuilder.addPropertyValue("startDate", (("#[registry:"+ offerChildElement.getAttribute("startDate-ref"))+"]"));
                    }
                }
                parseProperty(offerBuilder, offerChildElement, "stockOptions", "stockOptions");
                parseProperty(offerBuilder, offerChildElement, "title", "title");
                builder.addPropertyValue("offer", offerBuilder.getBeanDefinition());
            }
        }
        BeanDefinition definition = builder.getBeanDefinition();
        setNoRecurseOnDefinition(definition);
        attachProcessorDefinition(parserContext, definition);
        return definition;
    }

}
