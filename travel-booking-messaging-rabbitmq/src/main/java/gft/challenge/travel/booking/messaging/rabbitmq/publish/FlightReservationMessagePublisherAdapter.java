package gft.challenge.travel.booking.messaging.rabbitmq.publish;

import gft.challenge.travel.booking.core.messaging.FlightReservationMessagePublisherPort;
import gft.challenge.travel.booking.domain.Flight;
import gft.challenge.travel.booking.domain.Travel;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class FlightReservationMessagePublisherAdapter implements FlightReservationMessagePublisherPort {
  @Value(value = "${app.messaging.flight-reservation-queue}")
  private String flightReservationQueue;

  private final RabbitTemplate rabbitTemplate;

  @Autowired
  public FlightReservationMessagePublisherAdapter(final RabbitTemplate rabbitTemplate) {
    this.rabbitTemplate = rabbitTemplate;
  }

  @Override
  public void send(final Travel travel) {
    rabbitTemplate.convertAndSend(flightReservationQueue, travel);
  }
}
