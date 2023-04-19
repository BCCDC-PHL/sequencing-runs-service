package ca.bccdcphl.sequencingruns.assembler;

import ca.bccdcphl.sequencingruns.controller.SequencingRunsController;
import ca.bccdcphl.sequencingruns.dto.SequencingRunNanoporeDTO;
import ca.bccdcphl.sequencingruns.model.aggregates.SequencingRunNanopore;

import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class SequencingRunNanoporeAssembler implements RepresentationModelAssembler<SequencingRunNanopore, SequencingRunNanoporeDTO> {
    @Override
    public @NonNull SequencingRunNanoporeDTO toModel(@NonNull SequencingRunNanopore sequencingRun) {

            SequencingRunNanoporeDTO dto = new SequencingRunNanoporeDTO(
                    sequencingRun.getSequencingRunId(),
                    sequencingRun.getInstrumentId()
            );

            // This switches the ID in the 'self' link from the DB primary key to the domain-specific ID
            dto.add(linkTo(methodOn(SequencingRunsController.class).getNanoporeSequencingRunById(sequencingRun.getSequencingRunId())).withSelfRel());

            return dto;
    }
}
