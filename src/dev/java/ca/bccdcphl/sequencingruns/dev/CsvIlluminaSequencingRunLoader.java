package ca.bccdcphl.sequencingruns.dev;

import ca.bccdcphl.sequencingruns.model.aggregates.SequencingRunIllumina;
import ca.bccdcphl.sequencingruns.service.SequencingRunIlluminaService;
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
public class CsvIlluminaSequencingRunLoader {
    static final Logger log = LoggerFactory.getLogger(CsvIlluminaSequencingRunLoader.class);
    private final ResourceLoader resourceLoader;
    private final SequencingRunIlluminaService service;

    @Autowired
    public CsvIlluminaSequencingRunLoader(ResourceLoader resourceLoader, SequencingRunIlluminaService service) {
        this.resourceLoader = resourceLoader;
        this.service = service;
    }

    @PostConstruct
    public Iterable<SequencingRunIllumina> buildRunsFromCsv() throws IOException {
        log.info("STARTING DEV CSV ILLUMINA RUNS LOADER");
        FileReader fileReader;
        List<SequencingRunIllumina> savedInstruments = new ArrayList<>();

        try {
            Resource resource = resourceLoader.getResource("classpath:illumina_sequencing_runs.csv");
            InputStream inputStream = resource.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            String line = null;
            do {
                line = reader.readLine();
                log.info("READ LINE: " + line);
                if (line != null) {
                    List<String> lineSplit = List.of(line.split(","));
                    SequencingRunIllumina savedSequencingRun = service.createSequencingRun(lineSplit.get(0), lineSplit.get(1), lineSplit.get(2));
                    savedInstruments.add(savedSequencingRun);
                }
            } while (line != null);
        } catch (FileNotFoundException ignored) {

        }
        return savedInstruments;
    }
}
