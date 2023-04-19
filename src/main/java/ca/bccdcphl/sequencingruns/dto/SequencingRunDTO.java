package ca.bccdcphl.sequencingruns.dto;


import lombok.Getter;
import lombok.Setter;
import org.springframework.hateoas.RepresentationModel;

@Getter
@Setter
public class SequencingRunDTO extends RepresentationModel<SequencingRunDTO> {
    private String id;
    private String instrument_id;

    public SequencingRunDTO(
            String sequencingRunId,
            String instrumentId
    ) {
        this.id = sequencingRunId;
        this.instrument_id = instrumentId;
    }
}
