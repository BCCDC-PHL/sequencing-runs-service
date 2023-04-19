package ca.bccdcphl.sequencingruns.service;

import ca.bccdcphl.sequencingruns.model.aggregates.SequencingInstrumentIllumina;
import ca.bccdcphl.sequencingruns.repositories.SequencingInstrumentIlluminaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
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

    public SequencingInstrumentIllumina updateStatus(final String instrumentId, final String status) {
        Optional<SequencingInstrumentIllumina> maybeInstrument = this.getInstrumentById(instrumentId);
        if (maybeInstrument.isPresent()) {
            SequencingInstrumentIllumina instrument = maybeInstrument.get();
            instrument.setStatus(status);
            return repo.save(instrument);
        } else {
            throw new EntityNotFoundException("Instrument not found for id: " + instrumentId);
        }
    }

}
