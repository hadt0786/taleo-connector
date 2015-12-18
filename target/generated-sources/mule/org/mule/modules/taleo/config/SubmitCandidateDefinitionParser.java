
package org.mule.modules.taleo.config;

import javax.annotation.Generated;
import org.mule.config.MuleManifest;
import org.mule.modules.taleo.model.holders.ArrayOfXsdLongExpressionHolder;
import org.mule.modules.taleo.model.holders.LongArrExpressionHolder;
import org.mule.modules.taleo.processors.SubmitCandidateMessageProcessor;
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
public class SubmitCandidateDefinitionParser
    extends AbstractDevkitBasedDefinitionParser
{

    private static Logger logger = LoggerFactory.getLogger(SubmitCandidateDefinitionParser.class);

    private BeanDefinitionBuilder getBeanDefinitionBuilder(ParserContext parserContext) {
        try {
            return BeanDefinitionBuilder.rootBeanDefinition(SubmitCandidateMessageProcessor.class.getName());
        } catch (NoClassDefFoundError noClassDefFoundError) {
            String muleVersion = "";
            try {
                muleVersion = MuleManifest.getProductVersion();
            } catch (Exception _x) {
                logger.error("Problem while reading mule version");
            }
            logger.error(("Cannot launch the mule app, the @Processor [submit-candidate] within the connector [taleo] is not supported in mule "+ muleVersion));
            throw new BeanDefinitionParsingException(new Problem(("Cannot launch the mule app, the @Processor [submit-candidate] within the connector [taleo] is not supported in mule "+ muleVersion), new Location(parserContext.getReaderContext().getResource()), null, noClassDefFoundError));
        }
    }

    public BeanDefinition parse(Element element, ParserContext parserContext) {
        BeanDefinitionBuilder builder = getBeanDefinitionBuilder(parserContext);
        builder.addConstructorArgValue("submitCandidate");
        builder.setScope(BeanDefinition.SCOPE_PROTOTYPE);
        if (!hasAttribute(element, "config-ref")) {
            throw new BeanDefinitionParsingException(new Problem("It seems that the config-ref for @Processor [submit-candidate] within the connector [taleo] is null or missing. Please, fill the value with the correct global element.", new Location(parserContext.getReaderContext().getResource()), null));
        }
        parseConfigRef(element, builder);
        parseProperty(builder, element, "candidateId", "candidateId");
        if (!parseObjectRef(element, builder, "requisition-ids", "requisitionIds")) {
            BeanDefinitionBuilder requisitionIdsBuilder = BeanDefinitionBuilder.rootBeanDefinition(LongArrExpressionHolder.class.getName());
            Element requisitionIdsChildElement = DomUtils.getChildElementByTagName(element, "requisition-ids");
            if (requisitionIdsChildElement!= null) {
                if (!parseObjectRef(requisitionIdsChildElement, requisitionIdsBuilder, "array", "array")) {
                    BeanDefinitionBuilder _arrayBuilder = BeanDefinitionBuilder.rootBeanDefinition(ArrayOfXsdLongExpressionHolder.class.getName());
                    Element _arrayChildElement = DomUtils.getChildElementByTagName(requisitionIdsChildElement, "array");
                    if (_arrayChildElement!= null) {
                        parseListAndSetProperty(_arrayChildElement, _arrayBuilder, "item", "item", "item", new ParseDelegate<String>() {


                            public String parse(Element element) {
                                return element.getTextContent();
                            }

                        }
                        );
                        requisitionIdsBuilder.addPropertyValue("array", _arrayBuilder.getBeanDefinition());
                    }
                }
                builder.addPropertyValue("requisitionIds", requisitionIdsBuilder.getBeanDefinition());
            }
        }
        BeanDefinition definition = builder.getBeanDefinition();
        setNoRecurseOnDefinition(definition);
        attachProcessorDefinition(parserContext, definition);
        return definition;
    }

}
