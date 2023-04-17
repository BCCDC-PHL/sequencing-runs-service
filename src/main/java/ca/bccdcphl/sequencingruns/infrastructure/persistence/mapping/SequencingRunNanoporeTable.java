package ca.bccdcphl.sequencingruns.infrastructure.persistence.mapping;

import ca.bccdcphl.sequencingruns.domain.model.entities.aggregates.SequencingInstrumentIllumina;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

import javax.persistence.*;

@Entity
@Table(name="sequencing_run_nanopore")
@EnableAutoConfiguration
public class SequencingRunNanoporeTable {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    @Column(name="sequencing_run_id")
    private String sequencingRunId;
    @ManyToOne
    @JoinColumn(name = "instrument_id", referencedColumnName = "id")
    private SequencingInstrumentNanoporeTable instrumentId;
}