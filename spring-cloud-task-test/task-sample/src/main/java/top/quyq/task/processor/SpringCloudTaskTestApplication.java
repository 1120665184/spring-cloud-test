package top.quyq.task.processor;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.task.configuration.EnableTask;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableTask
public class SpringCloudTaskTestApplication {

    /**
     * 添加 task任务
     * @return
     */
    @Bean
    public CommandLineRunner commandLineRunner() {
        return new HelloWorldCommandLineRunner();
    }

    /**
     * 绑定 task 监听器
     * @return
     */
    @Bean
    public TaskListener taskListener(){
        return new TaskListener();
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudTaskTestApplication.class, args);
    }


    public static class HelloWorldCommandLineRunner implements CommandLineRunner {

        @Override
        public void run(String... strings) throws Exception {
            System.out.println("Hello, World!");
        }
    }

}
