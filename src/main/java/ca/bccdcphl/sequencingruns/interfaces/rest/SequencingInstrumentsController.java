package ca.bccdcphl.sequencingruns.interfaces.rest;

import ca.bccdcphl.sequencingruns.domain.model.values.SequencingInstrumentId;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.hateoas.CollectionModel;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Arrays;
import java.util.List;

@RestController()
@RequestMapping("/instruments")
public class SequencingInstrumentsController {

    private static final Logger log = LoggerFactory.getLogger(SequencingInstrumentsController.class);

    public SequencingInstrumentsController() {

    }

    @GetMapping(consumes = MediaType.ALL_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public CollectionModel<SequencingInstrumentId> getInstruments(@Valid RequestEntity request) {

        log.debug("Request {}", request);
        SequencingInstrumentId instrumentId = new SequencingInstrumentId("M00123");
        List<SequencingInstrumentId> instruments = List.of(instrumentId);
        CollectionModel<SequencingInstrumentId> response =  CollectionModel.of(instruments);

        return response;
    }
}
