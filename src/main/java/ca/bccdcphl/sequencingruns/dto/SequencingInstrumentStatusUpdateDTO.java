package ca.bccdcphl.sequencingruns.dto;


import lombok.*;
import org.springframework.hateoas.RepresentationModel;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SequencingInstrumentStatusUpdateDTO extends RepresentationModel<SequencingInstrumentStatusUpdateDTO> {

    private String status;
    private String current_sequencing_run_id;

}
