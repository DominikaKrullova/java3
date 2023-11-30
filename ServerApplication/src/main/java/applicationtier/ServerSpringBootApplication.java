package applicationtier;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = {"applicationtier"})
@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class ServerSpringBootApplication
{
    public static void main(String[] args)
    {
        SpringApplication.run(ServerSpringBootApplication.class, args);
    }
}
