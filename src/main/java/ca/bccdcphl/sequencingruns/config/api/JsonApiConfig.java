package ca.bccdcphl.sequencingruns.config.api;

import ca.bccdcphl.sequencingruns.dto.*;
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
                .withTypeForClass(SequencingInstrumentIlluminaDTO.class, "illumina_sequencing_instrument")
                .withTypeForClass(SequencingInstrumentNanoporeDTO.class, "nanopore_sequencing_instrument")
                .withTypeForClass(SequencingRunIlluminaDTO.class, "illumina_sequencing_run")
                .withTypeForClass(SequencingRunIlluminaDemultiplexingDTO.class, "illumina_sequencing_run_demultiplexing")
                .withTypeForClass(SequencingRunNanoporeDTO.class, "nanopore_sequencing_run");

        return config;
    }
}
