package top.quyq.task.sink;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.task.launcher.annotation.EnableTaskLauncher;

@SpringBootApplication
@EnableTaskLauncher
public class SinkApplication {

    public static void main(String[] args) {
        SpringApplication.run(SinkApplication.class,args);
    }

}
