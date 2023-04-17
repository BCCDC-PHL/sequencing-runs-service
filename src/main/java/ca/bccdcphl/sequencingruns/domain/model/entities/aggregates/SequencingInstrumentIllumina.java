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
    private String instrumentId;
    private String type;
    private String model;
    private String status;
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
