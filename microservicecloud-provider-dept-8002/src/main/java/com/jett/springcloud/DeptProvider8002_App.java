package com.jett.springcloud;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@EnableDiscoveryClient
@SpringBootApplication
@EnableSwagger2
@ServletComponentScan
@Slf4j
public class DeptProvider8002_App {
    public static void main(String[] args)
    {
        SpringApplication.run(DeptProvider8002_App.class, args);
        log.debug("DeptProvider8002_App启动完成!");
    }
}
