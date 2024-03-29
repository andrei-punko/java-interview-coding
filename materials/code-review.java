
** Problem Definition:

@Service
@RequiredArgsConstructor
public class CommonService<S extends ExecuteService> {
    private final S service;

    void process() {
        service.execute();
    }
}

@Service
@RequiredArgsConstructor
public class InfoService {
    private final InfoProcessor service;

    void process() {
        service.execute();
    }
}

@Service
@RequiredArgsConstructor
public class RequestService {
    private final RequestProcessor service;

    void process() {
        service.execute();
    }
}
----------------------------------------------------------
** After refactoring:

@Service
@RequiredArgsConstructor
public class CommonService<S extends IExecuteService> {
    private final S service;

    void process() {
        service.execute();
    }
}

public interface IExecuteService {
    void execute();
}

@Service
@RequiredArgsConstructor
public class InfoService implements IExecuteService {
    private final InfoProcessor processor;

    @Override
    public void execute() {
        processor.process();
    }
}

@Service
@RequiredArgsConstructor
public class RequestService implements IExecuteService {
    private final RequestProcessor processor;

    @Override
    public void execute() {
        processor.process();
    }
}

@Service
public class InfoProcessor {
    public void execute() {
    }
}

@Service
public class RequestProcessor {
    public void execute() {
    }
}
----------------------------------------------------------
** Logs:

***************************
APPLICATION FAILED TO START
***************************

Description:

Parameter 0 of constructor in by.andd3dfx.templateapp.service.review.CommonService required a single bean, but 2 were found:
        - infoService: defined in file [C:\Work\Personal\spring-boot-3-template\target\classes\by\andd3dfx\templateapp\service\review\executors\InfoService.class]
        - requestService: defined in file [C:\Work\Personal\spring-boot-3-template\target\classes\by\andd3dfx\templateapp\service\review\executors\RequestService.class]

This may be due to missing parameter name information

Action:

Consider marking one of the beans as @Primary, updating the consumer to accept multiple beans, or using @Qualifier to identify the bean that should be consumed
----------------------------------------------------------
** Solution:

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

or

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
