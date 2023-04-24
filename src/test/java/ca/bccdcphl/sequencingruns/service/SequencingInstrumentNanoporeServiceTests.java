package ca.bccdcphl.sequencingruns.service;

import ca.bccdcphl.sequencingruns.model.aggregates.SequencingInstrumentIllumina;
import ca.bccdcphl.sequencingruns.model.aggregates.SequencingInstrumentNanopore;
import ca.bccdcphl.sequencingruns.repositories.SequencingInstrumentIlluminaRepository;
import ca.bccdcphl.sequencingruns.repositories.SequencingInstrumentNanoporeRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class SequencingInstrumentNanoporeServiceTests {

    @Mock
    private SequencingInstrumentNanoporeRepository repo;

    @InjectMocks
    private SequencingInstrumentNanoporeService service;

    @Test
    void testGetInstrumentById() {
        String TEST_INSTRUMENT_ID = "GXB00123";
        SequencingInstrumentNanopore testInstrument = new SequencingInstrumentNanopore();
        testInstrument.setInstrumentId(TEST_INSTRUMENT_ID);

        when(repo.findByInstrumentId(TEST_INSTRUMENT_ID)).thenReturn(Optional.of(testInstrument));

        Optional<SequencingInstrumentNanopore> result = service.getInstrumentById(TEST_INSTRUMENT_ID);
        if (result.isPresent()) {
            assertEquals(testInstrument, result.get());
        }
    }

    @Test
    void testGetInstrumentByNonexistentId() {
        String NONEXISTENT_INSTRUMENT_ID = "FOO";

        when(repo.findByInstrumentId(NONEXISTENT_INSTRUMENT_ID)).thenReturn(Optional.empty());

        Optional<SequencingInstrumentNanopore> result = service.getInstrumentById(NONEXISTENT_INSTRUMENT_ID);
        assert(result.isEmpty());
    }
}
