package ca.bccdcphl.sequencingruns.domain.model.entities.aggregates;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.domain.AbstractAggregateRoot;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name="sequencing_run_nanopore")
@Getter
@Setter
@NoArgsConstructor
public class SequencingRunNanopore extends AbstractAggregateRoot<SequencingRunNanopore> {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private String sequencingRunId;
    private String sampleSheetPath;
    private String instrumentId;
    private String flowcellId;
    private String flowcellProductCode;
    private Date runDate;
    private String protocolId;
    private String protocolRunId;
    private LocalDateTime timestampProtocolRunStarted;
    private LocalDateTime timestampProtocolRunEnded;
    private Long numReadsTotal;
    private Long numReadsPassedFilter;
    private Float yieldGigabases;


}
