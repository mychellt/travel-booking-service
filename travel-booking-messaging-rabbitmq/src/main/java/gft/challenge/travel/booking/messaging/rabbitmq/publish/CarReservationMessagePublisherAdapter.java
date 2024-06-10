package gft.challenge.travel.booking.messaging.rabbitmq.publish;

import gft.challenge.travel.booking.core.messaging.CarReservationMessagePublisherPort;
import gft.challenge.travel.booking.domain.Car;
import gft.challenge.travel.booking.domain.Travel;
import gft.challenge.travel.booking.messaging.rabbitmq.configuration.RabbitMQConfiguration;
import gft.challenge.travel.booking.messaging.rabbitmq.model.CarReservationMessage;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.UUID;

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
  public void send(final Travel travel) {
    final CarReservationMessage message = CarReservationMessage.builder()
        .plate(travel.getCar().getPlate())
        .pickupDate(travel.getCar().getPickupDate())
        .returnDate(travel.getCar().getReturnDate())
        .travelReservationId(travel.getId())
        .build();
    rabbitTemplate.convertAndSend(carReservationQueue, message);
  }
}
