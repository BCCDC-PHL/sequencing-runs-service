package ca.bccdcphl.sequencingruns.dto;


import lombok.Getter;
import lombok.Setter;
import org.springframework.hateoas.RepresentationModel;

@Getter
@Setter
public class SequencingInstrumentDTO extends RepresentationModel<SequencingInstrumentDTO> {
    private String instrumentId;
    private String type;
    private String model;

    public SequencingInstrumentDTO(String instrumentId, String type, String model) {
        this.instrumentId = instrumentId;
        this.type = type;
        this.model = model;
    }
}
