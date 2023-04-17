package ca.bccdcphl.sequencingruns.domain.model.entities.aggregates;

import ca.bccdcphl.sequencingruns.domain.model.AggregateRoot;
import ca.bccdcphl.sequencingruns.domain.model.values.SequencingInstrumentId;
import ca.bccdcphl.sequencingruns.domain.model.values.SequencingRunId;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class SequencingInstrumentNanopore extends AggregateRoot<SequencingInstrumentNanopore, SequencingInstrumentId> {

    @Id
    private SequencingInstrumentId instrumentId;

    protected SequencingInstrumentNanopore( SequencingInstrumentId entityId) {
        super(entityId);
    }

    @Override
    public boolean sameIdentityAs(SequencingInstrumentNanopore other) {
        return other != null && entityId.sameValueAs(other.entityId);
    }
    public SequencingInstrumentId id() {
        return this.entityId;
    }
}
