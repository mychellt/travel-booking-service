package gft.challenge.travel.booking.messaging.rabbitmq.consumer;

import gft.challenge.travel.booking.core.messaging.HotelReservationConfirmationConsumerPort;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class HotelReservationConfirmationConsumerAdapter implements HotelReservationConfirmationConsumerPort {

  @Override
  @RabbitListener(queues = "${app.messaging.hotel-reservation-confirmation-queue}")
  public void receive(final String message) {

  }
}
