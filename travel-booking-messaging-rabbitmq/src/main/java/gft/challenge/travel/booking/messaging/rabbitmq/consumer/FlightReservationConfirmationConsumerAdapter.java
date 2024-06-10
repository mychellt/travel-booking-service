package gft.challenge.travel.booking.messaging.rabbitmq.consumer;

import gft.challenge.travel.booking.core.business.FlightReservationConfirmationPort;
import gft.challenge.travel.booking.core.command.Context;
import gft.challenge.travel.booking.messaging.rabbitmq.model.FlightReservationConfirmationMessage;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FlightReservationConfirmationConsumerAdapter {
  private final FlightReservationConfirmationPort flightReservationConfirmationPort;

  @Autowired
  public FlightReservationConfirmationConsumerAdapter(FlightReservationConfirmationPort flightReservationConfirmationPort) {
    this.flightReservationConfirmationPort = flightReservationConfirmationPort;
  }

  @RabbitListener(queues = "${app.messaging.flight-reservation-confirmation-queue}")
  public void receive(final FlightReservationConfirmationMessage message) {
    final Context context = new Context();
    context.setData(message.getTravelReservationId());
    flightReservationConfirmationPort.process(context);
  }
}
