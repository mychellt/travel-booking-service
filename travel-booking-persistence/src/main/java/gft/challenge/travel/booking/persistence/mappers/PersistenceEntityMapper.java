package gft.challenge.travel.booking.persistence.mappers;

import gft.challenge.travel.booking.domain.Travel;
import gft.challenge.travel.booking.persistence.model.TravelEntity;
import org.mapstruct.*;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Mapper(builder = @Builder(disableBuilder = true), componentModel = "spring")
public interface PersistenceEntityMapper {

  @Mapping(source = "customerEmail", target = "customer.email")
  @Mapping(source = "customerName", target = "customer.name")
  @Mapping(source = "customerPhone", target = "customer.phone")
  @Mapping(source = "flightResevationDetails", target = "flight")
  @Mapping(source = "hotelResevationDetails", target = "hotel")
  @Mapping(source = "carResevationDetails", target = "car")
  @Mapping(source = "flightResevationDetails.seats", target = "flight.seats", qualifiedByName = "mapSeatsToIntegers")
  Travel from(final TravelEntity source);

  @Mapping(source = "customer.phone", target = "customerPhone")
  @Mapping(source = "customer.name", target = "customerName")
  @Mapping(source = "customer.email", target = "customerEmail")
  @Mapping(source = "car", target = "carResevationDetails")
  @Mapping(source = "hotel", target = "hotelResevationDetails")
  @Mapping(source = "hotel.hotelId", target = "hotelResevationDetails.hotelId")
  @Mapping(source = "flight.flightId", target = "flightResevationDetails.flightId")
  @Mapping(source = "flight.seats", target = "flightResevationDetails.seats", qualifiedByName = "mapSeats")
  TravelEntity from(final Travel source);

  @Named("mapSeats")
  default String mapSeats(List<Integer> seats) {
    return seats.stream()
        .map(String::valueOf)
        .collect(Collectors.joining(","));
  }

  @Named("mapSeatsToIntegers")
  default List<Integer> mapSeatsToIntegers(String seats) {
    if (seats == null || seats.isEmpty()) {
      return Collections.emptyList();
    }
    return Arrays.stream(seats.split(","))
        .map(Integer::parseInt)
        .toList();
  }

  @AfterMapping
  default void after(@MappingTarget TravelEntity entity) {
    if (entity.getCarResevationDetails() != null) {
      entity.getCarResevationDetails().setTravel(entity);
    }

    if (entity.getHotelResevationDetails() != null) {
      entity.getHotelResevationDetails().setTravel(entity);
    }

    if (entity.getFlightResevationDetails() != null) {
      entity.getFlightResevationDetails().setTravel(entity);
    }
  }
}
