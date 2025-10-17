# My Rental Booking API

This is a simple REST API I built with Java and Spring Boot. It's for a fake rental company and lets you manage items, customers, and bookings.

## What It Can Do (Key Features)

* **Full CRUD:** You can create, read, update, and delete all the main things: items, persons, and bookings.
* **Uses JSON:** The API talks to the outside world using JSON, which is a simple text format for sending data.
* **Checks for Errors:** The app checks the data you send it. For example, you can't create a booking in the past. If you mess up, it sends back a clear error message with the right status code (like 400 or 404).
* **API Documentation:** I used Swagger so there's a nice webpage where you can see all the API endpoints and test them out yourself.
* **Organized Code:** I split the code into a Controller, Service, and Repository. This is a standard way to keep the project clean and make sure everything has its own job.

## How It's Built (Tech Stack)

I built this with a common setup called a three-layer architecture. This just means I split the code into three main jobs to keep things organized.

* **Language:** Java (version 17).
* **Framework:** Spring Boot, which makes setting up a web server really easy.
* **Architecture:** It's a simple **Controller-Service-Repository** setup. The Controller handles web requests, the Service does the thinking, and the Repository talks to the database.
* **Web Stuff:** I used **Spring Web (MVC)** to create the API endpoints.
* **Database Stuff:** I used **Spring Data JPA**, which makes it super easy to save and get stuff from the database without writing a bunch of SQL code.
* **Database:** The project uses an **H2 In-Memory Database**. This means the database is temporary and gets wiped clean every time I restart the app, which is great for testing.
* **JSON Conversion:** Spring Boot uses a tool called **Jackson** behind the scenes to automatically turn my Java objects into JSON text and back again.

## How a Booking is Made (Data Flow)

The app’s main job is handling booking requests.

Here’s what happens when a client sends a `POST` request to create a new booking:

1.  The request first hits the `BookingController`. Spring's Jackson library automatically reads the JSON in the request body and converts it into a `BookingRequest` Java object. It also checks the validation rules here, like making sure dates aren't in the past.
2.  The controller then passes this `BookingRequest` object over to the `BookingService`.
3.  Inside the service, it uses the `itemId` and `personId` from the request to fetch the full `Item` and `Person` objects from the database. It does this by calling the `ItemRepository` and `PersonRepository`.
4.  After it has the item and person, and after making sure everything is okay (like the start date is before the end date), the service creates a new `Booking` entity object.
5.  This new `Booking` entity is handed to the `BookingRepository` with a command to save it.
6.  Once the database confirms the booking is saved, the controller sends a `201 Created` status code back to the client, along with a JSON version of the new booking, which now includes its official ID.