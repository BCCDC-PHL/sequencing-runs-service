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

    public SequencingInstrumentIllumina() {
        super();
    }

    public SequencingInstrumentIllumina(String instrumentId) {
        super(instrumentId);
    }

    public SequencingInstrumentIllumina(String instrumentId, String type, String model) {
        this.instrumentId = instrumentId;
        this.type = type;
        this.model = model;
    }

    public String getInstrumentId() {
        return this.instrumentId;
    }

    public void setInstrumentId(String instrumentId) {
        this.instrumentId = instrumentId;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getModel() {
        return this.type;
    }

    public void setModel(String model) {
        this.type = model;
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
