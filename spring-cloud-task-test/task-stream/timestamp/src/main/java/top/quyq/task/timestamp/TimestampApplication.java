package top.quyq.task.timestamp;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.task.configuration.EnableTask;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@EnableTask
@SpringBootApplication
@EnableConfigurationProperties({TimestampTaskProperties.class})
public class TimestampApplication {

    private static final Log logger = LogFactory.getLog(TimestampApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(TimestampApplication.class, args);
    }

    @Bean
    public TimestampTask timestampTask() {
        return new TimestampTask();
    }


    public static class TimestampTask implements CommandLineRunner {

        @Autowired
        private TimestampTaskProperties properties;

        @Override
        public void run(String... args) throws Exception {
            logger.info(LocalDateTime.now().format(DateTimeFormatter.ofPattern(properties.getFormat())));
        }
    }


}
