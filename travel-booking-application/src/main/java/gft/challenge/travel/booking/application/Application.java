package gft.challenge.travel.booking.application;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "gft.challenge.travel.booking")
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
