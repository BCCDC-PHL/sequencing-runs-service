package ca.bccdcphl.sequencingruns.infrastructure.persistence.mapping;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

import javax.persistence.*;

@Entity
@Table(name="sequencing_instrument_illumina")
@EnableAutoConfiguration
public class SequencingInstrumentIlluminaTable {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    @Column(name="instrument_id")
    private String instrumentId;

    private String status;
}