package ca.bccdcphl.sequencingruns.assembler;

import ca.bccdcphl.sequencingruns.controller.SequencingInstrumentsController;
import ca.bccdcphl.sequencingruns.dto.SequencingInstrumentIlluminaDTO;
import ca.bccdcphl.sequencingruns.model.aggregates.SequencingInstrumentIllumina;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class SequencingInstrumentIlluminaAssembler implements RepresentationModelAssembler<SequencingInstrumentIllumina, SequencingInstrumentIlluminaDTO> {
    @Override
    public @NonNull SequencingInstrumentIlluminaDTO toModel(@NonNull SequencingInstrumentIllumina instrument) {

        SequencingInstrumentIlluminaDTO dto = new SequencingInstrumentIlluminaDTO(
                instrument.getInstrumentId(),
                instrument.getType(),
                instrument.getModel(),
                instrument.getStatus()
        );

        dto.add(linkTo(methodOn(SequencingInstrumentsController.class).getIlluminaInstrumentById(instrument.getInstrumentId())).withSelfRel());

        return dto;

    }
}
