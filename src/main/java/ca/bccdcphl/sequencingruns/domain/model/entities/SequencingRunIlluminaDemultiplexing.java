package ca.bccdcphl.sequencingruns.domain.model.entities;

import ca.bccdcphl.sequencingruns.domain.model.entities.aggregates.SequencingRunIllumina;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.*;

@Entity
@Table(name="sequencing_run_illumina_demultiplexing")
@Getter
@Setter
@NoArgsConstructor
public class SequencingRunIlluminaDemultiplexing extends AbstractPersistable<Long> {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name="sequencing_run_id")
    private SequencingRunIllumina sequencingRun;
    private Integer demultiplexingId;
    private String sampleSheetPath;
}
