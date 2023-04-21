package ca.bccdcphl.sequencingruns.dev;

import ca.bccdcphl.sequencingruns.dto.SequencingRunIlluminaDTO;
import ca.bccdcphl.sequencingruns.model.aggregates.SequencingRunIllumina;
import ca.bccdcphl.sequencingruns.service.SequencingRunIlluminaService;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.DataInput;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
public class JsonIlluminaSequencingRunLoader {
    static final Logger log = LoggerFactory.getLogger(JsonIlluminaSequencingRunLoader.class);
    private final ResourceLoader resourceLoader;
    private final SequencingRunIlluminaService service;
    private final ObjectMapper objectMapper;

    @Autowired
    public JsonIlluminaSequencingRunLoader(ResourceLoader resourceLoader, SequencingRunIlluminaService service, ObjectMapper objectMapper) {
        this.resourceLoader = resourceLoader;
        this.service = service;
        this.objectMapper = objectMapper;
    }

    @PostConstruct
    public Iterable<SequencingRunIllumina> buildInstrumentsFromCsv() throws IOException {
        log.info("STARTING DEV JSON ILLUMINA SEQUENCING RUN LOADER");
        List<SequencingRunIllumina> savedSequencingRuns = new ArrayList<>();
        DateFormat dateFormat = new SimpleDateFormat("YYYY-MM-dd");
        try {
            File resource = resourceLoader.getResource("classpath:illumina_sequencing_runs.json").getFile();
            JsonNode tree = objectMapper.readTree(resource);

            for (JsonNode jsonSequencingRun : tree) {
                SequencingRunIlluminaDTO sequencingRunDTO = objectMapper.treeToValue(jsonSequencingRun, SequencingRunIlluminaDTO.class);
                SequencingRunIllumina savedSequencingRun = service.createSequencingRun(sequencingRunDTO);
                savedSequencingRuns.add(savedSequencingRun);
            }
        } catch (FileNotFoundException ignored) {

        }
        return savedSequencingRuns;
    }
}
