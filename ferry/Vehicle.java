package ferry;
import org.jetbrains.annotations.NotNull;
/**
 * @author Roger Hägerbaum
 * @version 1.0
 * roger.hagerbaum@lerniastudent.se
 */

public abstract class Vehicle {


    private Passenger passengers = new Passenger();
    final  int MAX_VEHICLESPACE = 200;
    protected int currentVehicleSpace;
    private int numberOfVehicles = 0;
    protected int embarkCost;
    protected int vehiclePassengers;
    private int totalPassengers;
    protected int numberOfPassengers;
    protected String vehicleName;
    protected int passenger;

    /**
     * Constructor
     * @param passenger number of vehicle passengers
     */

    public  Vehicle(int passenger){

        this.vehiclePassengers = passenger;
    }

    /**
     * Add the vehicle and passengers to the ferry
     * @param arrP passengers array
     * @param arrV vehicle array
     * @param v vehicle to be embarked
     * @param totalEarnings current total earnings
     * @param numberOfVehicles current numbers of vehicles
     * @param numbersOfPassengers current numbers of passengers
     * @param vehicleSpace current number of vehicles space
     * @return The total earnings plus the added vehicle and passengers
     */

    public int addVehicle (Passenger[] arrP, @NotNull Vehicle[] arrV, Vehicle v, int totalEarnings, int numberOfVehicles, int numbersOfPassengers, int vehicleSpace){
        if(vehicleSpace <= MAX_VEHICLESPACE) {
            this.numberOfVehicles = this.numberOfVehicles + numberOfVehicles;
            arrV[this.numberOfVehicles] = v;
            this.numberOfVehicles++;
            passengers.addVehiclePassengers(arrP, vehiclePassengers, numbersOfPassengers);
            totalPassengers = passengers.getPassengers();
            totalEarnings = totalEarnings + embarkCost();
            currentVehicleSpace = vehicleSpace + embarkSpace();
        }
        return totalEarnings;


    }

    /**
     *
     * @return the vehicle space
     */

    public int getVehicleSpace(){

        return currentVehicleSpace;
    }

    /**
     *
     * @return number of vehicles
     */

    public int getNumberOfVehicles(){
        return numberOfVehicles;
    }

    /**
     *
     * @return the number of passengers
     */
    public int totalPassengers(){
        return totalPassengers;
    }

    // abstract methods
    public abstract String toString();
    protected abstract int embarkCost();
    protected abstract int embarkSpace();
    protected abstract boolean checkPassengers();
    protected abstract boolean hasRoom(int totalVehicles);
}
