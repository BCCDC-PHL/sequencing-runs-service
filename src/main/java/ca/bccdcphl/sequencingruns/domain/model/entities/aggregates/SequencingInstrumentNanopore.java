package ca.bccdcphl.sequencingruns.domain.model.entities.aggregates;

import ca.bccdcphl.sequencingruns.domain.model.AggregateRoot;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class SequencingInstrumentNanopore extends AggregateRoot<SequencingInstrumentNanopore, String> {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    @Column(name="instrument_id")
    private String instrumentId;

    @Column(name="status")
    private String status;

    @Column(name="timestamp_status_updated")
    private LocalDateTime timestampStatusUpdated;

    protected SequencingInstrumentNanopore(String instrumentId) {
        super(instrumentId);
    }

    @Override
    public boolean sameIdentityAs(SequencingInstrumentNanopore other) {
        return other != null && this.id().equals(other.id());
    }
    public String id() {
        return this.instrumentId;
    }
}
