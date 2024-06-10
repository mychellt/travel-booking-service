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
public class CarReservationConfirmationMessage {
  private UUID travelReservationId;
  private Long days;
  private LocalDateTime date;
}
