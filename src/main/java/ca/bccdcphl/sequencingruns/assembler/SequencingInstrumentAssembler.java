package ca.bccdcphl.sequencingruns.assembler;

import ca.bccdcphl.sequencingruns.controller.SequencingInstrumentsController;
import ca.bccdcphl.sequencingruns.dto.SequencingInstrumentDTO;
import ca.bccdcphl.sequencingruns.model.aggregates.SequencingInstrumentIllumina;
import ca.bccdcphl.sequencingruns.model.aggregates.SequencingInstrumentNanopore;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class SequencingInstrumentAssembler implements RepresentationModelAssembler<Object, SequencingInstrumentDTO> {
    @Override
    public @NonNull SequencingInstrumentDTO toModel(@NonNull Object instrument) {
        if (instrument instanceof SequencingInstrumentIllumina) {
            SequencingInstrumentIllumina illuminaInstrument = (SequencingInstrumentIllumina) instrument;
            SequencingInstrumentDTO dto = new SequencingInstrumentDTO(
                    illuminaInstrument.getInstrumentId(),
                    illuminaInstrument.getType(),
                    illuminaInstrument.getModel()
            );
            dto.add(linkTo(methodOn(SequencingInstrumentsController.class).getInstrumentById(illuminaInstrument.getInstrumentId())).withSelfRel());
            return dto;
        } else if (instrument instanceof SequencingInstrumentNanopore) {
            SequencingInstrumentNanopore nanoporeInstrument = (SequencingInstrumentNanopore) instrument;
            SequencingInstrumentDTO dto = new SequencingInstrumentDTO(
                    nanoporeInstrument.getInstrumentId(),
                    nanoporeInstrument.getType(),
                    nanoporeInstrument.getModel()
            );
            dto.add(linkTo(methodOn(SequencingInstrumentsController.class).getInstrumentById(nanoporeInstrument.getInstrumentId())).withSelfRel());

            return dto;
        } else {
            throw new IllegalArgumentException("Invalid instrument type: " + instrument.getClass().getName());
        }
    }
}
