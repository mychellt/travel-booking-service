package gft.challenge.travel.booking.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Car {
  private String plate;
  private LocalDateTime pickupDate;
  private LocalDateTime returnDate;
  private boolean confirmed;
}
