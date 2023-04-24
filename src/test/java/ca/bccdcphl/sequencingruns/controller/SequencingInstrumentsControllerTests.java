package ca.bccdcphl.sequencingruns.controller;

import ca.bccdcphl.sequencingruns.service.SequencingInstrumentIlluminaService;
import ca.bccdcphl.sequencingruns.service.SequencingInstrumentNanoporeService;
import ca.bccdcphl.sequencingruns.service.SequencingRunIlluminaService;
import ca.bccdcphl.sequencingruns.service.SequencingRunNanoporeService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.hateoas.CollectionModel;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletRequest;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;


@ExtendWith(MockitoExtension.class)
public class SequencingInstrumentsControllerTests {
    private static final Logger log = LoggerFactory.getLogger(SequencingInstrumentsControllerTests.class);

    @InjectMocks
    SequencingInstrumentsController controller;

    @Mock
    SequencingInstrumentIlluminaService illuminaInstrumentsService;

    @Mock
    SequencingInstrumentNanoporeService nanoporeInstrumentsService;

    @Mock
    SequencingRunIlluminaService illuminaRunsService;

    @Mock
    SequencingRunNanoporeService nanoporeRunsService;


    @Test
    public void testGetInstruments() {

        MockHttpServletRequest request = new MockHttpServletRequest();
        CollectionModel<Object> response = controller.getInstruments();
        // The '/instruments' endpoint has no data and two links ('/instruments/illumina' and '/instruments/nanopore'
        assertThat(response.getLinks().hasSize(2));
    }
}


