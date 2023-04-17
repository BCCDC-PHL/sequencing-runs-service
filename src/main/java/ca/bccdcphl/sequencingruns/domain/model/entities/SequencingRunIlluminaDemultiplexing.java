package ca.bccdcphl.sequencingruns.domain.model.entities;

import ca.bccdcphl.sequencingruns.domain.model.entities.aggregates.SequencingRunIllumina;

import javax.persistence.*;

@Entity
public class SequencingRunIlluminaDemultiplexing {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name="sequencing_run_id")
    private SequencingRunIllumina sequencingRun;
    private Integer demultiplexingId;
    private String sampleSheetPath;
}
