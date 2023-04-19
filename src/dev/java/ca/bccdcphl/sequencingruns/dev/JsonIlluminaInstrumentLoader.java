package ca.bccdcphl.sequencingruns.dev;

import ca.bccdcphl.sequencingruns.model.aggregates.SequencingInstrumentIllumina;
import ca.bccdcphl.sequencingruns.service.SequencingInstrumentIlluminaService;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class JsonIlluminaInstrumentLoader {
    static final Logger log = LoggerFactory.getLogger(JsonIlluminaInstrumentLoader.class);
    private final ResourceLoader resourceLoader;
    private final SequencingInstrumentIlluminaService service;
    private final ObjectMapper objectMapper;

    @Autowired
    public JsonIlluminaInstrumentLoader(ResourceLoader resourceLoader, SequencingInstrumentIlluminaService service, ObjectMapper objectMapper) {
        this.resourceLoader = resourceLoader;
        this.service = service;
        this.objectMapper = objectMapper;
    }

    @PostConstruct
    public Iterable<SequencingInstrumentIllumina> buildInstrumentsFromCsv() throws IOException {
        log.info("STARTING DEV JSON ILLUMINA INSTRUMENTS LOADER");
        List<SequencingInstrumentIllumina> savedInstruments = new ArrayList<>();
        try {
            File resource = resourceLoader.getResource("classpath:illumina_instruments.json").getFile();
            JsonNode tree = objectMapper.readTree(resource);
            for (JsonNode jsonInstrument : tree) {
                SequencingInstrumentIllumina savedInstrument = service.createInstrument(
                        jsonInstrument.get("instrument_id").textValue(),
                        jsonInstrument.get("type").textValue(),
                        jsonInstrument.get("model").textValue()
                );
                savedInstruments.add(savedInstrument);
            }
        } catch (FileNotFoundException ignored) {

        }
        return savedInstruments;
    }
}
