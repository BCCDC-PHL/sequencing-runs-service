package ca.bccdcphl.sequencingruns.domain.model.entities;

import ca.bccdcphl.sequencingruns.domain.model.entities.aggregates.SequencingRunNanopore;

import javax.persistence.*;

@Entity
public class SequencedLibraryNanopore {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private String libraryId;
    @ManyToOne
    @JoinColumn(name="sequencing_run_id")
    private SequencingRunNanopore sequencingRun;
    private String fastqCombinedPath;
}
