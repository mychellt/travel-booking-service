package gft.challenge.travel.booking.http.resources.dto;

import com.fasterxml.jackson.annotation.JsonRootName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@JsonRootName(value = "customer_details")
public class CustomerDetailsDTO {
  private String name;
  private String email;
  private String phone;
}
