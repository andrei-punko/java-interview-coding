package by.andd3dfx.proxy;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import java.lang.reflect.Proxy;
import org.junit.Test;

/**
 * Dynamic proxy usage example
 * Based on http://www.baeldung.com/java-dynamic-proxies
 */
public class ProxyCreationByInterfacesTest {

  @Test
  public void performAction() {
    Object proxyInstance = Proxy.newProxyInstance(
        ProxyCreationByInterfacesTest.class.getClassLoader(),
        new Class[]{SomeInterface1.class, SomeInterface2.class},
        new DynamicInvocationHandler()
    );

    assertThat("Double value expected", ((SomeInterface1) proxyInstance).performActionOne(10), is(20));
    assertThat("Square value expected", ((SomeInterface2) proxyInstance).performActionTwo(10), is(100));
  }
}
