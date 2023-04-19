package ca.bccdcphl.sequencingruns.controller;

import ca.bccdcphl.sequencingruns.assembler.SequencingRunAssembler;
import ca.bccdcphl.sequencingruns.dto.SequencingRunDTO;
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
    private final SequencingRunAssembler assembler;


    @Autowired
    public SequencingRunsController(
            SequencingRunIlluminaService illuminaRunService,
            SequencingRunNanoporeService nanoporeRunService,
            SequencingRunAssembler assembler
    ) {
        this.illuminaRunService = illuminaRunService;
        this.nanoporeRunService = nanoporeRunService;
        this.assembler = assembler;
    }

    @GetMapping(value="/sequencing-runs", consumes = MediaType.ALL_VALUE, produces = {"application/json", "application/vnd.api+json"})
    public CollectionModel<SequencingRunDTO> getSequencingRuns() {
        List<SequencingRunDTO> runs = new ArrayList<>();

        Iterable<SequencingRunIllumina> illuminaRuns = illuminaRunService.getSequencingRuns();
        for (SequencingRunIllumina illuminaRun : illuminaRuns) {
            SequencingRunDTO runModel = assembler.toModel(illuminaRun);
            runs.add(runModel);
        }

        Iterable<SequencingRunNanopore> nanoporeRuns = nanoporeRunService.getSequencingRuns();
        for (SequencingRunNanopore nanoporeRun : nanoporeRuns) {
            SequencingRunDTO runModel = assembler.toModel(nanoporeRun);
            runs.add(runModel);
        }

        return CollectionModel.of(runs);
    }

    @GetMapping(value="/sequencing-runs/{sequencingRunId}", consumes = MediaType.ALL_VALUE, produces = {"application/json", "application/vnd.api+json"})
    public EntityModel<SequencingRunDTO> getSequencingRunById(@PathVariable final String sequencingRunId) {

        Optional<SequencingRunIllumina> illuminaRun = illuminaRunService.getSequencingRunById(sequencingRunId);
        Optional<SequencingRunNanopore> nanoporeRun = nanoporeRunService.getSequencingRunById(sequencingRunId);

        if (illuminaRun.isPresent()) {
            return EntityModel.of(assembler.toModel(illuminaRun.get()));
        } else if (nanoporeRun.isPresent()) {
            return EntityModel.of(assembler.toModel(nanoporeRun.get()));
        } else {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "sequencing run not found"
            );
        }
    }


}
