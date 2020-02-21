package top.quyq.task.batch.job.configuration;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JobConfiguration {

    private static final Log logger = LogFactory.getLog(JobConfiguration.class);

    @Autowired
    public JobBuilderFactory jobBuilderFactory;

    @Autowired
    public StepBuilderFactory stepBuilderFactory;

    @Bean
    public Job job1() {
        return this.jobBuilderFactory.get("job1")
                .start(
                        this.stepBuilderFactory.get("job1step1")
                                .tasklet((contribution, chunkContext) -> {
                                    logger.info("job1 was run");
                                    return RepeatStatus.FINISHED;
                                }).build()
                ).build();
    }

    @Bean
    public Job job2(){
        return this.jobBuilderFactory.get("job2")
                .start(
                        this.stepBuilderFactory.get("job2step1")
                        .tasklet((contribution, chunkContext)  -> {
                            logger.info("job2 was run");
                            return RepeatStatus.FINISHED;
                        }).build()
                ).build();
    }



}
