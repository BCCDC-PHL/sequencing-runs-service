package ca.bccdcphl.sequencingruns.domain.model;

import java.io.Serializable;


public abstract class AggregateRoot<E, ID extends Serializable> implements Entity<E, ID> {

    public final ID entityId;

    protected AggregateRoot(ID entityId) {
        this.entityId = entityId;
    }

}