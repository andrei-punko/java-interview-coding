package by.andd3dfx.restclient;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@AllArgsConstructor
@Component
public class RestClient {

    private final RestTemplate restTemplate;

    /**
     * Make GET call of external REST endpoint.
     *
     * @param url           Endpoint url
     * @param responseClazz Response class
     * @param <T>           Type of result
     * @return Object of type T
     */
    public <T> T getForObject(String url, Class<T> responseClazz) {
        return getForObject(url, new HashMap<>(), new HashMap<>(), responseClazz);
    }

    /**
     * Make GET call of external REST endpoint.
     *
     * @param url           Endpoint url
     * @param headers       Map with http headers
     * @param responseClazz Response class
     * @param <T>           Type of result
     * @return Object of type T
     */
    public <T> T getForObject(String url, Map<String, String> headers, Class<T> responseClazz) {
        return getForObject(url, headers, new HashMap<>(), responseClazz);
    }

    /**
     * Make GET call of external REST endpoint.
     *
     * @param url           Endpoint url
     * @param headers       Map with http headers
     * @param queryParams   Query params (it's not path params!)
     * @param responseClazz Response class
     * @param <T>           Type of result
     * @return Object of type T
     */
    public <T> T getForObject(String url, Map<String, String> headers, Map<String, String> queryParams, Class<T> responseClazz) {
        String uriString = buildUriString(url, queryParams);
        HttpHeaders httpHeaders = buildHttpHeaders(headers);

        return makeCall(uriString, HttpMethod.GET, new HttpEntity<>(httpHeaders), responseClazz);
    }

    /**
     * Make POST call of external REST endpoint.
     *
     * @param url            Endpoint url
     * @param bodyJsonString Body JSON string
     * @param responseClazz  Response class
     * @param <T>            Type of result
     * @return Object of type T
     */
    public <T> T postForObject(String url, String bodyJsonString, Class<T> responseClazz) {
        return postForObject(url, new HashMap<>(), bodyJsonString, responseClazz);
    }

    /**
     * Make POST call of external REST endpoint.
     *
     * @param url            Endpoint url
     * @param headers        Map with http headers
     * @param bodyJsonString Body JSON string
     * @param responseClazz  Response class
     * @param <T>            Type of result
     * @return Object of type T
     */
    public <T> T postForObject(String url, Map<String, String> headers, String bodyJsonString, Class<T> responseClazz) {
        return postForObject(url, headers, new HashMap<>(), bodyJsonString, responseClazz);
    }

    /**
     * Make POST call of external REST endpoint.
     *
     * @param url            Endpoint url
     * @param headers        Map with http headers
     * @param queryParams    Query params (it's not path params!)
     * @param bodyJsonString Body JSON string
     * @param responseClazz  Response class
     * @param <T>            Type of result
     * @return Object of type T
     */
    public <T> T postForObject(String url, Map<String, String> headers, Map<String, String> queryParams,
                               String bodyJsonString, Class<T> responseClazz) {
        String uriString = buildUriString(url, queryParams);
        HttpHeaders httpHeaders = buildHttpHeaders(headers);
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);

        return makeCall(uriString, HttpMethod.POST, new HttpEntity<>(bodyJsonString, httpHeaders), responseClazz);
    }

    /**
     * Make PUT call of external REST endpoint.
     *
     * @param url           Endpoint url
     * @param headers       Map with http headers
     * @param responseClazz Response class
     * @param <T>           Type of result
     * @return Object of type T
     */
    public <T> T putForObject(String url, Map<String, String> headers, Class<T> responseClazz) {
        return putForObject(url, headers, new HashMap<>(), responseClazz);
    }

    /**
     * Make PUT call of external REST endpoint.
     *
     * @param url           Endpoint url
     * @param headers       Map with http headers
     * @param queryParams   Query params (it's not path params!)
     * @param responseClazz Response class
     * @param <T>           Type of result
     * @return Object of type T
     */
    public <T> T putForObject(String url, Map<String, String> headers, Map<String, String> queryParams, Class<T> responseClazz) {
        String uriString = buildUriString(url, queryParams);
        HttpHeaders httpHeaders = buildHttpHeaders(headers);
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);

        return makeCall(uriString, HttpMethod.PUT, new HttpEntity<>(httpHeaders), responseClazz);
    }

    /**
     * Make DELETE call of external REST endpoint.
     *
     * @param url           Endpoint url
     * @param headers       Map with http headers
     * @param responseClazz Response class
     * @param <T>           Type of result
     * @return Object of type T
     */
    public <T> T deleteForObject(String url, Map<String, String> headers, Class<T> responseClazz) {
        HttpHeaders httpHeaders = buildHttpHeaders(headers);
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);

        return makeCall(url, HttpMethod.DELETE, new HttpEntity<>(httpHeaders), responseClazz);
    }

    private String buildUriString(String url, Map<String, String> queryParams) {
        UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromHttpUrl(url);
        queryParams.forEach(uriBuilder::queryParam);
        return uriBuilder.toUriString();
    }

    private HttpHeaders buildHttpHeaders(Map<String, String> headers) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        headers.forEach(httpHeaders::set);
        return httpHeaders;
    }

    private <T> T makeCall(String url, HttpMethod httpMethod, HttpEntity<String> entity, Class<T> responseClazz) {
        return restTemplate
                .exchange(url, httpMethod, entity, responseClazz)
                .getBody();
    }
}
