package ca.bccdcphl.sequencingruns.model.aggregates;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.domain.AbstractAggregateRoot;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="sequencing_run_illumina")
@Getter
@Setter
@NoArgsConstructor
public class SequencingRunIllumina extends AbstractAggregateRoot<SequencingRunIllumina> {

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


}
