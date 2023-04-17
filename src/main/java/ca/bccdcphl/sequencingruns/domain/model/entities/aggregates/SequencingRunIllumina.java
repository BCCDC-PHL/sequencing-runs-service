package ca.bccdcphl.sequencingruns.domain.model.entities.aggregates;

import ca.bccdcphl.sequencingruns.domain.model.AggregateRoot;
import ca.bccdcphl.sequencingruns.domain.model.values.SequencingRunId;
import org.springframework.context.ApplicationContext;

import javax.persistence.*;
import java.util.Date;

@Entity
public class SequencingRunIllumina extends AggregateRoot<SequencingRunIllumina, SequencingRunId> {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private SequencingRunId sequencingRunId;
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

    protected SequencingRunIllumina(SequencingRunId entityId) {
        super(entityId);
    }

    @Override
    public boolean sameIdentityAs(SequencingRunIllumina other) {
        return other != null && this.id().sameValueAs(other.id());
    }

    @Override
    public SequencingRunId id() {
        return this.sequencingRunId;
    }

}
