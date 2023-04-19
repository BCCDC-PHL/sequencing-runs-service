package ca.bccdcphl.sequencingruns.repositories;

import ca.bccdcphl.sequencingruns.model.aggregates.SequencingInstrumentIllumina;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SequencingInstrumentIlluminaRepository extends JpaRepository<SequencingInstrumentIllumina, Long> {
    @Override
    @NonNull
    public <S extends SequencingInstrumentIllumina> S save(@NonNull S instrument);

    @Override
    @NonNull
    public <S extends SequencingInstrumentIllumina> List<S> saveAll(@NonNull Iterable<S> instruments);

    @Override
    @NonNull
    public Optional<SequencingInstrumentIllumina> findById(@NonNull Long id);

    public Optional<SequencingInstrumentIllumina> findByInstrumentId(@NonNull String instrumentId);

    @Override
    public boolean existsById(@NonNull Long id);

    @Override
    @NonNull
    public List<SequencingInstrumentIllumina> findAll();

    @Override
    @NonNull
    public List<SequencingInstrumentIllumina> findAllById(@NonNull Iterable<Long> ids);

    @Override
    public long count();

    @Override
    public void deleteById(@NonNull Long id);

    public void deleteByInstrumentId(@NonNull String id);

    @Override
    public void delete(@NonNull SequencingInstrumentIllumina instrument);

    @Override
    public void deleteAllById(Iterable<? extends Long> ids);

    @Override
    public void deleteAll(@NonNull Iterable<? extends SequencingInstrumentIllumina> instruments);

    @Override
    public void deleteAll();
}
