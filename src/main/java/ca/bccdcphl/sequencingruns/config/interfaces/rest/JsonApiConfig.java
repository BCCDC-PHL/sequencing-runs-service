package ca.bccdcphl.sequencingruns.config.interfaces.rest;

import com.toedter.spring.hateoas.jsonapi.JsonApiConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JsonApiConfig {
    @Bean
    JsonApiConfiguration jsonApiConfiguration() {
        return new JsonApiConfiguration()
                .withPluralizedTypeRendered(false)
                .withLowerCasedTypeRendered(true);
    }
}
