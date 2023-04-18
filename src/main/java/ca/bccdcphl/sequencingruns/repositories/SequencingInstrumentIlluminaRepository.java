package ca.bccdcphl.sequencingruns.repositories;

import ca.bccdcphl.sequencingruns.domain.model.entities.aggregates.SequencingInstrumentIllumina;

import org.springframework.data.repository.CrudRepository;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SequencingInstrumentIlluminaRepository extends CrudRepository<SequencingInstrumentIllumina, String> {
    @Override
    @NonNull
    public <S extends SequencingInstrumentIllumina> S save(@NonNull S instrument);

    @Override
    @NonNull
    public <S extends SequencingInstrumentIllumina> Iterable<S> saveAll(@NonNull Iterable<S> instruments);

    @Override
    @NonNull
    public Optional<SequencingInstrumentIllumina> findById(@NonNull String id);

    @Override
    public boolean existsById(@NonNull String id);

    @Override
    @NonNull
    public Iterable<SequencingInstrumentIllumina> findAll();

    @Override
    @NonNull
    public Iterable<SequencingInstrumentIllumina> findAllById(@NonNull Iterable<String> ids);

    @Override
    public long count();

    @Override
    public void deleteById(@NonNull String id);

    @Override
    public void delete(@NonNull SequencingInstrumentIllumina instrument);

    @Override
    public void deleteAllById(Iterable<? extends String> ids);

    @Override
    public void deleteAll(@NonNull Iterable<? extends SequencingInstrumentIllumina> instruments);

    @Override
    public void deleteAll();
}
