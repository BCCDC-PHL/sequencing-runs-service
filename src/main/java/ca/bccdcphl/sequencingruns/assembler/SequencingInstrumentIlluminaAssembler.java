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

        SequencingInstrumentIlluminaDTO instrumentDTO = SequencingInstrumentIlluminaDTO.builder()
                .id(instrument.getInstrumentId())
                .instrumentType(instrument.getType())
                .instrumentModel(instrument.getModel())
                .status(instrument.getStatus())
                .currentSequencingRunId(instrument.getCurrentSequencingRunId())
                .previousSequencingRunId(instrument.getPreviousSequencingRunId())
                .build();


        instrumentDTO.add(linkTo(methodOn(SequencingInstrumentsController.class).getIlluminaInstrumentById(instrument.getInstrumentId())).withSelfRel());
        instrumentDTO.add(linkTo(methodOn(SequencingInstrumentsController.class).getIlluminaInstrumentStatus(instrument.getInstrumentId())).withRel("status"));
        instrumentDTO.add(linkTo(methodOn(SequencingInstrumentsController.class).getIlluminaSequencingRunsByInstrumentId(instrument.getInstrumentId())).withRel("sequencing_runs"));

        return instrumentDTO;

    }
}
