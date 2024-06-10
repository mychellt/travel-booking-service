package gft.challenge.travel.booking.messaging.rabbitmq.consumer;

import gft.challenge.travel.booking.core.command.Context;
import gft.challenge.travel.booking.core.business.HotelReservationConfirmationPort;
import gft.challenge.travel.booking.messaging.rabbitmq.model.HotelReservationConfirmationMessage;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class HotelReservationConfirmationConsumerAdapter {
  private final HotelReservationConfirmationPort hotelReservationConfirmationPort;

  public HotelReservationConfirmationConsumerAdapter(HotelReservationConfirmationPort hotelReservationConfirmationPort) {
    this.hotelReservationConfirmationPort = hotelReservationConfirmationPort;
  }

  @RabbitListener(queues = "${app.messaging.hotel-reservation-confirmation-queue}")
  public void receive(final HotelReservationConfirmationMessage message) {
    final Context context = new Context();
    context.setData(message.getTravelReservationId());
    hotelReservationConfirmationPort.process(context);
  }
}
