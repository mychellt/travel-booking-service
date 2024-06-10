package gft.challenge.travel.booking.core.messaging;

public interface HotelReservationConfirmationConsumerPort {
  void receive(final String message);
}
