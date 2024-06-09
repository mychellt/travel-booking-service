CREATE TABLE IF NOT EXISTS car_reservetions_details(
    id UUID NOT NULL PRIMARY KEY,
    confirmed BOOLEAN NOT NULL,
    pickup_date DATE NOT NULL,
    return_date DATE NOT NULL
);

CREATE TABLE IF NOT EXISTS flight_reservetions_details(
  id UUID NOT NULL PRIMARY KEY,
  confirmed BOOLEAN NOT NULL,
  flight_id uuid NOT NULL,
  seats VARCHAR(255) NOT NULL
);

CREATE TABLE IF NOT EXISTS hotel_reservetions_details(
  id UUID NOT NULL PRIMARY KEY,
  confirmed BOOLEAN NOT NULL,
  hotel_id uuid NOT NULL,
  check_in_date DATE NOT NULL,
  check_out_date DATE NOT NULL
);

CREATE TABLE IF NOT EXISTS travels(
  id UUID NOT NULL PRIMARY KEY,
  customer_name VARCHAR(255) NOT NULL,
  customer_email VARCHAR(255),
  customer_phone VARCHAR(255),
  car_resevation_details_id UUID NOT NULL,
  hotel_resevation_details_id UUID NOT NULL,
  flight_resevation_details_id UUID NOT NULL,
  status VARCHAR(255) NOT NULL,
  FOREIGN KEY (car_resevation_details_id) REFERENCES car_reservetions_details(id),
  FOREIGN KEY (hotel_resevation_details_id) REFERENCES hotel_reservetions_details(id),
  FOREIGN KEY (flight_resevation_details_id) REFERENCES flight_reservetions_details(id)
)