package gft.challenge.travel.booking.core.persistence;

import gft.challenge.travel.booking.domain.Travel;

import java.util.Optional;
import java.util.UUID;

public interface TravelRepositoryPort {
    Travel save(final Travel obj);
    Optional<Travel> get(final UUID id);
}
