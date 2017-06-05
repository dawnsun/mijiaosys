package com.mijiaokj.sys.common.httpclient;

import org.slf4j.LoggerFactory;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by sunchenguang on 2017/6/5.
 */
public class ThreadPoolHttp {

    AtomicInteger errorAtomicInteger=new AtomicInteger();
    // 多线程httpclient解决超时连接,  设置请求超时2秒钟 根据业务调整 ;设置等待数据超时时间2秒钟 根据业务调整;该值就是连接不够用的时候等待超时时间，一定要设置，而且不能太大 ()
    RequestConfig defaultRequestConfig = RequestConfig.custom().setSocketTimeout(20000).setConnectTimeout(2000).setConnectionRequestTimeout(500)
            .setStaleConnectionCheckEnabled(true).build();
    private static final Logger log = LoggerFactory.getLogger(ThreadPoolHttp.class);
    public void threadPoolHttp() {
        long beingTime = System.currentTimeMillis();

        List<String> urlList = new ArrayList<>();
        urlList.add("http://news.1nongjing.com/Alert/");
        urlList.add("http://news.1nongjing.com/locality/");
        urlList.add("http://news.1nongjing.com/spaq/");
        urlList.add("http://news.1nongjing.com/zc/");
        urlList.add("http://news.1nongjing.com/Depth/");
        urlList.add("http://news.1nongjing.com/exclusive/");
        urlList.add("http://www.farmer.com.cn/xwpd/");
        urlList.add("http://www.farmer.com.cn/jjpd/");
        urlList.add("http://www.farmer.com.cn/sh/");
        urlList.add("http://www.farmer.com.cn/");
        urlList.add("http://www.farmer.com.cn/snsx/");
        urlList.add("http://www.farmer.com.cn/zt/");
        urlList.add("http://news.1nongjing.com/locality/gansu/");

        CloseableHttpClient httpclient = getPoolHttpClient(urlList.size());
        ExecutorService executorService = Executors.newFixedThreadPool(urlList.size());

        for(String url : urlList){
            executorService.execute(getThread(httpclient,url, "UTF-8","get",null));
        }
        executorService.shutdown();
        try {
            executorService.awaitTermination(Long.MAX_VALUE, TimeUnit.DAYS);
            long endTime = System.currentTimeMillis();
            log.info("执行threadPoolHttp时间：" + (endTime - beingTime));
            log.info("connect time out 错误个数：" +errorAtomicInteger.getAndIncrement());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public void auth(){
        CloseableHttpClient httpclient = getPoolHttpClient(1000);
        ExecutorService executorService = Executors.newFixedThreadPool(1000);
//		String url = "http://www.yilejoy.com:8080/yljManager/season.do?method=gauth";
        String url2 = "http://www.yilejoy.com:8080/yljManager/season.do?method=produceAgree4H5&pid=ed8a9eeea1a84cbfabb5c2ec81d9751f&auth=eav4";
//		executorService.execute(getThread(httpclient,url, "UTF-8","get",null));
        for(int i=0; i<1000; i++){
            executorService.execute(getThread(httpclient,url2, "UTF-8","get",null));
        }
        executorService.shutdown();

    }
    /**
     * 当使用了请求连接池管理器（比如PoolingClientConnectionManager）后，HttpClient就可以同时执行多个线程的请求了。
     * @return
     */
    public CloseableHttpClient getPoolHttpClient(Integer threadNumber) {
        // 单线程跑是基本看不出配置了连接池的好处的，只有使用多线程爬取数据的时候，并且数据量越大效果越明显
        PoolingHttpClientConnectionManager conMgr = new PoolingHttpClientConnectionManager();
        conMgr.setMaxTotal(threadNumber); // 设置整个连接池最大连接数 根据自己的场景决定
        // 是路由的默认最大连接（该值默认为2），限制数量实际使用DefaultMaxPerRoute并非MaxTotal。
        // 设置过小无法支持大并发(ConnectionPoolTimeoutException: Timeout waiting for connection from pool)，路由是对maxTotal的细分。

        conMgr.setDefaultMaxPerRoute(threadNumber);// （目前只有一个路由，因此让他等于最大值）
        CloseableHttpClient httpClient = HttpClients.custom().setConnectionManager(conMgr).build();
        return httpClient;
    }

    private Thread getThread(CloseableHttpClient httpclient, String url, String charSet, String methods, Map<String, String> params) {
        return new Thread(() -> {
            if("get".equals(methods)){
                HttpGet httGet = new HttpGet(url);
                //设置访问参数
//	            RequestConfig requestConfig = RequestConfig.copy(defaultRequestConfig).build();
                httGet.setConfig(defaultRequestConfig);
                CloseableHttpResponse resopnse = null;
                HttpEntity entity = null;
                try {
                    log.info("开始请求");
                    // 每个线程独立一个httpclient才可以达到线程的效果
                    if (httpclient == null) {
                        resopnse = HttpClients.createDefault().execute(httGet);
                    } else {
                        // 多线程公用一个httpclient会导致串行,一个Http连接在同一时间只能被一个线程访问
                        resopnse = httpclient.execute(httGet);
                    }
                    log.info("status:" + resopnse.getStatusLine());
                    // 休眠模拟多个线程抢占httpclient
                    entity = resopnse.getEntity();
                    String result = EntityUtils.toString(entity, charSet);
                    log.info(Thread.currentThread().getName()+"");
                    contentToTxt("D:/testUrl/"+Thread.currentThread().getName()+".txt", result);
                } catch (IOException e) {
                    errorAtomicInteger.getAndIncrement();
                    log.error("" + e.getLocalizedMessage());
                } finally {
                    if (resopnse != null) {
                        try {
                            EntityUtils.consume(entity); // 会自动释放连接
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }else{
                long start = System.currentTimeMillis();
                HttpPost httpPost = new HttpPost(url);
                HttpEntity entity = null;
                //设置访问参数
                RequestConfig requestConfig = RequestConfig.copy(defaultRequestConfig).build();
                httpPost.setConfig(defaultRequestConfig);
                List<NameValuePair> parameters =new ArrayList<>();
                if(null!=params){
                    for (String key : params.keySet()) {
                        NameValuePair nameValuePair = new BasicNameValuePair(key, params.get(key));
                        parameters.add(nameValuePair);
                    }
                }

                httpPost.setEntity(new UrlEncodedFormEntity(parameters, Charset.forName("UTF-8")));
                HttpClientContext context = HttpClientContext.create();
                context.setRequestConfig(requestConfig);
                CloseableHttpResponse response = null;


                try {
                    response = httpclient.execute(httpPost, context);
                    int statusCode = response.getStatusLine().getStatusCode();
//					if(statusCode == HttpStatus.SC_OK){
                    entity = response.getEntity();
                    String result = EntityUtils.toString(entity, charSet);
                    contentToTxt("D:/testUrl/"+Thread.currentThread().getName()+".txt", result);
//					}
                } catch (ClientProtocolException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                } finally {
                    long end = System.currentTimeMillis();
                    long cost = end - start;
                    //printCurlRequest(url, params, cost);
                    if (response != null) {
                        try {
                            response.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    httpPost.releaseConnection();
                }

            }

        });
    }


    public void contentToTxt(String filePath, String content) {
        try {
            File f = new File(filePath);
            if (!f.exists()) {
                f.createNewFile();
            }

            BufferedWriter output = new BufferedWriter(new FileWriter(f));
            output.write(content);
            output.close();
        } catch (Exception e) {
            e.printStackTrace();

        }
    }

    public static void main(String[] args) {
        ThreadPoolHttp threadPoolHttp = new ThreadPoolHttp();
        threadPoolHttp.auth();
//		threadPoolHttp.contentToTxt("D:/testUrl/1.txt", "sdfsdf");
    }

}
