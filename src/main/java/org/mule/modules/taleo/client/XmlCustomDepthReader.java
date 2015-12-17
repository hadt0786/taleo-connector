/**
 * (c) 2003-2015 MuleSoft, Inc. The software in this package is published under
 * the terms of the CPAL v1.0 license, a copy of which has been included with this
 * distribution in the LICENSE.md file.
 */

package org.mule.modules.taleo.client;

import org.apache.cxf.staxutils.DepthXMLStreamReader;

import javax.xml.namespace.QName;
import javax.xml.stream.XMLStreamReader;

/**
 * Taleo is not making RPC/Literal compliant responses, we where forced to add custom handling for some namespaces at certains levels
 * to avoid unmarshalling errors
 *
 * @author pablocabrera
 */
public class XmlCustomDepthReader extends DepthXMLStreamReader {

    public XmlCustomDepthReader(XMLStreamReader r) {
        super(r);
    }

    @Override
    public QName getName() {
        QName qn = super.getName();
        if (getDepth() == 2) {
            qn = new QName("", qn.getLocalPart());
        }
        return qn;
    }

    @Override
    public String getNamespaceURI() {
        String qn = super.getNamespaceURI();
        if (getDepth() == 2) {
            qn = "";
        }
        return qn;
    }

}
