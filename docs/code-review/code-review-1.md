# Propose solution by looking on app logs

## Task definition

```
** Logs:

***************************
APPLICATION FAILED TO START
***************************

Description:

Parameter 0 of constructor in by.andd3dfx.templateapp.service.review.CommonService required a single bean, but 2 were found:
        - infoService: defined in file [C:\Work\Personal\spring-boot-3-template\target\classes\by\andd3dfx\templateapp\service\review\executors\InfoService.class]
        - requestService: defined in file [C:\Work\Personal\spring-boot-3-template\target\classes\by\andd3dfx\templateapp\service\review\executors\RequestService.class]
```

## Solution

This may be due to missing parameter name information

Consider marking one of the beans as `@Primary`, updating the consumer to accept multiple beans, or using
`@Qualifier` to identify the bean that should be consumed

```java

@Primary
@Service
@RequiredArgsConstructor
public class InfoService implements IExecuteService {
    private final InfoProcessor processor;

    @Override
    public void execute() {
        processor.process();
    }
}
```

or

```java

@Service
public class CommonService<S extends IExecuteService> {
    private final S service;

    @Autowired
    public CommonService(@Qualifier("infoService") S service) {
        this.service = service;
    }

    void process() {
        service.execute();
    }
}
```
