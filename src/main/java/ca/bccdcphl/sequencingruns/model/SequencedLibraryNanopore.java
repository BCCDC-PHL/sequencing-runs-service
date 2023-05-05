package ca.bccdcphl.sequencingruns.model;

import ca.bccdcphl.sequencingruns.model.aggregates.SequencingRunNanopore;
import lombok.*;
import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.*;
import javax.validation.constraints.Min;

@Entity
@Table(name="sequenced_library_nanopore")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SequencedLibraryNanopore extends AbstractPersistable<Long> {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private String libraryId;
    @ManyToOne
    @JoinColumn(name="acquisition_run_id", referencedColumnName="id")
    private AcquisitionRunNanopore acquisitionRun;
    private String samplesheetProjectId;
    private String translatedProjectId;
    private String barcodeName;
    private String barcodeAlias;
    @Min(value=0, message="Value must be non-negative")
    private Long numReads;
    private String fastqCombinedPath;

}
