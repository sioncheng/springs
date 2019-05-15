package com.github.sioncheng.springs.webclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class App1 {

    public static void main(String[] args) {
        SpringApplication.run(App1.class);

        RestTemplate restTemplate = new RestTemplate();

        String res = restTemplate.getForObject("http://www.baidu.com", String.class);

        System.out.println(res);
    }
}
