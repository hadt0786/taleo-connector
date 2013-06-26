/**
 * Mule Taleo Cloud Connector
 *
 * Copyright (c) MuleSoft, Inc. All rights reserved. http://www.mulesoft.com
 *
 */
package org.mule.modules.taleo.client;

import java.io.InputStream;

import javax.xml.stream.XMLStreamReader;

import org.apache.cxf.binding.soap.SoapMessage;
import org.apache.cxf.binding.soap.interceptor.AbstractSoapInterceptor;
import org.apache.cxf.binding.soap.interceptor.ReadHeadersInterceptor;
import org.apache.cxf.interceptor.Fault;
import org.apache.cxf.phase.Phase;
import org.apache.cxf.staxutils.StaxUtils;

public class CustomMessageReaderInterceptor extends AbstractSoapInterceptor {

	public CustomMessageReaderInterceptor() {
		super(Phase.READ);
		addAfter(ReadHeadersInterceptor.class.getName());
	}

	public void handleMessage(SoapMessage message) throws Fault {
        XMLStreamReader xmlReader = message.getContent(XMLStreamReader.class);

        if (xmlReader == null) {
            InputStream in = (InputStream)message.getContent(InputStream.class);
            if (in == null) {
                throw new RuntimeException("Can't find input stream in message");
            }
            xmlReader = StaxUtils.createXMLStreamReader(in);
        }
        if (xmlReader != null) {
			XMLStreamReader readerCustom = new XmlCustomDepthReader(xmlReader);
			message.setContent(XMLStreamReader.class, readerCustom);
		}
	}
}