package gft.challenge.travel.booking.core.messaging;

public interface CarReservationConfirmationConsumerPort {
  void receive(final String message);
}
