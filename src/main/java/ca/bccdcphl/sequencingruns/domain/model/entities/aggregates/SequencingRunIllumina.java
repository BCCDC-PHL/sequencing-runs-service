package ca.bccdcphl.sequencingruns.domain.model.entities.aggregates;

import ca.bccdcphl.sequencingruns.domain.model.AggregateRoot;

import javax.persistence.*;
import java.util.Date;

@Entity
public class SequencingRunIllumina extends AggregateRoot<SequencingRunIllumina, String> {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private String sequencingRunId;
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
    private Float percentAligned;
    private Float q30Percent;
    private Float projectedYieldGigabases;
    private Float yieldGigabases;
    private Long numReads;
    private Long numReadsPassedFilter;

    protected SequencingRunIllumina(String entityId) {
        super(entityId);
    }

    @Override
    public boolean sameIdentityAs(SequencingRunIllumina other) {
        return other != null && this.id().equals(other.id());
    }

    @Override
    public String id() {
        return this.sequencingRunId;
    }

}
