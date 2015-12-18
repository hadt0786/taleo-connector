
package org.mule.modules.taleo.config;

import javax.annotation.Generated;
import org.mule.config.MuleManifest;
import org.mule.modules.taleo.model.holders.AccountBeanExpressionHolder;
import org.mule.modules.taleo.model.holders.ArrayOfFlexFieldBeanExpressionHolder;
import org.mule.modules.taleo.model.holders.FlexFieldBeanExpressionHolder;
import org.mule.modules.taleo.processors.UpdateAccountMessageProcessor;
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
public class UpdateAccountDefinitionParser
    extends AbstractDevkitBasedDefinitionParser
{

    private static Logger logger = LoggerFactory.getLogger(UpdateAccountDefinitionParser.class);

    private BeanDefinitionBuilder getBeanDefinitionBuilder(ParserContext parserContext) {
        try {
            return BeanDefinitionBuilder.rootBeanDefinition(UpdateAccountMessageProcessor.class.getName());
        } catch (NoClassDefFoundError noClassDefFoundError) {
            String muleVersion = "";
            try {
                muleVersion = MuleManifest.getProductVersion();
            } catch (Exception _x) {
                logger.error("Problem while reading mule version");
            }
            logger.error(("Cannot launch the mule app, the @Processor [update-account] within the connector [taleo] is not supported in mule "+ muleVersion));
            throw new BeanDefinitionParsingException(new Problem(("Cannot launch the mule app, the @Processor [update-account] within the connector [taleo] is not supported in mule "+ muleVersion), new Location(parserContext.getReaderContext().getResource()), null, noClassDefFoundError));
        }
    }

    public BeanDefinition parse(Element element, ParserContext parserContext) {
        BeanDefinitionBuilder builder = getBeanDefinitionBuilder(parserContext);
        builder.addConstructorArgValue("updateAccount");
        builder.setScope(BeanDefinition.SCOPE_PROTOTYPE);
        if (!hasAttribute(element, "config-ref")) {
            throw new BeanDefinitionParsingException(new Problem("It seems that the config-ref for @Processor [update-account] within the connector [taleo] is null or missing. Please, fill the value with the correct global element.", new Location(parserContext.getReaderContext().getResource()), null));
        }
        parseConfigRef(element, builder);
        if (!parseObjectRefWithDefault(element, builder, "account", "account", "#[payload]")) {
            BeanDefinitionBuilder accountBuilder = BeanDefinitionBuilder.rootBeanDefinition(AccountBeanExpressionHolder.class.getName());
            Element accountChildElement = DomUtils.getChildElementByTagName(element, "account");
            if (accountChildElement!= null) {
                if (hasAttribute(accountChildElement, "creationDate-ref")) {
                    if (accountChildElement.getAttribute("creationDate-ref").startsWith("#")) {
                        accountBuilder.addPropertyValue("creationDate", accountChildElement.getAttribute("creationDate-ref"));
                    } else {
                        accountBuilder.addPropertyValue("creationDate", (("#[registry:"+ accountChildElement.getAttribute("creationDate-ref"))+"]"));
                    }
                }
                if (!parseObjectRef(accountChildElement, accountBuilder, "flex-values", "flexValues")) {
                    BeanDefinitionBuilder __flexValuesBuilder = BeanDefinitionBuilder.rootBeanDefinition(ArrayOfFlexFieldBeanExpressionHolder.class.getName());
                    Element __flexValuesChildElement = DomUtils.getChildElementByTagName(accountChildElement, "flex-values");
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
                        accountBuilder.addPropertyValue("flexValues", __flexValuesBuilder.getBeanDefinition());
                    }
                }
                parseProperty(accountBuilder, accountChildElement, "id", "id");
                if (hasAttribute(accountChildElement, "lastUpdated-ref")) {
                    if (accountChildElement.getAttribute("lastUpdated-ref").startsWith("#")) {
                        accountBuilder.addPropertyValue("lastUpdated", accountChildElement.getAttribute("lastUpdated-ref"));
                    } else {
                        accountBuilder.addPropertyValue("lastUpdated", (("#[registry:"+ accountChildElement.getAttribute("lastUpdated-ref"))+"]"));
                    }
                }
                parseProperty(accountBuilder, accountChildElement, "status", "status");
                parseProperty(accountBuilder, accountChildElement, "address", "address");
                parseProperty(accountBuilder, accountChildElement, "city", "city");
                parseProperty(accountBuilder, accountChildElement, "country", "country");
                parseProperty(accountBuilder, accountChildElement, "description", "description");
                parseProperty(accountBuilder, accountChildElement, "fax", "fax");
                parseProperty(accountBuilder, accountChildElement, "industry", "industry");
                parseProperty(accountBuilder, accountChildElement, "name", "name");
                parseProperty(accountBuilder, accountChildElement, "parentAccountId", "parentAccountId");
                parseProperty(accountBuilder, accountChildElement, "phone", "phone");
                parseProperty(accountBuilder, accountChildElement, "state", "state");
                parseProperty(accountBuilder, accountChildElement, "type", "type");
                parseProperty(accountBuilder, accountChildElement, "webSite", "webSite");
                parseProperty(accountBuilder, accountChildElement, "zipCode", "zipCode");
                builder.addPropertyValue("account", accountBuilder.getBeanDefinition());
            }
        }
        BeanDefinition definition = builder.getBeanDefinition();
        setNoRecurseOnDefinition(definition);
        attachProcessorDefinition(parserContext, definition);
        return definition;
    }

}
