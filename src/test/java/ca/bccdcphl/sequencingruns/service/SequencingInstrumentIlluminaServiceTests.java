package ca.bccdcphl.sequencingruns.service;

import ca.bccdcphl.sequencingruns.repositories.SequencingInstrumentIlluminaRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

@ContextConfiguration(classes={
        SequencingInstrumentIlluminaRepository.class
})
public class SequencingInstrumentIlluminaServiceTests {

    @InjectMocks
    private SequencingInstrumentIlluminaService service;

    @Mock
    private SequencingInstrumentIlluminaRepository repo;

    @Test
    void contextLoads() {
    }
}
