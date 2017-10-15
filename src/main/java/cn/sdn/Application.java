package cn.sdn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


/**
 * Created by L on 2017/10/15.
 */
@SpringBootApplication //开启springboot自动注解
@ComponentScan(basePackages = "cn.sdn")
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
