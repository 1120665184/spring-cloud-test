package top.quyq.task.sink;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.task.launcher.annotation.EnableTaskLauncher;
import org.springframework.cloud.task.repository.TaskExecution;
import org.springframework.context.annotation.Bean;

import java.util.function.Consumer;

@SpringBootApplication
@EnableTaskLauncher
@EnableBinding(TaskEventChannels.class)
public class SinkApplication {

    private static final Log logger = LogFactory.getLog(SinkApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(SinkApplication.class,args);
    }

    /**
     * 监听task 放入 Stream中的事件。
     * 需将timestamp项目打包进本地maven库，在 task-processor项目中调用 /send/{text} 接口。
     * 或者直接运行timestamp项目
     * @param payload
     */
    @StreamListener(TaskEventChannels.TASK_EVENTS)
    public void receiveTaskEvent(Object payload){
       logger.info("task event :" + payload.toString());
    }

}
