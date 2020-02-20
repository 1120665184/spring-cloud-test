package top.quyq.task.processor;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("spring")
public class TaskProcessorProperties {

    //private static final String DEFAULT_URI = "maven://org.springframework.cloud.task.app:"
     //       + "timestamp-task:jar:1.0.1.RELEASE";

    private static final String DEFAULT_URI = "maven://top.quyq:"
            + "timestamp:jar:0.0.1-SNAPSHOT";

    private String uri = DEFAULT_URI;

    private String dataSourceUrl;

    private String dataSourceDriverClassName;

    private String dataSourceUserName;

    private String dataSourcePassword;

    private String applicationName;

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public String getDataSourceUrl() {
        return dataSourceUrl;
    }

    public void setDataSourceUrl(String dataSourceUrl) {
        this.dataSourceUrl = dataSourceUrl;
    }

    public String getDataSourceDriverClassName() {
        return dataSourceDriverClassName;
    }

    public void setDataSourceDriverClassName(String dataSourceDriverClassName) {
        this.dataSourceDriverClassName = dataSourceDriverClassName;
    }

    public String getDataSourceUserName() {
        return dataSourceUserName;
    }

    public void setDataSourceUserName(String dataSourceUserName) {
        this.dataSourceUserName = dataSourceUserName;
    }

    public String getDataSourcePassword() {
        return dataSourcePassword;
    }

    public void setDataSourcePassword(String dataSourcePassword) {
        this.dataSourcePassword = dataSourcePassword;
    }

    public String getApplicationName() {
        return applicationName;
    }

    public void setApplicationName(String applicationName) {
        this.applicationName = applicationName;
    }
}
