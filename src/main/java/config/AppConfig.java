package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@ComponentScan("controllers")
public class AppConfig {
        @Bean
        public InternalResourceViewResolver internalResourceViewResolver() {

            InternalResourceViewResolver internalResourceViewResolver = new InternalResourceViewResolver();

            internalResourceViewResolver.setPrefix("/WEB-INF/views/");
            internalResourceViewResolver.setSuffix(".jsp");

            return internalResourceViewResolver;
        }


}
