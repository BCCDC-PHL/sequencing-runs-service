package ca.bccdcphl.sequencingruns.model.aggregates;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.domain.AbstractAggregateRoot;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name="sequencing_instrument_nanopore")
@Getter
@Setter
@NoArgsConstructor
public class SequencingInstrumentNanopore extends AbstractAggregateRoot<SequencingInstrumentNanopore> {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private String instrumentId;
    private String type;
    private String model;
    private String status;
    private LocalDateTime timestampStatusUpdated;


}
