package ca.bccdcphl.sequencingruns.controller;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.hateoas.CollectionModel;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class RootControllerTests {
    private static final Logger log = LoggerFactory.getLogger(RootControllerTests.class);

    private RootController rootController = new RootController();

    @Test
    public void testGetRoot() {

        CollectionModel<Object> rootModel = rootController.getRoot();
        // The API Root has no data and two links ('/instruments' and '/sequencing-runs'
        assertThat(rootModel.getLinks().hasSize(2));

    }
}


