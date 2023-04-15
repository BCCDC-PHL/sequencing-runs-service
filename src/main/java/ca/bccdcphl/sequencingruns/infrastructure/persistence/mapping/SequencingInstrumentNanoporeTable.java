package ca.bccdcphl.sequencingruns.infrastructure.persistence.mapping;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="sequencing_instrument")
@EnableAutoConfiguration
public class SequencingInstrumentNanoporeTable {
    @Id
    private Long id;
    @Column(name="instrument_id")
    private String instrumentId;

    @Column(name="status")
    private String status;
}