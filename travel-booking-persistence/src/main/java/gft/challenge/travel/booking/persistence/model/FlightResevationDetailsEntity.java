package gft.challenge.travel.booking.persistence.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@Table(name = "flight_reservetions_details")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class FlightResevationDetailsEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(columnDefinition = "UUID")
  private UUID id;

  private boolean confirmed;

  @Column(name = "flight_id")
  private UUID flightId;

  private String seats;

  @OneToOne
  @JoinColumn(name = "travel_id", columnDefinition = "id")
  private TravelEntity travel;
}
