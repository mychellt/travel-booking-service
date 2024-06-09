package gft.challenge.travel.booking.core.business;

import gft.challenge.travel.booking.core.command.Command;
import gft.challenge.travel.booking.domain.Travel;

import java.util.Optional;

public interface BookTravelReservationPort extends Command<Optional<Travel>> {

}
