package ca.bccdcphl.sequencingruns.assembler;

import ca.bccdcphl.sequencingruns.controller.SequencingInstrumentsController;
import ca.bccdcphl.sequencingruns.dto.SequencingInstrumentNanoporeDTO;
import ca.bccdcphl.sequencingruns.model.aggregates.SequencingInstrumentNanopore;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;

@Component
public class SequencingInstrumentNanoporeAssembler implements RepresentationModelAssembler<SequencingInstrumentNanopore, SequencingInstrumentNanoporeDTO> {
    @Override
    public @NonNull SequencingInstrumentNanoporeDTO toModel(@NonNull SequencingInstrumentNanopore instrument) {

        SequencingInstrumentNanoporeDTO dto = new SequencingInstrumentNanoporeDTO(
                instrument.getInstrumentId(),
                instrument.getType(),
                instrument.getModel(),
                instrument.getStatus()
        );

        dto.add(linkTo(methodOn(SequencingInstrumentsController.class).getNanoporeInstrumentById(instrument.getInstrumentId())).withSelfRel());
        dto.add(linkTo(methodOn(SequencingInstrumentsController.class).getNanoporeInstrumentStatus(instrument.getInstrumentId())).withRel("status"));
        dto.add(linkTo(methodOn(SequencingInstrumentsController.class).getNanoporeSequencingRunsByInstrumentId(instrument.getInstrumentId())).withRel("sequencing_runs"));

        return dto;
    }
}
