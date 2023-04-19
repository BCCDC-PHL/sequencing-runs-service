package ca.bccdcphl.sequencingruns.repositories;

import ca.bccdcphl.sequencingruns.model.aggregates.SequencingRunNanopore;
import org.springframework.data.repository.CrudRepository;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SequencingRunNanoporeRepository extends CrudRepository<SequencingRunNanopore, String> {
    @Override
    @NonNull
    public <S extends SequencingRunNanopore> S save(@NonNull S sequencingRun);

    @Override
    @NonNull
    public <S extends SequencingRunNanopore> Iterable<S> saveAll(@NonNull Iterable<S> sequencingRuns);

    @Override
    @NonNull
    public Optional<SequencingRunNanopore> findById(@NonNull String id);

    @Override
    public boolean existsById(@NonNull String id);

    @Override
    @NonNull
    public Iterable<SequencingRunNanopore> findAll();

    @Override
    @NonNull
    public Iterable<SequencingRunNanopore> findAllById(@NonNull Iterable<String> ids);

    @Override
    public long count();

    @Override
    public void deleteById(@NonNull String s);

    @Override
    public void delete(@NonNull SequencingRunNanopore sequencingRun);

    @Override
    public void deleteAllById(Iterable<? extends String> ids);

    @Override
    public void deleteAll(@NonNull Iterable<? extends SequencingRunNanopore> sequencingRuns);

    @Override
    public void deleteAll();
}
