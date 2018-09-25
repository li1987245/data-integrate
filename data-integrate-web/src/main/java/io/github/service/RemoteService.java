package io.github.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.util.StringUtils;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @Author: jinwei.li@100credit.com
 * @Date: 2018/9/7 16:06
 */
@Service
public class RemoteService {
    @Resource
    private RestTemplate restTemplate;

//    @HystrixCommand(fallbackMethod = "defaultMethod")
    public String hello(String name) {
        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        if (StringUtils.isEmpty(name))
            params.add("name", "阿达的");
        else
            params.add("name", name);
        return restTemplate.postForObject("http://DATA-INTEGRATE-SCHEDUE/hello", params, String.class);
    }


    public String defaultMethod(String name) {
        return name;
    }
}
