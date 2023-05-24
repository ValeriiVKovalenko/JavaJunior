package oop.task16;

import java.util.ArrayList;
import java.util.List;

public class FlightSchedule {
    List<Flight> flights;

    public FlightSchedule() {
        flights = new ArrayList<>(10);
    }

    public void addNewFlight(Flight flight) {
        flights.add(flight);
    }

    public void findFlightByDepartureAirportAndArrivalAirport(
            String departAirport, String arriveAirport){

        for (Flight flight : flights) {
            if(flight.getDepartureAirport().equals(departAirport) &&
            flight.getArrivalAirport().equals(arriveAirport)) {
                flight.getInfoAboutFlight();
            }
        }
    }

    public void showFlightSchedule() {
        for (Flight flight : flights) {
            System.out.printf("%s %s -> %s %s\n", flight.getDepartureTime(), flight.getDepartureAirport(),
                    flight.getArrivalTime(), flight.getArrivalAirport());
        }
    }
}
