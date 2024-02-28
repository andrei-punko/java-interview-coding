
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

==========================================================

public class DirectoryFolder {
    private Long id;
    private String name;
    private List<DirectoryFolder> subFolders;
}

==========================================================
