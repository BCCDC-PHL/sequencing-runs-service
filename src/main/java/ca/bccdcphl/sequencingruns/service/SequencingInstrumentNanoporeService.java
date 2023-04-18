package ca.bccdcphl.sequencingruns.service;

import ca.bccdcphl.sequencingruns.domain.model.entities.aggregates.SequencingInstrumentNanopore;
import ca.bccdcphl.sequencingruns.repositories.SequencingInstrumentNanoporeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SequencingInstrumentNanoporeService {
    @Autowired
    private SequencingInstrumentNanoporeRepository repo;
    public SequencingInstrumentNanopore createInstrument(String instrumentId, String type, String model) {
        SequencingInstrumentNanopore instrument = new SequencingInstrumentNanopore();
        instrument.setInstrumentId(instrumentId);
        instrument.setType(type);
        instrument.setModel(model);
        return repo.save(instrument);
    }
}
