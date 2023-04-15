package ca.bccdcphl.sequencingruns.domain.model.entities.aggregates;

import ca.bccdcphl.sequencingruns.domain.model.AggregateRoot;
import ca.bccdcphl.sequencingruns.domain.model.values.SequencingRunId;
import org.springframework.context.ApplicationContext;

public class SequencingRunIllumina extends AggregateRoot<SequencingRunIllumina, SequencingRunId> {
    protected SequencingRunIllumina(ApplicationContext applicationContext, SequencingRunId entityId) {
        super(applicationContext, entityId);
    }

    @Override
    public boolean sameIdentityAs(SequencingRunIllumina other) {
        return other != null && entityId.sameValueAs(other.entityId);
    }

    @Override
    public SequencingRunId id() {
        return entityId;
    }
    @Override
    protected AggregateRootBehavior initialBehavior() {
        AggregateRootBehaviorBuilder behaviorBuilder = new AggregateRootBehaviorBuilder();
        return behaviorBuilder.build();
    }
}
