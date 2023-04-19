package ca.bccdcphl.sequencingruns.repositories;

import ca.bccdcphl.sequencingruns.model.aggregates.SequencingRunIllumina;
import org.springframework.data.repository.CrudRepository;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SequencingRunIlluminaRepository extends CrudRepository<SequencingRunIllumina, String> {
    @Override
    @NonNull
    public <S extends SequencingRunIllumina> S save(@NonNull S sequencingRun);

    @Override
    @NonNull
    public <S extends SequencingRunIllumina> Iterable<S> saveAll(@NonNull Iterable<S> sequencingRuns);

    @Override
    @NonNull
    public Optional<SequencingRunIllumina> findById(@NonNull String id);

    @Override
    public boolean existsById(@NonNull String id);

    @Override
    @NonNull
    public Iterable<SequencingRunIllumina> findAll();

    @Override
    @NonNull
    public Iterable<SequencingRunIllumina> findAllById(@NonNull Iterable<String> ids);

    @Override
    public long count();

    @Override
    public void deleteById(@NonNull String s);

    @Override
    public void delete(@NonNull SequencingRunIllumina sequencingRun);

    @Override
    public void deleteAllById(Iterable<? extends String> ids);

    @Override
    public void deleteAll(@NonNull Iterable<? extends SequencingRunIllumina> sequencingRuns);

    @Override
    public void deleteAll();
}
