package gft.challenge.travel.booking.http.resources.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonRootName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@JsonRootName(value = "travel_booking")
public class TravelBookingDTO {
  @JsonAlias(value = "customer_details")
  private CustomerDetailsDTO customerDetails;

  @JsonAlias(value = "flight_reservation")
  private FlightReservationDTO flightReservation;

  @JsonAlias(value = "hotel_reservation")
  private HotelResevationDTO hotelResevation;

  @JsonAlias(value = "car_reservation")
  private CarReservationDTO carReservation;
}
