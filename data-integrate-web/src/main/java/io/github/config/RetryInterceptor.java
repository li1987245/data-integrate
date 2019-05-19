package io.github.config;

import lombok.extern.slf4j.Slf4j;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;

import javax.annotation.Resource;
import java.io.IOException;

@Slf4j
public class RetryInterceptor implements Interceptor {
    private int retryCount;

    @Resource
    private LoadBalancerClient loadBalancerClient;

    public RetryInterceptor() {
        this(3);

    }

    public RetryInterceptor(int retryCount) {
        this.retryCount = retryCount;
    }

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();
        // try the request
        Response response = doRequest(chain, request);
        int tryCount = 0;
        String url = request.url().toString();
        while (response == null && tryCount <= retryCount) {
            Request newRequest = request.newBuilder().url(url).build();
            log.debug("intercept Request is not successful - {}", tryCount);
            tryCount++;
            // retry the request
            response = doRequest(chain, newRequest);
        }
        if (response == null) {
            log.warn("retry time:{}", retryCount);
            throw new IOException();
        }
        return response;
    }

    private Response doRequest(Chain chain, Request request) {
        Response response = null;
        try {
            response = chain.proceed(request);
        } catch (Exception e) {
            log.error("url:{} request error:{}", request.url(), e);
        }
        return response;
    }


}