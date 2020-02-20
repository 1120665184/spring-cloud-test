package top.quyq.stream.rabbit;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.EmitterProcessor;
import reactor.core.publisher.Flux;

import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Supplier;

@RestController
@Slf4j
public class RabbitController {

    EmitterProcessor<String> processor = EmitterProcessor.create();

    EmitterProcessor<Message<?>> processor2 = EmitterProcessor.create();

    @PostMapping
    public void controllerToSupplier(@RequestBody String body){
        processor.onNext(body);

    }


    @Bean
    public Supplier<Flux<String>> rabbitControllerSupplier(){
        return () -> processor;
    }

    @Bean
    public Consumer<String> rabbitControllerConsumer(){
        return message -> log.info("controller message : " + message);
    }

    /**
     * 根据消息类型发送到不同的队列中
     * @param body
     */

    @PostMapping("/sendTo")
    public void controllerToSupplier(@RequestBody Map<String,String> body){
        String destinationName = body.get("id");
        Message<?> message = MessageBuilder.withPayload(body)
                .setHeader("spring.cloud.stream.sendto.destination",destinationName)
                .build();
        processor2.onNext(message);
    }

    @Bean
    public Supplier<Flux<Message<?>>> rabbitControllerSupplier1(){
        return () -> processor2;
    }

    @Bean
    public Consumer<Message<?>> rabbitSendToConsumer(){
        return message -> log.info("sendto-rabbit-1 Message:"+message.getPayload().toString());
    }
    @Bean
    public Consumer<Message<?>> rabbitSendToConsumer2(){
        return message -> log.info("sendto-rabbit-2 Message:" + message.getHeaders().toString());
    }


}
