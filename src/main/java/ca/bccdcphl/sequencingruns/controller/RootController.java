package ca.bccdcphl.sequencingruns.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.Link;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.Collections;

/**
 * API Root controller, serves responses for requests to '/'
 *
 */
@RestController()
public class RootController {
    private static final Logger log = LoggerFactory.getLogger(RootController.class);

    @Autowired
    public RootController(){

    }

    @GetMapping(value="/")
    public CollectionModel<Object> getRoot() {
        Collection<Object> emptyCollection = Collections.emptySet();
        CollectionModel<Object> model = CollectionModel.of(emptyCollection);
        Link instrumentsLink = Link.of("/instruments", "instruments");
        Link sequencingRunsLink = Link.of("/sequencing-runs", "sequencing_runs");
        model.add(instrumentsLink);
        model.add(sequencingRunsLink);

        return model;
    }
}
