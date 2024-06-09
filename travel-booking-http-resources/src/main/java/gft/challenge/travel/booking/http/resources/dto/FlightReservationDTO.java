package gft.challenge.travel.booking.http.resources.dto;

import com.fasterxml.jackson.annotation.JsonRootName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
@JsonRootName(value = "flight_reservation")
public class FlightReservationDTO {
  private UUID id;
  private List<Integer> seats;
}
