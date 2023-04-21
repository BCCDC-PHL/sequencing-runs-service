package ca.bccdcphl.sequencingruns.dto;


import lombok.*;
import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.core.Relation;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Relation(collectionRelation = "instruments", itemRelation = "instrument")
public class SequencingInstrumentNanoporeDTO extends RepresentationModel<SequencingInstrumentNanoporeDTO> {
    private String id;
    private String instrument_type;
    private String instrument_model;
    private String status;

}
