package ca.bccdcphl.sequencingruns.dto;


import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.*;
import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.core.Relation;

import javax.validation.constraints.Min;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Relation(collectionRelation = "sequencing_runs", itemRelation = "sequencing_run")
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class SequencedLibraryNanoporeDTO extends RepresentationModel<SequencedLibraryNanoporeDTO> {
    private String id;
    private String samplesheetProjectId;
    private String translatedProjectId;
    private String barcodeName;
    private String barcodeAlias;
    @Min(value = 0, message = "Value must be non-negative")
    private Long numReads;
    private String fastqCombinedPath;
}
