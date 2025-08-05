# Perform review of this code

How many instances of `PrototypeBean` class will be created?

```java
@Configuration
public class AppConfig {

    @Bean
    @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    public PrototypeBean prototypeBean() {
        return new PrototypeBean();
    }

    @Bean
    public MyService myService() {
        return new MyService();
    }
}

public class MyService {

    @Autowired
    private PrototypeBean prototypeBean;

    public void method() {
        prototypeBean.get();
        prototypeBean.process();
    }
}
```
