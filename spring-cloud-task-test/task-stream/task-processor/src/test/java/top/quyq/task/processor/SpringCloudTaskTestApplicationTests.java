package top.quyq.task.processor;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.stream.messaging.Processor;
import org.springframework.cloud.stream.test.binder.MessageCollector;
import org.springframework.cloud.task.launcher.TaskLaunchRequest;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.GenericMessage;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = TaskProcessorApplication.class)
class SpringCloudTaskTestApplicationTests {

    private static final String DEFAULT_PAYLOAD = "hello";

    @Autowired
    private Processor channels;

    @Autowired
    private MessageCollector messageCollector;

    private ObjectMapper mapper = new ObjectMapper();

    @Test
    public void test() throws InterruptedException, IOException {

        this.channels.input().send(new GenericMessage<>(DEFAULT_PAYLOAD));
        Map<String, String> properties = new HashMap();
        properties.put("payload", DEFAULT_PAYLOAD);
        TaskLaunchRequest expectedRequest = new TaskLaunchRequest(
                "maven://org.springframework.cloud.task.app:"
                        + "timestamp-task:jar:1.0.1.RELEASE", null, properties,
                null, null);
        Message<String> result = (Message<String>) this.messageCollector
                .forChannel(this.channels.output())
                .take();
        TaskLaunchRequest tlq = this.mapper
                .readValue(result.getPayload(), TaskLaunchRequest.class);
        assertThat(tlq).isEqualTo(expectedRequest);
    }

}
