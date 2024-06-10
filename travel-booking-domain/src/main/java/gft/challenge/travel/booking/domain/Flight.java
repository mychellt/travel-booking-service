package gft.challenge.travel.booking.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Flight {
  private UUID flightId;
  private List<Integer> seats;
  private boolean confirmed;


  public String getSeatAsString() {
    return seats.stream()
        .map(String::valueOf)
        .collect(Collectors.joining(","));
  }
}
