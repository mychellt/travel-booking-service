
CREATE TABLE IF NOT EXISTS travels(
  id UUID NOT NULL PRIMARY KEY,
  customer_name VARCHAR(255) NOT NULL,
  customer_email VARCHAR(255),
  customer_phone VARCHAR(255),
  status VARCHAR(255) NOT NULL
);

CREATE TABLE IF NOT EXISTS car_reservetions_details(
    id UUID NOT NULL PRIMARY KEY,
    confirmed BOOLEAN NOT NULL,
    pickup_date DATE NOT NULL,
    return_date DATE NOT NULL,
    plate VARCHAR(255),
    travel_id uuid NOT NULL,
    FOREIGN KEY (travel_id) REFERENCES travels(id)
);

CREATE TABLE IF NOT EXISTS flight_reservetions_details(
  id UUID NOT NULL PRIMARY KEY,
  confirmed BOOLEAN NOT NULL,
  flight_id uuid NOT NULL,
  travel_id uuid NOT NULL,
  seats VARCHAR(255) NOT NULL,
  FOREIGN KEY (travel_id) REFERENCES travels(id)
);

CREATE TABLE IF NOT EXISTS hotel_reservetions_details(
  id UUID NOT NULL PRIMARY KEY,
  confirmed BOOLEAN NOT NULL,
  hotel_id uuid NOT NULL,
  number_of_rooms INTEGER NOT NULL,
  check_in_date DATE NOT NULL,
  check_out_date DATE NOT NULL,
  travel_id uuid NOT NULL,
  FOREIGN KEY (travel_id) REFERENCES travels(id)
);