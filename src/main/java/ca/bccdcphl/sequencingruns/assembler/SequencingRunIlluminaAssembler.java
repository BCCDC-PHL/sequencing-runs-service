package ca.bccdcphl.sequencingruns.assembler;

import ca.bccdcphl.sequencingruns.controller.SequencingRunsController;
import ca.bccdcphl.sequencingruns.dto.SequencingRunIlluminaDTO;
import ca.bccdcphl.sequencingruns.model.aggregates.SequencingRunIllumina;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class SequencingRunIlluminaAssembler implements RepresentationModelAssembler<SequencingRunIllumina, SequencingRunIlluminaDTO> {
    @Override
    public @NonNull SequencingRunIlluminaDTO toModel(@NonNull SequencingRunIllumina sequencingRun) {

        SequencingRunIlluminaDTO dto = new SequencingRunIlluminaDTO(
                sequencingRun.getSequencingRunId(),
                sequencingRun.getInstrumentId()
        );
        // This switches the ID in the 'self' link from the DB primary key to the domain-specific ID
        dto.add(linkTo(methodOn(SequencingRunsController.class).getIlluminaSequencingRunById(sequencingRun.getSequencingRunId())).withSelfRel());

        return dto;
    }
}
