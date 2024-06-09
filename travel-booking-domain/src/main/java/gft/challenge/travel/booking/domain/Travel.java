package gft.challenge.travel.booking.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Travel {
  private Customer customer;
  private Flight flight;
  private Car car;
  private Hotel hotel;
}
