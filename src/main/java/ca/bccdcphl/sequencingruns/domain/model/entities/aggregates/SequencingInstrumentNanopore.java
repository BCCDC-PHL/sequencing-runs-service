package ca.bccdcphl.sequencingruns.domain.model.entities.aggregates;

import ca.bccdcphl.sequencingruns.domain.model.AggregateRoot;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class SequencingInstrumentNanopore extends AggregateRoot<SequencingInstrumentNanopore, String> {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private String instrumentId;
    private String type;
    private String model;
    private String status;
    private LocalDateTime timestampStatusUpdated;

    public SequencingInstrumentNanopore() {
        super();
    }

    public SequencingInstrumentNanopore(String instrumentId) {
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
