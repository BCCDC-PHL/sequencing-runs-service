package ca.bccdcphl.sequencingruns.dto;


import lombok.Getter;
import lombok.Setter;
import org.springframework.hateoas.RepresentationModel;

@Getter
@Setter
public class SequencingInstrumentIlluminaDTO extends RepresentationModel<SequencingInstrumentIlluminaDTO> {
    private String id;
    private String instrument_type;
    private String instrument_model;
    private String status;
    private String current_sequencing_run_id;
    private String previous_sequencing_run_id;

    public SequencingInstrumentIlluminaDTO(
            String instrumentId,
            String type,
            String model
    ) {
        this.id = instrumentId;
        this.instrument_type = type;
        this.instrument_model = model;
    }

    public SequencingInstrumentIlluminaDTO(
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

    public SequencingInstrumentIlluminaDTO(
            String instrumentId,
            String type,
            String model,
            String status,
            String current_sequencing_run_id,
            String previous_sequencing_run_id
    ) {
        this.id = instrumentId;
        this.instrument_type = type;
        this.instrument_model = model;
        this.status = status;
        this.current_sequencing_run_id = current_sequencing_run_id;
        this.previous_sequencing_run_id = previous_sequencing_run_id;
    }
}
