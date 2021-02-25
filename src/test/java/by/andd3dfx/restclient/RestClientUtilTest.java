package by.andd3dfx.restclient;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;

import java.lang.reflect.Field;
import org.junit.Test;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

public class RestClientUtilTest {

    @Test
    public void buildRestTemplate() throws NoSuchFieldException, IllegalAccessException {
        String username = "usernameValue";
        String password = "somePass";
        int timeout = 20000;

        RestTemplate restTemplate = RestClientUtil.buildRestTemplate(username, password, timeout);

        assertThat("Shouldn't be null", restTemplate, is(notNullValue()));
        assertThat("Wrong message converters amount", restTemplate.getMessageConverters().size(), is(1));

        final ClientHttpRequestFactory requestFactory = restTemplate.getRequestFactory();
        assertThat("Request factory shouldn't be null", requestFactory, is(notNullValue()));

        checkFieldExistence(requestFactory, "username", username);
        checkFieldExistence(requestFactory, "password", password);
        checkFieldExistence(requestFactory, "timeout", timeout);
    }

    private void checkFieldExistence(ClientHttpRequestFactory requestFactory, String fieldName, Object expectedValue)
        throws IllegalAccessException {
        final Field[] declaredFields = requestFactory.getClass().getDeclaredFields();
        for (Field field : declaredFields) {
            if (field.getName().endsWith(fieldName)) {
                field.setAccessible(true);
                assertThat("Wrong field value", field.get(requestFactory), is(expectedValue));
            }
        }
    }
}
