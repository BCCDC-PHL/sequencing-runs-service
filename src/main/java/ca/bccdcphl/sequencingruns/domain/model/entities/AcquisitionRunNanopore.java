package ca.bccdcphl.sequencingruns.domain.model.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class AcquisitionRunNanopore {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private String acquisitionRunId;
}
