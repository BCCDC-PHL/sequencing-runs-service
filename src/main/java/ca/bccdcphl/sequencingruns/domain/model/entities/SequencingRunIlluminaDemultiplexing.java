package ca.bccdcphl.sequencingruns.domain.model.entities;

import ca.bccdcphl.sequencingruns.domain.model.AggregateRoot;
import ca.bccdcphl.sequencingruns.domain.model.Entity;
import ca.bccdcphl.sequencingruns.domain.model.values.SequencingRunId;
import ca.bccdcphl.sequencingruns.domain.model.values.SequencingRunIlluminaDemultiplexingId;
import org.springframework.context.ApplicationContext;

public class SequencingRunIlluminaDemultiplexing implements Entity<SequencingRunIlluminaDemultiplexing, SequencingRunIlluminaDemultiplexingId> {

    private final SequencingRunIlluminaDemultiplexingId id;
    public SequencingRunIlluminaDemultiplexing(SequencingRunIlluminaDemultiplexingId id){
        this.id = id;
    }
    @Override
    public boolean sameIdentityAs(SequencingRunIlluminaDemultiplexing other) {
        return other != null && this.id.sameValueAs(other.id());
    }

    @Override
    public SequencingRunIlluminaDemultiplexingId id() {
        return this.id;
    }
}
