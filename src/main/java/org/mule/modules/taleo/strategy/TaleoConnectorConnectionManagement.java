/**
 * (c) 2003-2015 MuleSoft, Inc. The software in this package is published under
 * the terms of the CPAL v1.0 license, a copy of which has been included with this
 * distribution in the LICENSE.md file.
 */

package org.mule.modules.taleo.strategy;

import org.mule.api.ConnectionException;
import org.mule.api.ConnectionExceptionCode;
import org.mule.api.annotations.*;
import org.mule.api.annotations.components.ConnectionManagement;
import org.mule.api.annotations.display.Password;
import org.mule.api.annotations.param.ConnectionKey;
import org.mule.api.annotations.param.Default;
import org.mule.modules.taleo.client.TaleoClient;
import org.mule.modules.taleo.client.TaleoCxfClientImpl;
import org.mule.modules.taleo.client.TaleoException;
import org.mule.modules.taleo.model.WebServicesException_Exception;

@ConnectionManagement(configElementName = "config",
        friendlyName = "Connection Management")
public class TaleoConnectorConnectionManagement {

    private TaleoClient client;


    /**
     * Company code of the company
     */
    @Configurable
    private String companyCode;

    /**
     * Url endpoint that will provide the URL for following messages
     */
    @Configurable
    @Default("https://tbe.taleo.net/MANAGER/dispatcher/servlet/rpcrouter")
    private String dispatcherUrl;

    /**
     * Connect
     *
     * @param username A username
     * @param password A password
     * @throws ConnectionException
     */
    @Connect
    @TestConnectivity
    public void connect(@ConnectionKey String username, @Password String password)
            throws ConnectionException {
        try {
            client = new TaleoCxfClientImpl();
            ((TaleoCxfClientImpl) client).setDispatcherUrl(this.getDispatcherUrl());
            client.connect(username, password, companyCode);
        } catch (WebServicesException_Exception e) {
            throw new ConnectionException(ConnectionExceptionCode.CANNOT_REACH, null, e.getMessage(), e);
        } catch (TaleoException e) {
            throw new ConnectionException(ConnectionExceptionCode.UNKNOWN, null, e.getMessage(), e);
        }
    }

    /**
     * Disconnect
     */
    @Disconnect
    public void disconnect() {
        if (client != null && client.isConnected()) {
            client.disconnect();
        }
        client = null;
    }

    /**
     * Are we connected
     */
    @ValidateConnection
    public boolean isConnected() {
        return client != null && client.isConnected();
    }

    /**
     * Are we connected
     */
    @ConnectionIdentifier
    public String connectionId() {
        return companyCode;
    }

    public TaleoClient getClient() {
        return client;
    }

    public void setClient(TaleoClient client) {
        this.client = client;
    }

    public String getCompanyCode() {
        return companyCode;
    }

    public void setCompanyCode(String companyCode) {
        this.companyCode = companyCode;
    }

    public String getDispatcherUrl() {
        return dispatcherUrl;
    }

    public void setDispatcherUrl(String dispatcherUrl) {
        this.dispatcherUrl = dispatcherUrl;
    }
}
