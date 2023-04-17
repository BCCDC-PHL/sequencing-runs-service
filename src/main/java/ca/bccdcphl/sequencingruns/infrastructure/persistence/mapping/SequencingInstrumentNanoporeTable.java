package ca.bccdcphl.sequencingruns.infrastructure.persistence.mapping;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

import javax.persistence.*;

@Entity
@Table(name="sequencing_instrument_nanopore")
@EnableAutoConfiguration
public class SequencingInstrumentNanoporeTable {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    @Column(name="instrument_id")
    private String instrumentId;

    @Column(name="status")
    private String status;
}