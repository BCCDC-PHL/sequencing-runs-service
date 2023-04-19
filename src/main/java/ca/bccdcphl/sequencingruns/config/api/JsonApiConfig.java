package ca.bccdcphl.sequencingruns.config.api;

import ca.bccdcphl.sequencingruns.dto.SequencingInstrumentDTO;
import com.toedter.spring.hateoas.jsonapi.JsonApiConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JsonApiConfig {
    @Bean
    JsonApiConfiguration jsonApiConfiguration() {
        JsonApiConfiguration config = new JsonApiConfiguration();
        config.withPluralizedTypeRendered(false)
                .withLowerCasedTypeRendered(true)
                .withTypeForClass(SequencingInstrumentDTO.class, "sequencing_instrument");
        return config;
    }
}
