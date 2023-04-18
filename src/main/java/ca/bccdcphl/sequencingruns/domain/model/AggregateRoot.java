package ca.bccdcphl.sequencingruns.domain.model;

import java.io.Serializable;


public abstract class AggregateRoot<E, ID extends Serializable> implements Entity<E, ID> {

    public final ID entityId;

    public AggregateRoot(){
        this.entityId = null;
    }

    public AggregateRoot(ID entityId) {
        this.entityId = entityId;
    }

}