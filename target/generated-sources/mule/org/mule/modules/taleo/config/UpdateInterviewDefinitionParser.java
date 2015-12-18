
package org.mule.modules.taleo.config;

import javax.annotation.Generated;
import org.mule.config.MuleManifest;
import org.mule.modules.taleo.model.holders.ArrayOfFlexFieldBeanExpressionHolder;
import org.mule.modules.taleo.model.holders.ArrayOfParticipantBeanExpressionHolder;
import org.mule.modules.taleo.model.holders.FlexFieldBeanExpressionHolder;
import org.mule.modules.taleo.model.holders.InterviewBeanExpressionHolder;
import org.mule.modules.taleo.model.holders.ParticipantBeanExpressionHolder;
import org.mule.modules.taleo.processors.UpdateInterviewMessageProcessor;
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
public class UpdateInterviewDefinitionParser
    extends AbstractDevkitBasedDefinitionParser
{

    private static Logger logger = LoggerFactory.getLogger(UpdateInterviewDefinitionParser.class);

    private BeanDefinitionBuilder getBeanDefinitionBuilder(ParserContext parserContext) {
        try {
            return BeanDefinitionBuilder.rootBeanDefinition(UpdateInterviewMessageProcessor.class.getName());
        } catch (NoClassDefFoundError noClassDefFoundError) {
            String muleVersion = "";
            try {
                muleVersion = MuleManifest.getProductVersion();
            } catch (Exception _x) {
                logger.error("Problem while reading mule version");
            }
            logger.error(("Cannot launch the mule app, the @Processor [update-interview] within the connector [taleo] is not supported in mule "+ muleVersion));
            throw new BeanDefinitionParsingException(new Problem(("Cannot launch the mule app, the @Processor [update-interview] within the connector [taleo] is not supported in mule "+ muleVersion), new Location(parserContext.getReaderContext().getResource()), null, noClassDefFoundError));
        }
    }

    public BeanDefinition parse(Element element, ParserContext parserContext) {
        BeanDefinitionBuilder builder = getBeanDefinitionBuilder(parserContext);
        builder.addConstructorArgValue("updateInterview");
        builder.setScope(BeanDefinition.SCOPE_PROTOTYPE);
        if (!hasAttribute(element, "config-ref")) {
            throw new BeanDefinitionParsingException(new Problem("It seems that the config-ref for @Processor [update-interview] within the connector [taleo] is null or missing. Please, fill the value with the correct global element.", new Location(parserContext.getReaderContext().getResource()), null));
        }
        parseConfigRef(element, builder);
        if (!parseObjectRefWithDefault(element, builder, "interview", "interview", "#[payload]")) {
            BeanDefinitionBuilder interviewBuilder = BeanDefinitionBuilder.rootBeanDefinition(InterviewBeanExpressionHolder.class.getName());
            Element interviewChildElement = DomUtils.getChildElementByTagName(element, "interview");
            if (interviewChildElement!= null) {
                if (hasAttribute(interviewChildElement, "creationDate-ref")) {
                    if (interviewChildElement.getAttribute("creationDate-ref").startsWith("#")) {
                        interviewBuilder.addPropertyValue("creationDate", interviewChildElement.getAttribute("creationDate-ref"));
                    } else {
                        interviewBuilder.addPropertyValue("creationDate", (("#[registry:"+ interviewChildElement.getAttribute("creationDate-ref"))+"]"));
                    }
                }
                if (!parseObjectRef(interviewChildElement, interviewBuilder, "flex-values", "flexValues")) {
                    BeanDefinitionBuilder __flexValuesBuilder = BeanDefinitionBuilder.rootBeanDefinition(ArrayOfFlexFieldBeanExpressionHolder.class.getName());
                    Element __flexValuesChildElement = DomUtils.getChildElementByTagName(interviewChildElement, "flex-values");
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
                        interviewBuilder.addPropertyValue("flexValues", __flexValuesBuilder.getBeanDefinition());
                    }
                }
                parseProperty(interviewBuilder, interviewChildElement, "id", "id");
                if (hasAttribute(interviewChildElement, "lastUpdated-ref")) {
                    if (interviewChildElement.getAttribute("lastUpdated-ref").startsWith("#")) {
                        interviewBuilder.addPropertyValue("lastUpdated", interviewChildElement.getAttribute("lastUpdated-ref"));
                    } else {
                        interviewBuilder.addPropertyValue("lastUpdated", (("#[registry:"+ interviewChildElement.getAttribute("lastUpdated-ref"))+"]"));
                    }
                }
                parseProperty(interviewBuilder, interviewChildElement, "status", "status");
                parseProperty(interviewBuilder, interviewChildElement, "candidateId", "candidateId");
                parseProperty(interviewBuilder, interviewChildElement, "comments", "comments");
                parseProperty(interviewBuilder, interviewChildElement, "creator", "creator");
                parseProperty(interviewBuilder, interviewChildElement, "interviewRoom", "interviewRoom");
                parseProperty(interviewBuilder, interviewChildElement, "interviewType", "interviewType");
                if (!parseObjectRef(interviewChildElement, interviewBuilder, "participants", "participants")) {
                    BeanDefinitionBuilder _participantsBuilder = BeanDefinitionBuilder.rootBeanDefinition(ArrayOfParticipantBeanExpressionHolder.class.getName());
                    Element _participantsChildElement = DomUtils.getChildElementByTagName(interviewChildElement, "participants");
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
                        interviewBuilder.addPropertyValue("participants", _participantsBuilder.getBeanDefinition());
                    }
                }
                parseProperty(interviewBuilder, interviewChildElement, "requisitionId", "requisitionId");
                if (hasAttribute(interviewChildElement, "startDate-ref")) {
                    if (interviewChildElement.getAttribute("startDate-ref").startsWith("#")) {
                        interviewBuilder.addPropertyValue("startDate", interviewChildElement.getAttribute("startDate-ref"));
                    } else {
                        interviewBuilder.addPropertyValue("startDate", (("#[registry:"+ interviewChildElement.getAttribute("startDate-ref"))+"]"));
                    }
                }
                builder.addPropertyValue("interview", interviewBuilder.getBeanDefinition());
            }
        }
        BeanDefinition definition = builder.getBeanDefinition();
        setNoRecurseOnDefinition(definition);
        attachProcessorDefinition(parserContext, definition);
        return definition;
    }

}
