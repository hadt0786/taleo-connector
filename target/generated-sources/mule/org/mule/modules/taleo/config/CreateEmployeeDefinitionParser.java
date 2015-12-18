
package org.mule.modules.taleo.config;

import javax.annotation.Generated;
import org.mule.config.MuleManifest;
import org.mule.modules.taleo.model.holders.ArrayOfFlexFieldBeanExpressionHolder;
import org.mule.modules.taleo.model.holders.EmployeeBeanExpressionHolder;
import org.mule.modules.taleo.model.holders.FlexFieldBeanExpressionHolder;
import org.mule.modules.taleo.model.holders.MapExpressionHolder;
import org.mule.modules.taleo.model.holders.MapItemExpressionHolder;
import org.mule.modules.taleo.processors.CreateEmployeeMessageProcessor;
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
public class CreateEmployeeDefinitionParser
    extends AbstractDevkitBasedDefinitionParser
{

    private static Logger logger = LoggerFactory.getLogger(CreateEmployeeDefinitionParser.class);

    private BeanDefinitionBuilder getBeanDefinitionBuilder(ParserContext parserContext) {
        try {
            return BeanDefinitionBuilder.rootBeanDefinition(CreateEmployeeMessageProcessor.class.getName());
        } catch (NoClassDefFoundError noClassDefFoundError) {
            String muleVersion = "";
            try {
                muleVersion = MuleManifest.getProductVersion();
            } catch (Exception _x) {
                logger.error("Problem while reading mule version");
            }
            logger.error(("Cannot launch the mule app, the @Processor [create-employee] within the connector [taleo] is not supported in mule "+ muleVersion));
            throw new BeanDefinitionParsingException(new Problem(("Cannot launch the mule app, the @Processor [create-employee] within the connector [taleo] is not supported in mule "+ muleVersion), new Location(parserContext.getReaderContext().getResource()), null, noClassDefFoundError));
        }
    }

    public BeanDefinition parse(Element element, ParserContext parserContext) {
        BeanDefinitionBuilder builder = getBeanDefinitionBuilder(parserContext);
        builder.addConstructorArgValue("createEmployee");
        builder.setScope(BeanDefinition.SCOPE_PROTOTYPE);
        if (!hasAttribute(element, "config-ref")) {
            throw new BeanDefinitionParsingException(new Problem("It seems that the config-ref for @Processor [create-employee] within the connector [taleo] is null or missing. Please, fill the value with the correct global element.", new Location(parserContext.getReaderContext().getResource()), null));
        }
        parseConfigRef(element, builder);
        if (!parseObjectRefWithDefault(element, builder, "employee", "employee", "#[payload]")) {
            BeanDefinitionBuilder employeeBuilder = BeanDefinitionBuilder.rootBeanDefinition(EmployeeBeanExpressionHolder.class.getName());
            Element employeeChildElement = DomUtils.getChildElementByTagName(element, "employee");
            if (employeeChildElement!= null) {
                parseProperty(employeeBuilder, employeeChildElement, "city", "city");
                parseProperty(employeeBuilder, employeeChildElement, "address", "address");
                parseProperty(employeeBuilder, employeeChildElement, "zipCode", "zipCode");
                parseProperty(employeeBuilder, employeeChildElement, "state", "state");
                parseProperty(employeeBuilder, employeeChildElement, "country", "country");
                parseProperty(employeeBuilder, employeeChildElement, "phone", "phone");
                if (hasAttribute(employeeChildElement, "creationDate-ref")) {
                    if (employeeChildElement.getAttribute("creationDate-ref").startsWith("#")) {
                        employeeBuilder.addPropertyValue("creationDate", employeeChildElement.getAttribute("creationDate-ref"));
                    } else {
                        employeeBuilder.addPropertyValue("creationDate", (("#[registry:"+ employeeChildElement.getAttribute("creationDate-ref"))+"]"));
                    }
                }
                if (!parseObjectRef(employeeChildElement, employeeBuilder, "flex-values", "flexValues")) {
                    BeanDefinitionBuilder ___flexValuesBuilder = BeanDefinitionBuilder.rootBeanDefinition(ArrayOfFlexFieldBeanExpressionHolder.class.getName());
                    Element ___flexValuesChildElement = DomUtils.getChildElementByTagName(employeeChildElement, "flex-values");
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
                        employeeBuilder.addPropertyValue("flexValues", ___flexValuesBuilder.getBeanDefinition());
                    }
                }
                parseProperty(employeeBuilder, employeeChildElement, "id", "id");
                if (hasAttribute(employeeChildElement, "lastUpdated-ref")) {
                    if (employeeChildElement.getAttribute("lastUpdated-ref").startsWith("#")) {
                        employeeBuilder.addPropertyValue("lastUpdated", employeeChildElement.getAttribute("lastUpdated-ref"));
                    } else {
                        employeeBuilder.addPropertyValue("lastUpdated", (("#[registry:"+ employeeChildElement.getAttribute("lastUpdated-ref"))+"]"));
                    }
                }
                parseProperty(employeeBuilder, employeeChildElement, "status", "status");
                parseProperty(employeeBuilder, employeeChildElement, "employeeNumber", "employeeNumber");
                parseProperty(employeeBuilder, employeeChildElement, "email", "email");
                parseProperty(employeeBuilder, employeeChildElement, "firstName", "firstName");
                parseProperty(employeeBuilder, employeeChildElement, "middleInitial", "middleInitial");
                parseProperty(employeeBuilder, employeeChildElement, "lastName", "lastName");
                parseProperty(employeeBuilder, employeeChildElement, "cellPhone", "cellPhone");
                parseProperty(employeeBuilder, employeeChildElement, "title", "title");
                if (hasAttribute(employeeChildElement, "hiredDate-ref")) {
                    if (employeeChildElement.getAttribute("hiredDate-ref").startsWith("#")) {
                        employeeBuilder.addPropertyValue("hiredDate", employeeChildElement.getAttribute("hiredDate-ref"));
                    } else {
                        employeeBuilder.addPropertyValue("hiredDate", (("#[registry:"+ employeeChildElement.getAttribute("hiredDate-ref"))+"]"));
                    }
                }
                if (hasAttribute(employeeChildElement, "startDate-ref")) {
                    if (employeeChildElement.getAttribute("startDate-ref").startsWith("#")) {
                        employeeBuilder.addPropertyValue("startDate", employeeChildElement.getAttribute("startDate-ref"));
                    } else {
                        employeeBuilder.addPropertyValue("startDate", (("#[registry:"+ employeeChildElement.getAttribute("startDate-ref"))+"]"));
                    }
                }
                parseProperty(employeeBuilder, employeeChildElement, "race", "race");
                parseProperty(employeeBuilder, employeeChildElement, "gender", "gender");
                parseProperty(employeeBuilder, employeeChildElement, "lockedFromEws", "lockedFromEws");
                parseProperty(employeeBuilder, employeeChildElement, "reviewManagerId", "reviewManagerId");
                parseProperty(employeeBuilder, employeeChildElement, "departmentId", "departmentId");
                parseProperty(employeeBuilder, employeeChildElement, "hierarchyPath", "hierarchyPath");
                parseProperty(employeeBuilder, employeeChildElement, "managerId", "managerId");
                parseProperty(employeeBuilder, employeeChildElement, "locationId", "locationId");
                parseProperty(employeeBuilder, employeeChildElement, "ewsLogin", "ewsLogin");
                parseProperty(employeeBuilder, employeeChildElement, "ewsPassword", "ewsPassword");
                parseProperty(employeeBuilder, employeeChildElement, "jobTitle", "jobTitle");
                parseProperty(employeeBuilder, employeeChildElement, "jobCode", "jobCode");
                parseProperty(employeeBuilder, employeeChildElement, "salaryGrade", "salaryGrade");
                parseProperty(employeeBuilder, employeeChildElement, "salary", "salary");
                parseProperty(employeeBuilder, employeeChildElement, "payFrequency", "payFrequency");
                parseProperty(employeeBuilder, employeeChildElement, "changePswdOnEwsLogin", "changePswdOnEwsLogin");
                if (!parseObjectRef(employeeChildElement, employeeBuilder, "additional-entities", "additionalEntities")) {
                    BeanDefinitionBuilder _additionalEntitiesBuilder = BeanDefinitionBuilder.rootBeanDefinition(MapExpressionHolder.class.getName());
                    Element _additionalEntitiesChildElement = DomUtils.getChildElementByTagName(employeeChildElement, "additional-entities");
                    if (_additionalEntitiesChildElement!= null) {
                        parseListAndSetProperty(_additionalEntitiesChildElement, _additionalEntitiesBuilder, "item", "item", "item", new ParseDelegate<BeanDefinition>() {


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
                        employeeBuilder.addPropertyValue("additionalEntities", _additionalEntitiesBuilder.getBeanDefinition());
                    }
                }
                builder.addPropertyValue("employee", employeeBuilder.getBeanDefinition());
            }
        }
        BeanDefinition definition = builder.getBeanDefinition();
        setNoRecurseOnDefinition(definition);
        attachProcessorDefinition(parserContext, definition);
        return definition;
    }

}
