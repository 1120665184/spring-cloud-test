package top.quyq.task.processor;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Processor;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.cloud.task.launcher.TaskLaunchRequest;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.annotation.Transformer;
import org.springframework.messaging.support.GenericMessage;
import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.Map;

@EnableBinding(Processor.class)
@EnableConfigurationProperties(TaskProcessorProperties.class)
public class TaskProcessor {
    private static final Log logger = LogFactory.getLog(TaskProcessor.class);

    public TaskProcessor(){
        logger.debug("加载。。。");
    }

    @Autowired
    private TaskProcessorProperties properties;

    @Transformer(inputChannel = Processor.INPUT, outputChannel = Processor.OUTPUT)
    public Object setupRequest(String message) {

        logger.debug(message);

        Map<String, String> properties = new HashMap<>();
        if (StringUtils.hasText(this.properties.getDataSourceUrl())) {
            properties
                    .put("spring_datasource_url", this.properties
                            .getDataSourceUrl());
        }
        if (StringUtils
                .hasText(this.properties.getDataSourceDriverClassName())) {
            properties.put("spring_datasource_driverClassName", this.properties
                    .getDataSourceDriverClassName());
        }
        if (StringUtils.hasText(this.properties.getDataSourceUserName())) {
            properties.put("spring_datasource_username", this.properties
                    .getDataSourceUserName());
        }
        if (StringUtils.hasText(this.properties.getDataSourcePassword())) {
            properties.put("spring_datasource_password", this.properties
                    .getDataSourcePassword());
        }
        properties.put("payload", message);

        TaskLaunchRequest request = new TaskLaunchRequest(
                this.properties.getUri(), null, properties, null,
                this.properties.getApplicationName());

        return new GenericMessage<>(request);
    }

}
