package ca.bccdcphl.sequencingruns.dto;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.core.Relation;

import javax.validation.constraints.Min;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@Builder
@Relation(collectionRelation = "sequencing_runs", itemRelation = "sequencing_run")
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class SequencedLibraryIlluminaDTO extends RepresentationModel<SequencedLibraryIlluminaDTO> {
    private String id;
    private String samplesheetProjectId;
    private String translatedProjectId;
    private String index1;
    private String index2;
    private String fastqPathR1;
    private String fastqPathR2;
    @Min(value = 0, message = "Value must be non-negative")
    private Long numReads;
}
