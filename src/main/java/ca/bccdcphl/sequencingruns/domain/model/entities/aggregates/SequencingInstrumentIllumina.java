package ca.bccdcphl.sequencingruns.domain.model.entities.aggregates;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.domain.AbstractAggregateRoot;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name="sequencing_instrument_illumina")
@Getter
@Setter
@NoArgsConstructor
public class SequencingInstrumentIllumina extends AbstractAggregateRoot<SequencingInstrumentIllumina> {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private String instrumentId;
    private String type;
    private String model;
    private String status;
    private LocalDateTime timestampStatusUpdated;


    public SequencingInstrumentIllumina(String instrumentId, String type, String model) {
        this.instrumentId = instrumentId;
        this.type = type;
        this.model = model;
    }

}
