package gft.challenge.travel.booking.http.resources.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonRootName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
@JsonRootName(value = "hotel_resevation")
public class HotelResevationDTO {
  private UUID id;

  @JsonAlias(value = "check_in_date")
  private LocalDateTime checkInDate;

  @JsonAlias(value = "check_out_date")
  private LocalDateTime checkOutDate;

  @JsonAlias(value = "number_of_rooms")
  private Integer numberOfRooms;

}
