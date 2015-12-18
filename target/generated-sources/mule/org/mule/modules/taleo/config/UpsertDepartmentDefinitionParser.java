
package org.mule.modules.taleo.config;

import javax.annotation.Generated;
import org.mule.config.MuleManifest;
import org.mule.modules.taleo.model.holders.ArrayOfXsdLongExpressionHolder;
import org.mule.modules.taleo.model.holders.DepartmentBeanExpressionHolder;
import org.mule.modules.taleo.model.holders.MapExpressionHolder;
import org.mule.modules.taleo.model.holders.MapItemExpressionHolder;
import org.mule.modules.taleo.processors.UpsertDepartmentMessageProcessor;
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
public class UpsertDepartmentDefinitionParser
    extends AbstractDevkitBasedDefinitionParser
{

    private static Logger logger = LoggerFactory.getLogger(UpsertDepartmentDefinitionParser.class);

    private BeanDefinitionBuilder getBeanDefinitionBuilder(ParserContext parserContext) {
        try {
            return BeanDefinitionBuilder.rootBeanDefinition(UpsertDepartmentMessageProcessor.class.getName());
        } catch (NoClassDefFoundError noClassDefFoundError) {
            String muleVersion = "";
            try {
                muleVersion = MuleManifest.getProductVersion();
            } catch (Exception _x) {
                logger.error("Problem while reading mule version");
            }
            logger.error(("Cannot launch the mule app, the @Processor [upsert-department] within the connector [taleo] is not supported in mule "+ muleVersion));
            throw new BeanDefinitionParsingException(new Problem(("Cannot launch the mule app, the @Processor [upsert-department] within the connector [taleo] is not supported in mule "+ muleVersion), new Location(parserContext.getReaderContext().getResource()), null, noClassDefFoundError));
        }
    }

    public BeanDefinition parse(Element element, ParserContext parserContext) {
        BeanDefinitionBuilder builder = getBeanDefinitionBuilder(parserContext);
        builder.addConstructorArgValue("upsertDepartment");
        builder.setScope(BeanDefinition.SCOPE_PROTOTYPE);
        if (!hasAttribute(element, "config-ref")) {
            throw new BeanDefinitionParsingException(new Problem("It seems that the config-ref for @Processor [upsert-department] within the connector [taleo] is null or missing. Please, fill the value with the correct global element.", new Location(parserContext.getReaderContext().getResource()), null));
        }
        parseConfigRef(element, builder);
        if (!parseObjectRefWithDefault(element, builder, "department", "department", "#[payload]")) {
            BeanDefinitionBuilder departmentBuilder = BeanDefinitionBuilder.rootBeanDefinition(DepartmentBeanExpressionHolder.class.getName());
            Element departmentChildElement = DomUtils.getChildElementByTagName(element, "department");
            if (departmentChildElement!= null) {
                if (!parseObjectRef(departmentChildElement, departmentBuilder, "additional-properties", "additionalProperties")) {
                    BeanDefinitionBuilder _additionalPropertiesBuilder = BeanDefinitionBuilder.rootBeanDefinition(MapExpressionHolder.class.getName());
                    Element _additionalPropertiesChildElement = DomUtils.getChildElementByTagName(departmentChildElement, "additional-properties");
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
                        departmentBuilder.addPropertyValue("additionalProperties", _additionalPropertiesBuilder.getBeanDefinition());
                    }
                }
                if (hasAttribute(departmentChildElement, "creationDate-ref")) {
                    if (departmentChildElement.getAttribute("creationDate-ref").startsWith("#")) {
                        departmentBuilder.addPropertyValue("creationDate", departmentChildElement.getAttribute("creationDate-ref"));
                    } else {
                        departmentBuilder.addPropertyValue("creationDate", (("#[registry:"+ departmentChildElement.getAttribute("creationDate-ref"))+"]"));
                    }
                }
                parseProperty(departmentBuilder, departmentChildElement, "departmentId", "departmentId");
                parseProperty(departmentBuilder, departmentChildElement, "departmentName", "departmentName");
                if (hasAttribute(departmentChildElement, "lastUpdated-ref")) {
                    if (departmentChildElement.getAttribute("lastUpdated-ref").startsWith("#")) {
                        departmentBuilder.addPropertyValue("lastUpdated", departmentChildElement.getAttribute("lastUpdated-ref"));
                    } else {
                        departmentBuilder.addPropertyValue("lastUpdated", (("#[registry:"+ departmentChildElement.getAttribute("lastUpdated-ref"))+"]"));
                    }
                }
                if (!parseObjectRef(departmentChildElement, departmentBuilder, "associated-users", "associatedUsers")) {
                    BeanDefinitionBuilder _associatedUsersBuilder = BeanDefinitionBuilder.rootBeanDefinition(ArrayOfXsdLongExpressionHolder.class.getName());
                    Element _associatedUsersChildElement = DomUtils.getChildElementByTagName(departmentChildElement, "associated-users");
                    if (_associatedUsersChildElement!= null) {
                        parseListAndSetProperty(_associatedUsersChildElement, _associatedUsersBuilder, "item", "item", "item", new ParseDelegate<String>() {


                            public String parse(Element element) {
                                return element.getTextContent();
                            }

                        }
                        );
                        departmentBuilder.addPropertyValue("associatedUsers", _associatedUsersBuilder.getBeanDefinition());
                    }
                }
                if (!parseObjectRef(departmentChildElement, departmentBuilder, "default-approvers", "defaultApprovers")) {
                    BeanDefinitionBuilder _defaultApproversBuilder = BeanDefinitionBuilder.rootBeanDefinition(ArrayOfXsdLongExpressionHolder.class.getName());
                    Element _defaultApproversChildElement = DomUtils.getChildElementByTagName(departmentChildElement, "default-approvers");
                    if (_defaultApproversChildElement!= null) {
                        parseListAndSetProperty(_defaultApproversChildElement, _defaultApproversBuilder, "item", "item", "item", new ParseDelegate<String>() {


                            public String parse(Element element) {
                                return element.getTextContent();
                            }

                        }
                        );
                        departmentBuilder.addPropertyValue("defaultApprovers", _defaultApproversBuilder.getBeanDefinition());
                    }
                }
                builder.addPropertyValue("department", departmentBuilder.getBeanDefinition());
            }
        }
        BeanDefinition definition = builder.getBeanDefinition();
        setNoRecurseOnDefinition(definition);
        attachProcessorDefinition(parserContext, definition);
        return definition;
    }

}
