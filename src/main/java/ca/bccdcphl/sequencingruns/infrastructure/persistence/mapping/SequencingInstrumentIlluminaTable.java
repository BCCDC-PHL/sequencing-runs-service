package ca.bccdcphl.sequencingruns.infrastructure.persistence.mapping;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

import javax.persistence.Column;
import javax.persistence.Table;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Table(name="sequencing_instrument")
@EnableAutoConfiguration
public class SequencingInstrumentIlluminaTable {
    @Id
    private Long id;
    @Column(name="instrument_id")
    private String instrumentId;
    private String status;
}