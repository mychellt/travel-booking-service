package gft.challenge.travel.booking.core.persistence;

import gft.challenge.travel.booking.domain.Travel;

public interface TravelRepositoryPort {
    Travel save(final Travel obj);
}
