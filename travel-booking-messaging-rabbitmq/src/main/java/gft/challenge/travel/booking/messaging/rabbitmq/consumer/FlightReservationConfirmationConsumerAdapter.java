package gft.challenge.travel.booking.messaging.rabbitmq.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class FlightReservationConfirmationConsumerAdapter implements FlightReservationConfirmationConsumerPort {

  @Override
  @RabbitListener(queues = "${app.messaging.flight-reservation-confirmation-queue}")
  public void receive(final String message) {

  }
}
