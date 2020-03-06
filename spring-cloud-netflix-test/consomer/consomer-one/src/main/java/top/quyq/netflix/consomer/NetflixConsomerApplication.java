package top.quyq.netflix.consomer;

import com.netflix.discovery.EurekaClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class NetflixConsomerApplication {

    public static void main(String[] args) {
        SpringApplication.run(NetflixConsomerApplication.class,args);
    }

    //netflix 原生获取发现服务客户端
    @Autowired
    private EurekaClient eurekaClient;
    //spring 封装后的方法
    @Autowired
    private DiscoveryClient discoveryClient;

    @GetMapping("/eurekaInfo")
    public Object getEurekaInfo(){
        return eurekaClient.getNextServerFromEureka("consomer-one",false);
    }

    @GetMapping("/discoveryInfo")
    public Object getServerInfo(){
        return discoveryClient.getInstances("consomer-one");
    }

}
