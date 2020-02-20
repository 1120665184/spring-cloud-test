package top.quyq.task.processor.timestamp;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties
public class TimestampTaskProperties {
    private String format = "yyyy-MM-dd HH:mm:ss:SSS";

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }
}
