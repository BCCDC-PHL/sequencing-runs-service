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
import java.util.Optional;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class SequencingRunIlluminaAssembler implements RepresentationModelAssembler<SequencingRunIllumina, SequencingRunIlluminaDTO> {
    @Override
    public @NonNull SequencingRunIlluminaDTO toModel(@NonNull SequencingRunIllumina sequencingRun) {

        SequencingRunIlluminaDTO sequencingRunDTO =  SequencingRunIlluminaDTO.builder()
                .id(sequencingRun.getSequencingRunId())
                .instrumentId(sequencingRun.getInstrumentId())
                .flowcellId(sequencingRun.getFlowcellId())
                .runDate(sequencingRun.getRunDate())
                .experimentName(sequencingRun.getExperimentName())
                .numCyclesR1(sequencingRun.getNumCyclesR1())
                .numCyclesR2(sequencingRun.getNumCyclesR2())
                .clusterCount(sequencingRun.getClusterCount())
                .clusterCountPassedFilter(sequencingRun.getClusterCountPassedFilter())
                .percentClustersPassedFilter(sequencingRun.getPercentClustersPassedFilter())
                .errorRate(sequencingRun.getErrorRate())
                .firstCycleIntensity(sequencingRun.getFirstCycleIntensity())
                .percentAligned(sequencingRun.getPercentAligned())
                .q30Percent(sequencingRun.getQ30Percent())
                .projectedYieldGigabases(sequencingRun.getProjectedYieldGigabases())
                .yieldGigabases(sequencingRun.getYieldGigabases())
                .numReads(sequencingRun.getNumReads())
                .numReadsPassedFilter(sequencingRun.getNumReadsPassedFilter())
                .build();

        List<SequencingRunIlluminaDemultiplexingDTO> demultiplexingDTOList = new ArrayList<>();
        for (SequencingRunIlluminaDemultiplexing demultiplexing : sequencingRun.getDemultiplexings()) {
            SequencingRunIlluminaDemultiplexingDTO demultiplexingDTO = SequencingRunIlluminaDemultiplexingDTO.builder()
                    .id(demultiplexing.getDemultiplexingId().toString())
                    .samplesheetPath(demultiplexing.getSamplesheetPath())
                    .build();
            demultiplexingDTOList.add(demultiplexingDTO);
            List<SequencedLibraryIlluminaDTO> sequencedLibraryDTOList = new ArrayList<>();
            for (SequencedLibraryIllumina sequencedLibrary : demultiplexing.getSequencedLibraries()) {
                SequencedLibraryIlluminaDTO sequencedLibraryDTO = SequencedLibraryIlluminaDTO.builder()
                        .id(sequencedLibrary.getLibraryId())
                        .samplesheetProjectId(sequencedLibrary.getSamplesheetProjectId())
                        .translatedProjectId(sequencedLibrary.getTranslatedProjectId())
                        .index(sequencedLibrary.getIndex())
                        .index2(sequencedLibrary.getIndex2())
                        .numReads(sequencedLibrary.getNumReads())
                        .fastqPathR1(sequencedLibrary.getFastqPathR1())
                        .fastqPathR2(sequencedLibrary.getFastqPathR2())
                        .build();
                sequencedLibraryDTOList.add(sequencedLibraryDTO);
            }
            demultiplexingDTO.setSequencedLibraries(sequencedLibraryDTOList);
        }
        sequencingRunDTO.setDemultiplexings(demultiplexingDTOList);

        // This switches the ID in the 'self' link from the DB primary key to the domain-specific ID
        sequencingRunDTO.add(linkTo(methodOn(SequencingRunsController.class).getIlluminaSequencingRunById(sequencingRun.getSequencingRunId())).withSelfRel());

        return sequencingRunDTO;
    }
}
