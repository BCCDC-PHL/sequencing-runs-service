package ca.bccdcphl.sequencingruns.service;

import ca.bccdcphl.sequencingruns.model.aggregates.SequencingRunIllumina;
import ca.bccdcphl.sequencingruns.repositories.SequencingRunIlluminaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SequencingRunIlluminaService {

    @Autowired
    private SequencingRunIlluminaRepository repo;

    public SequencingRunIllumina createSequencingRun(
            String sequencingRunId,
            String instrumentId,
            String flowcellId
    ) {
        SequencingRunIllumina sequencingRun = new SequencingRunIllumina();
        sequencingRun.setSequencingRunId(sequencingRunId);
        sequencingRun.setInstrumentId(instrumentId);
        sequencingRun.setFlowcellId(flowcellId);
        return repo.save(sequencingRun);
    }

    public Iterable<SequencingRunIllumina> getSequencingRuns() {
        return repo.findAll();
    }

    public Optional<SequencingRunIllumina> getSequencingRunById(final String sequencingRunId) {
        return repo.findBySequencingRunId(sequencingRunId);
    }

    public Iterable<SequencingRunIllumina> getSequencingRunsByInstrumentId(final String instrumentId) {
        return repo.findAllByInstrumentId(instrumentId);
    }

}
