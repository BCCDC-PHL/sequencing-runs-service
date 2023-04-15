package ca.bccdcphl.sequencingruns.domain.model;

import java.util.Set;

public class CommandFailure {
    public final Set<String> codes;

    CommandFailure(){
        this.codes = Set.of("command_failure");
    }
}
