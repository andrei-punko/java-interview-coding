package by.andd3dfx.proxy;

import org.junit.Test;

import java.lang.reflect.Proxy;

import static org.assertj.core.api.Assertions.assertThat;

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

    assertThat(((SomeInterface1) proxyInstance).performActionOne(10))
            .as("x2 value expected")
            .isEqualTo(20);
    assertThat(((SomeInterface2) proxyInstance).performActionTwo(10))
            .as("x4 value expected")
            .isEqualTo(100);
  }
}
