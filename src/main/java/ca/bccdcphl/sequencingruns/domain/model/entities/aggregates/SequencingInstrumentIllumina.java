package ca.bccdcphl.sequencingruns.domain.model.entities.aggregates;

import ca.bccdcphl.sequencingruns.domain.model.AggregateRoot;
import ca.bccdcphl.sequencingruns.domain.model.values.SequencingInstrumentId;
import org.springframework.context.ApplicationContext;

import javax.persistence.*;

@Entity
@Table(name="sequencing_instrument_illumina")
public class SequencingInstrumentIllumina extends AggregateRoot<SequencingInstrumentIllumina, SequencingInstrumentId> {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    @Column(name="instrument_id")
    private String instrumentId;

    private String status;

    protected SequencingInstrumentIllumina(SequencingInstrumentId entityId) {
        super(entityId);
    }

    @Override
    public boolean sameIdentityAs(SequencingInstrumentIllumina other) {
        return other != null && entityId.sameValueAs(other.entityId);
    }

    @Override
    public SequencingInstrumentId id() {
        return entityId;
    }

}
