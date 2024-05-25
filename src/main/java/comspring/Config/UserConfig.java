package comspring.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.ui.ModelMap;

@Configuration
public class UserConfig {
    @Bean
    public ModelMap modelMap() {
        return new ModelMap();
    }
}
