package ca.bccdcphl.sequencingruns.config.api;

import ca.bccdcphl.sequencingruns.dto.SequencingInstrumentDTO;
import ca.bccdcphl.sequencingruns.dto.SequencingRunDTO;
import com.toedter.spring.hateoas.jsonapi.JsonApiConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JsonApiConfig {
    @Bean
    JsonApiConfiguration jsonApiConfiguration() {
        JsonApiConfiguration config = new JsonApiConfiguration()
                .withPluralizedTypeRendered(false)
                .withLowerCasedTypeRendered(true)
                .withTypeForClass(SequencingInstrumentDTO.class, "sequencing_instrument")
                .withTypeForClass(SequencingRunDTO.class, "sequencing_run");

        return config;
    }
}
