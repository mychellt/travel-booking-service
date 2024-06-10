package gft.challenge.travel.booking.persistence.adapters;

import gft.challenge.travel.booking.core.persistence.TravelRepositoryPort;
import gft.challenge.travel.booking.domain.Travel;
import gft.challenge.travel.booking.persistence.mappers.PersistenceEntityMapper;
import gft.challenge.travel.booking.persistence.model.TravelEntity;
import gft.challenge.travel.booking.persistence.repository.TravelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


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
    final TravelEntity travel = mapper.from(obj);
    return mapper.from(repository.save(travel));
  }
}
