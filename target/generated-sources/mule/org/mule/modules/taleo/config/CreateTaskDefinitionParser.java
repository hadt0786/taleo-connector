
package org.mule.modules.taleo.config;

import javax.annotation.Generated;
import org.mule.config.MuleManifest;
import org.mule.modules.taleo.model.holders.ArrayOfFlexFieldBeanExpressionHolder;
import org.mule.modules.taleo.model.holders.ArrayOfParticipantBeanExpressionHolder;
import org.mule.modules.taleo.model.holders.FlexFieldBeanExpressionHolder;
import org.mule.modules.taleo.model.holders.ParticipantBeanExpressionHolder;
import org.mule.modules.taleo.model.holders.TaskBeanExpressionHolder;
import org.mule.modules.taleo.processors.CreateTaskMessageProcessor;
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
public class CreateTaskDefinitionParser
    extends AbstractDevkitBasedDefinitionParser
{

    private static Logger logger = LoggerFactory.getLogger(CreateTaskDefinitionParser.class);

    private BeanDefinitionBuilder getBeanDefinitionBuilder(ParserContext parserContext) {
        try {
            return BeanDefinitionBuilder.rootBeanDefinition(CreateTaskMessageProcessor.class.getName());
        } catch (NoClassDefFoundError noClassDefFoundError) {
            String muleVersion = "";
            try {
                muleVersion = MuleManifest.getProductVersion();
            } catch (Exception _x) {
                logger.error("Problem while reading mule version");
            }
            logger.error(("Cannot launch the mule app, the @Processor [create-task] within the connector [taleo] is not supported in mule "+ muleVersion));
            throw new BeanDefinitionParsingException(new Problem(("Cannot launch the mule app, the @Processor [create-task] within the connector [taleo] is not supported in mule "+ muleVersion), new Location(parserContext.getReaderContext().getResource()), null, noClassDefFoundError));
        }
    }

    public BeanDefinition parse(Element element, ParserContext parserContext) {
        BeanDefinitionBuilder builder = getBeanDefinitionBuilder(parserContext);
        builder.addConstructorArgValue("createTask");
        builder.setScope(BeanDefinition.SCOPE_PROTOTYPE);
        if (!hasAttribute(element, "config-ref")) {
            throw new BeanDefinitionParsingException(new Problem("It seems that the config-ref for @Processor [create-task] within the connector [taleo] is null or missing. Please, fill the value with the correct global element.", new Location(parserContext.getReaderContext().getResource()), null));
        }
        parseConfigRef(element, builder);
        if (!parseObjectRefWithDefault(element, builder, "task", "task", "#[payload]")) {
            BeanDefinitionBuilder taskBuilder = BeanDefinitionBuilder.rootBeanDefinition(TaskBeanExpressionHolder.class.getName());
            Element taskChildElement = DomUtils.getChildElementByTagName(element, "task");
            if (taskChildElement!= null) {
                if (hasAttribute(taskChildElement, "creationDate-ref")) {
                    if (taskChildElement.getAttribute("creationDate-ref").startsWith("#")) {
                        taskBuilder.addPropertyValue("creationDate", taskChildElement.getAttribute("creationDate-ref"));
                    } else {
                        taskBuilder.addPropertyValue("creationDate", (("#[registry:"+ taskChildElement.getAttribute("creationDate-ref"))+"]"));
                    }
                }
                if (!parseObjectRef(taskChildElement, taskBuilder, "flex-values", "flexValues")) {
                    BeanDefinitionBuilder __flexValuesBuilder = BeanDefinitionBuilder.rootBeanDefinition(ArrayOfFlexFieldBeanExpressionHolder.class.getName());
                    Element __flexValuesChildElement = DomUtils.getChildElementByTagName(taskChildElement, "flex-values");
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
                        taskBuilder.addPropertyValue("flexValues", __flexValuesBuilder.getBeanDefinition());
                    }
                }
                parseProperty(taskBuilder, taskChildElement, "id", "id");
                if (hasAttribute(taskChildElement, "lastUpdated-ref")) {
                    if (taskChildElement.getAttribute("lastUpdated-ref").startsWith("#")) {
                        taskBuilder.addPropertyValue("lastUpdated", taskChildElement.getAttribute("lastUpdated-ref"));
                    } else {
                        taskBuilder.addPropertyValue("lastUpdated", (("#[registry:"+ taskChildElement.getAttribute("lastUpdated-ref"))+"]"));
                    }
                }
                parseProperty(taskBuilder, taskChildElement, "status", "status");
                if (!parseObjectRef(taskChildElement, taskBuilder, "assigned-to", "assignedTo")) {
                    BeanDefinitionBuilder _assignedToBuilder = BeanDefinitionBuilder.rootBeanDefinition(ArrayOfParticipantBeanExpressionHolder.class.getName());
                    Element _assignedToChildElement = DomUtils.getChildElementByTagName(taskChildElement, "assigned-to");
                    if (_assignedToChildElement!= null) {
                        parseListAndSetProperty(_assignedToChildElement, _assignedToBuilder, "item", "item", "item", new ParseDelegate<BeanDefinition>() {


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
                        taskBuilder.addPropertyValue("assignedTo", _assignedToBuilder.getBeanDefinition());
                    }
                }
                parseProperty(taskBuilder, taskChildElement, "creator", "creator");
                parseProperty(taskBuilder, taskChildElement, "description", "description");
                if (hasAttribute(taskChildElement, "dueDate-ref")) {
                    if (taskChildElement.getAttribute("dueDate-ref").startsWith("#")) {
                        taskBuilder.addPropertyValue("dueDate", taskChildElement.getAttribute("dueDate-ref"));
                    } else {
                        taskBuilder.addPropertyValue("dueDate", (("#[registry:"+ taskChildElement.getAttribute("dueDate-ref"))+"]"));
                    }
                }
                parseProperty(taskBuilder, taskChildElement, "entityId", "entityId");
                parseProperty(taskBuilder, taskChildElement, "entityType", "entityType");
                parseProperty(taskBuilder, taskChildElement, "priority", "priority");
                parseProperty(taskBuilder, taskChildElement, "subject", "subject");
                builder.addPropertyValue("task", taskBuilder.getBeanDefinition());
            }
        }
        BeanDefinition definition = builder.getBeanDefinition();
        setNoRecurseOnDefinition(definition);
        attachProcessorDefinition(parserContext, definition);
        return definition;
    }

}
