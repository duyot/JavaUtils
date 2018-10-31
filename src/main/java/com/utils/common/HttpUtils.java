package com.utils.common;

import org.apache.commons.io.IOUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLContextBuilder;
import org.apache.http.conn.ssl.TrustSelfSignedStrategy;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

public class HttpUtils {

    private static Logger log = LoggerFactory.getLogger(HttpUtils.class);

    public static String sendPOSTRequest(String url, String jsonData) {
        log.info("Send "+ jsonData + " to : "+ url);
        String result;
        //
        RequestConfig requestConfig = RequestConfig.custom().setConnectTimeout(30 * 1000).build();
        HttpClient httpClient = HttpClientBuilder.create().setDefaultRequestConfig(requestConfig).build();

        HttpPost postMethod = new HttpPost(url);
        //
        StringEntity requestEntity = new StringEntity(jsonData,ContentType.APPLICATION_JSON);
        requestEntity.setContentType("application/json");
        requestEntity.setContentEncoding("UTF-8");
        postMethod.setEntity(requestEntity);
        //
        postMethod.setEntity(requestEntity);
        //
        try {
            HttpResponse rawResponse = httpClient.execute(postMethod);
            HttpEntity entity = rawResponse.getEntity();
            result =  EntityUtils.toString(entity);
        } catch (IOException e) {
            log.info(e.toString());
            e.printStackTrace();
            result =  "";
        }
        //
        log.info("Result: "+ result.toString());
        //
        return result;
    }

    public static String sendPOSTSSLRequest(String url, String data) {
        log.info("Send "+ data + " to : "+ url);
        String result;
        try{
            HttpPost httpPost=new HttpPost(url);
            //
            StringEntity input = new StringEntity(data,"UTF-8");
            input.setContentType("application/json");
            input.setContentEncoding("UTF-8");
            httpPost.setEntity(input);
            //
            SSLContextBuilder builder = new SSLContextBuilder();
            builder.loadTrustMaterial(null, new TrustSelfSignedStrategy());
            SSLConnectionSocketFactory sslsf = new SSLConnectionSocketFactory(builder.build());
            CloseableHttpClient httpclient = HttpClients.custom().setSSLSocketFactory(sslsf).build();

            HttpResponse response = httpclient.execute(httpPost);
            //
            HttpEntity entity = response.getEntity();
            InputStream content = entity.getContent();

            ByteArrayOutputStream baos = new ByteArrayOutputStream(2048 * 2048);
            try {

                IOUtils.copy(content, baos);
            } finally {
                try
                {
                    content.close();
                    entity.consumeContent();
                    httpclient.getConnectionManager().shutdown();
                }catch(Exception ex){System.out.println("Close Connection:"+ex.toString());}
            }

            byte[] bytes = baos.toByteArray();

            result = new String(bytes);
        }catch (Exception e){
            log.info(e.toString());
            result = "";
        }
        //
        log.info("Result: "+ result);
        //
        return result;
    }

    public static String sendGETRequest(String getURL) throws Exception {
        log.info("Send GET request to: "+ getURL);
        //
        StringBuilder result = new StringBuilder();
        URL url = new URL(getURL);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded;charset=utf-8");
        //
        InputStream is = conn.getInputStream();
        InputStreamReader isr = new InputStreamReader(is, "utf-8");
        BufferedReader rd = new BufferedReader(isr);
        String line;
        while ((line = rd.readLine()) != null) {
            result.append(line);
        }
        rd.close();
        //
        log.info("Result: "+ result.toString());
        //
        return result.toString();
    }

    public static String sendGETRequestByHttpClient(String url) throws Exception {
        log.info("Send GET request to: "+ url);
        //
        HttpClient client = HttpClientBuilder.create().build();
        HttpGet request = new HttpGet(url);

        HttpResponse response = client.execute(request);

        BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
        StringBuffer result = new StringBuffer();
        String line = "";
        while ((line = rd.readLine()) != null) {
            result.append(line);
        }
        //
        log.info("Result: "+ result.toString());
        //
        return result.toString();
    }


    public static String sendGETRequest(String url, String request, int timeout) throws Exception {
        URL sendUrl = new URL(url);
        URLConnection urlCon = sendUrl.openConnection();
        urlCon.setDoOutput(true);
        urlCon.setDoInput(true);
        HttpURLConnection httpConnection = (HttpURLConnection) urlCon;

        httpConnection.setRequestMethod("GET");
        httpConnection.setRequestProperty("Content-Length", Integer.toString(request.length()));
        httpConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded;charset=utf-8");
        httpConnection.setConnectTimeout(timeout);
        httpConnection.setReadTimeout(timeout);

        PrintStream ps = new PrintStream(httpConnection.getOutputStream(), true, "utf-8");
        ps.flush();

        String str = httpConnection.getResponseMessage();
        if (str.equals("OK")) {
            InputStream is = httpConnection.getInputStream();
            InputStreamReader isr = new InputStreamReader(is, "utf-8");
            BufferedReader br = new BufferedReader(isr);
            str = "";

            StringBuilder sb = new StringBuilder();
            while ((str = br.readLine()) != null) {
                sb.append(str);
            }

            is.close();
            return sb.toString();
        } else {
            InputStream is = httpConnection.getInputStream();
            InputStreamReader isr = new InputStreamReader(is, "utf-8");
            BufferedReader br = new BufferedReader(isr);
            str = "";

            StringBuilder sb = new StringBuilder();
            while ((str = br.readLine()) != null) {
                sb.append(str);
            }

            is.close();
            throw new Exception(sb.toString());
        }
    }

}
