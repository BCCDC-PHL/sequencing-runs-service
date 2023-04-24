package ca.bccdcphl.sequencingruns.service;

import ca.bccdcphl.sequencingruns.model.aggregates.SequencingInstrumentIllumina;
import ca.bccdcphl.sequencingruns.repositories.SequencingInstrumentIlluminaRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class SequencingInstrumentIlluminaServiceTests {

    @Mock
    private SequencingInstrumentIlluminaRepository repo;

    @InjectMocks
    private SequencingInstrumentIlluminaService service;

    @Test
    void testGetInstrumentById() {
        String TEST_INSTRUMENT_ID = "M00123";
        SequencingInstrumentIllumina testInstrument = new SequencingInstrumentIllumina();
        testInstrument.setInstrumentId(TEST_INSTRUMENT_ID);

        when(repo.findByInstrumentId(TEST_INSTRUMENT_ID)).thenReturn(Optional.of(testInstrument));

        Optional<SequencingInstrumentIllumina> result = service.getInstrumentById(TEST_INSTRUMENT_ID);
        if (result.isPresent()) {
            assertEquals(testInstrument, result.get());
        }
    }

    @Test
    void testGetInstrumentByNonexistentId() {
        String NONEXISTENT_INSTRUMENT_ID = "FOO";

        when(repo.findByInstrumentId(NONEXISTENT_INSTRUMENT_ID)).thenReturn(Optional.empty());

        Optional<SequencingInstrumentIllumina> result = service.getInstrumentById(NONEXISTENT_INSTRUMENT_ID);
        assert(result.isEmpty());
    }
}
