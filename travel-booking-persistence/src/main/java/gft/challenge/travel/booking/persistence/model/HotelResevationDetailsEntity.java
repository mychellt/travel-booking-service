package gft.challenge.travel.booking.persistence.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "hotel_reservetions_details")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class HotelResevationDetailsEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(columnDefinition = "UUID")
  private UUID id;

  private boolean confirmed;

  @Column(name = "hotel_id")
  private UUID hotelId;

  @Column(name = "check_in_date")
  private LocalDateTime checkInDate;

  @Column(name = "check_out_date")
  private LocalDateTime checkOutDate;
}
