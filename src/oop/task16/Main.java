package oop.task16;

public class Main {
    public static void main(String[] args) {
        Flight flight1 = new Flight("Odessa", "Kiew", "15:00", "16:30");
        Flight flight2 = new Flight("Berlin", "Paris", "09:00", "21:30");
        Flight flight3 = new Flight("Hamburg", "London", "04:00", "16:30");

        FlightSchedule flightSchedule = new FlightSchedule();
        flightSchedule.addNewFlight(flight1);
        flightSchedule.addNewFlight(flight2);
        flightSchedule.addNewFlight(flight3);

        flightSchedule.findFlightByDepartureAirportAndArrivalAirport("Hamburg", "London");
        flightSchedule.showFlightSchedule();
    }
}
