package ca.bccdcphl.sequencingruns.service;

import ca.bccdcphl.sequencingruns.dto.SequencingRunIlluminaDTO;
import ca.bccdcphl.sequencingruns.dto.SequencingRunIlluminaDemultiplexingDTO;
import ca.bccdcphl.sequencingruns.model.SequencingRunIlluminaDemultiplexing;
import ca.bccdcphl.sequencingruns.model.aggregates.SequencingRunIllumina;
import ca.bccdcphl.sequencingruns.repositories.SequencingRunIlluminaRepository;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Date;

@Service
public class SequencingRunIlluminaService {

    @Autowired
    private SequencingRunIlluminaRepository repo;

    public SequencingRunIllumina createNullSequencingRun(String sequencingRunId) {
        SequencingRunIllumina sequencingRun = SequencingRunIllumina
                .builder()
                .sequencingRunId(sequencingRunId)
                .build();
        return repo.save(sequencingRun);
    }

    public SequencingRunIllumina createSequencingRun(SequencingRunIlluminaDTO dto) {
        SequencingRunIllumina sequencingRun = SequencingRunIllumina.builder()
                .sequencingRunId(dto.getId())
                .instrumentId(dto.getInstrumentId())
                .flowcellId(dto.getFlowcellId())
                .runDate(dto.getRunDate())
                .experimentName(dto.getExperimentName())
                .numCyclesR1(dto.getNumCyclesR1())
                .numCyclesR2(dto.getNumCyclesR2())
                .clusterCount(dto.getClusterCount())
                .clusterCountPassedFilter(dto.getClusterCountPassedFilter())
                .percentClustersPassedFilter(dto.getPercentClustersPassedFilter())
                .errorRate(dto.getErrorRate())
                .firstCycleIntensity(dto.getFirstCycleIntensity())
                .percentAligned(dto.getPercentAligned())
                .q30Percent(dto.getQ30Percent())
                .projectedYieldGigabases(dto.getProjectedYieldGigabases())
                .yieldGigabases(dto.getYieldGigabases())
                .numReads(dto.getNumReads())
                .numReadsPassedFilter(dto.getNumReadsPassedFilter())
                .build();
        List<SequencingRunIlluminaDemultiplexing> demultiplexingsList = new ArrayList<>();
        for (SequencingRunIlluminaDemultiplexingDTO demultiplexingDTO : dto.getDemultiplexings()) {
            SequencingRunIlluminaDemultiplexing demultiplexing = SequencingRunIlluminaDemultiplexing.builder()
                    .demultiplexingId(Integer.parseInt(demultiplexingDTO.getId()))
                    .samplesheetPath(demultiplexingDTO.getSamplesheetPath())
                    .build();
            demultiplexingsList.add(demultiplexing);
        }
        sequencingRun.setDemultiplexings(demultiplexingsList);
        return repo.save(sequencingRun);
    }

    public Iterable<SequencingRunIllumina> getSequencingRuns() {
        return repo.findAll();
    }

    public Optional<SequencingRunIllumina> getSequencingRunById(final String sequencingRunId) {
        return repo.findBySequencingRunId(sequencingRunId);
    }

    public Iterable<SequencingRunIllumina> getSequencingRunsByInstrumentId(final String instrumentId) {
        return repo.findAllByInstrumentId(instrumentId);
    }

}
