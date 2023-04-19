package ca.bccdcphl.sequencingruns.model;

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
}
