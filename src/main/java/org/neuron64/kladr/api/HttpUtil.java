package org.neuron64.kladr.api;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

/**
 * Created by neuron on 21.05.17.
 */
public class HttpUtil {

    private static CloseableHttpClient CLIENT = HttpClients.createDefault();

    public static String get(final String uri) throws IOException {
        final HttpGet get = new HttpGet(uri);
//        final HttpGet get = new HttpGet(URLEncoder.encode(uri, "UTF-8"));

        final CloseableHttpResponse response = CLIENT.execute(get);
        final HttpEntity entity = response.getEntity();

        return EntityUtils.toString(entity);
    }

}
