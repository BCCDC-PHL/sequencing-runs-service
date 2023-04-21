package ca.bccdcphl.sequencingruns.model.aggregates;

import ca.bccdcphl.sequencingruns.model.AcquisitionRunNanopore;
import lombok.*;
import org.springframework.data.domain.AbstractAggregateRoot;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="sequencing_run_nanopore")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SequencingRunNanopore extends AbstractAggregateRoot<SequencingRunNanopore> {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private String sequencingRunId;
    private String instrumentId;
    private String sampleSheetPath;
    private String flowcellId;
    private String flowcellProductCode;
    private LocalDate runDate;
    private String protocolId;
    private String protocolRunId;
    private LocalDateTime timestampProtocolRunStarted;
    private LocalDateTime timestampProtocolRunEnded;
    private Long numReadsTotal;
    private Long numReadsPassedFilter;
    private Float yieldGigabases;
    @OneToMany(mappedBy="sequencingRun", cascade={CascadeType.PERSIST, CascadeType.REMOVE})
    private List<AcquisitionRunNanopore> acquisitionRuns;

}
