package ferry;

import org.jetbrains.annotations.NotNull;

/**
 * @author Roger Hägerbaum
 * @version 1.0
 * roger.hagerbaum@lerniastudent.se
 */


public class Passenger {

    private int passenger ;
    private int costPassenger = 25;
    final  int MAX_PASSENGER = 200;


    /**
     *  Constructor
     */
    public Passenger () {

    }

    /**
     *  Add passenger to the ferry
     *
     * @param arr Passenger array
     * @param p Passenger that will be embarked on the ferry
     * @param totalEarnings Current earned money
     * @param numberOfPassengers Current number of passengers on the ferry
     * @return The total earnings plus the added passenger
     */
    public int addPassenger (@NotNull Passenger[] arr, Passenger p, int totalEarnings, int numberOfPassengers){
        if(numberOfPassengers <= MAX_PASSENGER) {
            passenger = passenger + numberOfPassengers;
            arr[passenger] = p;
            passenger++;
            totalEarnings = totalEarnings + costPassenger;
        }
        return totalEarnings;

    }

    /**
     *
     * @param arr Passenger array
     * @param vehiclePassengers Number of passenger on the vehicle
     * @param numbersOfPassengers Current number of passengers on the ferry
     */
    public void addVehiclePassengers(Passenger[] arr, int vehiclePassengers, int numbersOfPassengers){
        if(numbersOfPassengers <= MAX_PASSENGER) {
            passenger = passenger + numbersOfPassengers;
            for (int j = 0; j < vehiclePassengers; j++) {
                arr[passenger] = new Passenger();
                passenger++;
            }
        }

    }

    /**
     *
     * @return the number of passengers
     */
    public int getPassengers(){

        return passenger;
    }

    /**
     * Check if there is room for a passenger on the ferry
     *
     * @return boolean
     */
    public boolean hasRoom(int totalPassengers){
        passenger = totalPassengers;
        if(passenger < MAX_PASSENGER){
            return true;
        }else return false;
    }

    /**
     *
     * @return
     */
    @Override
    public String toString() {
        return "Passenger";
    }
}
