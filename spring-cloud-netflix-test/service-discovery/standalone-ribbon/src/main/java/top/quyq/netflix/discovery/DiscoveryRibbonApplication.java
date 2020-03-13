package top.quyq.netflix.discovery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class DiscoveryRibbonApplication {

    public static void main(String[] args) {
        SpringApplication.run(DiscoveryRibbonApplication.class,args);
    }

}
