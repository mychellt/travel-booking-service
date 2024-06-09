package gft.challenge.travel.booking.core.persistence;

import gft.challenge.travel.booking.domain.TravelBooking;

public interface TravelBookingRepositoryPort {
    TravelBooking save(final TravelBooking obj);
}
