package gft.challenge.travel.booking.messaging.rabbitmq.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class FlightReservationConfirmationMessage {
  private UUID travelReservationId;
  private String flightNumber;
  private LocalDateTime date;
}
