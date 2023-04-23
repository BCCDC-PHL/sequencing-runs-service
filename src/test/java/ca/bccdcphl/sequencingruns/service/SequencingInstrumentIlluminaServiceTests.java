package ca.bccdcphl.sequencingruns.service;

import ca.bccdcphl.sequencingruns.repositories.SequencingInstrumentIlluminaRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

@SpringBootTest
@ContextConfiguration(classes={
        SequencingInstrumentIlluminaRepository.class
})
public class SequencingInstrumentIlluminaServiceTests {

    @Mock
    private SequencingInstrumentIlluminaRepository repo;

    @Test
    void contextLoads() {
    }
}
