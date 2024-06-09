package gft.challenge.travel.booking.persistence.mappers;

import gft.challenge.travel.booking.domain.Travel;
import gft.challenge.travel.booking.persistence.model.TravelEntity;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;

@Mapper(builder = @Builder(disableBuilder = true), componentModel = "spring")
public interface PersistenceEntityMapper {
  Travel from(final TravelEntity source);
  TravelEntity from(final Travel source);
}
