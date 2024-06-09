package gft.challenge.travel.booking.persistence.repository;

import gft.challenge.travel.booking.persistence.model.TravelEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface TravelRepository extends JpaRepository<TravelEntity, UUID> {
}
