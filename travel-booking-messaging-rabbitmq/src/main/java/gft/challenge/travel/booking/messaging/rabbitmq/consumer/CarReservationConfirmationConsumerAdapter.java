package gft.challenge.travel.booking.messaging.rabbitmq.consumer;

import gft.challenge.travel.booking.messaging.rabbitmq.model.CarReservationConfirmationMessage;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class CarReservationConfirmationConsumerAdapter {

  @RabbitListener(queues = "${app.messaging.car-reservation-confirmation-queue}")
  public void receive(final CarReservationConfirmationMessage message) {

  }
}
