package by.andd3dfx.restclient;

import java.util.ArrayList;
import java.util.List;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.client.HttpClient;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.impl.client.HttpClientBuilder;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

public class RestClientUtil {

    public static RestTemplate buildRestTemplate(String username, String password, int timeout) {
        RestTemplate restTemplate = new RestTemplate(
            RestClientUtil.buildClientHttpRequestFactory(username, password, timeout)
        );

        List<HttpMessageConverter<?>> messageConverters = new ArrayList<HttpMessageConverter<?>>() {{
            add(new MappingJackson2HttpMessageConverter());
        }};
        restTemplate.setMessageConverters(messageConverters);

        return restTemplate;
    }

    private static HttpComponentsClientHttpRequestFactory buildClientHttpRequestFactory(
        final String username, final String password, final int timeout) {

        return new HttpComponentsClientHttpRequestFactory() {{
            setHttpClient(buildHttpClient(username, password));
            setConnectionRequestTimeout(timeout);
            setConnectTimeout(timeout);
            setReadTimeout(timeout);
        }};
    }

    private static HttpClient buildHttpClient(String username, String password) {
        CredentialsProvider credentialsProvider = new BasicCredentialsProvider();
        credentialsProvider.setCredentials(AuthScope.ANY, new UsernamePasswordCredentials(username, password));

        try {
            SSLConnectionSocketFactory sslConnectionSocketFactory = buildSSLConnectionSocketFactory();

            return HttpClientBuilder
                .create()
                .setSSLSocketFactory(sslConnectionSocketFactory)
                .setDefaultCredentialsProvider(credentialsProvider)
                .setMaxConnTotal(200)
                .setMaxConnPerRoute(40)
                .build();
        } catch (Exception e) {
            throw new RuntimeException("Problems with https connection", e);
        }
    }

    private static SSLConnectionSocketFactory buildSSLConnectionSocketFactory() {
        return new SSLConnectionSocketFactory(
            new TLSSocketConnectionFactory(),
            new String[]{"TLSv1.2"},
            null,
            SSLConnectionSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER
        );
    }
}
