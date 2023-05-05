package ca.bccdcphl.sequencingruns.model;

import lombok.*;
import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.*;

@Entity
@Table(name="sequenced_library_illumina")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SequencedLibraryIllumina extends AbstractPersistable<Long> {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private String libraryId;
    @ManyToOne
    @JoinColumn(name="demultiplexing_id", referencedColumnName="id")
    private SequencingRunIlluminaDemultiplexing demultiplexing;
    private String samplesheetProjectId;
    private String translatedProjectId;
    private String index;
    private String index2;
    private Long numReads;
    @Column(name="fastq_path_r1")
    private String fastqPathR1;
    @Column(name="fastq_path_r2")
    private String fastqPathR2;
}
