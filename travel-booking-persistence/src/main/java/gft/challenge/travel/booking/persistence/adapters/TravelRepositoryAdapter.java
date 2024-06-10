package gft.challenge.travel.booking.persistence.adapters;

import gft.challenge.travel.booking.core.persistence.TravelRepositoryPort;
import gft.challenge.travel.booking.domain.Travel;
import gft.challenge.travel.booking.persistence.mappers.PersistenceEntityMapper;
import gft.challenge.travel.booking.persistence.repository.TravelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Objects;
import java.util.Optional;
import java.util.UUID;


@Repository
public class TravelRepositoryAdapter implements TravelRepositoryPort {
  private final TravelRepository repository;
  private final PersistenceEntityMapper mapper;

  @Autowired
  public TravelRepositoryAdapter(final TravelRepository repository,
                                 final PersistenceEntityMapper mapper) {
    this.repository = repository;
    this.mapper = mapper;
  }

  @Override
  public Travel save(Travel obj) {
    return mapper.from(repository.save(mapper.from(obj)));
  }

  @Override
  public Optional<Travel> get(UUID id) {
    Travel travel = repository.findById(id)
        .map(mapper::from)
        .orElse(null);
    return Objects.nonNull(travel) ? Optional.of(travel) : Optional.empty();
  }
}
