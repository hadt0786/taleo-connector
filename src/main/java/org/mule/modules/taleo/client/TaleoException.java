/**
 * Mule Taleo Cloud Connector
 *
 * Copyright (c) MuleSoft, Inc. All rights reserved. http://www.mulesoft.com
 *
 */

package org.mule.modules.taleo.client;

public class TaleoException extends Exception {

	private static final long serialVersionUID = 1L;

    public TaleoException(Throwable cause) {
        super(cause);
    }

    public TaleoException(String message, Throwable cause) {
        super(message, cause);
    }

    public TaleoException(String s) {
        super(s);
    }
}
