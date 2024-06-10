package gft.challenge.travel.booking.core.messaging;

import gft.challenge.travel.booking.domain.Travel;

public interface FlightReservationMessagePublisherPort {
  void send(final Travel travel);
}
