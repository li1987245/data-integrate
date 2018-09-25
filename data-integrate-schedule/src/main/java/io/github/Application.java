package io.github;

import com.netflix.discovery.DiscoveryManager;
import io.github.common.ShutdownHook;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

/**
 * @Author: jinwei.li@100credit.com
 * @Date: 2018/8/30 15:56
 */
@SpringBootApplication
@RestController
public class Application {
    @RequestMapping("/hello")
    public String home(String name) throws InterruptedException {
        Random ra = new Random();
        Thread.sleep(ra.nextInt(1000));
        return "Hello " + name;
    }

    public static void main(String[] args) throws InterruptedException {
//        Runtime.getRuntime().addShutdownHook(new Thread(new ShutdownHook()));  //得到Runtime的引用并注册关闭钩子
        new SpringApplicationBuilder(Application.class).web(true).run(args);
        Thread.sleep(10000);
        System.exit(0);
    }
}
