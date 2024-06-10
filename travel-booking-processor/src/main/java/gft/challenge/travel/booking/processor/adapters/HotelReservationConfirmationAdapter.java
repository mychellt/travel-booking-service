package gft.challenge.travel.booking.processor.adapters;

import gft.challenge.travel.booking.core.command.Context;
import gft.challenge.travel.booking.core.messaging.HotelReservationConfirmationPort;
import gft.challenge.travel.booking.core.persistence.TravelRepositoryPort;
import gft.challenge.travel.booking.domain.Status;
import gft.challenge.travel.booking.domain.Travel;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class HotelReservationConfirmationAdapter implements HotelReservationConfirmationPort {
  private final TravelRepositoryPort repositoryPort;

  public HotelReservationConfirmationAdapter(TravelRepositoryPort repositoryPort) {
    this.repositoryPort = repositoryPort;
  }

  @Override
  public Void process(Context context) {
    UUID id = context.getData(UUID.class);
    Optional<Travel> optTravel = repositoryPort.get(id);
    if(optTravel.isPresent()) {
      final Travel travel = optTravel.get();
      travel.getHotel().setConfirmed(Boolean.TRUE);
      if(travel.getCar().isConfirmed() && travel.getFlight().isConfirmed()) {
        travel.setStatus(Status.CONFIRMED);
      }
      repositoryPort.save(optTravel.get());
    }

    return null;
  }
}
