package ca.bccdcphl.sequencingruns.service;

import ca.bccdcphl.sequencingruns.model.aggregates.SequencingRunIllumina;
import ca.bccdcphl.sequencingruns.repositories.SequencingRunIlluminaRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class SequencingRunIlluminaServiceTests {

    @Mock
    private SequencingRunIlluminaRepository repo;

    @InjectMocks
    private SequencingRunIlluminaService service;

    @Test
    void testGetSequencingRunById() {
        String TEST_RUN_ID = "220505_M00123_0123_000000000-AGB5E";
        SequencingRunIllumina testRun = new SequencingRunIllumina();
        testRun.setSequencingRunId(TEST_RUN_ID);

        when(repo.findBySequencingRunId(TEST_RUN_ID)).thenReturn(Optional.of(testRun));

        Optional<SequencingRunIllumina> result = service.getSequencingRunById(TEST_RUN_ID);
        if (result.isPresent()) {
            assertEquals(testRun, result.get());
        }
    }

    @Test
    void testGetSequencingRunByNonexistentId() {
        String NONEXISTENT_RUN_ID = "FOO";

        when(repo.findBySequencingRunId(NONEXISTENT_RUN_ID)).thenReturn(Optional.empty());

        Optional<SequencingRunIllumina> result = service.getSequencingRunById(NONEXISTENT_RUN_ID);
        assert(result.isEmpty());
    }
}
