package gft.challenge.travel.booking.http.resources.controllers;

import gft.challenge.travel.booking.core.business.BookTravelReservationPort;
import gft.challenge.travel.booking.core.command.Context;
import gft.challenge.travel.booking.domain.Travel;
import gft.challenge.travel.booking.http.resources.dto.TravelBookingDTO;
import gft.challenge.travel.booking.http.resources.mappers.TravelBookingModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/travel/booking")
public class TravelBookingController {
  private final BookTravelReservationPort bookTravelReservationPort;
  private final TravelBookingModelMapper mapper;

  @Autowired
  public TravelBookingController(final BookTravelReservationPort bookTravelReservationPort,
                                 final TravelBookingModelMapper mapper) {
    this.bookTravelReservationPort = bookTravelReservationPort;
    this.mapper = mapper;
  }


  @PostMapping
  public ResponseEntity<Void> book(@RequestBody final TravelBookingDTO body) {
    final Travel travel = mapper.from(body);

    final Context context = new Context();
    context.setData(travel);

    bookTravelReservationPort.process(context);

    return ResponseEntity.ok().build();
  }

}
