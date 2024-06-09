package gft.challenge.travel.booking.core.persistence;

import gft.challenge.travel.booking.domain.Travel;

public interface TravelBookingRepositoryPort {
    Travel save(final Travel obj);
}
