
package org.mule.modules.taleo.config;

import javax.annotation.Generated;
import org.mule.config.MuleManifest;
import org.mule.modules.taleo.model.holders.ArrayOfFlexFieldBeanExpressionHolder;
import org.mule.modules.taleo.model.holders.ArrayOfXsdLongExpressionHolder;
import org.mule.modules.taleo.model.holders.ArrayOfXsdStringExpressionHolder;
import org.mule.modules.taleo.model.holders.FlexFieldBeanExpressionHolder;
import org.mule.modules.taleo.model.holders.LocationBeanExpressionHolder;
import org.mule.modules.taleo.model.holders.MapExpressionHolder;
import org.mule.modules.taleo.model.holders.MapItemExpressionHolder;
import org.mule.modules.taleo.processors.UpsertLocationMessageProcessor;
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
public class UpsertLocationDefinitionParser
    extends AbstractDevkitBasedDefinitionParser
{

    private static Logger logger = LoggerFactory.getLogger(UpsertLocationDefinitionParser.class);

    private BeanDefinitionBuilder getBeanDefinitionBuilder(ParserContext parserContext) {
        try {
            return BeanDefinitionBuilder.rootBeanDefinition(UpsertLocationMessageProcessor.class.getName());
        } catch (NoClassDefFoundError noClassDefFoundError) {
            String muleVersion = "";
            try {
                muleVersion = MuleManifest.getProductVersion();
            } catch (Exception _x) {
                logger.error("Problem while reading mule version");
            }
            logger.error(("Cannot launch the mule app, the @Processor [upsert-location] within the connector [taleo] is not supported in mule "+ muleVersion));
            throw new BeanDefinitionParsingException(new Problem(("Cannot launch the mule app, the @Processor [upsert-location] within the connector [taleo] is not supported in mule "+ muleVersion), new Location(parserContext.getReaderContext().getResource()), null, noClassDefFoundError));
        }
    }

    public BeanDefinition parse(Element element, ParserContext parserContext) {
        BeanDefinitionBuilder builder = getBeanDefinitionBuilder(parserContext);
        builder.addConstructorArgValue("upsertLocation");
        builder.setScope(BeanDefinition.SCOPE_PROTOTYPE);
        if (!hasAttribute(element, "config-ref")) {
            throw new BeanDefinitionParsingException(new Problem("It seems that the config-ref for @Processor [upsert-location] within the connector [taleo] is null or missing. Please, fill the value with the correct global element.", new Location(parserContext.getReaderContext().getResource()), null));
        }
        parseConfigRef(element, builder);
        if (!parseObjectRefWithDefault(element, builder, "location", "location", "#[payload]")) {
            BeanDefinitionBuilder locationBuilder = BeanDefinitionBuilder.rootBeanDefinition(LocationBeanExpressionHolder.class.getName());
            Element locationChildElement = DomUtils.getChildElementByTagName(element, "location");
            if (locationChildElement!= null) {
                parseProperty(locationBuilder, locationChildElement, "city", "city");
                parseProperty(locationBuilder, locationChildElement, "address", "address");
                parseProperty(locationBuilder, locationChildElement, "zipCode", "zipCode");
                parseProperty(locationBuilder, locationChildElement, "state", "state");
                parseProperty(locationBuilder, locationChildElement, "country", "country");
                parseProperty(locationBuilder, locationChildElement, "phone", "phone");
                if (hasAttribute(locationChildElement, "creationDate-ref")) {
                    if (locationChildElement.getAttribute("creationDate-ref").startsWith("#")) {
                        locationBuilder.addPropertyValue("creationDate", locationChildElement.getAttribute("creationDate-ref"));
                    } else {
                        locationBuilder.addPropertyValue("creationDate", (("#[registry:"+ locationChildElement.getAttribute("creationDate-ref"))+"]"));
                    }
                }
                if (!parseObjectRef(locationChildElement, locationBuilder, "flex-values", "flexValues")) {
                    BeanDefinitionBuilder ___flexValuesBuilder = BeanDefinitionBuilder.rootBeanDefinition(ArrayOfFlexFieldBeanExpressionHolder.class.getName());
                    Element ___flexValuesChildElement = DomUtils.getChildElementByTagName(locationChildElement, "flex-values");
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
                        locationBuilder.addPropertyValue("flexValues", ___flexValuesBuilder.getBeanDefinition());
                    }
                }
                parseProperty(locationBuilder, locationChildElement, "id", "id");
                if (hasAttribute(locationChildElement, "lastUpdated-ref")) {
                    if (locationChildElement.getAttribute("lastUpdated-ref").startsWith("#")) {
                        locationBuilder.addPropertyValue("lastUpdated", locationChildElement.getAttribute("lastUpdated-ref"));
                    } else {
                        locationBuilder.addPropertyValue("lastUpdated", (("#[registry:"+ locationChildElement.getAttribute("lastUpdated-ref"))+"]"));
                    }
                }
                parseProperty(locationBuilder, locationChildElement, "status", "status");
                if (!parseObjectRef(locationChildElement, locationBuilder, "additional-properties", "additionalProperties")) {
                    BeanDefinitionBuilder _additionalPropertiesBuilder = BeanDefinitionBuilder.rootBeanDefinition(MapExpressionHolder.class.getName());
                    Element _additionalPropertiesChildElement = DomUtils.getChildElementByTagName(locationChildElement, "additional-properties");
                    if (_additionalPropertiesChildElement!= null) {
                        parseListAndSetProperty(_additionalPropertiesChildElement, _additionalPropertiesBuilder, "item", "item", "item", new ParseDelegate<BeanDefinition>() {


                            public BeanDefinition parse(Element element) {
                                BeanDefinitionBuilder builder = BeanDefinitionBuilder.rootBeanDefinition(MapItemExpressionHolder.class);
                                if (hasAttribute(element, "key-ref")) {
                                    if (element.getAttribute("key-ref").startsWith("#")) {
                                        builder.addPropertyValue("key", element.getAttribute("key-ref"));
                                    } else {
                                        builder.addPropertyValue("key", (("#[registry:"+ element.getAttribute("key-ref"))+"]"));
                                    }
                                }
                                if (hasAttribute(element, "propertyValue-ref")) {
                                    if (element.getAttribute("propertyValue-ref").startsWith("#")) {
                                        builder.addPropertyValue("propertyValue", element.getAttribute("propertyValue-ref"));
                                    } else {
                                        builder.addPropertyValue("propertyValue", (("#[registry:"+ element.getAttribute("propertyValue-ref"))+"]"));
                                    }
                                }
                                return builder.getBeanDefinition();
                            }

                        }
                        );
                        locationBuilder.addPropertyValue("additionalProperties", _additionalPropertiesBuilder.getBeanDefinition());
                    }
                }
                parseProperty(locationBuilder, locationChildElement, "directions", "directions");
                parseProperty(locationBuilder, locationChildElement, "locationId", "locationId");
                parseProperty(locationBuilder, locationChildElement, "locationName", "locationName");
                parseProperty(locationBuilder, locationChildElement, "regionId", "regionId");
                parseProperty(locationBuilder, locationChildElement, "timeZone", "timeZone");
                if (!parseObjectRef(locationChildElement, locationBuilder, "interview-rooms", "interviewRooms")) {
                    BeanDefinitionBuilder _interviewRoomsBuilder = BeanDefinitionBuilder.rootBeanDefinition(ArrayOfXsdStringExpressionHolder.class.getName());
                    Element _interviewRoomsChildElement = DomUtils.getChildElementByTagName(locationChildElement, "interview-rooms");
                    if (_interviewRoomsChildElement!= null) {
                        parseListAndSetProperty(_interviewRoomsChildElement, _interviewRoomsBuilder, "item", "item", "item", new ParseDelegate<String>() {


                            public String parse(Element element) {
                                return element.getTextContent();
                            }

                        }
                        );
                        locationBuilder.addPropertyValue("interviewRooms", _interviewRoomsBuilder.getBeanDefinition());
                    }
                }
                if (!parseObjectRef(locationChildElement, locationBuilder, "default-approvers", "defaultApprovers")) {
                    BeanDefinitionBuilder _defaultApproversBuilder = BeanDefinitionBuilder.rootBeanDefinition(ArrayOfXsdLongExpressionHolder.class.getName());
                    Element _defaultApproversChildElement = DomUtils.getChildElementByTagName(locationChildElement, "default-approvers");
                    if (_defaultApproversChildElement!= null) {
                        parseListAndSetProperty(_defaultApproversChildElement, _defaultApproversBuilder, "item", "item", "item", new ParseDelegate<String>() {


                            public String parse(Element element) {
                                return element.getTextContent();
                            }

                        }
                        );
                        locationBuilder.addPropertyValue("defaultApprovers", _defaultApproversBuilder.getBeanDefinition());
                    }
                }
                builder.addPropertyValue("location", locationBuilder.getBeanDefinition());
            }
        }
        BeanDefinition definition = builder.getBeanDefinition();
        setNoRecurseOnDefinition(definition);
        attachProcessorDefinition(parserContext, definition);
        return definition;
    }

}
