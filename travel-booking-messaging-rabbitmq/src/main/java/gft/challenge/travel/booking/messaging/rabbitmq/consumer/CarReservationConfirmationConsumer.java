package gft.challenge.travel.booking.messaging.rabbitmq.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class CarReservationConfirmationConsumer {

  @RabbitListener(queues = "${app.messaging.car-reservation-confirmation-queue}")
  public void receiveMessage(String message) {

  }
}
