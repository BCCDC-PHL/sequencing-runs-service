package ca.bccdcphl.sequencingruns.domain.model;

import java.io.Serializable;
import ca.bccdcphl.sequencingruns.domain.model.ID;

public interface Entity<E, ID extends Serializable> {
    /**
     * Entities compare by identity, not by attributes.
     *
     * @param other The other entity.
     * @return true if the identities are the same, regardles of other attributes.
     */
    boolean sameIdentityAs(E other);

    ID id();
}
