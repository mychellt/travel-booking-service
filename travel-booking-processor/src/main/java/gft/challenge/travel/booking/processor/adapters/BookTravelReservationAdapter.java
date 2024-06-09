package gft.challenge.travel.booking.processor.adapters;

import gft.challenge.travel.booking.core.business.BookTravelReservationPort;
import gft.challenge.travel.booking.core.command.Context;
import gft.challenge.travel.booking.domain.Travel;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BookTravelReservationAdapter implements BookTravelReservationPort {
  @Override
  public Optional<Travel> process(Context context) {
    return Optional.empty();
  }
}
