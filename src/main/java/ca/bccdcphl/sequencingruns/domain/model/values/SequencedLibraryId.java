package ca.bccdcphl.sequencingruns.domain.model.values;

import ca.bccdcphl.sequencingruns.domain.model.ID;
import ca.bccdcphl.sequencingruns.domain.model.Value;

import javax.validation.constraints.NotNull;

public class SequencedLibraryId extends ID implements Value<SequencedLibraryId> {
    @NotNull
    private final String value;

    public SequencedLibraryId(String value) {
        this.value = value;
    }

    @Override
    public String value(){
        return this.value;
    }
    @Override
    public boolean sameValueAs(SequencedLibraryId other) {
        return other != null && this.value().equals(other.value());
    }
}
