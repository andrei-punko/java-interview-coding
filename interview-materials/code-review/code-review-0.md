# Perform refactoring of this code

## Before refactoring:

```java

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
```

## After refactoring:

```java

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
```
