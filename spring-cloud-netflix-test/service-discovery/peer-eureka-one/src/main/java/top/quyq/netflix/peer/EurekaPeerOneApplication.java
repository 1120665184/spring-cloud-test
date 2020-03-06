package top.quyq.netflix.peer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class EurekaPeerOneApplication {

    public static void main(String[] args) {
        SpringApplication.run(EurekaPeerOneApplication.class,args);
    }

}
