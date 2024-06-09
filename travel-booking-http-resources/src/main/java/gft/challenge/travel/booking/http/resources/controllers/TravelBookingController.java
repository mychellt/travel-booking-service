package gft.challenge.travel.booking.http.resources.controllers;

import gft.challenge.travel.booking.core.business.BookTravelReservationPort;
import gft.challenge.travel.booking.domain.TravelBooking;
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

  @Autowired
  public TravelBookingController(final BookTravelReservationPort bookTravelReservationPort) {
    this.bookTravelReservationPort = bookTravelReservationPort;
  }


  @PostMapping
  public ResponseEntity<Void> book(@RequestBody final TravelBooking body) {
    return null;
  }

}
