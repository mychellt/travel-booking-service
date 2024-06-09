package gft.challenge.travel.booking.core.messaging;

import gft.challenge.travel.booking.domain.Car;

public interface CarReservationMessagePublisherPort {
  void send(final Car obj);
}
