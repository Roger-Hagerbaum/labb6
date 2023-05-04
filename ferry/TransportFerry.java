package ferry;
import org.jetbrains.annotations.NotNull;
/**
 * @author Roger Hägerbaum
 * @version 1.0
 * roger.hagerbaum@lerniastudent.se
 */

import java.util.Arrays;
public class TransportFerry  implements Ferry {
    private int vehicleSpace = 0;
    private int totalEarnings = 0;
    private int numbersOfPassengers =0;
    private int numberOfVehicles = 0;
    private Vehicle[] transportFerry;
    private Passenger[] passengers;

    /**
     * Constructor crates a vehicle and passenger array
     */
    public TransportFerry(){
        transportFerry = new Vehicle[200];
        passengers = new Passenger[200];
    }

    /**
     * Return the number of passengers on the ferry
     * @return
     */
    @Override
    public int countPassengers() {

        return numbersOfPassengers;
    }

    /**
     * Return the used vehicle space on the ferry
     * @return
     */

    @Override
    public int countVehicleSpace() {
        return vehicleSpace;
    }

    /**
     * Returns the total amount of earnings
     * @return
     */
    @Override
    public int countMoney() {

        return totalEarnings;
    }

    /**
     * Returns an array with all the vehicles
     * @return
     */
    @Override
    public Vehicle[] getAllVehicles() {
        int tempLength = 0;
        Vehicle[] temp = new Vehicle[0];
        for(int i = 0; i < transportFerry.length; i++ ){
            tempLength++;
            if(transportFerry[i] == null){
                temp = Arrays.copyOf(transportFerry, tempLength -1);
                i = transportFerry.length;
            }
        }
        return temp;


    }

    /**
     * Embarks the vehicle and the passengers of the vehicle
     * Uses a if statement to check if the vehicle already have embarked on the ferry
     * Uses a if statement to check if the vehicle i not null and have room
     * @param v the vehicle to embark
     */
    @Override
    public void embark(@NotNull Vehicle v) {
        if(v.vehiclePassengers != 0 && ! Arrays.asList(transportFerry).contains(v) && hasSpaceFor(v)){
            totalEarnings = v.addVehicle(passengers, transportFerry, v, totalEarnings, numberOfVehicles, numbersOfPassengers, vehicleSpace);
            vehicleSpace = v.getVehicleSpace();
            numberOfVehicles = v.getNumberOfVehicles();
            numbersOfPassengers = v.totalPassengers();
        }
    }

    /**
     * Embarks the passenger on the ferry
     * Uses a if statement to check if there is room
     * @param p passenger that will embark
     */
    @Override
    public void embark(Passenger p) {
        if(hasRoomFor(p)) {
            totalEarnings = p.addPassenger(passengers, p, totalEarnings, numbersOfPassengers);
            numbersOfPassengers = p.getPassengers();
        }
    }

    /**
     * Disembarks all the vehicles and passengers on the ferry.
     * Resets all variables except the earnings.
     */
    @Override
    public void disembark() {
        transportFerry = new Vehicle[200];
        passengers = new Passenger[200];
        numbersOfPassengers = 0;
        vehicleSpace = 0;
        numberOfVehicles = 0;
    }

    /**
     *  Checks if there is room on the ferry for the vehicle
     * @param v the vehicle
     * @return boolean
     */
    @Override
    public boolean hasSpaceFor(Vehicle v) {

        return v.hasRoom(vehicleSpace);
    }

    /**
     * Checks if there is room on the ferry for the passenger
     * @param p the passenger
     * @return boolean
     */
    @Override
    public boolean hasRoomFor(Passenger p) {
        return p.hasRoom(numbersOfPassengers);
    }
    /**
     * To string method that return ferry status
     * @return return ferry status
     */
    @Override
    public String toString() {

        return "The ferry currently contains: " + '\n' + "Vehicels: " + numberOfVehicles + '\n' + "Passengers: " + numbersOfPassengers;
    }

}


