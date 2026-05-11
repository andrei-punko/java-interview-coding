# Perform review of this code

```java
// Сделать ревью кода сервиса DataService и метода создания/получения новой сущности Data.
// Метод создания может вызваться из разных потоков и должен быть безопасен для такого режима использования.
// AccessService и DataRepository безопасны для использования из разных потоков.
// Предложить как можно сделать лучше и починить проблемы, если они есть.

@ReqArgsConstructor
public class DataService {

    private AccessService access;   // final, change name to `accessService`
    private DataRepository repository;  // final
    private MessageDigest digest = get();   // should be removed, use Holder described below

    public DataService(AccessService access, DataRepository repository) {   // could be deleted
        this.access = access;
        this.repository = repository;
    }

    public Data get(String uid) {   // change name to findByUid
        access.checkRead();         // switch to use annotation-driven approach
        return repository.get(uid); // switch to findByUid() method or another
    }

    public void create(String name) {   // return created object or creation status
        access.checkWrite();        // switch to use annotation-driven approach
        digest = get();
        repository.save(new Data(   // add return
                HexFormat.of().formatHex(digest.digest(name.getBytes())),   // may be after switch to UUID - we could generate UUID by name OR use random UUID generation
                name
        ));
    }

    public static MessageDigest get() {     // move into some MessageDigestHolder, pre-create and get already created object. add synchronized at least
        try {
            return MessageDigest.getInstance("md5");
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException();   // pass e as RuntimeException parameter, add error logging if needed
        }
    }

    public record Data( // extract to separate class
                        String uid,     // switch to use dedicated UUID class
                        String name
    ) {
    }

    // @Repository to wrap exceptions
    public interface DataRepository {   // extract to separate class
        void save(Data data);

        Data get(String uid);   // change name to findByUid
    }

    public interface AccessService { // extract to separate class
        void checkRead();

        void checkWrite();
    }
}
```
