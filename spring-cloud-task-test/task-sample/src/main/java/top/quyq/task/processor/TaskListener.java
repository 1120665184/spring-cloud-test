package top.quyq.task.processor;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.cloud.task.listener.annotation.AfterTask;
import org.springframework.cloud.task.listener.annotation.BeforeTask;
import org.springframework.cloud.task.listener.annotation.FailedTask;
import org.springframework.cloud.task.repository.TaskExecution;

public class TaskListener {

    private static final Log logger = LogFactory.getLog(TaskListener.class);

    @BeforeTask
    public void methodBefore(TaskExecution execution) {
        logger.info("task Listener before");
    }

    @AfterTask
    public void methodAfter(TaskExecution execution) {
        logger.info("task Listener after");
    }

    @FailedTask
    public void methodFailed(TaskExecution execution) {
        logger.info("task Listener failed");
    }

}
