package gft.challenge.travel.booking.persistence.model;

import gft.challenge.travel.booking.domain.Status;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "travels")
@Getter @Setter
public class TravelEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(columnDefinition = "UUID")
  private UUID id;

  @OneToOne(cascade = CascadeType.ALL, mappedBy = "travel")
  private CarResevationDetailsEntity carResevationDetails;

  @OneToOne(cascade = CascadeType.ALL, mappedBy = "travel")
  private HotelResevationDetailsEntity hotelResevationDetails;

  @OneToOne(cascade = CascadeType.ALL, mappedBy = "travel")
  private FlightResevationDetailsEntity flightResevationDetails;

  @Column(name = "customer_name")
  private String customerName;

  @Column(name = "customer_email")
  private String customerEmail;

  @Column(name = "customer_phone")
  private String customerPhone;

  @Enumerated(EnumType.STRING)
  private Status status;
}
