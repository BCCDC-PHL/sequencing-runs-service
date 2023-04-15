package ca.bccdcphl.sequencingruns.domain.model.values;

import ca.bccdcphl.sequencingruns.domain.model.ID;
import ca.bccdcphl.sequencingruns.domain.model.Value;

import javax.validation.constraints.NotNull;

public class SequencingInstrumentId extends ID implements Value<SequencingInstrumentId> {
    @NotNull
    private final String value;

    public SequencingInstrumentId(String value) {
        this.value = value;
    }

    @Override
    public String value() {
        return this.value;
    }
    @Override
    public boolean sameValueAs(SequencingInstrumentId other) {
        return other != null && this.value().equals(other.value());
    }
}
