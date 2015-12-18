
package org.mule.modules.taleo.config;

import javax.annotation.Generated;
import org.mule.config.MuleManifest;
import org.mule.modules.taleo.model.holders.ArrayOfFlexFieldBeanExpressionHolder;
import org.mule.modules.taleo.model.holders.FlexFieldBeanExpressionHolder;
import org.mule.modules.taleo.model.holders.RequisitionBeanExpressionHolder;
import org.mule.modules.taleo.processors.CreateRequisitionTemplateMessageProcessor;
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
public class CreateRequisitionTemplateDefinitionParser
    extends AbstractDevkitBasedDefinitionParser
{

    private static Logger logger = LoggerFactory.getLogger(CreateRequisitionTemplateDefinitionParser.class);

    private BeanDefinitionBuilder getBeanDefinitionBuilder(ParserContext parserContext) {
        try {
            return BeanDefinitionBuilder.rootBeanDefinition(CreateRequisitionTemplateMessageProcessor.class.getName());
        } catch (NoClassDefFoundError noClassDefFoundError) {
            String muleVersion = "";
            try {
                muleVersion = MuleManifest.getProductVersion();
            } catch (Exception _x) {
                logger.error("Problem while reading mule version");
            }
            logger.error(("Cannot launch the mule app, the @Processor [create-requisition-template] within the connector [taleo] is not supported in mule "+ muleVersion));
            throw new BeanDefinitionParsingException(new Problem(("Cannot launch the mule app, the @Processor [create-requisition-template] within the connector [taleo] is not supported in mule "+ muleVersion), new Location(parserContext.getReaderContext().getResource()), null, noClassDefFoundError));
        }
    }

    public BeanDefinition parse(Element element, ParserContext parserContext) {
        BeanDefinitionBuilder builder = getBeanDefinitionBuilder(parserContext);
        builder.addConstructorArgValue("createRequisitionTemplate");
        builder.setScope(BeanDefinition.SCOPE_PROTOTYPE);
        if (!hasAttribute(element, "config-ref")) {
            throw new BeanDefinitionParsingException(new Problem("It seems that the config-ref for @Processor [create-requisition-template] within the connector [taleo] is null or missing. Please, fill the value with the correct global element.", new Location(parserContext.getReaderContext().getResource()), null));
        }
        parseConfigRef(element, builder);
        if (!parseObjectRefWithDefault(element, builder, "requisition", "requisition", "#[payload]")) {
            BeanDefinitionBuilder requisitionBuilder = BeanDefinitionBuilder.rootBeanDefinition(RequisitionBeanExpressionHolder.class.getName());
            Element requisitionChildElement = DomUtils.getChildElementByTagName(element, "requisition");
            if (requisitionChildElement!= null) {
                if (hasAttribute(requisitionChildElement, "creationDate-ref")) {
                    if (requisitionChildElement.getAttribute("creationDate-ref").startsWith("#")) {
                        requisitionBuilder.addPropertyValue("creationDate", requisitionChildElement.getAttribute("creationDate-ref"));
                    } else {
                        requisitionBuilder.addPropertyValue("creationDate", (("#[registry:"+ requisitionChildElement.getAttribute("creationDate-ref"))+"]"));
                    }
                }
                if (!parseObjectRef(requisitionChildElement, requisitionBuilder, "flex-values", "flexValues")) {
                    BeanDefinitionBuilder __flexValuesBuilder = BeanDefinitionBuilder.rootBeanDefinition(ArrayOfFlexFieldBeanExpressionHolder.class.getName());
                    Element __flexValuesChildElement = DomUtils.getChildElementByTagName(requisitionChildElement, "flex-values");
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
                        requisitionBuilder.addPropertyValue("flexValues", __flexValuesBuilder.getBeanDefinition());
                    }
                }
                parseProperty(requisitionBuilder, requisitionChildElement, "id", "id");
                if (hasAttribute(requisitionChildElement, "lastUpdated-ref")) {
                    if (requisitionChildElement.getAttribute("lastUpdated-ref").startsWith("#")) {
                        requisitionBuilder.addPropertyValue("lastUpdated", requisitionChildElement.getAttribute("lastUpdated-ref"));
                    } else {
                        requisitionBuilder.addPropertyValue("lastUpdated", (("#[registry:"+ requisitionChildElement.getAttribute("lastUpdated-ref"))+"]"));
                    }
                }
                parseProperty(requisitionBuilder, requisitionChildElement, "status", "status");
                parseProperty(requisitionBuilder, requisitionChildElement, "city", "city");
                parseProperty(requisitionBuilder, requisitionChildElement, "description", "description");
                parseProperty(requisitionBuilder, requisitionChildElement, "duration", "duration");
                if (hasAttribute(requisitionChildElement, "filledDate-ref")) {
                    if (requisitionChildElement.getAttribute("filledDate-ref").startsWith("#")) {
                        requisitionBuilder.addPropertyValue("filledDate", requisitionChildElement.getAttribute("filledDate-ref"));
                    } else {
                        requisitionBuilder.addPropertyValue("filledDate", (("#[registry:"+ requisitionChildElement.getAttribute("filledDate-ref"))+"]"));
                    }
                }
                parseProperty(requisitionBuilder, requisitionChildElement, "jobCategory", "jobCategory");
                parseProperty(requisitionBuilder, requisitionChildElement, "jobCode", "jobCode");
                parseProperty(requisitionBuilder, requisitionChildElement, "location", "location");
                parseProperty(requisitionBuilder, requisitionChildElement, "numOpen", "numOpen");
                if (hasAttribute(requisitionChildElement, "openedDate-ref")) {
                    if (requisitionChildElement.getAttribute("openedDate-ref").startsWith("#")) {
                        requisitionBuilder.addPropertyValue("openedDate", requisitionChildElement.getAttribute("openedDate-ref"));
                    } else {
                        requisitionBuilder.addPropertyValue("openedDate", (("#[registry:"+ requisitionChildElement.getAttribute("openedDate-ref"))+"]"));
                    }
                }
                parseProperty(requisitionBuilder, requisitionChildElement, "payRange", "payRange");
                parseProperty(requisitionBuilder, requisitionChildElement, "state", "state");
                parseProperty(requisitionBuilder, requisitionChildElement, "title", "title");
                builder.addPropertyValue("requisition", requisitionBuilder.getBeanDefinition());
            }
        }
        BeanDefinition definition = builder.getBeanDefinition();
        setNoRecurseOnDefinition(definition);
        attachProcessorDefinition(parserContext, definition);
        return definition;
    }

}
