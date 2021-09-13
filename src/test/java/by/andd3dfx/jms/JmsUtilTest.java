package by.andd3dfx.jms;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThanOrEqualTo;

/**
 * To perform check - start Active MQ broker with JMX enabled in configuration according to notes in JmsUtil
 */
public class JmsUtilTest {
    private final String ACTIVEMQ_URL = "service:jmx:rmi:///jndi/rmi://localhost:1099/jmxrmi";
    private final String QUEUE_NAME = "JMS/DGST.MIGRATE.IN";

    @Test
    public void getQueueSize() throws Exception {
        Long queueSize = JmsUtil.getQueueSize(ACTIVEMQ_URL, QUEUE_NAME);

        assertThat("Size should be >=0", queueSize, greaterThanOrEqualTo(0L));
    }

    @Test
    public void getQueueSize2() throws Exception {
        Long queueSize = JmsUtil.getQueueSize2(ACTIVEMQ_URL, QUEUE_NAME);

        assertThat("Size should be >=0", queueSize, greaterThanOrEqualTo(0L));
    }
}
