package rhy.sample.common.util;

import java.net.SocketTimeoutException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.NameValuePair;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.conn.ConnectTimeoutException;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HTTPClientUtil {
    
    private static final int DEFAULT_CONNECT_TIMEOUT = 3;
    private static final int DEFAULT_SOCKET_TIMEOUT = 3;
    private static final String DEFAULT_ENCODING = "utf-8";
    private static final String DEFAULT_CONTENT_TYPE = "application/json";
    
//    private static final HttpHost PROXY = new HttpHost("70.10.15.10", 8080, "http");
    private static final HttpHost PROXY = null;
    
    private static final Logger LOGGER = LoggerFactory.getLogger(HTTPClientUtil.class);
    
    
    /**
     * Get Method로 HttpClient 호출
     * 
     * @param URL : 호출하려는 URL 
     * @param paramMap : 파라미터 정보를 담은 Map
     * @return
     */
    public static String processHttpClientGet(String URL, List<NameValuePair> params){
        Map<String, String> headerMap = new HashMap<String, String>();
        headerMap.put("Content-Type", DEFAULT_CONTENT_TYPE + "; charset=" + DEFAULT_ENCODING);
        return processHttpClientGet(URL, params, headerMap);
    }
    
    /**
     * Get Method로 HttpClient 호출 (Header 추가)
     * 
     * @param URL : 호출하려는 URL 
     * @param paramMap : 파라미터 정보를 담은 Map
     * @param headerMap : 헤더 정보를 담은 Map
     * @return
     */
    public static String processHttpClientGet(String URL, List<NameValuePair> params, Map<String,String> headerMap){
        return processHttpClientGet(URL, params, headerMap, DEFAULT_CONNECT_TIMEOUT, DEFAULT_SOCKET_TIMEOUT);
    }
    
    /**
     * Post Method로 HttpClient 호출
     * 
     * @param URL : 호출하려는 URL 
     * @param requestBody : Payload에 담길 request body 정보
     * @return
     */
    public static String processHttpClientPost(String URL, String requestBody){
        Map<String, String> headerMap = new HashMap<String, String>();
        headerMap.put("Content-Type", DEFAULT_CONTENT_TYPE + "; charset=" + DEFAULT_ENCODING);
        return processHttpClientPost(URL, requestBody, headerMap, DEFAULT_CONNECT_TIMEOUT, DEFAULT_SOCKET_TIMEOUT);
    }
    
    /**
     * Post Method로 HttpClient 호출 (Header 추가)
     * 
     * @param URL : 호출하려는 URL 
     * @param requestBody : Payload에 담길 request body 정보
     * @param headerMap : 헤더 정보를 담은 Map
     * @return
     */
    public static String processHttpClientPost(String URL, String requestBody, Map<String,String> headerMap){
        return processHttpClientPost(URL, requestBody, headerMap, DEFAULT_CONNECT_TIMEOUT, DEFAULT_SOCKET_TIMEOUT);
    }
    
    
    /**
     * /**
     * Get Method로 HttpClient 호출 (Header, Timeout 추가)
     * 
     * @param URL : 호출하려는 URL 
     * @param paramMap : 파라미터 정보를 담은 Map
     * @param headerMap : 헤더 정보를 담은 Map
     * @param connectionTimeoutSec : connection 타임아웃 (초)
     * @param socketTimeoutSec : socket 타임아웃 (초)
     * @return
     */
    public static String processHttpClientGet(String URL, List<NameValuePair> params, Map<String,String> headerMap, int connectionTimeoutSec, int socketTimeoutSec){
        StringBuilder requestURL = new StringBuilder(URL);
        requestURL.append("?");
        requestURL.append(URLEncodedUtils.format(params, DEFAULT_ENCODING));
        
        HttpGet httpGet = new HttpGet(requestURL.toString());
        CloseableHttpResponse response = null;
        CloseableHttpClient httpClient = HttpClients.createDefault();
        RequestConfig config = RequestConfig.custom()
                .setConnectTimeout(connectionTimeoutSec * 1000)
                .setSocketTimeout(socketTimeoutSec * 1000).build();
        httpGet.setConfig(config);
        httpGet = (HttpGet)convertHeaders(httpGet, headerMap);
        String result = null;
        try {
            response = httpClient.execute(httpGet);
            HttpEntity entity = response.getEntity();
            result = EntityUtils.toString(entity);
        } catch (ConnectTimeoutException e){
            LOGGER.error("# ERROR ConnectTimeoutException : {}", URL);
        } catch (SocketTimeoutException e){
            LOGGER.error("# ERROR SocketTimeoutException ", e);
        } catch (Exception e){
            LOGGER.error("# ERROR processHttpClientGet ", e);
        } finally {
            try { if (response != null) response.close(); } catch (Exception e) {}
        }
        
        return result;
    }

    /**
     * Post Method로 HttpClient 호출 (Header 추가)
     * 
     * @param URL : 호출하려는 URL 
     * @param requestBody : Payload에 담길 request body 정보
     * @param headerMap : 헤더 정보를 담은 Map
     * @param connectionTimeoutSec : connection 타임아웃 (초)
     * @param socketTimeoutSec : socket 타임아웃 (초)
     * @return
     */
    public static String processHttpClientPost(String URL, String requestBody, Map<String,String> headerMap, int connectionTimeoutSec, int socketTimeoutSec){
        CloseableHttpResponse response = null;
        HttpPost httpPost = new HttpPost(URL);
        CloseableHttpClient httpclient = HttpClients.createDefault();
        RequestConfig config = RequestConfig.custom()
                .setProxy(PROXY)
                .setConnectTimeout(connectionTimeoutSec * 1000)
                .setSocketTimeout(socketTimeoutSec * 1000).build();
        httpPost.setConfig(config);
        httpPost = (HttpPost)convertHeaders(httpPost, headerMap);
        String result = null;
        try {
            httpPost.setEntity(new StringEntity(requestBody));
            response = httpclient.execute(httpPost);
            HttpEntity entity = response.getEntity();
            result = EntityUtils.toString(entity);
        } catch (ConnectTimeoutException e){
            LOGGER.error("# ERROR ConnectTimeoutException : {}", URL);
        } catch (SocketTimeoutException e){
            LOGGER.error("# ERROR SocketTimeoutException ", e);
        } catch (Exception e){
            LOGGER.error("# ERROR processHttpClientGet ", e);
        } finally {
            try { if (response != null) response.close(); } catch (Exception e) {}
        }
        
        return result;
    }

    public static List<NameValuePair> setParameters(String... params) {
        if (params == null) {
            return null;
        }
        
        if (params.length % 2 != 0) {
            LOGGER.error("## ERROR - Parameters must be key-value pair.");
            return null;
        }
        
        List <NameValuePair> nvps = new ArrayList <NameValuePair>();
        for (int i=0; i<params.length; i=i+2){
            nvps.add(new BasicNameValuePair(params[i], params[i+1]));
        }
        return nvps;
    }
    
    private static HttpRequestBase convertHeaders(HttpRequestBase request, Map<String, String> headerMap) {
        for (Entry<String, String> entry : headerMap.entrySet()){
            request.addHeader(entry.getKey(), entry.getValue());
        }
        return request;
    }
}
