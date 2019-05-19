package io.github;

import io.github.config.RetryInterceptor;
import io.github.service.RemoteService;
import okhttp3.ConnectionPool;
import okhttp3.OkHttpClient;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.http.client.OkHttp3ClientHttpRequestFactory;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

/**
 * @Author: jinwei.li@100credit.com
 * @Date: 2018/8/30 15:56
 */
@SpringCloudApplication
@RestController
public class WebApplication {
    @Resource
    private RemoteService remoteService;


    @RequestMapping("/hello")
    public String hello(String name) {
        return remoteService.hello(name);
    }

//    @Bean
//    @LoadBalanced
//    public RestTemplate restTemplate() {
//        ConnectionPool pool = new ConnectionPool(10, 5, TimeUnit.MINUTES);
//        OkHttpClient client = new OkHttpClient.Builder().connectionPool(pool).connectTimeout(1, TimeUnit.SECONDS)
//                .readTimeout(5, TimeUnit.SECONDS).retryOnConnectionFailure(true).addInterceptor(new RetryInterceptor()).build();
//        OkHttp3ClientHttpRequestFactory factory = new OkHttp3ClientHttpRequestFactory(client);
//        return new RestTemplate(factory);
//    }

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        SimpleClientHttpRequestFactory simpleClientHttpRequestFactory = new   SimpleClientHttpRequestFactory();
        simpleClientHttpRequestFactory.setConnectTimeout(500);
        simpleClientHttpRequestFactory.setReadTimeout(1000);
        return new RestTemplate(simpleClientHttpRequestFactory);
    }

    public static void main(String[] args) {
        new SpringApplicationBuilder(WebApplication.class).web(true).run(args);
//        DiscoveryManager.getInstance().shutdownComponent();
    }
}
