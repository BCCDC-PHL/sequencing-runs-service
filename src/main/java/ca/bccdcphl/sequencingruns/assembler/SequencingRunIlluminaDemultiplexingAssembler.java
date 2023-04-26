package ca.bccdcphl.sequencingruns.assembler;

import ca.bccdcphl.sequencingruns.controller.SequencingRunsController;
import ca.bccdcphl.sequencingruns.dto.SequencedLibraryIlluminaDTO;
import ca.bccdcphl.sequencingruns.dto.SequencingRunIlluminaDTO;
import ca.bccdcphl.sequencingruns.dto.SequencingRunIlluminaDemultiplexingDTO;
import ca.bccdcphl.sequencingruns.model.SequencedLibraryIllumina;
import ca.bccdcphl.sequencingruns.model.SequencingRunIlluminaDemultiplexing;
import ca.bccdcphl.sequencingruns.model.aggregates.SequencingRunIllumina;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class SequencingRunIlluminaDemultiplexingAssembler implements RepresentationModelAssembler<SequencingRunIlluminaDemultiplexing, SequencingRunIlluminaDemultiplexingDTO> {
    @Override
    public @NonNull SequencingRunIlluminaDemultiplexingDTO toModel(@NonNull SequencingRunIlluminaDemultiplexing demultiplexing) {
        SequencingRunIllumina sequencingRun = demultiplexing.getSequencingRun();

        SequencingRunIlluminaDemultiplexingDTO demultiplexingDTO =  SequencingRunIlluminaDemultiplexingDTO.builder()
                .id(demultiplexing.getDemultiplexingId())
                .samplesheetPath(demultiplexing.getSamplesheetPath())
                .build();

        List<SequencedLibraryIlluminaDTO> sequencedLibraryDTOList = new ArrayList<>();
        for (SequencedLibraryIllumina sequencedLibrary : demultiplexing.getSequencedLibraries()) {
            SequencedLibraryIlluminaDTO sequencedLibraryDTO = SequencedLibraryIlluminaDTO.builder()
                    .id(sequencedLibrary.getLibraryId())

                    .build();
            sequencedLibraryDTOList.add(sequencedLibraryDTO);


        }
        demultiplexingDTO.setSequencedLibraries(sequencedLibraryDTOList);

        // This switches the ID in the 'self' link from the DB primary key to the domain-specific ID
        demultiplexingDTO.add(linkTo(methodOn(SequencingRunsController.class).getIlluminaSequencingRunDemultiplexingsBySequencingRunId(sequencingRun.getSequencingRunId())).withSelfRel());

        return demultiplexingDTO;
    }
}
