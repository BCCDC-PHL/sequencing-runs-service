package ca.bccdcphl.sequencingruns.dev;

import ca.bccdcphl.sequencingruns.model.aggregates.SequencingInstrumentNanopore;
import ca.bccdcphl.sequencingruns.service.SequencingInstrumentNanoporeService;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Component
public class JsonNanoporeInstrumentLoader {
    static final Logger log = LoggerFactory.getLogger(JsonNanoporeInstrumentLoader.class);
    private final ResourceLoader resourceLoader;
    private final SequencingInstrumentNanoporeService service;
    private final ObjectMapper objectMapper;

    @Autowired
    public JsonNanoporeInstrumentLoader(ResourceLoader resourceLoader, SequencingInstrumentNanoporeService service, ObjectMapper objectMapper) {
        this.resourceLoader = resourceLoader;
        this.service = service;
        this.objectMapper = objectMapper;
    }

    @PostConstruct
    public Iterable<SequencingInstrumentNanopore> buildInstrumentsFromCsv() throws IOException {
        log.info("STARTING DEV JSON NANOPORE INSTRUMENTS LOADER");
        List<SequencingInstrumentNanopore> savedInstruments = new ArrayList<>();
        try {
            File resource = resourceLoader.getResource("classpath:nanopore_instruments.json").getFile();
            JsonNode tree = objectMapper.readTree(resource);
            for (JsonNode jsonInstrument : tree) {
                SequencingInstrumentNanopore savedInstrument = service.createInstrument(
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
