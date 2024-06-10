package gft.challenge.travel.booking.core.messaging;

public interface FlightReservationConfirmationConsumerPort {
  void receive(final String message);
}
