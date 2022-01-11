package project.sw.NilkhetJai;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class NilkhetJaiApplication {

    /**
     * main funtion start NilkhetJaiApplication
     * 
     * @param args
     */

    public static void main(String[] args) {
        SpringApplication.run(NilkhetJaiApplication.class, args);
    }

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
