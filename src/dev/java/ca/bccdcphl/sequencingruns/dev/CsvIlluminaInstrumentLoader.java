package ca.bccdcphl.sequencingruns.dev;

import ca.bccdcphl.sequencingruns.model.aggregates.SequencingInstrumentIllumina;
import ca.bccdcphl.sequencingruns.service.SequencingInstrumentIlluminaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;

import javax.annotation.PostConstruct;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

// @Component
public class CsvIlluminaInstrumentLoader {
    static final Logger log = LoggerFactory.getLogger(CsvIlluminaInstrumentLoader.class);
    private final ResourceLoader resourceLoader;
    private final SequencingInstrumentIlluminaService service;

    @Autowired
    public CsvIlluminaInstrumentLoader(ResourceLoader resourceLoader, SequencingInstrumentIlluminaService service) {
        this.resourceLoader = resourceLoader;
        this.service = service;
    }

    @PostConstruct
    public Iterable<SequencingInstrumentIllumina> buildInstrumentsFromCsv() throws IOException {
        log.info("STARTING DEV CSV ILLUMINA INSTRUMENTS LOADER");
        List<SequencingInstrumentIllumina> savedInstruments = new ArrayList<>();

        try {
            Resource resource = resourceLoader.getResource("classpath:illumina_instruments.csv");
            InputStream inputStream = resource.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            String line = null;
            do {
                line = reader.readLine();
                log.info("READ LINE: " + line);
                if (line != null) {
                    List<String> lineSplit = List.of(line.split(","));
                    SequencingInstrumentIllumina savedInstrument = service.createInstrument(lineSplit.get(0), lineSplit.get(1), lineSplit.get(2));
                    savedInstruments.add(savedInstrument);
                }
            } while (line != null);
        } catch (FileNotFoundException ignored) {

        }
        return savedInstruments;
    }
}
