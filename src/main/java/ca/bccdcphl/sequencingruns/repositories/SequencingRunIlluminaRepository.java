package ca.bccdcphl.sequencingruns.repositories;

import ca.bccdcphl.sequencingruns.model.aggregates.SequencingRunIllumina;
import org.springframework.data.repository.CrudRepository;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Repository;

import javax.validation.constraints.NotNull;
import java.util.Optional;

@Repository
public interface SequencingRunIlluminaRepository extends CrudRepository<SequencingRunIllumina, Long> {
    @Override
    @NonNull
    public <S extends SequencingRunIllumina> S save(@NonNull S sequencingRun);

    @Override
    @NonNull
    public <S extends SequencingRunIllumina> Iterable<S> saveAll(@NonNull Iterable<S> sequencingRuns);

    @Override
    @NonNull
    public Optional<SequencingRunIllumina> findById(@NonNull Long id);

    public Optional<SequencingRunIllumina> findBySequencingRunId(@NonNull String sequencingRunId);

    @Override
    public boolean existsById(@NonNull Long id);

    @Override
    @NonNull
    public Iterable<SequencingRunIllumina> findAll();

    @Override
    @NonNull
    public Iterable<SequencingRunIllumina> findAllById(@NonNull Iterable<Long> ids);

    @Override
    public long count();

    @Override
    public void deleteById(@NonNull Long id);

    public void deleteBySequencingRunId(@NonNull String sequencingRunId);

    @Override
    public void delete(@NonNull SequencingRunIllumina sequencingRun);

    @Override
    public void deleteAllById(@NotNull Iterable<? extends Long> ids);

    @Override
    public void deleteAll(@NonNull Iterable<? extends SequencingRunIllumina> sequencingRuns);

    @Override
    public void deleteAll();
}
