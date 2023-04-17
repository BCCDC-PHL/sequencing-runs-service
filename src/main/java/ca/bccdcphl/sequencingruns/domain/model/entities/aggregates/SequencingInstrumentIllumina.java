package ca.bccdcphl.sequencingruns.domain.model.entities.aggregates;

import ca.bccdcphl.sequencingruns.domain.model.AggregateRoot;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name="sequencing_instrument_illumina")
public class SequencingInstrumentIllumina extends AggregateRoot<SequencingInstrumentIllumina, String> {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    @Column(name="instrument_id")
    private String instrumentId;

    @Column(name="status")
    private String status;

    @Column(name="timestamp_status_updated")
    private LocalDateTime timestampStatusUpdated;

    protected SequencingInstrumentIllumina(String instrumentId) {
        super(instrumentId);
    }

    @Override
    public boolean sameIdentityAs(SequencingInstrumentIllumina other) {
        return other != null && this.id().equals(other.id());
    }

    @Override
    public String id() {
        return this.instrumentId;
    }

}
