package ca.bccdcphl.sequencingruns.model;

import ca.bccdcphl.sequencingruns.model.aggregates.SequencingRunNanopore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.*;

@Entity
@Table(name="sequenced_library_nanopore")
@Getter
@Setter
@NoArgsConstructor
public class SequencedLibraryNanopore extends AbstractPersistable<Long> {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private String libraryId;
    @ManyToOne
    @JoinColumn(name="sequencing_run_id", referencedColumnName="id")
    private SequencingRunNanopore sequencingRun;
    private String fastqCombinedPath;
}
