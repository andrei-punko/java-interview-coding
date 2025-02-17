package by.andd3dfx.proxy;

import org.junit.Test;

import java.lang.reflect.Proxy;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Dynamic proxy usage example
 * Based on <a href="http://www.baeldung.com/java-dynamic-proxies">article</a>
 */
public class ProxyCreationByInterfacesTest {

  @Test
  public void performAction() {
    Object proxyInstance = Proxy.newProxyInstance(
        ProxyCreationByInterfacesTest.class.getClassLoader(),
        new Class[]{SomeInterface1.class, SomeInterface2.class},
        new DynamicInvocationHandler()
    );

    assertThat("x2 value expected", ((SomeInterface1) proxyInstance).performActionOne(10), is(20));
    assertThat("x4 value expected", ((SomeInterface2) proxyInstance).performActionTwo(10), is(100));
  }
}
