package gft.challenge.travel.booking.http.resources.mappers;

import gft.challenge.travel.booking.domain.Travel;
import gft.challenge.travel.booking.http.resources.dto.TravelBookingDTO;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(builder = @Builder(disableBuilder = true), componentModel = "spring")
public interface TravelBookingModelMapper {
  @Mapping(source = "customerDetails.name", target = "customer.name")
  @Mapping(source = "customerDetails.email", target = "customer.email")
  @Mapping(source = "customerDetails.phone", target = "customer.phone")
  @Mapping(source = "flightReservation.id", target = "flight.flightId")
  @Mapping(source = "flightReservation.seats", target = "flight.seats")
  @Mapping(source = "hotelResevation.id", target = "hotel.hotelId")
  @Mapping(source = "hotelResevation.checkInDate", target = "hotel.checkInDate")
  @Mapping(source = "hotelResevation.checkOutDate", target = "hotel.checkOutDate")
  @Mapping(source = "hotelResevation.numberOfRooms", target = "hotel.numberOfRooms")
  @Mapping(source = "carReservation.plate", target = "car.plate")
  @Mapping(source = "carReservation.pickupDate", target = "car.pickupDate")
  @Mapping(source = "carReservation.returnDate", target = "car.returnDate")
  Travel from(final TravelBookingDTO source);

}
