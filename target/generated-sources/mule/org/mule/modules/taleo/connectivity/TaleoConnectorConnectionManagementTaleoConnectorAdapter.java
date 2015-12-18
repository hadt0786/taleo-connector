
package org.mule.modules.taleo.connectivity;

import javax.annotation.Generated;
import org.mule.api.ConnectionException;
import org.mule.devkit.shade.connection.management.ConnectionManagementConnectionAdapter;
import org.mule.modules.taleo.strategy.TaleoConnectorConnectionManagement;

@SuppressWarnings("all")
@Generated(value = "Mule DevKit Version 3.6.1", date = "2015-12-18T03:06:03-03:00", comments = "Build UNNAMED.2405.44720b7")
public class TaleoConnectorConnectionManagementTaleoConnectorAdapter
    extends TaleoConnectorConnectionManagement
    implements ConnectionManagementConnectionAdapter<TaleoConnectorConnectionManagement, ConnectionManagementConfigTaleoConnectorConnectionKey>
{


    @Override
    public void connect(ConnectionManagementConfigTaleoConnectorConnectionKey connectionKey)
        throws ConnectionException
    {
        super.connect(connectionKey.getUsername(), connectionKey.getPassword());
    }

    @Override
    public void disconnect() {
        super.disconnect();
    }

    @Override
    public String connectionId() {
        return super.connectionId();
    }

    @Override
    public boolean isConnected() {
        return super.isConnected();
    }

    @Override
    public TaleoConnectorConnectionManagement getStrategy() {
        return this;
    }

}
