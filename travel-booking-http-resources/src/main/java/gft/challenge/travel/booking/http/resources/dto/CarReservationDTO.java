package gft.challenge.travel.booking.http.resources.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonRootName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
@JsonRootName(value = "car_resevation")
public class CarReservationDTO {
  private String plate;

  @JsonAlias(value = "pickup_date")
  private LocalDateTime pickupDate;

  @JsonAlias(value = "return_date")
  private LocalDateTime returnDate;
}
