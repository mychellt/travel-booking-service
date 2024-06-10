package gft.challenge.travel.booking.messaging.rabbitmq.publish;

import gft.challenge.travel.booking.core.messaging.HotelReservationMessagePublisherPort;
import gft.challenge.travel.booking.domain.Travel;
import gft.challenge.travel.booking.messaging.rabbitmq.model.HotelReservationMessage;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class HotelReservationMessagePublisherAdapter implements HotelReservationMessagePublisherPort {
  @Value(value = "${app.messaging.hotel-reservation-queue}")
  private String hotelReservationQueue;

  private final RabbitTemplate rabbitTemplate;

  @Autowired
  public HotelReservationMessagePublisherAdapter(final RabbitTemplate rabbitTemplate) {
    this.rabbitTemplate = rabbitTemplate;
  }

  @Override
  public void send(final Travel travel) {
    final HotelReservationMessage message = HotelReservationMessage.builder()
        .travelReservationId(travel.getId())
        .hotelId(travel.getHotel().getHotelId())
        .checkInDate(travel.getHotel().getCheckInDate())
        .checkOutDate(travel.getHotel().getCheckOutDate())
        .numberOfRooms(travel.getHotel().getNumberOfRooms())
        .build();
    rabbitTemplate.convertAndSend(hotelReservationQueue, message);
  }
}
