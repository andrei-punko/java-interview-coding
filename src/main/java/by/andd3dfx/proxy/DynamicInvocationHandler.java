package by.andd3dfx.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class DynamicInvocationHandler implements InvocationHandler {

  private SomeInterface1 addOperation = new SomeInterface1Impl();
  private SomeInterface2 multiplyOperation = new SomeInterface2Impl();

  @Override
  public Object invoke(Object proxy, Method method, Object[] args) {
    System.out.println("Invoked method: " + method.getName());

    Integer arg = (Integer) args[0];
    switch (method.getName()) {
      case "performActionOne":
        return addOperation.performActionOne(arg);

      case "performActionTwo":
        return multiplyOperation.performActionTwo(arg);

      default:
        return 42;
    }
  }
}
