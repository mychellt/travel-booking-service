package gft.challenge.travel.booking.messaging.rabbitmq.consumer;

import gft.challenge.travel.booking.core.business.CarReservationConfirmationPort;
import gft.challenge.travel.booking.core.command.Context;
import gft.challenge.travel.booking.messaging.rabbitmq.model.CarReservationConfirmationMessage;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CarReservationConfirmationConsumerAdapter {
  private final CarReservationConfirmationPort carReservationConfirmationPort;

  @Autowired
  public CarReservationConfirmationConsumerAdapter(CarReservationConfirmationPort carReservationConfirmationPort) {
    this.carReservationConfirmationPort = carReservationConfirmationPort;
  }

  @RabbitListener(queues = "${app.messaging.car-reservation-confirmation-queue}")
  public void receive(final CarReservationConfirmationMessage message) {
    final Context context = new Context();
    context.setData(message.getTravelReservationId());
    carReservationConfirmationPort.process(context);
  }
}
