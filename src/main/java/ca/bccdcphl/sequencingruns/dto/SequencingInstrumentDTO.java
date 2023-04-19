package ca.bccdcphl.sequencingruns.dto;


import lombok.Getter;
import lombok.Setter;
import org.springframework.hateoas.RepresentationModel;

@Getter
@Setter
public class SequencingInstrumentDTO extends RepresentationModel<SequencingInstrumentDTO> {
    private String id;
    private String instrument_type;
    private String instrument_model;

    public SequencingInstrumentDTO(String instrumentId, String type, String model) {
        this.id = instrumentId;
        this.instrument_type = type;
        this.instrument_model = model;
    }
}
