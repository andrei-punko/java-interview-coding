package by.andd3dfx.jms;

import org.apache.activemq.broker.jmx.BrokerViewMBean;
import org.apache.activemq.broker.jmx.QueueViewMBean;

import javax.management.MBeanServerConnection;
import javax.management.MBeanServerInvocationHandler;
import javax.management.MalformedObjectNameException;
import javax.management.ObjectName;
import javax.management.remote.JMXConnector;
import javax.management.remote.JMXConnectorFactory;
import javax.management.remote.JMXServiceURL;
import java.io.IOException;

/**
 * To make JMX available for ActiveMQ it should be configured in config activemq.xml:
 * <managementContext>
 *   <managementContext createConnector="true"/>
 * </managementContext>
 */
public class JmsUtil {

    public static Long getQueueSize(String activeMqUrl, String queueName) throws Exception {
        JMXConnector connector = JMXConnectorFactory.connect(new JMXServiceURL(activeMqUrl));
        MBeanServerConnection connection = connector.getMBeanServerConnection();

        ObjectName objectName = new ObjectName("org.apache.activemq:type=Broker,brokerName=localhost");
        BrokerViewMBean brokerViewMBean;
        brokerViewMBean = MBeanServerInvocationHandler.newProxyInstance(connection, objectName, BrokerViewMBean.class, true);
        brokerViewMBean.addQueue(queueName);

        for (ObjectName name : brokerViewMBean.getQueues()) {
            QueueViewMBean queueViewMBean = MBeanServerInvocationHandler.newProxyInstance(connection, name, QueueViewMBean.class, true);

            if (queueViewMBean != null && queueViewMBean.getName().equals(queueName)) {
                return queueViewMBean.getQueueSize();
            }
        }
        return null;
    }

    public static Long getQueueSize2(String activeMqUrl, String queueName) throws IOException, MalformedObjectNameException {
        JMXConnector connector = JMXConnectorFactory.connect(new JMXServiceURL(activeMqUrl));
        MBeanServerConnection connection = connector.getMBeanServerConnection();

        ObjectName objectName = new ObjectName("org.apache.activemq:type=Broker,brokerName=localhost,destinationType=Queue,destinationName=" + queueName);
        QueueViewMBean queueViewMBean = MBeanServerInvocationHandler.newProxyInstance(connection, objectName, QueueViewMBean.class, true);

        if (queueViewMBean != null) {
            return queueViewMBean.getQueueSize();
        }

        return null;
    }
}
