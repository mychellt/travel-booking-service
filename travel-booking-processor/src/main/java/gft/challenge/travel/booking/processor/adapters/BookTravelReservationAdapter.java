package gft.challenge.travel.booking.processor.adapters;

import gft.challenge.travel.booking.core.business.BookTravelReservationPort;
import gft.challenge.travel.booking.core.command.Context;
import gft.challenge.travel.booking.core.messaging.CarReservationMessagePublisherPort;
import gft.challenge.travel.booking.core.messaging.FlightReservationMessagePublisherPort;
import gft.challenge.travel.booking.core.messaging.HotelReservationMessagePublisherPort;
import gft.challenge.travel.booking.core.persistence.TravelRepositoryPort;
import gft.challenge.travel.booking.domain.Travel;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BookTravelReservationAdapter implements BookTravelReservationPort {
  private final CarReservationMessagePublisherPort carReservationMessagePublisherPort;
  private final HotelReservationMessagePublisherPort hotelReservationMessagePublisherPort;
  private final FlightReservationMessagePublisherPort flightReservationMessagePublisherPort;

  private final TravelRepositoryPort repository;

  public BookTravelReservationAdapter(final CarReservationMessagePublisherPort carReservationMessagePublisherPort,
                                      final HotelReservationMessagePublisherPort hotelReservationMessagePublisherPort,
                                      final FlightReservationMessagePublisherPort flightReservationMessagePublisherPort,
                                      final TravelRepositoryPort repository) {
    this.carReservationMessagePublisherPort = carReservationMessagePublisherPort;
    this.hotelReservationMessagePublisherPort = hotelReservationMessagePublisherPort;
    this.flightReservationMessagePublisherPort = flightReservationMessagePublisherPort;
    this.repository = repository;
  }

  @Override
  public Optional<Travel> process(Context context) {
    Travel travel = context.getData(Travel.class);

    travel.getCar().setConfirmed(Boolean.FALSE);
    travel.getFlight().setConfirmed(Boolean.FALSE);
    travel.getHotel().setConfirmed(Boolean.FALSE);

    travel = repository.save(travel);

    carReservationMessagePublisherPort.send(travel.getCar());
    hotelReservationMessagePublisherPort.send(travel.getHotel());
    flightReservationMessagePublisherPort.send(travel.getFlight());

    return Optional.of(travel);
  }
}
