package ca.bccdcphl.sequencingruns.domain.model.entities;

import javax.persistence.*;

@Entity
public class SequencedLibraryIllumina {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private String libraryId;
    @ManyToOne
    @JoinColumn(name="demultiplexing_id")
    private SequencingRunIlluminaDemultiplexing demultiplexing;
    private String samplesheetProjectId;
    private String translatedProjectId;
    private String index1;
    private String index2;
    private Long numReads;
    @Column(name="fastq_path_r1")
    private String fastqPathR1;
    @Column(name="fastq_path_r2")
    private String fastqPathR2;
}
