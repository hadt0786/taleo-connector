/**
 * (c) 2003-2015 MuleSoft, Inc. The software in this package is published under
 * the terms of the CPAL v1.0 license, a copy of which has been included with this
 * distribution in the LICENSE.md file.
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
