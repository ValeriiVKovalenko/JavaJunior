package oop.task16;

/*
Создайте класс Flight, представляющий полет, с свойствами departureAirport, arrivalAirport, departureTime и
arrivalTime. Реализуйте методы для расчета длительности полета и вывода информации о полете. Создайте класс
FlightSchedule, который содержит список полетов (Flight) и методы для добавления нового полета, поиска полетов
по аэропорту отправления и аэропорту прибытия, а также вывода расписания полетов.
 */

public class Flight {
    private String departureAirport;
    private String arrivalAirport;
    private String departureTime;
    private String arrivalTime;

    public Flight(String departureAirport, String arrivalAirport, String departureTime, String arrivalTime) {
        this.departureAirport = departureAirport;
        this.arrivalAirport = arrivalAirport;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
    }

    public String getDepartureTime() {
        return departureTime;
    }

    public String getArrivalTime() {
        return arrivalTime;
    }

    public String getDepartureAirport() {
        return departureAirport;
    }

    public String getArrivalAirport() {
        return arrivalAirport;
    }

    public void flightDuration() {

        int[] timeArray1 = convertToTimeArray(departureTime);
        int[] timeArray2 = convertToTimeArray(arrivalTime);

        int hourDifference =  Math.abs(timeArray1[0] - timeArray2[0]);
        int minuteDifference = Math.abs(timeArray1[1] - timeArray2[1]);

        System.out.printf("Difference: %s hours and %s minutes.", hourDifference, minuteDifference);
    }

    private int[] convertToTimeArray(String time) {
        int[] timeArray = new int[2];
        timeArray[0] = Integer.parseInt(time.substring(0, 2));
        timeArray[1] = Integer.parseInt(time.substring(3,5));
        return timeArray;
    }

    public void getInfoAboutFlight() {
        System.out.println("Flight{" +
                "departureAirport='" + departureAirport + '\'' +
                ", arrivalAirport='" + arrivalAirport + '\'' +
                ", departureTime='" + departureTime + '\'' +
                ", arrivalTime='" + arrivalTime + '\'' +
                '}');
    }

}
