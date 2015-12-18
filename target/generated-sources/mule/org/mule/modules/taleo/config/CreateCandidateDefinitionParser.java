
package org.mule.modules.taleo.config;

import javax.annotation.Generated;
import org.mule.config.MuleManifest;
import org.mule.modules.taleo.model.holders.ArrayOfFlexFieldBeanExpressionHolder;
import org.mule.modules.taleo.model.holders.CandidateBeanExpressionHolder;
import org.mule.modules.taleo.model.holders.FlexFieldBeanExpressionHolder;
import org.mule.modules.taleo.processors.CreateCandidateMessageProcessor;
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
public class CreateCandidateDefinitionParser
    extends AbstractDevkitBasedDefinitionParser
{

    private static Logger logger = LoggerFactory.getLogger(CreateCandidateDefinitionParser.class);

    private BeanDefinitionBuilder getBeanDefinitionBuilder(ParserContext parserContext) {
        try {
            return BeanDefinitionBuilder.rootBeanDefinition(CreateCandidateMessageProcessor.class.getName());
        } catch (NoClassDefFoundError noClassDefFoundError) {
            String muleVersion = "";
            try {
                muleVersion = MuleManifest.getProductVersion();
            } catch (Exception _x) {
                logger.error("Problem while reading mule version");
            }
            logger.error(("Cannot launch the mule app, the @Processor [create-candidate] within the connector [taleo] is not supported in mule "+ muleVersion));
            throw new BeanDefinitionParsingException(new Problem(("Cannot launch the mule app, the @Processor [create-candidate] within the connector [taleo] is not supported in mule "+ muleVersion), new Location(parserContext.getReaderContext().getResource()), null, noClassDefFoundError));
        }
    }

    public BeanDefinition parse(Element element, ParserContext parserContext) {
        BeanDefinitionBuilder builder = getBeanDefinitionBuilder(parserContext);
        builder.addConstructorArgValue("createCandidate");
        builder.setScope(BeanDefinition.SCOPE_PROTOTYPE);
        if (!hasAttribute(element, "config-ref")) {
            throw new BeanDefinitionParsingException(new Problem("It seems that the config-ref for @Processor [create-candidate] within the connector [taleo] is null or missing. Please, fill the value with the correct global element.", new Location(parserContext.getReaderContext().getResource()), null));
        }
        parseConfigRef(element, builder);
        if (!parseObjectRefWithDefault(element, builder, "candidate", "candidate", "#[payload]")) {
            BeanDefinitionBuilder candidateBuilder = BeanDefinitionBuilder.rootBeanDefinition(CandidateBeanExpressionHolder.class.getName());
            Element candidateChildElement = DomUtils.getChildElementByTagName(element, "candidate");
            if (candidateChildElement!= null) {
                if (hasAttribute(candidateChildElement, "creationDate-ref")) {
                    if (candidateChildElement.getAttribute("creationDate-ref").startsWith("#")) {
                        candidateBuilder.addPropertyValue("creationDate", candidateChildElement.getAttribute("creationDate-ref"));
                    } else {
                        candidateBuilder.addPropertyValue("creationDate", (("#[registry:"+ candidateChildElement.getAttribute("creationDate-ref"))+"]"));
                    }
                }
                if (!parseObjectRef(candidateChildElement, candidateBuilder, "flex-values", "flexValues")) {
                    BeanDefinitionBuilder __flexValuesBuilder = BeanDefinitionBuilder.rootBeanDefinition(ArrayOfFlexFieldBeanExpressionHolder.class.getName());
                    Element __flexValuesChildElement = DomUtils.getChildElementByTagName(candidateChildElement, "flex-values");
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
                        candidateBuilder.addPropertyValue("flexValues", __flexValuesBuilder.getBeanDefinition());
                    }
                }
                parseProperty(candidateBuilder, candidateChildElement, "id", "id");
                if (hasAttribute(candidateChildElement, "lastUpdated-ref")) {
                    if (candidateChildElement.getAttribute("lastUpdated-ref").startsWith("#")) {
                        candidateBuilder.addPropertyValue("lastUpdated", candidateChildElement.getAttribute("lastUpdated-ref"));
                    } else {
                        candidateBuilder.addPropertyValue("lastUpdated", (("#[registry:"+ candidateChildElement.getAttribute("lastUpdated-ref"))+"]"));
                    }
                }
                parseProperty(candidateBuilder, candidateChildElement, "status", "status");
                parseProperty(candidateBuilder, candidateChildElement, "address", "address");
                parseProperty(candidateBuilder, candidateChildElement, "cellPhone", "cellPhone");
                parseProperty(candidateBuilder, candidateChildElement, "city", "city");
                parseProperty(candidateBuilder, candidateChildElement, "country", "country");
                parseProperty(candidateBuilder, candidateChildElement, "email", "email");
                parseProperty(candidateBuilder, candidateChildElement, "firstName", "firstName");
                parseProperty(candidateBuilder, candidateChildElement, "gender", "gender");
                if (hasAttribute(candidateChildElement, "hiredDate-ref")) {
                    if (candidateChildElement.getAttribute("hiredDate-ref").startsWith("#")) {
                        candidateBuilder.addPropertyValue("hiredDate", candidateChildElement.getAttribute("hiredDate-ref"));
                    } else {
                        candidateBuilder.addPropertyValue("hiredDate", (("#[registry:"+ candidateChildElement.getAttribute("hiredDate-ref"))+"]"));
                    }
                }
                parseProperty(candidateBuilder, candidateChildElement, "lastName", "lastName");
                parseProperty(candidateBuilder, candidateChildElement, "legalStatus", "legalStatus");
                parseProperty(candidateBuilder, candidateChildElement, "middleInitial", "middleInitial");
                parseProperty(candidateBuilder, candidateChildElement, "password", "password");
                parseProperty(candidateBuilder, candidateChildElement, "phone", "phone");
                parseProperty(candidateBuilder, candidateChildElement, "race", "race");
                parseProperty(candidateBuilder, candidateChildElement, "rank", "rank");
                parseProperty(candidateBuilder, candidateChildElement, "reasonRejected", "reasonRejected");
                parseProperty(candidateBuilder, candidateChildElement, "referredBy", "referredBy");
                parseProperty(candidateBuilder, candidateChildElement, "resumeFileName", "resumeFileName");
                parseProperty(candidateBuilder, candidateChildElement, "source", "source");
                if (hasAttribute(candidateChildElement, "startDate-ref")) {
                    if (candidateChildElement.getAttribute("startDate-ref").startsWith("#")) {
                        candidateBuilder.addPropertyValue("startDate", candidateChildElement.getAttribute("startDate-ref"));
                    } else {
                        candidateBuilder.addPropertyValue("startDate", (("#[registry:"+ candidateChildElement.getAttribute("startDate-ref"))+"]"));
                    }
                }
                parseProperty(candidateBuilder, candidateChildElement, "state", "state");
                parseProperty(candidateBuilder, candidateChildElement, "submittedBy", "submittedBy");
                parseProperty(candidateBuilder, candidateChildElement, "textResume", "textResume");
                parseProperty(candidateBuilder, candidateChildElement, "veteran", "veteran");
                parseProperty(candidateBuilder, candidateChildElement, "zipCode", "zipCode");
                builder.addPropertyValue("candidate", candidateBuilder.getBeanDefinition());
            }
        }
        BeanDefinition definition = builder.getBeanDefinition();
        setNoRecurseOnDefinition(definition);
        attachProcessorDefinition(parserContext, definition);
        return definition;
    }

}
