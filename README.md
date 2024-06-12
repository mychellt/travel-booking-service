# Travel Reservation Service

This is a simple Travel reservation system built using Java and Spring Boot.

## Features

- **Reservation Management**: Allows users to make, update, and cancel travel reservations.
- **Integration with Messaging Service**: Utilizes RabbitMQ for asynchronous communication between microservices.
- **Multi-module Project Structure**: Organized into separate modules for better code organization and maintenance.

## Dependencies

- Java 17
- Spring Boot 3.3.0
- Maven
- RabbitMQ
- PostgreSQL

## Modules

1. **travel-reservation-core**: Contains the core business logic and domain models for travel reservations.
2. **travel-reservation-domain**: Contains the core domain models and business logic for the travel reservation system
3. **travel-reservation-http-resources**: Implements RESTful APIs using Spring Web for handling travel reservation requests.
4. **travel-reservation-messaging-rabbiitmq**: Integrates with RabbitMQ for handling messaging-related tasks.
5. **travel-reservation-persistence**: Handles persistence using JPA and provides repositories for accessing database entities. 
6. **travel-reservation-processor**: Module contains the core domain models and business logic for the travel reservation system


## Clone the Repository

```shell
    git clone https://github.com/mychellt/travel-booking-service.git
```

## Build

To build the project, you can use the Maven command provided below. This command will clean the project and then package it, using two CPU cores to speed up the process:

```shell
mvn -T 2C clean package
```

## Configuration

- **Database Configuration**: Configure database settings in `application.properties` files located in each module.
- **Messaging Configuration**: Set up RabbitMQ connection properties in `application.properties` files in the messaging module.


## Request Body

The JSON body below contains comprehensive information for a complete reservation, including car rental, customer details, flight booking, and hotel reservation.

```shell
{
    "car_reservation": {
        "plate": "NNS2130",
        "pickup_date": "2026-01-01T15:00:00",
        "return_date": "2026-01-01T15:00:00",
        "car_id": ""
    },
    "customer_details": {
        "name": "Mychell Teixeira de Araújo",
        "email": "mychellt@gmail.com",
        "phone": "+5584996057585"
    },
    "flight_reservation": {
        "id": "c573f07b-3c30-4c22-91b5-712e06ba46ea",
        "seats": [1,2,3]
    },
    "hotel_reservation": {
        "id": "fb5d599d-b690-4f80-84e2-b0185e57249e",
        "check_in_date": "2026-01-01T15:00:00",
        "check_out_date": "2026-01-01T15:00:00",
        "number_of_rooms":  2
    }
}
```
## Running the Project

To start the project, you need to use Docker Compose. Make sure Docker and Docker Compose are installed on your machine. The docker-compose.yml file can be found in the following repository:

https://github.com/mychellt/travel-booking-infra.git

To run the project, follow these steps:

1. **Clone the repository that contains the Docker Compose configuration:**

```shell
git clone https://github.com/mychellt/travel-booking-infra.git
```

2. **Navigate to the directory containing the docker-compose.yml file:**

```shell
cd travel-booking-infra
```

3. **Run the following command in the terminal:**

```shell
docker-compose up
```
This command will:

- **Download all the necessary Docker images.**
- **Build the containers defined in the docker-compose.yml file.**
- **Start all the project services configured to run in Docker containers.**




