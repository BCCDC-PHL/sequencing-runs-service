package ca.bccdcphl.sequencingruns.domain.model.entities.aggregates;

import ca.bccdcphl.sequencingruns.domain.model.AggregateRoot;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
public class SequencingRunNanopore extends AggregateRoot<SequencingRunNanopore, String> {
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


    protected SequencingRunNanopore(String sequencingRunId) {
        super(sequencingRunId);
    }

    @Override
    public boolean sameIdentityAs(SequencingRunNanopore other) {
        return other != null && this.id().equals(other.id());
    }

    @Override
    public String id() {
        return this.sequencingRunId;
    }
}
