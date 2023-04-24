package ca.bccdcphl.sequencingruns.service;

import ca.bccdcphl.sequencingruns.model.aggregates.SequencingRunNanopore;
import ca.bccdcphl.sequencingruns.repositories.SequencingRunNanoporeRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class SequencingRunNanoporeServiceTests {

    @Mock
    private SequencingRunNanoporeRepository repo;

    @InjectMocks
    private SequencingRunNanoporeService service;

    @Test
    void testGetSequencingRunById() {
        String TEST_RUN_ID = "20220630_1328_X2_ADR136_a3962c67";
        SequencingRunNanopore testRun = new SequencingRunNanopore();
        testRun.setSequencingRunId(TEST_RUN_ID);

        when(repo.findBySequencingRunId(TEST_RUN_ID)).thenReturn(Optional.of(testRun));

        Optional<SequencingRunNanopore> result = service.getSequencingRunById(TEST_RUN_ID);
        if (result.isPresent()) {
            assertEquals(testRun, result.get());
        }
    }

    @Test
    void testGetSequencingRunByNonexistentId() {
        String NONEXISTENT_RUN_ID = "FOO";

        when(repo.findBySequencingRunId(NONEXISTENT_RUN_ID)).thenReturn(Optional.empty());

        Optional<SequencingRunNanopore> result = service.getSequencingRunById(NONEXISTENT_RUN_ID);
        assert(result.isEmpty());
    }
}
