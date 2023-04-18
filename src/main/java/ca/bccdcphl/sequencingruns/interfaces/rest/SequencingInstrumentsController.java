package ca.bccdcphl.sequencingruns.interfaces.rest;

import ca.bccdcphl.sequencingruns.domain.model.entities.aggregates.SequencingInstrumentIllumina;
import ca.bccdcphl.sequencingruns.service.SequencingInstrumentIlluminaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController()
public class SequencingInstrumentsController {

    private static final Logger log = LoggerFactory.getLogger(SequencingInstrumentsController.class);
    private final SequencingInstrumentIlluminaService illuminaInstrumentService;

    @Autowired
    public SequencingInstrumentsController(SequencingInstrumentIlluminaService illuminaInstrumentService) {
        this.illuminaInstrumentService = illuminaInstrumentService;
    }

    @GetMapping(value="/instruments", consumes = MediaType.ALL_VALUE, produces = {"application/json", "application/vnd.api+json"})
    public CollectionModel<SequencingInstrumentIllumina> getInstruments() {
        return CollectionModel.of(illuminaInstrumentService.getInstruments());
    }

    @GetMapping(value="/instruments/{instrumentId}", consumes = MediaType.ALL_VALUE, produces = {"application/json", "application/vnd.api+json"})
    public EntityModel<SequencingInstrumentIllumina> getInstrumentById(@PathVariable final String instrumentId) {
        EntityModel<SequencingInstrumentIllumina> response;
        Optional<SequencingInstrumentIllumina> illuminaInstrument = illuminaInstrumentService.getInstrumentById(instrumentId);
        response = illuminaInstrument.map(EntityModel::of).orElseGet(() -> EntityModel.of(null));

        return response;
    }


}
