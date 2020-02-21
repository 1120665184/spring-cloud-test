package top.quyq.task.batch.partitioned;


import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.task.configuration.EnableTask;

@EnableTask
@SpringBootApplication
@EnableBatchProcessing
public class BatchPartitionedApplication {
    public static void main(String[] args) {
        SpringApplication.run(BatchPartitionedApplication.class);
    }
}
