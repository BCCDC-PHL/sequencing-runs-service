package ca.bccdcphl.sequencingruns.controller;

import ca.bccdcphl.sequencingruns.assembler.SequencingRunIlluminaAssembler;
import ca.bccdcphl.sequencingruns.assembler.SequencingRunNanoporeAssembler;
import ca.bccdcphl.sequencingruns.dto.SequencingRunIlluminaDTO;
import ca.bccdcphl.sequencingruns.dto.SequencingRunNanoporeDTO;
import ca.bccdcphl.sequencingruns.model.aggregates.SequencingRunIllumina;
import ca.bccdcphl.sequencingruns.model.aggregates.SequencingRunNanopore;
import ca.bccdcphl.sequencingruns.service.SequencingRunIlluminaService;
import ca.bccdcphl.sequencingruns.service.SequencingRunNanoporeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController()
public class SequencingRunsController {

    private static final Logger log = LoggerFactory.getLogger(SequencingRunsController.class);
    private final SequencingRunIlluminaService illuminaRunService;
    private final SequencingRunNanoporeService nanoporeRunService;
    private final SequencingRunIlluminaAssembler illuminaAssembler;
    private final SequencingRunNanoporeAssembler nanoporeAssembler;

    @Autowired
    public SequencingRunsController(
            SequencingRunIlluminaService illuminaRunService,
            SequencingRunNanoporeService nanoporeRunService,
            SequencingRunIlluminaAssembler illuminaAssembler,
            SequencingRunNanoporeAssembler nanoporeAssembler
    ) {
        this.illuminaRunService = illuminaRunService;
        this.nanoporeRunService = nanoporeRunService;
        this.illuminaAssembler = illuminaAssembler;
        this.nanoporeAssembler = nanoporeAssembler;
    }

    @GetMapping(value="/sequencing-runs/illumina", consumes = MediaType.ALL_VALUE, produces = {"application/json", "application/vnd.api+json"})
    public CollectionModel<SequencingRunIlluminaDTO> getIlluminaSequencingRuns() {
        List<SequencingRunIlluminaDTO> runs = new ArrayList<>();

        Iterable<SequencingRunIllumina> illuminaRuns = illuminaRunService.getSequencingRuns();
        for (SequencingRunIllumina illuminaRun : illuminaRuns) {
            SequencingRunIlluminaDTO runModel = illuminaAssembler.toModel(illuminaRun);
            runs.add(runModel);
        }

        return CollectionModel.of(runs);
    }

    @GetMapping(value="/sequencing-runs/illumina/{sequencingRunId}", consumes = MediaType.ALL_VALUE, produces = {"application/json", "application/vnd.api+json"})
    public EntityModel<SequencingRunIlluminaDTO> getIlluminaSequencingRunById(@PathVariable final String sequencingRunId) {

        Optional<SequencingRunIllumina> illuminaRun = illuminaRunService.getSequencingRunById(sequencingRunId);

        if (illuminaRun.isPresent()) {
            return EntityModel.of(illuminaAssembler.toModel(illuminaRun.get()));
        } else {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "sequencing run not found"
            );
        }
    }

    @GetMapping(value="/sequencing-runs/nanopore", consumes = MediaType.ALL_VALUE, produces = {"application/json", "application/vnd.api+json"})
    public CollectionModel<SequencingRunNanoporeDTO> getNanoporeSequencingRuns() {
        List<SequencingRunNanoporeDTO> runs = new ArrayList<>();

        Iterable<SequencingRunNanopore> nanoporeRuns = nanoporeRunService.getSequencingRuns();
        for (SequencingRunNanopore nanoporeRun : nanoporeRuns) {
            SequencingRunNanoporeDTO runModel = nanoporeAssembler.toModel(nanoporeRun);
            runs.add(runModel);
        }

        return CollectionModel.of(runs);
    }

    @GetMapping(value="/sequencing-runs/nanopore/{sequencingRunId}", consumes = MediaType.ALL_VALUE, produces = {"application/json", "application/vnd.api+json"})
    public EntityModel<SequencingRunNanoporeDTO> getNanoporeSequencingRunById(@PathVariable final String sequencingRunId) {

        Optional<SequencingRunNanopore> nanoporeRun = nanoporeRunService.getSequencingRunById(sequencingRunId);

        if (nanoporeRun.isPresent()) {
            return EntityModel.of(nanoporeAssembler.toModel(nanoporeRun.get()));
        } else {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "sequencing run not found"
            );
        }
    }


}
