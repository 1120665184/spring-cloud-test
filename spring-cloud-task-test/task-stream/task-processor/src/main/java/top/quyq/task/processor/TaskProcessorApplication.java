package top.quyq.task.processor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.messaging.Processor;
import org.springframework.messaging.support.GenericMessage;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class TaskProcessorApplication {

    public static void main(String[] args) {
        SpringApplication.run(TaskProcessorApplication.class,args);
    }

    @Autowired
    private Processor channels;


    @GetMapping("/send/{text}")
    public String sendTask(@PathVariable String text){
        this.channels.input().send(new GenericMessage<>(text));
        return "SUCCESS";
    }

}
