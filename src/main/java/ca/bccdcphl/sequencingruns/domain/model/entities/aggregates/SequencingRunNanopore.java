package ca.bccdcphl.sequencingruns.domain.model.entities.aggregates;

import ca.bccdcphl.sequencingruns.domain.model.values.SequencingRunId;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class SequencingRunNanopore {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private SequencingRunId sequencingRunId;
}
