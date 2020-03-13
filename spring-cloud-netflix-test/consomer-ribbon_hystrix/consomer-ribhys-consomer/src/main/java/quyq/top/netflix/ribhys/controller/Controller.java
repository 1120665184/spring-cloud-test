package quyq.top.netflix.ribhys.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import quyq.top.netflix.ribhys.api.User;

@RestController
public class Controller extends FallbackMethods {

    private static Log logger = LogFactory.getLog(Controller.class);

    @Autowired
    private RestTemplate restTemplate;

    final private String USER_SERVICE_NAME = "http://consomer-ribhys-provider";

    @GetMapping("/getUser")
    @HystrixCommand(fallbackMethod = "getUserFallback")
    public User getUser(){
        return restTemplate.getForObject(USER_SERVICE_NAME + "/getUser",User.class);
    }


}
