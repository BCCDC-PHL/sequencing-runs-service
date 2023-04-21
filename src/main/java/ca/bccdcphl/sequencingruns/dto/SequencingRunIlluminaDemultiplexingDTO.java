package ca.bccdcphl.sequencingruns.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.hateoas.server.core.Relation;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@Builder
@Relation(collectionRelation = "demultiplexings", itemRelation = "demultiplexing")
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class SequencingRunIlluminaDemultiplexingDTO {
    private String id;
    private String samplesheetPath;
    private List<SequencedLibraryIlluminaDTO> sequencedLibraries;
}
