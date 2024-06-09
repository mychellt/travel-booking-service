package gft.challenge.travel.booking.core.business;

import gft.challenge.travel.booking.core.command.Command;
import gft.challenge.travel.booking.domain.TravelBooking;

import java.util.Optional;

public interface ConsultTravelBookingPort extends Command<Optional<TravelBooking>> {
}
