package ca.bccdcphl.sequencingruns.model.aggregates;

import ca.bccdcphl.sequencingruns.model.SequencingRunIlluminaDemultiplexing;
import lombok.*;
import org.springframework.data.domain.AbstractAggregateRoot;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name="sequencing_run_illumina")
@Getter
@Setter
@NoArgsConstructor(force = true)
@AllArgsConstructor
@Builder
public class SequencingRunIllumina extends AbstractAggregateRoot<SequencingRunIllumina> {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    @NonNull
    private String sequencingRunId;
    private String instrumentId;
    private String flowcellId;
    private LocalDate runDate;
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
    private Float percentReadsPassedFilter;
    private Float percentOccupied;
    @OneToMany(mappedBy="sequencingRun", cascade={CascadeType.PERSIST, CascadeType.REMOVE})
    private List<SequencingRunIlluminaDemultiplexing> demultiplexings;

}
