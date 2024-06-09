package gft.challenge.travel.booking.messaging.rabbitmq.publish;

import gft.challenge.travel.booking.core.messaging.CarReservationMessagePublisherPort;
import gft.challenge.travel.booking.domain.Car;
import gft.challenge.travel.booking.messaging.rabbitmq.configuration.RabbitMQConfiguration;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class CarReservationMessagePublisherAdapter implements CarReservationMessagePublisherPort {
  @Value(value = "${app.messaging.car-reservation-queue}")
  private String carReservationQueue;

  private final RabbitTemplate rabbitTemplate;

  @Autowired
  public CarReservationMessagePublisherAdapter(final RabbitTemplate rabbitTemplate) {
    this.rabbitTemplate = rabbitTemplate;
  }


  @Override
  public void send(Car obj) {
    rabbitTemplate.convertAndSend(carReservationQueue, obj);
  }
}
