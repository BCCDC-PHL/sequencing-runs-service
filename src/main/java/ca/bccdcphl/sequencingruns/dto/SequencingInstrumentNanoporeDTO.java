package ca.bccdcphl.sequencingruns.dto;


import lombok.Getter;
import lombok.Setter;
import org.springframework.hateoas.RepresentationModel;

@Getter
@Setter
public class SequencingInstrumentNanoporeDTO extends RepresentationModel<SequencingInstrumentNanoporeDTO> {
    private String id;
    private String instrument_type;
    private String instrument_model;
    private String status;

    public SequencingInstrumentNanoporeDTO(
            String instrumentId,
            String type,
            String model

    ) {
        this.id = instrumentId;
        this.instrument_type = type;
        this.instrument_model = model;
    }

    public SequencingInstrumentNanoporeDTO(
            String instrumentId,
            String type,
            String model,
            String status
    ) {
        this.id = instrumentId;
        this.instrument_type = type;
        this.instrument_model = model;
        this.status = status;
    }
}
