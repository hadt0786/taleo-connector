
package org.mule.modules.taleo.config;

import javax.annotation.Generated;
import org.mule.config.MuleManifest;
import org.mule.modules.taleo.model.holders.ArrayOfFlexFieldBeanExpressionHolder;
import org.mule.modules.taleo.model.holders.ArrayOfParticipantBeanExpressionHolder;
import org.mule.modules.taleo.model.holders.CalendarEventBeanExpressionHolder;
import org.mule.modules.taleo.model.holders.FlexFieldBeanExpressionHolder;
import org.mule.modules.taleo.model.holders.ParticipantBeanExpressionHolder;
import org.mule.modules.taleo.processors.CreateEventMessageProcessor;
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
public class CreateEventDefinitionParser
    extends AbstractDevkitBasedDefinitionParser
{

    private static Logger logger = LoggerFactory.getLogger(CreateEventDefinitionParser.class);

    private BeanDefinitionBuilder getBeanDefinitionBuilder(ParserContext parserContext) {
        try {
            return BeanDefinitionBuilder.rootBeanDefinition(CreateEventMessageProcessor.class.getName());
        } catch (NoClassDefFoundError noClassDefFoundError) {
            String muleVersion = "";
            try {
                muleVersion = MuleManifest.getProductVersion();
            } catch (Exception _x) {
                logger.error("Problem while reading mule version");
            }
            logger.error(("Cannot launch the mule app, the @Processor [create-event] within the connector [taleo] is not supported in mule "+ muleVersion));
            throw new BeanDefinitionParsingException(new Problem(("Cannot launch the mule app, the @Processor [create-event] within the connector [taleo] is not supported in mule "+ muleVersion), new Location(parserContext.getReaderContext().getResource()), null, noClassDefFoundError));
        }
    }

    public BeanDefinition parse(Element element, ParserContext parserContext) {
        BeanDefinitionBuilder builder = getBeanDefinitionBuilder(parserContext);
        builder.addConstructorArgValue("createEvent");
        builder.setScope(BeanDefinition.SCOPE_PROTOTYPE);
        if (!hasAttribute(element, "config-ref")) {
            throw new BeanDefinitionParsingException(new Problem("It seems that the config-ref for @Processor [create-event] within the connector [taleo] is null or missing. Please, fill the value with the correct global element.", new Location(parserContext.getReaderContext().getResource()), null));
        }
        parseConfigRef(element, builder);
        if (!parseObjectRefWithDefault(element, builder, "event", "event", "#[payload]")) {
            BeanDefinitionBuilder eventBuilder = BeanDefinitionBuilder.rootBeanDefinition(CalendarEventBeanExpressionHolder.class.getName());
            Element eventChildElement = DomUtils.getChildElementByTagName(element, "event");
            if (eventChildElement!= null) {
                if (hasAttribute(eventChildElement, "creationDate-ref")) {
                    if (eventChildElement.getAttribute("creationDate-ref").startsWith("#")) {
                        eventBuilder.addPropertyValue("creationDate", eventChildElement.getAttribute("creationDate-ref"));
                    } else {
                        eventBuilder.addPropertyValue("creationDate", (("#[registry:"+ eventChildElement.getAttribute("creationDate-ref"))+"]"));
                    }
                }
                if (!parseObjectRef(eventChildElement, eventBuilder, "flex-values", "flexValues")) {
                    BeanDefinitionBuilder __flexValuesBuilder = BeanDefinitionBuilder.rootBeanDefinition(ArrayOfFlexFieldBeanExpressionHolder.class.getName());
                    Element __flexValuesChildElement = DomUtils.getChildElementByTagName(eventChildElement, "flex-values");
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
                        eventBuilder.addPropertyValue("flexValues", __flexValuesBuilder.getBeanDefinition());
                    }
                }
                parseProperty(eventBuilder, eventChildElement, "id", "id");
                if (hasAttribute(eventChildElement, "lastUpdated-ref")) {
                    if (eventChildElement.getAttribute("lastUpdated-ref").startsWith("#")) {
                        eventBuilder.addPropertyValue("lastUpdated", eventChildElement.getAttribute("lastUpdated-ref"));
                    } else {
                        eventBuilder.addPropertyValue("lastUpdated", (("#[registry:"+ eventChildElement.getAttribute("lastUpdated-ref"))+"]"));
                    }
                }
                parseProperty(eventBuilder, eventChildElement, "status", "status");
                parseProperty(eventBuilder, eventChildElement, "creator", "creator");
                parseProperty(eventBuilder, eventChildElement, "description", "description");
                parseProperty(eventBuilder, eventChildElement, "duration", "duration");
                parseProperty(eventBuilder, eventChildElement, "entityId", "entityId");
                parseProperty(eventBuilder, eventChildElement, "entityType", "entityType");
                parseProperty(eventBuilder, eventChildElement, "isPrivate", "isPrivate");
                parseProperty(eventBuilder, eventChildElement, "location", "location");
                if (!parseObjectRef(eventChildElement, eventBuilder, "participants", "participants")) {
                    BeanDefinitionBuilder _participantsBuilder = BeanDefinitionBuilder.rootBeanDefinition(ArrayOfParticipantBeanExpressionHolder.class.getName());
                    Element _participantsChildElement = DomUtils.getChildElementByTagName(eventChildElement, "participants");
                    if (_participantsChildElement!= null) {
                        parseListAndSetProperty(_participantsChildElement, _participantsBuilder, "item", "item", "item", new ParseDelegate<BeanDefinition>() {


                            public BeanDefinition parse(Element element) {
                                BeanDefinitionBuilder builder = BeanDefinitionBuilder.rootBeanDefinition(ParticipantBeanExpressionHolder.class);
                                if (hasAttribute(element, "endDate-ref")) {
                                    if (element.getAttribute("endDate-ref").startsWith("#")) {
                                        builder.addPropertyValue("endDate", element.getAttribute("endDate-ref"));
                                    } else {
                                        builder.addPropertyValue("endDate", (("#[registry:"+ element.getAttribute("endDate-ref"))+"]"));
                                    }
                                }
                                parseProperty(builder, element, "eventId", "eventId");
                                parseProperty(builder, element, "eventType", "eventType");
                                parseProperty(builder, element, "personId", "personId");
                                parseProperty(builder, element, "personType", "personType");
                                if (hasAttribute(element, "startDate-ref")) {
                                    if (element.getAttribute("startDate-ref").startsWith("#")) {
                                        builder.addPropertyValue("startDate", element.getAttribute("startDate-ref"));
                                    } else {
                                        builder.addPropertyValue("startDate", (("#[registry:"+ element.getAttribute("startDate-ref"))+"]"));
                                    }
                                }
                                return builder.getBeanDefinition();
                            }

                        }
                        );
                        eventBuilder.addPropertyValue("participants", _participantsBuilder.getBeanDefinition());
                    }
                }
                if (hasAttribute(eventChildElement, "startDate-ref")) {
                    if (eventChildElement.getAttribute("startDate-ref").startsWith("#")) {
                        eventBuilder.addPropertyValue("startDate", eventChildElement.getAttribute("startDate-ref"));
                    } else {
                        eventBuilder.addPropertyValue("startDate", (("#[registry:"+ eventChildElement.getAttribute("startDate-ref"))+"]"));
                    }
                }
                parseProperty(eventBuilder, eventChildElement, "subject", "subject");
                builder.addPropertyValue("event", eventBuilder.getBeanDefinition());
            }
        }
        BeanDefinition definition = builder.getBeanDefinition();
        setNoRecurseOnDefinition(definition);
        attachProcessorDefinition(parserContext, definition);
        return definition;
    }

}
