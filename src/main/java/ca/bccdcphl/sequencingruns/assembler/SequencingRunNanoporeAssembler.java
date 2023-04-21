package ca.bccdcphl.sequencingruns.assembler;

import ca.bccdcphl.sequencingruns.controller.SequencingRunsController;
import ca.bccdcphl.sequencingruns.dto.AcquisitionRunNanoporeDTO;
import ca.bccdcphl.sequencingruns.dto.SequencedLibraryNanoporeDTO;
import ca.bccdcphl.sequencingruns.dto.SequencingRunNanoporeDTO;
import ca.bccdcphl.sequencingruns.model.AcquisitionRunNanopore;
import ca.bccdcphl.sequencingruns.model.SequencedLibraryNanopore;
import ca.bccdcphl.sequencingruns.model.aggregates.SequencingRunNanopore;

import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class SequencingRunNanoporeAssembler implements RepresentationModelAssembler<SequencingRunNanopore, SequencingRunNanoporeDTO> {
    @Override
    public @NonNull SequencingRunNanoporeDTO toModel(@NonNull SequencingRunNanopore sequencingRun) {

        SequencingRunNanoporeDTO sequencingRunDTO = SequencingRunNanoporeDTO.builder()
                .id(sequencingRun.getSequencingRunId())
                .instrumentId(sequencingRun.getInstrumentId())
                .samplesheetPath(sequencingRun.getSampleSheetPath())
                .flowcellId(sequencingRun.getFlowcellId())
                .flowcellProductCode(sequencingRun.getFlowcellProductCode())
                .runDate(sequencingRun.getRunDate())
                .protocolId(sequencingRun.getProtocolId())
                .protocolRunId(sequencingRun.getProtocolRunId())
                .timestampProtocolRunStarted(sequencingRun.getTimestampProtocolRunStarted())
                .timestampProtocolRunEnded(sequencingRun.getTimestampProtocolRunEnded())
                .numReadsTotal(sequencingRun.getNumReadsTotal())
                .numReadsPassedFilter(sequencingRun.getNumReadsPassedFilter())
                .yieldGigabases(sequencingRun.getYieldGigabases())
                .build();

        List<AcquisitionRunNanoporeDTO> acquisitionRunDTOList = new ArrayList<>();
        for (AcquisitionRunNanopore acquisitionRun : sequencingRun.getAcquisitionRuns()) {
            AcquisitionRunNanoporeDTO acquisitionRunDTO = AcquisitionRunNanoporeDTO.builder()
                    .id(acquisitionRun.getAcquisitionRunId())
                    .numReadsTotal(acquisitionRun.getNumReadsTotal())
                    .numReadsPassedFilter(acquisitionRun.getNumReadsPassedFilter())
                    .numBasesTotal(acquisitionRun.getNumBasesTotal())
                    .numBasesPassedFilter(acquisitionRun.getNumBasesPassedFilter())
                    .startupState(acquisitionRun.getStartupState())
                    .state(acquisitionRun.getState())
                    .finishingState(acquisitionRun.getFinishingState())
                    .stopReason(acquisitionRun.getStopReason())
                    .purpose(acquisitionRun.getPurpose())
                    .basecallingConfigFilename(acquisitionRun.getBasecallingConfigFilename())
                    .eventsToBaseRatio(acquisitionRun.getEventsToBaseRatio())
                    .sampleRate(acquisitionRun.getSampleRate())
                    .channelCount(acquisitionRun.getChannelCount())
                    .build();
            acquisitionRunDTOList.add(acquisitionRunDTO);
            List<SequencedLibraryNanoporeDTO> sequencedLibraryDTOList = new ArrayList<>();
            for (SequencedLibraryNanopore sequencedLibrary : acquisitionRun.getSequencedLibraries()) {
                SequencedLibraryNanoporeDTO sequencedLibraryDTO = SequencedLibraryNanoporeDTO.builder()
                        .id(sequencedLibrary.getLibraryId())
                        .samplesheetProjectId(sequencedLibrary.getSamplesheetProjectId())
                        .translatedProjectId(sequencedLibrary.getTranslatedProjectId())
                        .barcodeName(sequencedLibrary.getBarcodeName())
                        .barcodeAlias(sequencedLibrary.getBarcodeAlias())
                        .numReads(sequencedLibrary.getNumReads())
                        .fastqCombinedPath(sequencedLibrary.getFastqCombinedPath())
                        .build();
                sequencedLibraryDTOList.add(sequencedLibraryDTO);
            }
            acquisitionRunDTO.setSequencedLibraries(sequencedLibraryDTOList);
        }
        sequencingRunDTO.setAcquisitionRuns(acquisitionRunDTOList);
            // This switches the ID in the 'self' link from the DB primary key to the domain-specific ID
        sequencingRunDTO.add(linkTo(methodOn(SequencingRunsController.class).getNanoporeSequencingRunById(sequencingRun.getSequencingRunId())).withSelfRel());

        return sequencingRunDTO;
    }
}
