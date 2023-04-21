package ca.bccdcphl.sequencingruns.dto;


import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.*;
import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.core.Relation;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Relation(collectionRelation = "instruments", itemRelation = "instrument")
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class SequencingInstrumentIlluminaDTO extends RepresentationModel<SequencingInstrumentIlluminaDTO> {
    private String id;
    private String instrumentType;
    private String instrumentModel;
    private String status;
    private String currentSequencingRunId;
    private String previousSequencingRunId;

}
