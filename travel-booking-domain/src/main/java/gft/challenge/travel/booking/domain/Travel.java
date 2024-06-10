package gft.challenge.travel.booking.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Travel {
  private UUID id;
  private Customer customer;
  private Flight flight;
  private Car car;
  private Hotel hotel;
  private Status status;
}
