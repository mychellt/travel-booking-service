package gft.challenge.travel.booking.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class User {
  private String firstName;
  private String surName;
  private String email;
  private String password;
}
