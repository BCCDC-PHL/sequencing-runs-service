package ca.bccdcphl.sequencingruns.model;

import ca.bccdcphl.sequencingruns.model.aggregates.SequencingRunNanopore;
import lombok.*;
import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="acquisition_run_nanopore")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AcquisitionRunNanopore extends AbstractPersistable<Long> {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private String acquisitionRunId;
    @ManyToOne
    @JoinColumn(name="sequencing_run_id", referencedColumnName="id")
    private SequencingRunNanopore sequencingRun;
    private Long numReadsTotal;
    private Long numReadsPassedFilter;
    private Long numBasesTotal;
    private Long numBasesPassedFilter;
    private String startupState;
    private String state;
    private String finishingState;
    private String stopReason;
    private String purpose;
    private String basecallingConfigFilename;
    private Float eventsToBaseRatio;
    private Long sampleRate;
    private Long channelCount;
    @OneToMany(mappedBy="acquisitionRun", cascade={CascadeType.PERSIST, CascadeType.REMOVE})
    private List<SequencedLibraryNanopore> sequencedLibraries;
}
