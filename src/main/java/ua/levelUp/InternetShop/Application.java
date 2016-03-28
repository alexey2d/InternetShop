package ua.levelUp.InternetShop;

/**
 * Created by java on 15.02.2016.
 */

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

/**
 * Class {@link Application}
 *
 * @author 12341234123412341234123421342134213412342134
 * @version 1.0
 * @since 05.02.16
 */

@SpringBootApplication
@ComponentScan({"ua.levelUp.InternetShop"})
public class Application  extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
