package ca.bccdcphl.sequencingruns.config.api;

import ca.bccdcphl.sequencingruns.model.aggregates.SequencingInstrumentIllumina;
import ca.bccdcphl.sequencingruns.model.aggregates.SequencingInstrumentNanopore;
import ca.bccdcphl.sequencingruns.repositories.SequencingInstrumentIlluminaRepository;
import ca.bccdcphl.sequencingruns.repositories.SequencingInstrumentNanoporeRepository;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

@Configuration
public class RestApiConfig implements RepositoryRestConfigurer {
    @Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config, CorsRegistry cors) {
        // This disables the default Spring Data REST endpoints, allowing
        // us to control how our endpoints are configured.
        config.disableDefaultExposure();
        config.withEntityLookup()
                .forRepository(SequencingInstrumentIlluminaRepository.class)
                .withIdMapping(SequencingInstrumentIllumina::getInstrumentId)
                .withLookup(SequencingInstrumentIlluminaRepository::findByInstrumentId);
        config.withEntityLookup()
                .forRepository(SequencingInstrumentNanoporeRepository.class)
                .withIdMapping(SequencingInstrumentNanopore::getInstrumentId)
                .withLookup(SequencingInstrumentNanoporeRepository::findByInstrumentId);
    }


}
