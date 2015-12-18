
package org.mule.modules.taleo.config;

import javax.annotation.Generated;
import org.mule.config.MuleManifest;
import org.mule.modules.taleo.model.holders.ArrayOfFlexFieldBeanExpressionHolder;
import org.mule.modules.taleo.model.holders.FlexFieldBeanExpressionHolder;
import org.mule.modules.taleo.model.holders.FlexRollingEntityBeanExpressionHolder;
import org.mule.modules.taleo.processors.UpsertRollingEntityMessageProcessor;
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
public class UpsertRollingEntityDefinitionParser
    extends AbstractDevkitBasedDefinitionParser
{

    private static Logger logger = LoggerFactory.getLogger(UpsertRollingEntityDefinitionParser.class);

    private BeanDefinitionBuilder getBeanDefinitionBuilder(ParserContext parserContext) {
        try {
            return BeanDefinitionBuilder.rootBeanDefinition(UpsertRollingEntityMessageProcessor.class.getName());
        } catch (NoClassDefFoundError noClassDefFoundError) {
            String muleVersion = "";
            try {
                muleVersion = MuleManifest.getProductVersion();
            } catch (Exception _x) {
                logger.error("Problem while reading mule version");
            }
            logger.error(("Cannot launch the mule app, the @Processor [upsert-rolling-entity] within the connector [taleo] is not supported in mule "+ muleVersion));
            throw new BeanDefinitionParsingException(new Problem(("Cannot launch the mule app, the @Processor [upsert-rolling-entity] within the connector [taleo] is not supported in mule "+ muleVersion), new Location(parserContext.getReaderContext().getResource()), null, noClassDefFoundError));
        }
    }

    public BeanDefinition parse(Element element, ParserContext parserContext) {
        BeanDefinitionBuilder builder = getBeanDefinitionBuilder(parserContext);
        builder.addConstructorArgValue("upsertRollingEntity");
        builder.setScope(BeanDefinition.SCOPE_PROTOTYPE);
        if (!hasAttribute(element, "config-ref")) {
            throw new BeanDefinitionParsingException(new Problem("It seems that the config-ref for @Processor [upsert-rolling-entity] within the connector [taleo] is null or missing. Please, fill the value with the correct global element.", new Location(parserContext.getReaderContext().getResource()), null));
        }
        parseConfigRef(element, builder);
        if (!parseObjectRefWithDefault(element, builder, "rolling-entity-bean", "rollingEntityBean", "#[payload]")) {
            BeanDefinitionBuilder rollingEntityBeanBuilder = BeanDefinitionBuilder.rootBeanDefinition(FlexRollingEntityBeanExpressionHolder.class.getName());
            Element rollingEntityBeanChildElement = DomUtils.getChildElementByTagName(element, "rolling-entity-bean");
            if (rollingEntityBeanChildElement!= null) {
                if (!parseObjectRef(rollingEntityBeanChildElement, rollingEntityBeanBuilder, "attributes", "attributes")) {
                    BeanDefinitionBuilder __attributesBuilder = BeanDefinitionBuilder.rootBeanDefinition(ArrayOfFlexFieldBeanExpressionHolder.class.getName());
                    Element __attributesChildElement = DomUtils.getChildElementByTagName(rollingEntityBeanChildElement, "attributes");
                    if (__attributesChildElement!= null) {
                        parseListAndSetProperty(__attributesChildElement, __attributesBuilder, "item", "item", "item", new ParseDelegate<BeanDefinition>() {


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
                        rollingEntityBeanBuilder.addPropertyValue("attributes", __attributesBuilder.getBeanDefinition());
                    }
                }
                if (hasAttribute(rollingEntityBeanChildElement, "creationDate-ref")) {
                    if (rollingEntityBeanChildElement.getAttribute("creationDate-ref").startsWith("#")) {
                        rollingEntityBeanBuilder.addPropertyValue("creationDate", rollingEntityBeanChildElement.getAttribute("creationDate-ref"));
                    } else {
                        rollingEntityBeanBuilder.addPropertyValue("creationDate", (("#[registry:"+ rollingEntityBeanChildElement.getAttribute("creationDate-ref"))+"]"));
                    }
                }
                if (!parseObjectRef(rollingEntityBeanChildElement, rollingEntityBeanBuilder, "flex-values", "flexValues")) {
                    BeanDefinitionBuilder ___flexValuesBuilder = BeanDefinitionBuilder.rootBeanDefinition(ArrayOfFlexFieldBeanExpressionHolder.class.getName());
                    Element ___flexValuesChildElement = DomUtils.getChildElementByTagName(rollingEntityBeanChildElement, "flex-values");
                    if (___flexValuesChildElement!= null) {
                        parseListAndSetProperty(___flexValuesChildElement, ___flexValuesBuilder, "item", "item", "item", new ParseDelegate<BeanDefinition>() {


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
                        rollingEntityBeanBuilder.addPropertyValue("flexValues", ___flexValuesBuilder.getBeanDefinition());
                    }
                }
                parseProperty(rollingEntityBeanBuilder, rollingEntityBeanChildElement, "id", "id");
                if (hasAttribute(rollingEntityBeanChildElement, "lastUpdated-ref")) {
                    if (rollingEntityBeanChildElement.getAttribute("lastUpdated-ref").startsWith("#")) {
                        rollingEntityBeanBuilder.addPropertyValue("lastUpdated", rollingEntityBeanChildElement.getAttribute("lastUpdated-ref"));
                    } else {
                        rollingEntityBeanBuilder.addPropertyValue("lastUpdated", (("#[registry:"+ rollingEntityBeanChildElement.getAttribute("lastUpdated-ref"))+"]"));
                    }
                }
                parseProperty(rollingEntityBeanBuilder, rollingEntityBeanChildElement, "status", "status");
                parseProperty(rollingEntityBeanBuilder, rollingEntityBeanChildElement, "entityType", "entityType");
                parseProperty(rollingEntityBeanBuilder, rollingEntityBeanChildElement, "entityId", "entityId");
                parseProperty(rollingEntityBeanBuilder, rollingEntityBeanChildElement, "subType", "subType");
                builder.addPropertyValue("rollingEntityBean", rollingEntityBeanBuilder.getBeanDefinition());
            }
        }
        BeanDefinition definition = builder.getBeanDefinition();
        setNoRecurseOnDefinition(definition);
        attachProcessorDefinition(parserContext, definition);
        return definition;
    }

}
