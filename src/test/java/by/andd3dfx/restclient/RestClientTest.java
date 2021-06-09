package by.andd3dfx.restclient;

import by.andd3dfx.restclient.dto.MoneyAmount;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class RestClientTest {

    @InjectMocks
    private RestClient restClient;

    @Mock
    private RestTemplate restTemplate;

    @Test
    public void getForObjectWithoutQueryParams() {
        testGetForObject(new HashMap<>());
    }

    @Test
    public void getForObjectWithQueryParams() {
        testGetForObject(buildQueryParams());
    }

    private void testGetForObject(Map<String, String> queryParams) {
        final String url = "http://localhost:8080/any-path";
        final Map<String, String> headers = buildHeaders();

        final String expectedUrl = buildExpectedUrl(url, queryParams);
        final MoneyAmount stubResult = new MoneyAmount(54.8, "BYN");
        final ResponseEntity<MoneyAmount> responseEntity = ResponseEntity.ok(stubResult);
        when(restTemplate.exchange(eq(expectedUrl), eq(HttpMethod.GET), any(HttpEntity.class), eq(MoneyAmount.class)))
                .thenReturn(responseEntity);

        MoneyAmount result = restClient.getForObject(url, headers, queryParams, MoneyAmount.class);

        assertThat(result.getAmount(), is(stubResult.getAmount()));
        assertThat(result.getCurrency(), is(stubResult.getCurrency()));

        ArgumentCaptor<HttpEntity> httpEntityCaptor = ArgumentCaptor.forClass(HttpEntity.class);
        verify(restTemplate).exchange(eq(expectedUrl), eq(HttpMethod.GET), httpEntityCaptor.capture(), eq(MoneyAmount.class));

        HttpEntity capturedHttpEntity = httpEntityCaptor.getValue();
        HttpHeaders capturedHeaders = capturedHttpEntity.getHeaders();
        assertThat(capturedHeaders.getAccept(), is(Arrays.asList(MediaType.APPLICATION_JSON)));
        headers.forEach((key, value) -> {
            assertThat(capturedHeaders.get(key), is(Arrays.asList(value)));
        });
        assertThat(capturedHttpEntity.getBody(), nullValue());
    }

    @Test
    public void postForObjectWithoutQueryParams() {
        testPostForObject(new HashMap<>());
    }

    @Test
    public void postForObjectWithQueryParams() {
        testPostForObject(buildQueryParams());
    }

    private void testPostForObject(Map<String, String> queryParams) {
        final String url = "http://localhost:8080/any-path";
        final Map<String, String> headers = buildHeaders();

        final String expectedUrl = buildExpectedUrl(url, queryParams);
        final MoneyAmount stubResult = new MoneyAmount(54.8, "BYN");
        final ResponseEntity<MoneyAmount> responseEntity = ResponseEntity.ok(stubResult);
        final String bodyJsonString = "{ \"name\": \"Axton\" }";
        when(restTemplate.exchange(eq(expectedUrl), eq(HttpMethod.POST), any(HttpEntity.class), eq(MoneyAmount.class)))
                .thenReturn(responseEntity);

        MoneyAmount result = restClient.postForObject(url, headers, queryParams, bodyJsonString, MoneyAmount.class);

        assertThat(result.getAmount(), is(stubResult.getAmount()));
        assertThat(result.getCurrency(), is(stubResult.getCurrency()));

        ArgumentCaptor<HttpEntity> httpEntityCaptor = ArgumentCaptor.forClass(HttpEntity.class);
        verify(restTemplate).exchange(eq(expectedUrl), eq(HttpMethod.POST), httpEntityCaptor.capture(), eq(MoneyAmount.class));

        HttpEntity capturedHttpEntity = httpEntityCaptor.getValue();
        HttpHeaders capturedHeaders = capturedHttpEntity.getHeaders();
        assertThat(capturedHeaders.getAccept(), is(Arrays.asList(MediaType.APPLICATION_JSON)));
        assertThat(capturedHeaders.getContentType(), is(MediaType.APPLICATION_JSON));
        headers.forEach((key, value) -> {
            assertThat(capturedHeaders.get(key), is(Arrays.asList(value)));
        });
        assertThat(capturedHttpEntity.getBody(), is(bodyJsonString));
    }

    private String buildExpectedUrl(String url, Map<String, String> queryParams) {
        if (queryParams.isEmpty()) {
            return url;
        }

        String params = queryParams.keySet().stream()
                .map(key -> key + "=" + queryParams.get(key))
                .collect(Collectors.joining("&"));
        return url + "?" + params;
    }

    private Map<String, String> buildHeaders() {
        return Map.of("Key1", "Value1");
    }

    private Map<String, String> buildQueryParams() {
        return Map.of("paramKey1", "paramValue1");
    }
}
