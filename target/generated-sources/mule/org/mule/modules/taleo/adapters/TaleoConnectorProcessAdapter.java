
package org.mule.modules.taleo.adapters;

import javax.annotation.Generated;
import org.mule.api.MuleEvent;
import org.mule.api.MuleMessage;
import org.mule.api.devkit.ProcessAdapter;
import org.mule.api.devkit.ProcessTemplate;
import org.mule.api.processor.MessageProcessor;
import org.mule.api.routing.filter.Filter;
import org.mule.modules.taleo.TaleoConnector;
import org.mule.security.oauth.callback.ProcessCallback;


/**
 * A <code>TaleoConnectorProcessAdapter</code> is a wrapper around {@link TaleoConnector } that enables custom processing strategies.
 * 
 */
@SuppressWarnings("all")
@Generated(value = "Mule DevKit Version 3.6.1", date = "2015-12-18T03:06:03-03:00", comments = "Build UNNAMED.2405.44720b7")
public class TaleoConnectorProcessAdapter
    extends TaleoConnectorLifecycleInjectionAdapter
    implements ProcessAdapter<TaleoConnectorCapabilitiesAdapter>
{


    public<P >ProcessTemplate<P, TaleoConnectorCapabilitiesAdapter> getProcessTemplate() {
        final TaleoConnectorCapabilitiesAdapter object = this;
        return new ProcessTemplate<P,TaleoConnectorCapabilitiesAdapter>() {


            @Override
            public P execute(ProcessCallback<P, TaleoConnectorCapabilitiesAdapter> processCallback, MessageProcessor messageProcessor, MuleEvent event)
                throws Exception
            {
                return processCallback.process(object);
            }

            @Override
            public P execute(ProcessCallback<P, TaleoConnectorCapabilitiesAdapter> processCallback, Filter filter, MuleMessage message)
                throws Exception
            {
                return processCallback.process(object);
            }

        }
        ;
    }

}
