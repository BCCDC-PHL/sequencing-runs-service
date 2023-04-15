package ca.bccdcphl.sequencingruns.domain.model.entities.aggregates;

import ca.bccdcphl.sequencingruns.domain.model.AggregateRoot;
import ca.bccdcphl.sequencingruns.domain.model.values.SequencingInstrumentId;
import org.springframework.context.ApplicationContext;

public class SequencingInstrumentNanopore extends AggregateRoot<SequencingInstrumentNanopore, SequencingInstrumentId> {
    protected SequencingInstrumentNanopore(ApplicationContext applicationContext, SequencingInstrumentId entityId) {
        super(applicationContext, entityId);
    }

    @Override
    public boolean sameIdentityAs(SequencingInstrumentNanopore other) {
        return other != null && entityId.sameValueAs(other.entityId);
    }

    @Override
    public SequencingInstrumentId id() {
        return entityId;
    }
    @Override
    protected AggregateRootBehavior initialBehavior() {
        AggregateRootBehaviorBuilder behaviorBuilder = new AggregateRootBehaviorBuilder();
        return behaviorBuilder.build();
    }
}
