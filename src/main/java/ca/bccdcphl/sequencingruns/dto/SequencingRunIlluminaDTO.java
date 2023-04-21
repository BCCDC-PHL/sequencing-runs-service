package ca.bccdcphl.sequencingruns.dto;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.core.Relation;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@Builder
@Relation(collectionRelation = "sequencing_runs", itemRelation = "sequencing_run")
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class SequencingRunIlluminaDTO extends RepresentationModel<SequencingRunIlluminaDTO> {
    private String id;
    private String instrumentId;
    private String flowcellId;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern="yyyy-MM-dd")
    private Date runDate;
    private String experimentName;
    private Integer numCyclesR1;
    private Integer numCyclesR2;
    private Long clusterCount;
    private Long clusterCountPassedFilter;
    private Float percentClustersPassedFilter;
    private Float errorRate;
    private Float firstCycleIntensity;
    private Float percentAligned;
    private Float q30Percent;
    private Float projectedYieldGigabases;
    private Float yieldGigabases;
    private Long numReads;
    private Long numReadsPassedFilter;
    private List<SequencingRunIlluminaDemultiplexingDTO> demultiplexings;

}
