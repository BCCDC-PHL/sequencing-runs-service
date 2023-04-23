package ca.bccdcphl.sequencingruns.service;

import ca.bccdcphl.sequencingruns.repositories.SequencingInstrumentNanoporeRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;


@ContextConfiguration(classes={
        SequencingInstrumentNanoporeRepository.class
})
public class SequencingInstrumentNanoporeServiceTests {

    @Mock
    private SequencingInstrumentNanoporeRepository repo;

    @Test
    void contextLoads() {
    }
}
