package ca.bccdcphl.sequencingruns.dto;


import lombok.Getter;
import lombok.Setter;
import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.core.Relation;

@Getter
@Setter
@Relation(collectionRelation = "sequencing_runs", itemRelation = "sequencing_run")
public class SequencingRunNanoporeDTO extends RepresentationModel<SequencingRunNanoporeDTO> {
    private String id;
    private String instrument_id;

    public SequencingRunNanoporeDTO(
            String sequencingRunId,
            String instrumentId
    ) {
        this.id = sequencingRunId;
        this.instrument_id = instrumentId;
    }
}
