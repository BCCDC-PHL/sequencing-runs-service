package ca.bccdcphl.sequencingruns.service;

import ca.bccdcphl.sequencingruns.dto.AcquisitionRunNanoporeDTO;
import ca.bccdcphl.sequencingruns.dto.SequencedLibraryNanoporeDTO;
import ca.bccdcphl.sequencingruns.dto.SequencingRunNanoporeDTO;
import ca.bccdcphl.sequencingruns.model.AcquisitionRunNanopore;
import ca.bccdcphl.sequencingruns.model.SequencedLibraryNanopore;
import ca.bccdcphl.sequencingruns.model.aggregates.SequencingRunNanopore;
import ca.bccdcphl.sequencingruns.repositories.SequencingRunNanoporeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class SequencingRunNanoporeService {

    @Autowired
    private SequencingRunNanoporeRepository repo;

    public SequencingRunNanopore createNullSequencingRun(String sequencingRunId) {
        SequencingRunNanopore sequencingRun = SequencingRunNanopore.builder()
                .sequencingRunId(sequencingRunId)
                .build();
        return repo.save(sequencingRun);
    }

    public SequencingRunNanopore createSequencingRun(SequencingRunNanoporeDTO sequencingRunDTO) {
        SequencingRunNanopore sequencingRun = SequencingRunNanopore.builder()
                .sequencingRunId(sequencingRunDTO.getId())
                .instrumentId(sequencingRunDTO.getInstrumentId())
                .sampleSheetPath(sequencingRunDTO.getSamplesheetPath())
                .flowcellId(sequencingRunDTO.getFlowcellId())
                .flowcellProductCode(sequencingRunDTO.getFlowcellProductCode())
                .runDate(sequencingRunDTO.getRunDate())
                .protocolId(sequencingRunDTO.getProtocolId())
                .protocolRunId(sequencingRunDTO.getProtocolRunId())
                .timestampProtocolRunStarted(sequencingRunDTO.getTimestampProtocolRunStarted())
                .timestampProtocolRunEnded(sequencingRunDTO.getTimestampProtocolRunEnded())
                .numReadsTotal(sequencingRunDTO.getNumReadsTotal())
                .numReadsPassedFilter(sequencingRunDTO.getNumReadsPassedFilter())
                .yieldGigabases(sequencingRunDTO.getYieldGigabases())
                .build();

        List<AcquisitionRunNanopore> acquisitionRunsList = new ArrayList<>();
        for (AcquisitionRunNanoporeDTO acquisitionRunDTO : sequencingRunDTO.getAcquisitionRuns()) {
            List<SequencedLibraryNanopore> sequencedLibrariesList = new ArrayList<>();
            AcquisitionRunNanopore acquisitionRun = AcquisitionRunNanopore.builder()
                    .acquisitionRunId(acquisitionRunDTO.getId())
                    .numReadsTotal(acquisitionRunDTO.getNumReadsTotal())
                    .numReadsPassedFilter(acquisitionRunDTO.getNumReadsPassedFilter())
                    .numBasesTotal(acquisitionRunDTO.getNumBasesTotal())
                    .numBasesPassedFilter(acquisitionRunDTO.getNumBasesPassedFilter())
                    .startupState(acquisitionRunDTO.getStartupState())
                    .state(acquisitionRunDTO.getState())
                    .finishingState(acquisitionRunDTO.getFinishingState())
                    .stopReason(acquisitionRunDTO.getStopReason())
                    .purpose(acquisitionRunDTO.getPurpose())
                    .basecallingConfigFilename(acquisitionRunDTO.getBasecallingConfigFilename())
                    .eventsToBaseRatio(acquisitionRunDTO.getEventsToBaseRatio())
                    .sampleRate(acquisitionRunDTO.getSampleRate())
                    .channelCount(acquisitionRunDTO.getChannelCount())
                    .build();
            for (SequencedLibraryNanoporeDTO sequencedLibraryDTO : acquisitionRunDTO.getSequencedLibraries()) {
                SequencedLibraryNanopore sequencedLibrary = SequencedLibraryNanopore.builder()
                        .libraryId(sequencedLibraryDTO.getId())
                        .samplesheetProjectId(sequencedLibraryDTO.getSamplesheetProjectId())
                        .translatedProjectId(sequencedLibraryDTO.getTranslatedProjectId())
                        .barcodeName(sequencedLibraryDTO.getBarcodeName())
                        .barcodeAlias(sequencedLibraryDTO.getBarcodeAlias())
                        .numReads(sequencedLibraryDTO.getNumReads())
                        .fastqCombinedPath(sequencedLibraryDTO.getFastqCombinedPath())
                        .build();
                sequencedLibrary.setAcquisitionRun(acquisitionRun);
                sequencedLibrariesList.add(sequencedLibrary);
            }
            acquisitionRun.setSequencedLibraries(sequencedLibrariesList);
            acquisitionRun.setSequencingRun(sequencingRun);
            acquisitionRunsList.add(acquisitionRun);
        }
        sequencingRun.setAcquisitionRuns(acquisitionRunsList);

        return repo.save(sequencingRun);
    }

    public Iterable<SequencingRunNanopore> getSequencingRuns() {
        return repo.findAll();
    }

    public Optional<SequencingRunNanopore> getSequencingRunById(final String sequencingRunId) {
        return repo.findBySequencingRunId(sequencingRunId);
    }

    public Iterable<SequencingRunNanopore> getSequencingRunsByInstrumentId(final String instrumentId) {
        return repo.findAllByInstrumentId(instrumentId);
    }
}
