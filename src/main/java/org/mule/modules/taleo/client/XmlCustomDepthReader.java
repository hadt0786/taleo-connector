/**
 * (c) 2003-2012 MuleSoft, Inc. This software is protected under international
 * copyright law. All use of this software is subject to MuleSoft's Master
 * Subscription Agreement (or other Terms of Service) separately entered
 * into between you and MuleSoft. If such an agreement is not in
 * place, you may not use the software.
 */

package org.mule.modules.taleo.client;

import javax.xml.namespace.QName;
import javax.xml.stream.XMLStreamReader;

import org.apache.cxf.staxutils.DepthXMLStreamReader;

/**
 * Taleo is not making RPC/Literal compliant responses, we where forced to add custom handling for some namespaces at certains levels
 * to avoid unmarshalling errors
 * @author pablocabrera
 *
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
