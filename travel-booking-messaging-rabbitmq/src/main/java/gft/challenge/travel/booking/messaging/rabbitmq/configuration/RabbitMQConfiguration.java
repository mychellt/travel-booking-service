package gft.challenge.travel.booking.messaging.rabbitmq.configuration;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfiguration {

  @Value(value = "${app.messaging.car-reservation-queue}")
  private String carReservationQueue;

  @Value(value = "${app.messaging.hotel-reservation-queue}")
  private String hotelReservationQueue;

  @Value(value = "${app.messaging.flight-reservation-queue}")
  private String flightReservationQueue;

  @Value(value = "${app.messaging.car-reservation-confirmation-queue}")
  private String carReservationConfirmationQueue;

  @Value(value = "${app.messaging.flight-reservation-confirmation-queue}")
  private String flightReservationConfirmationQueue;

  @Value(value = "${app.messaging.hotel-reservation-confirmation-queue}")
  private String hotelReservationConfirmationQueue;

  @Bean
  public Queue carReservationQueue() {
    return new Queue(carReservationQueue, Boolean.TRUE);
  }

  @Bean
  public Queue carReservationConfirmationQueue() {
    return new Queue(carReservationConfirmationQueue, Boolean.TRUE);
  }

  @Bean
  public Queue hotelReservationQueue() {
    return new Queue(hotelReservationQueue, Boolean.TRUE);
  }

  @Bean
  public Queue hotelReservationConfirmationQueue() {
    return new Queue(hotelReservationConfirmationQueue, Boolean.TRUE);
  }

  @Bean
  public Queue flightReservationQueue() {
    return new Queue(flightReservationQueue, Boolean.TRUE);
  }

  @Bean
  public Queue flightReservationConfirmationQueue() {
    return new Queue(flightReservationConfirmationQueue, Boolean.TRUE);
  }

  @Bean
  public RabbitTemplate rabbitTemplate(ConnectionFactory connectionFactory) {
    final RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
    rabbitTemplate.setMessageConverter(jsonMessageConverter());
    return rabbitTemplate;
  }

  @Bean
  public MessageConverter jsonMessageConverter() {
    return new Jackson2JsonMessageConverter();
  }
}
