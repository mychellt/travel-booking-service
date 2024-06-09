package gft.challenge.travel.booking.messaging.rabbitmq.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class MessageConsumer {
  @RabbitListener(queues = "travel-booked-queue")
  public void receiveMessage(String message) {

  }
}
