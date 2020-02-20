package top.quyq.task.sink;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.MessageChannel;

public interface TaskEventChannels {

    /**
     * Name of the default task events channel.
     */
    String TASK_EVENTS = "task-events";

    @Input(TASK_EVENTS)
    MessageChannel taskEvents();

}
