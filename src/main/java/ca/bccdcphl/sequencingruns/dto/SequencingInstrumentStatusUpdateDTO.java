package ca.bccdcphl.sequencingruns.dto;


import lombok.Getter;
import lombok.Setter;
import org.springframework.hateoas.RepresentationModel;

@Getter
@Setter
public class SequencingInstrumentStatusUpdateDTO extends RepresentationModel<SequencingInstrumentStatusUpdateDTO> {

    private String status;
    private String current_sequencing_run_id;

    public SequencingInstrumentStatusUpdateDTO(
            String status
    ) {
        this.status = status;
    }

    public SequencingInstrumentStatusUpdateDTO(
            String status,
            String current_sequencing_run_id
    ) {
        this.status = status;
        this.current_sequencing_run_id = current_sequencing_run_id;
    }

}
