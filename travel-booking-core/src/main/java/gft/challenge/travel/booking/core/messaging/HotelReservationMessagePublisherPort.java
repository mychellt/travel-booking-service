package gft.challenge.travel.booking.core.messaging;

import gft.challenge.travel.booking.domain.Car;
import gft.challenge.travel.booking.domain.Hotel;

public interface HotelReservationMessagePublisherPort {
  void send(final Hotel obj);
}
