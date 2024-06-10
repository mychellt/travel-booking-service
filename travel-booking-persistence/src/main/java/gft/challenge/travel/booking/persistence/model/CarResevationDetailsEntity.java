package gft.challenge.travel.booking.persistence.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "car_reservetions_details")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CarResevationDetailsEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(columnDefinition = "UUID")
  private UUID id;
  private boolean confirmed;

  private String plate;
  @Column(name = "pickup_date")
  private LocalDateTime pickupDate;

  @Column(name = "return_date")
  private LocalDateTime returnDate;

  @OneToOne
  @JoinColumn(name = "travel_id", columnDefinition = "id")
  private TravelEntity travel;
}
