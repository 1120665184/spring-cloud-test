package top.quyq.stream.rabbit;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import reactor.core.publisher.Flux;
import top.quyq.stream.entity.People;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

@Configuration
@Slf4j
public class RabbitStreamConfigration {

    public RabbitStreamConfigration(){
        log.info("rabbitStream init...");
    }

    private AtomicBoolean semaphore = new AtomicBoolean(true);


    @Bean
    public Supplier<People> testSource(){
        return () ->{
            People people = new People();
            if(this.semaphore.getAndSet(!this.semaphore.get())){
                people.setAge(16)
                        .setName("bar")
                        .setXingbie("男");
            }else {
                people.setAge(20)
                        .setName("foo")
                        .setXingbie("女");
            }
            return people;
        };
    }

    @Bean
    public Consumer<String> testSink(){
        return payload -> log.info("Data received :" + payload);
    }


    @Bean
    public Function<Flux<People>,Flux<String>> nameUp(){
        return people -> people.map(peo -> peo.getName().toUpperCase());
    }

    @Bean
    public Function<Flux<String> , Flux<String>> nameModify(){
        return nameStr -> nameStr.map(str -> str + "-Modified");
    }


}
