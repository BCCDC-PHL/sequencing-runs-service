package ca.bccdcphl.sequencingruns.service;

import ca.bccdcphl.sequencingruns.domain.model.entities.aggregates.SequencingRunNanopore;
import ca.bccdcphl.sequencingruns.repositories.SequencingRunNanoporeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SequencingRunNanoporeService {
    @Autowired
    private SequencingRunNanoporeRepository repo;
    public SequencingRunNanopore createSequencingRun(
            String sequencingRunId,
            String instrumentId,
            String flowcellId
    ) {
        SequencingRunNanopore sequencingRun = new SequencingRunNanopore();
        sequencingRun.setSequencingRunId(sequencingRunId);
        sequencingRun.setInstrumentId(instrumentId);
        sequencingRun.setFlowcellId(flowcellId);
        return repo.save(sequencingRun);
    }
}
