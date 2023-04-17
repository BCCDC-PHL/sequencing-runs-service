package ca.bccdcphl.sequencingruns.infrastructure.persistence.mapping;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="sequencing_run_illumina")
@EnableAutoConfiguration
public class SequencingRunIlluminaTable {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    @Column(name="sequencing_run_id")
    private String sequencingRunId;

    @Column(name="instrument_id")
    private String instrumentId;

    @Column(name="flowcell_id")
    private String flowcellId;

    @Column(name="run_date")
    @Temporal(TemporalType.DATE)
    private Date runDate;

    @Column(name="experiment_name")
    private String experimentName;

    @Column(name="num_cycles_r1")
    private Integer numCyclesR1;

    @Column(name="num_cycles_r2")
    private Integer numCyclesR2;

    @Column(name="cluster_count")
    private Long clusterCount;

    @Column(name="cluster_count_passed_filter")
    private Long clusterCountPassedFilter;
}