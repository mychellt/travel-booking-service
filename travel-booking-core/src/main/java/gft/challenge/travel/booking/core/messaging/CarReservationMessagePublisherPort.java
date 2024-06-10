package gft.challenge.travel.booking.core.messaging;

import gft.challenge.travel.booking.domain.Car;
import gft.challenge.travel.booking.domain.Travel;

import java.util.UUID;

public interface CarReservationMessagePublisherPort {
  void send(final Travel obj);
}
