package gft.challenge.travel.booking.core.messaging;

import gft.challenge.travel.booking.domain.Flight;

public interface FlightReservationMessagePublisherPort {
  void send(final Flight obj);
}
