package top.quyq.config.client.samp;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class SampConfigClientApplication {


    @Value("${foo.bar}")
    private String bar;


    public static void main(String[] args) {
        SpringApplication.run(SampConfigClientApplication.class, args);
    }

    @GetMapping("/getBar")
    public String getBarVal() {
        return bar;
    }

}
