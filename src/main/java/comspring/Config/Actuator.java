package comspring.Config;

import org.springframework.boot.actuate.health.CompositeHealthContributor;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;

@Configuration
public class Actuator {

    @Bean
    public HealthIndicator customHealthIndicator() {
        return () -> Health.up().withDetail("customIndicator", "I'm healthy").build();
    }

    @Bean
    public CompositeHealthContributor healthContributor() {
        Map<String, HealthIndicator> healthIndicators = new LinkedHashMap<>();
        healthIndicators.put("customHealthIndicator", customHealthIndicator());
        return CompositeHealthContributor.fromMap(healthIndicators);
    }
}
