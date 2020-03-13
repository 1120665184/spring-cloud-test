package quyq.top.netflix.ribhys.controller;

import quyq.top.netflix.ribhys.api.User;

public class FallbackMethods {

    public User getUserFallback(){
        User user = new User();
        user.setName("fallback-value");

        return user;
    }

}
