package ca.bccdcphl.sequencingruns.repositories;

import ca.bccdcphl.sequencingruns.domain.model.entities.aggregates.SequencingInstrumentIllumina;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SequencingInstrumentIlluminaRepository extends CrudRepository<SequencingInstrumentIllumina, String> {
    @Override
    @NonNull
    public <S extends SequencingInstrumentIllumina> S save(@NonNull S instrument);

    @Override
    @NonNull
    public <S extends SequencingInstrumentIllumina> Iterable<S> saveAll(@NonNull Iterable<S> instruments );

    @Override
    @NonNull
    public Optional<SequencingInstrumentIllumina> findById(@NonNull String s);

    @Override
    public boolean existsById(@NonNull String s);

    @Override
    @NonNull
    public Iterable<SequencingInstrumentIllumina> findAll();

    @Override
    @NonNull
    public Iterable<SequencingInstrumentIllumina> findAllById(@NonNull Iterable<String> strings);

    @Override
    public long count();

    @Override
    public void deleteById(@NonNull String s);

    @Override
    public void delete(@NonNull SequencingInstrumentIllumina entity);

    @Override
    public void deleteAllById(Iterable<? extends String> strings);

    @Override
    public void deleteAll(@NonNull Iterable<? extends SequencingInstrumentIllumina> entities);

    @Override
    public void deleteAll();
}
