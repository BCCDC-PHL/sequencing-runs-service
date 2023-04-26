package ca.bccdcphl.sequencingruns.repositories;

import ca.bccdcphl.sequencingruns.model.SequencingRunIlluminaDemultiplexing;
import ca.bccdcphl.sequencingruns.model.aggregates.SequencingRunIllumina;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.lang.NonNull;

import java.util.List;
import java.util.Optional;

public class SequencingRunIlluminaRepositoryImpl {

    private final SequencingRunIlluminaRepository sequencingRunIlluminaRepository;

    // We use a constructor instead of @Autowired annotation here
    // to avoid a circular dependency
    // https://www.baeldung.com/circular-dependencies-in-spring
    public SequencingRunIlluminaRepositoryImpl(@Lazy SequencingRunIlluminaRepository sequencingRunIlluminaRepository) {
        super();
        this.sequencingRunIlluminaRepository = sequencingRunIlluminaRepository;
    }

    public Optional<List<SequencingRunIlluminaDemultiplexing>> findDemultiplexingsBySequencingRunId(@NonNull String sequencingRunId) {
        Optional<SequencingRunIllumina> sequencingRun = sequencingRunIlluminaRepository.findBySequencingRunId(sequencingRunId);
        if (sequencingRun.isPresent()) {
            List<SequencingRunIlluminaDemultiplexing> demultiplexings = sequencingRun.get().getDemultiplexings();
            return Optional.of(demultiplexings);
        } else {
            return Optional.empty();
        }
    }

    public Optional<SequencingRunIlluminaDemultiplexing> findDemultiplexingBySequencingRunIdAndDemultiplexingId(@NonNull String sequencingRunId, @NonNull String demultiplexingId) {
        Optional<SequencingRunIllumina> sequencingRun = sequencingRunIlluminaRepository.findBySequencingRunId(sequencingRunId);
        if (sequencingRun.isPresent()) {
            List<SequencingRunIlluminaDemultiplexing> demultiplexings = sequencingRun.get().getDemultiplexings();
            for (SequencingRunIlluminaDemultiplexing demultiplexing : demultiplexings) {
                if (demultiplexing.getDemultiplexingId().equals(sequencingRunId + "-DMX" + demultiplexingId)) {
                    return Optional.of(demultiplexing);
                }
            }
        }
        return Optional.empty();
    }
}
