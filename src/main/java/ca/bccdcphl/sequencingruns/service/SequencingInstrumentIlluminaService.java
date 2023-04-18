package ca.bccdcphl.sequencingruns.service;

import ca.bccdcphl.sequencingruns.domain.model.entities.aggregates.SequencingInstrumentIllumina;
import ca.bccdcphl.sequencingruns.repositories.SequencingInstrumentIlluminaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SequencingInstrumentIlluminaService {
    @Autowired
    private SequencingInstrumentIlluminaRepository repo;

    public SequencingInstrumentIllumina createInstrument(String instrumentId, String type, String model) {
        SequencingInstrumentIllumina instrument = new SequencingInstrumentIllumina();
        instrument.setInstrumentId(instrumentId);
        instrument.setType(type);
        instrument.setModel(model);
        return repo.save(instrument);
    }

    public Iterable<SequencingInstrumentIllumina> getInstruments() {
        return repo.findAll();
    }

    public Optional<SequencingInstrumentIllumina> getInstrumentById(final String instrumentId) {
        return repo.findByInstrumentId(instrumentId);
    }


}
