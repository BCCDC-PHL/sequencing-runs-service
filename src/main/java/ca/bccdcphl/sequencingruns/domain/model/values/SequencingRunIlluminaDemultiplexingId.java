package ca.bccdcphl.sequencingruns.domain.model.values;

import ca.bccdcphl.sequencingruns.domain.model.ID;
import ca.bccdcphl.sequencingruns.domain.model.Value;

import javax.validation.constraints.NotNull;

public class SequencingRunIlluminaDemultiplexingId extends ID implements Value<SequencingRunIlluminaDemultiplexingId> {
    @NotNull
    private final Integer value;

    public SequencingRunIlluminaDemultiplexingId(Integer value) {
        this.value = value;
    }

    public Integer value() {
        return this.value;
    }
    @Override
    public boolean sameValueAs(SequencingRunIlluminaDemultiplexingId other) {
        return other != null && this.value.equals(other.value);
    }
}
