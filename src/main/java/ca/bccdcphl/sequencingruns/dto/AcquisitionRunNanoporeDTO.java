package ca.bccdcphl.sequencingruns.dto;

import ca.bccdcphl.sequencingruns.model.SequencedLibraryNanopore;
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
@Relation(collectionRelation = "acquisition_runs", itemRelation = "acquisition_run")
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class AcquisitionRunNanoporeDTO {
    private String id;
    private Long numReadsTotal;
    private Long numReadsPassedFilter;
    private Long numBasesTotal;
    private Long numBasesPassedFilter;
    private String startupState;
    private String state;
    private String finishingState;
    private String stopReason;
    private String purpose;
    private String basecallingConfigFilename;
    private Float eventsToBaseRatio;
    private Long sampleRate;
    private Long channelCount;
    private List<SequencedLibraryNanoporeDTO> sequencedLibraries;

}
