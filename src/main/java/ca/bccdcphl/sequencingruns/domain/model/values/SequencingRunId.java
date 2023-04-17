package ca.bccdcphl.sequencingruns.domain.model.values;

import ca.bccdcphl.sequencingruns.domain.model.ID;
import ca.bccdcphl.sequencingruns.domain.model.Value;

import javax.validation.constraints.NotNull;

public class SequencingRunId extends ID implements Value<SequencingRunId> {
    @NotNull
    private final String value;

    public SequencingRunId(String value) {
        this.value = value;
    }

    @Override
    public String value() {
        return this.value;
    }

    @Override
    public boolean sameValueAs(SequencingRunId other) {
        return other != null && this.value().equals(other.value());
    }
}