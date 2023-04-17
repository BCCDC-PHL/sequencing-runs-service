package ca.bccdcphl.sequencingruns.domain.model.entities.aggregates;

import ca.bccdcphl.sequencingruns.domain.model.AggregateRoot;
import ca.bccdcphl.sequencingruns.domain.model.values.SequencingRunId;
import org.springframework.context.ApplicationContext;

import javax.persistence.Column;
import java.util.Date;

public class SequencingRunIllumina extends AggregateRoot<SequencingRunIllumina, SequencingRunId> {


    private SequencingRunId entityId;
    private String instrumentId;
    private String flowcellId;
    private Date runDate;
    private String experimentName;
    private Integer numCyclesR1;
    private Integer numCyclesR2;
    private Long clusterCount;
    private Long clusterCountPassedFilter;
    private Float percentClustersPassedFilter;
    private Float errorRate;
    private Float firstCycleIntensity;

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
