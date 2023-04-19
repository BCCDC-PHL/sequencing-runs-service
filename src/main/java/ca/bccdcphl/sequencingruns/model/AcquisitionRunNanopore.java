package ca.bccdcphl.sequencingruns.model;

import ca.bccdcphl.sequencingruns.model.aggregates.SequencingRunNanopore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.*;

@Entity
@Table(name="acquisition_run_nanopore")
@Getter
@Setter
@NoArgsConstructor
public class AcquisitionRunNanopore extends AbstractPersistable<Long> {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private String acquisitionRunId;
    @ManyToOne
    @JoinColumn(name="sequencing_run_id")
    private SequencingRunNanopore sequencingRun;
    private Long numReadsTotal;
    private Long numReadsPassedFilter;
    private Long numBasesPassedFilter;
    private String startupState;
    private String state;
    private String finishingState;
    private String stopReason;
    private String purpose;
    private Float eventsToBaseRatio;
    private Long sampleRate;
    private Long channelCount;
}
