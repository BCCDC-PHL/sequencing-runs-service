package ca.bccdcphl.sequencingruns.controller;

import ca.bccdcphl.sequencingruns.assembler.SequencingInstrumentIlluminaAssembler;
import ca.bccdcphl.sequencingruns.assembler.SequencingInstrumentNanoporeAssembler;
import ca.bccdcphl.sequencingruns.assembler.SequencingRunIlluminaAssembler;
import ca.bccdcphl.sequencingruns.assembler.SequencingRunNanoporeAssembler;
import ca.bccdcphl.sequencingruns.dto.*;
import ca.bccdcphl.sequencingruns.model.aggregates.SequencingInstrumentIllumina;
import ca.bccdcphl.sequencingruns.model.aggregates.SequencingInstrumentNanopore;
import ca.bccdcphl.sequencingruns.model.aggregates.SequencingRunIllumina;
import ca.bccdcphl.sequencingruns.model.aggregates.SequencingRunNanopore;
import ca.bccdcphl.sequencingruns.service.SequencingInstrumentIlluminaService;
import ca.bccdcphl.sequencingruns.service.SequencingInstrumentNanoporeService;
import ca.bccdcphl.sequencingruns.service.SequencingRunIlluminaService;
import ca.bccdcphl.sequencingruns.service.SequencingRunNanoporeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.RepresentationModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.bind.annotation.*;

import java.util.*;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController()
public class SequencingInstrumentsController  {

    private static final Logger log = LoggerFactory.getLogger(SequencingInstrumentsController.class);
    private final SequencingInstrumentIlluminaService illuminaInstrumentService;
    private final SequencingRunIlluminaService illuminaRunService;
    private final SequencingInstrumentNanoporeService nanoporeInstrumentService;
    private final SequencingRunNanoporeService nanoporeRunService;
    private final SequencingInstrumentIlluminaAssembler illuminaInstrumentAssembler;
    private final SequencingRunIlluminaAssembler illuminaRunAssembler;
    private final SequencingInstrumentNanoporeAssembler nanoporeInstrumentAssembler;
    private final SequencingRunNanoporeAssembler nanoporeRunAssembler;

    @Autowired
    public SequencingInstrumentsController(
            SequencingInstrumentIlluminaService illuminaInstrumentService,
            SequencingRunIlluminaService illuminaRunService,
            SequencingInstrumentNanoporeService nanoporeInstrumentService,
            SequencingRunNanoporeService nanoporeRunService,
            SequencingInstrumentIlluminaAssembler illuminaInstrumentAssembler,
            SequencingRunIlluminaAssembler illuminaRunAssembler,
            SequencingInstrumentNanoporeAssembler nanoporeInstrumentAssembler,
            SequencingRunNanoporeAssembler nanoporeRunAssembler
    ) {
        this.illuminaInstrumentService = illuminaInstrumentService;
        this.illuminaRunService = illuminaRunService;
        this.nanoporeInstrumentService = nanoporeInstrumentService;
        this.nanoporeRunService = nanoporeRunService;
        this.illuminaInstrumentAssembler = illuminaInstrumentAssembler;
        this.illuminaRunAssembler = illuminaRunAssembler;
        this.nanoporeInstrumentAssembler = nanoporeInstrumentAssembler;
        this.nanoporeRunAssembler = nanoporeRunAssembler;
    }

    @GetMapping(value="/instruments")
    public CollectionModel<Object> getInstruments() {
        Collection<Object> emptyCollection = Collections.emptySet();
        CollectionModel<Object> model = CollectionModel.of(emptyCollection);
        Link illuminaLink = Link.of("/instruments/illumina", "illumina_instruments");
        Link nanoporeLink = Link.of("/instruments/nanopore", "nanopore_instruments");
        model.add(illuminaLink);
        model.add(nanoporeLink);

        return model;
    }

    @GetMapping(value="/instruments/illumina", consumes = MediaType.ALL_VALUE, produces = {"application/json", "application/vnd.api+json"})
    public CollectionModel<SequencingInstrumentIlluminaDTO> getIlluminaInstruments() {
        List<SequencingInstrumentIlluminaDTO> instruments = new ArrayList<>();

        Iterable<SequencingInstrumentIllumina> illuminaInstruments = illuminaInstrumentService.getInstruments();
        for (SequencingInstrumentIllumina illuminaInstrument : illuminaInstruments) {
            SequencingInstrumentIlluminaDTO instrumentModel = illuminaInstrumentAssembler.toModel(illuminaInstrument);
            instruments.add(instrumentModel);
        }

        return CollectionModel.of(instruments);
    }

    @GetMapping(value="/instruments/illumina/{instrumentId}", consumes = MediaType.ALL_VALUE, produces = {"application/json", "application/vnd.api+json"})
    public EntityModel<SequencingInstrumentIlluminaDTO> getIlluminaInstrumentById(@PathVariable final String instrumentId) {

        Optional<SequencingInstrumentIllumina> maybeInstrument = illuminaInstrumentService.getInstrumentById(instrumentId);

        if (maybeInstrument.isPresent()) {
            SequencingInstrumentIllumina instrument = maybeInstrument.get();
            return EntityModel.of(illuminaInstrumentAssembler.toModel(instrument));
        } else {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "instrument not found"
            );
        }
    }

    @PostMapping(value="/instruments/illumina/{instrumentId}/status", consumes = {"application/json", "application/vnd.api+json"})
    public EntityModel<SequencingInstrumentIlluminaDTO> postIlluminaInstrumentStatus(@PathVariable final String instrumentId, @RequestBody SequencingInstrumentStatusUpdateDTO statusUpdate) {
        Optional<SequencingInstrumentIllumina> maybeInstrument = illuminaInstrumentService.getInstrumentById(instrumentId);
        if (maybeInstrument.isPresent()) {
            SequencingInstrumentIllumina instrument = maybeInstrument.get();
            SequencingInstrumentIllumina updatedInstrument = illuminaInstrumentService.updateStatus(instrumentId, statusUpdate.getStatus());
            return EntityModel.of(illuminaInstrumentAssembler.toModel(updatedInstrument));
        } else {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "instrument not found"
            );
        }
    }

    @GetMapping(value="/instruments/illumina/{instrumentId}/status", consumes = {"application/json", "application/vnd.api+json"})
    public EntityModel<SequencingInstrumentIlluminaDTO> getIlluminaInstrumentStatus(@PathVariable final String instrumentId) {
        Optional<SequencingInstrumentIllumina> maybeInstrument = illuminaInstrumentService.getInstrumentById(instrumentId);
        if (maybeInstrument.isPresent()) {
            SequencingInstrumentIllumina instrument = maybeInstrument.get();
            return EntityModel.of(illuminaInstrumentAssembler.toModel(instrument));
        } else {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "instrument not found"
            );
        }
    }

    @GetMapping(value="/instruments/illumina/{instrumentId}/sequencing-runs", consumes = MediaType.ALL_VALUE, produces = {"application/json", "application/vnd.api+json"})
    public CollectionModel<SequencingRunIlluminaDTO> getIlluminaSequencingRunsByInstrumentId(@PathVariable final String instrumentId) {

        Optional<SequencingInstrumentIllumina> maybeInstrument = illuminaInstrumentService.getInstrumentById(instrumentId);
        Iterable<SequencingRunIllumina> sequencingRuns = illuminaRunService.getSequencingRunsByInstrumentId(instrumentId);
        List<SequencingRunIlluminaDTO> runs = new ArrayList<>();

        if (maybeInstrument.isPresent()) {
            for (SequencingRunIllumina illuminaRun : sequencingRuns) {
                SequencingRunIlluminaDTO runModel = illuminaRunAssembler.toModel(illuminaRun);
                runs.add(runModel);
            }
            return CollectionModel.of(runs);

        } else {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "instrument not found"
            );
        }
    }

    @GetMapping(value="/instruments/nanopore", consumes = MediaType.ALL_VALUE, produces = {"application/json", "application/vnd.api+json"})
    public CollectionModel<SequencingInstrumentNanoporeDTO> getNanoporeInstruments() {

        List<SequencingInstrumentNanoporeDTO> instruments = new ArrayList<>();
        Iterable<SequencingInstrumentNanopore> nanoporeInstruments = nanoporeInstrumentService.getInstruments();

        for (SequencingInstrumentNanopore nanoporeInstrument : nanoporeInstruments) {
            SequencingInstrumentNanoporeDTO instrumentModel = nanoporeInstrumentAssembler.toModel(nanoporeInstrument);
            instruments.add(instrumentModel);
        }

        return CollectionModel.of(instruments);
    }

    @GetMapping(value="/instruments/nanopore/{instrumentId}", consumes = MediaType.ALL_VALUE, produces = {"application/json", "application/vnd.api+json"})
    public EntityModel<SequencingInstrumentNanoporeDTO> getNanoporeInstrumentById(@PathVariable final String instrumentId) {

        Optional<SequencingInstrumentNanopore> maybeInstrument = nanoporeInstrumentService.getInstrumentById(instrumentId);

        if (maybeInstrument.isPresent()) {
            SequencingInstrumentNanopore instrument = maybeInstrument.get();
            return EntityModel.of(nanoporeInstrumentAssembler.toModel(instrument));
        } else {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "instrument not found"
            );
        }
    }

    @PostMapping(value="/instruments/nanopore/{instrumentId}/status", consumes = {"application/json", "application/vnd.api+json"})
    public EntityModel<SequencingInstrumentNanoporeDTO> postNanoporeInstrumentStatus(@PathVariable final String instrumentId, @RequestBody SequencingInstrumentStatusUpdateDTO statusUpdate) {
        Optional<SequencingInstrumentNanopore> maybeInstrument = nanoporeInstrumentService.getInstrumentById(instrumentId);
        if (maybeInstrument.isPresent()) {
            SequencingInstrumentNanopore instrument = maybeInstrument.get();
            SequencingInstrumentNanopore updatedInstrument = nanoporeInstrumentService.updateStatus(instrumentId, statusUpdate.getStatus());
            return EntityModel.of(nanoporeInstrumentAssembler.toModel(updatedInstrument));
        } else {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "instrument not found"
            );
        }
    }

    @GetMapping(value="/instruments/nanopore/{instrumentId}/status", consumes = {"application/json", "application/vnd.api+json"})
    public EntityModel<SequencingInstrumentNanoporeDTO> getNanoporeInstrumentStatus(@PathVariable final String instrumentId) {
        Optional<SequencingInstrumentNanopore> maybeInstrument = nanoporeInstrumentService.getInstrumentById(instrumentId);
        if (maybeInstrument.isPresent()) {
            SequencingInstrumentNanopore instrument = maybeInstrument.get();
            return EntityModel.of(nanoporeInstrumentAssembler.toModel(instrument));
        } else {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "instrument not found"
            );
        }
    }

    @GetMapping(value="/instruments/nanopore/{instrumentId}/sequencing-runs", consumes = MediaType.ALL_VALUE, produces = {"application/json", "application/vnd.api+json"})
    public CollectionModel<SequencingRunNanoporeDTO> getNanoporeSequencingRunsByInstrumentId(@PathVariable final String instrumentId) {

        Optional<SequencingInstrumentNanopore> instrument = nanoporeInstrumentService.getInstrumentById(instrumentId);
        Iterable<SequencingRunNanopore> sequencingRuns = nanoporeRunService.getSequencingRunsByInstrumentId(instrumentId);
        List<SequencingRunNanoporeDTO> runs = new ArrayList<>();

        if (instrument.isPresent()) {
            for (SequencingRunNanopore nanoporeRun : sequencingRuns) {
                SequencingRunNanoporeDTO runModel = nanoporeRunAssembler.toModel(nanoporeRun);
                runs.add(runModel);
            }
            return CollectionModel.of(runs);

        } else {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "instrument not found"
            );
        }
    }

}
