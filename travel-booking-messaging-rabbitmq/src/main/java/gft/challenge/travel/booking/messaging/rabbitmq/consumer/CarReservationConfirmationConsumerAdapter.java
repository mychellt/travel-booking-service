package gft.challenge.travel.booking.messaging.rabbitmq.consumer;

import gft.challenge.travel.booking.core.messaging.CarReservationConfirmationConsumerPort;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class CarReservationConfirmationConsumerAdapter implements CarReservationConfirmationConsumerPort {

  @Override
  @RabbitListener(queues = "${app.messaging.car-reservation-confirmation-queue}")
  public void receive(final String message) {

  }
}
