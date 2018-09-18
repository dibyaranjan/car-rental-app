package gcom.dr.carrental.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;

@EnableAutoConfiguration
@ComponentScan("gcom.dr.carrental")
public class Main {
    public static void main(String... args) {
        SpringApplication.run(Main.class);

    }
}
