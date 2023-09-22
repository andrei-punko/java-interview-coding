package by.andd3dfx.serialization;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ExternalizeUtilTest {

    private static final String SERIALIZED_FILE_NAME = "./build/save.ser";

    @Test
    public void testSerializeDeserialize() {
        ExternalizeUtil.write(SERIALIZED_FILE_NAME, buildUserInfo());
        var deserializedObject = ExternalizeUtil.read(SERIALIZED_FILE_NAME);

        assertThat(deserializedObject).isEqualTo(buildUserInfo());
    }

    private static UserInfo buildUserInfo() {
        return UserInfo.builder()
                .firstName("Andrei")
                .lastName("Punko")
                .email("andd3dfx@gmail.com")
                .url("https://github.com/andrei-punko")
                .superSecretInformation("Some security data")
                .build();
    }
}
