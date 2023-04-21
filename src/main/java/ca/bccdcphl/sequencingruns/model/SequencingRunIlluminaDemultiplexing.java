package ca.bccdcphl.sequencingruns.model;

import ca.bccdcphl.sequencingruns.model.aggregates.SequencingRunIllumina;
import lombok.*;
import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="sequencing_run_illumina_demultiplexing")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SequencingRunIlluminaDemultiplexing extends AbstractPersistable<Long> {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    @ManyToOne
    @JoinColumn(name="sequencing_run_id", referencedColumnName="id")
    private SequencingRunIllumina sequencingRun;
    private Integer demultiplexingId;
    private String samplesheetPath;
    @OneToMany(mappedBy="demultiplexing", cascade={CascadeType.PERSIST, CascadeType.REMOVE})
    private List<SequencedLibraryIllumina> sequencedLibraries;
}
