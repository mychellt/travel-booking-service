package gft.challenge.travel.booking.processor.adapters;

import gft.challenge.travel.booking.core.business.CarReservationConfirmationPort;
import gft.challenge.travel.booking.core.command.Context;
import gft.challenge.travel.booking.core.persistence.TravelRepositoryPort;
import gft.challenge.travel.booking.domain.Status;
import gft.challenge.travel.booking.domain.Travel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class CarReservationConfirmationAdapter implements CarReservationConfirmationPort {
  private final TravelRepositoryPort repositoryPort;

  @Autowired
  public CarReservationConfirmationAdapter(TravelRepositoryPort repositoryPort) {
    this.repositoryPort = repositoryPort;
  }

  @Override
  public Void process(Context context) {
    UUID id = context.getData(UUID.class);
    Optional<Travel> optTravel = repositoryPort.get(id);
    if(optTravel.isPresent()) {
      final Travel travel = optTravel.get();
      travel.getCar().setConfirmed(Boolean.TRUE);
      if(travel.getHotel().isConfirmed() && travel.getFlight().isConfirmed()) {
        travel.setStatus(Status.CONFIRMED);
      }
      repositoryPort.save(optTravel.get());
    }

    return null;
  }
}
