package ca.bccdcphl.sequencingruns.repositories;

import ca.bccdcphl.sequencingruns.domain.model.entities.aggregates.SequencingInstrumentNanopore;
import org.springframework.data.repository.CrudRepository;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SequencingInstrumentNanoporeRepository extends CrudRepository<SequencingInstrumentNanopore, String> {
    @Override
    @NonNull
    public <S extends SequencingInstrumentNanopore> S save(@NonNull S instrument);

    @Override
    @NonNull
    public <S extends SequencingInstrumentNanopore> Iterable<S> saveAll(@NonNull Iterable<S> instruments);

    @Override
    @NonNull
    public Optional<SequencingInstrumentNanopore> findById(@NonNull String id);

    @Override
    public boolean existsById(@NonNull String id);

    @Override
    @NonNull
    public Iterable<SequencingInstrumentNanopore> findAll();

    @Override
    @NonNull
    public Iterable<SequencingInstrumentNanopore> findAllById(@NonNull Iterable<String> ids);

    @Override
    public long count();

    @Override
    public void deleteById(@NonNull String id);

    @Override
    public void delete(@NonNull SequencingInstrumentNanopore instrument);

    @Override
    public void deleteAllById(Iterable<? extends String> ids);

    @Override
    public void deleteAll(@NonNull Iterable<? extends SequencingInstrumentNanopore> instruments);

    @Override
    public void deleteAll();
}
