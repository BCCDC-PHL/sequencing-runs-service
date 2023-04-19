package ca.bccdcphl.sequencingruns.repositories;

import ca.bccdcphl.sequencingruns.model.aggregates.SequencingInstrumentNanopore;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SequencingInstrumentNanoporeRepository extends JpaRepository<SequencingInstrumentNanopore, Long> {
    @Override
    @NonNull
    public <S extends SequencingInstrumentNanopore> S save(@NonNull S instrument);

    @Override
    @NonNull
    public <S extends SequencingInstrumentNanopore> List<S> saveAll(@NonNull Iterable<S> instruments);

    @Override
    @NonNull
    public Optional<SequencingInstrumentNanopore> findById(@NonNull Long id);

    public Optional<SequencingInstrumentNanopore> findByInstrumentId(@NonNull String instrumentId);

    @Override
    @NonNull
    public List<SequencingInstrumentNanopore> findAll();

    @Override
    @NonNull
    public List<SequencingInstrumentNanopore> findAllById(@NonNull Iterable<Long> ids);

    @Override
    public long count();

    @Override
    public void delete(@NonNull SequencingInstrumentNanopore instrument);

    @Override
    public void deleteAllById(Iterable<? extends Long> ids);

    public void deleteByInstrumentId(@NonNull String id);

    @Override
    public void deleteAll(@NonNull Iterable<? extends SequencingInstrumentNanopore> instruments);

    @Override
    public void deleteAll();
}
