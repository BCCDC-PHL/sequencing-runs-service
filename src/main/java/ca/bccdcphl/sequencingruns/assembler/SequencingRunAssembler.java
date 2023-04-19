package ca.bccdcphl.sequencingruns.assembler;

import ca.bccdcphl.sequencingruns.controller.SequencingRunsController;
import ca.bccdcphl.sequencingruns.dto.SequencingRunDTO;
import ca.bccdcphl.sequencingruns.model.aggregates.SequencingRunIllumina;
import ca.bccdcphl.sequencingruns.model.aggregates.SequencingRunNanopore;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class SequencingRunAssembler implements RepresentationModelAssembler<Object, SequencingRunDTO> {
    @Override
    public @NonNull SequencingRunDTO toModel(@NonNull Object sequencingRun) {
        if (sequencingRun instanceof SequencingRunIllumina) {
            SequencingRunIllumina illuminaRun = (SequencingRunIllumina) sequencingRun;
            SequencingRunDTO dto = new SequencingRunDTO(
                    illuminaRun.getSequencingRunId(),
                    illuminaRun.getInstrumentId()
            );
            // This switches the ID in the 'self' link from the DB primary key to the domain-specific ID
            dto.add(linkTo(methodOn(SequencingRunsController.class).getSequencingRunById(illuminaRun.getSequencingRunId())).withSelfRel());
            return dto;
        } else if (sequencingRun instanceof SequencingRunNanopore) {
            SequencingRunNanopore nanoporeRun = (SequencingRunNanopore) sequencingRun;
            SequencingRunDTO dto = new SequencingRunDTO(
                    nanoporeRun.getSequencingRunId(),
                    nanoporeRun.getInstrumentId()
            );
            dto.add(linkTo(methodOn(SequencingRunsController.class).getSequencingRunById(nanoporeRun.getSequencingRunId())).withSelfRel());
            return dto;
        } else {
            throw new IllegalArgumentException("Invalid sequencing run type: " + sequencingRun.getClass().getName());
        }
    }
}
