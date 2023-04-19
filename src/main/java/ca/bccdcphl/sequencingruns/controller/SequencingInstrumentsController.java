package ca.bccdcphl.sequencingruns.controller;

import ca.bccdcphl.sequencingruns.assembler.SequencingInstrumentAssembler;
import ca.bccdcphl.sequencingruns.dto.SequencingInstrumentDTO;
import ca.bccdcphl.sequencingruns.model.aggregates.SequencingInstrumentIllumina;
import ca.bccdcphl.sequencingruns.model.aggregates.SequencingInstrumentNanopore;
import ca.bccdcphl.sequencingruns.service.SequencingInstrumentIlluminaService;
import ca.bccdcphl.sequencingruns.service.SequencingInstrumentNanoporeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController()
public class SequencingInstrumentsController  {

    private static final Logger log = LoggerFactory.getLogger(SequencingInstrumentsController.class);
    private final SequencingInstrumentIlluminaService illuminaInstrumentService;
    private final SequencingInstrumentNanoporeService nanoporeInstrumentService;
    private final SequencingInstrumentAssembler assembler;


    @Autowired
    public SequencingInstrumentsController(
            SequencingInstrumentIlluminaService illuminaInstrumentService,
            SequencingInstrumentNanoporeService nanoporeInstrumentService,
            SequencingInstrumentAssembler assembler
    ) {
        this.illuminaInstrumentService = illuminaInstrumentService;
        this.nanoporeInstrumentService = nanoporeInstrumentService;
        this.assembler = assembler;
    }

    @GetMapping(value="/instruments", consumes = MediaType.ALL_VALUE, produces = {"application/json", "application/vnd.api+json"})
    public CollectionModel<SequencingInstrumentDTO> getInstruments() {
        List<SequencingInstrumentDTO> instruments = new ArrayList<SequencingInstrumentDTO>();
        Iterable<SequencingInstrumentIllumina> illuminaInstruments = illuminaInstrumentService.getInstruments();
        for (SequencingInstrumentIllumina illuminaInstrument : illuminaInstruments) {
            SequencingInstrumentDTO instrumentModel = assembler.toModel(illuminaInstrument);
            instruments.add(instrumentModel);
        }

        Iterable<SequencingInstrumentNanopore> nanoporeInstruments = nanoporeInstrumentService.getInstruments();
        for (SequencingInstrumentNanopore nanoporeInstrument : nanoporeInstruments) {
            SequencingInstrumentDTO instrumentModel = assembler.toModel(nanoporeInstrument);
            instruments.add(instrumentModel);
        }

        return CollectionModel.of(instruments);
    }

    @GetMapping(value="/instruments/{instrumentId}", consumes = MediaType.ALL_VALUE, produces = {"application/json", "application/vnd.api+json"})
    public EntityModel<SequencingInstrumentIllumina> getInstrumentById(@PathVariable final String instrumentId) {
        EntityModel<SequencingInstrumentIllumina> response;
        Optional<SequencingInstrumentIllumina> illuminaInstrument = illuminaInstrumentService.getInstrumentById(instrumentId);
        response = illuminaInstrument.map(EntityModel::of).orElseGet(() -> EntityModel.of(null));

        return response;
    }


}
