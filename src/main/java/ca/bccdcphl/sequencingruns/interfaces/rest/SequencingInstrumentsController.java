package ca.bccdcphl.sequencingruns.interfaces.rest;

import ca.bccdcphl.sequencingruns.domain.model.entities.aggregates.SequencingInstrumentIllumina;
import ca.bccdcphl.sequencingruns.service.SequencingInstrumentIlluminaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController()
@RequestMapping("/instruments")
public class SequencingInstrumentsController {

    private static final Logger log = LoggerFactory.getLogger(SequencingInstrumentsController.class);
    private final SequencingInstrumentIlluminaService illuminaInstrumentService;

    @Autowired
    public SequencingInstrumentsController(SequencingInstrumentIlluminaService illuminaInstrumentService) {
        this.illuminaInstrumentService = illuminaInstrumentService;
    }

    @GetMapping(consumes = MediaType.ALL_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public CollectionModel<SequencingInstrumentIllumina> getInstruments(@Valid RequestEntity request) {

        Iterable<SequencingInstrumentIllumina> illuminaInstruments = illuminaInstrumentService.getInstruments();
        CollectionModel<SequencingInstrumentIllumina> response =  CollectionModel.of(illuminaInstruments);

        return response;
    }
}
