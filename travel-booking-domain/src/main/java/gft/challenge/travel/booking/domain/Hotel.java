package gft.challenge.travel.booking.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Hotel {
  private UUID hotelId;
  private LocalDateTime checkInDate;
  private LocalDateTime checkOutDate;
  private Integer numberOfRooms;
  private boolean confirmed;
}
