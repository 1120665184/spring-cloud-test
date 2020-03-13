package quyq.top.netflix.ribhys.controller;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import quyq.top.netflix.ribhys.api.User;

@RestController
public class GetRequestController {


    private static final Log logger = LogFactory.getLog(GetRequestController.class);

    @GetMapping("/getUser")
    public User hello() {
        User user = new User();
        user.setName("cluster-two");
        user.setAge(20);
        user.setOther("other value");
        logger.debug("/getUser user:" + user.toString());
        return user;
    }


}
