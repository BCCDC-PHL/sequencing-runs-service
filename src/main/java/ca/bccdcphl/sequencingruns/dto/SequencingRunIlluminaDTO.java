package ca.bccdcphl.sequencingruns.dto;


import lombok.Getter;
import lombok.Setter;
import org.springframework.hateoas.RepresentationModel;

@Getter
@Setter
public class SequencingRunIlluminaDTO extends RepresentationModel<SequencingRunIlluminaDTO> {
    private String id;
    private String instrument_id;

    public SequencingRunIlluminaDTO(
            String sequencingRunId,
            String instrumentId
    ) {
        this.id = sequencingRunId;
        this.instrument_id = instrumentId;
    }
}
