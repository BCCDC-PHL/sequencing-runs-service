package ca.bccdcphl.sequencingruns.domain.model.entities;

import ca.bccdcphl.sequencingruns.domain.model.entities.aggregates.SequencingRunNanopore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.*;

@Entity
@Table(name="sequenced_library_illumina")
@Getter
@Setter
@NoArgsConstructor
public class SequencedLibraryNanopore extends AbstractPersistable<Long> {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private String libraryId;
    @ManyToOne
    @JoinColumn(name="sequencing_run_id")
    private SequencingRunNanopore sequencingRun;
    private String fastqCombinedPath;
}
