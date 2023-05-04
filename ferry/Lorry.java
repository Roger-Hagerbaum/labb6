package ferry;
/**
 * @author Roger Hägerbaum
 * @version 1.0
 * roger.hagerbaum@lerniastudent.se
 */
public class Lorry extends Vehicle {
    final int MAX_PASSENGERS = 2;
    final int VEHICLE_SPACE = 40;

    /**
     * Constructor checks if the numbers of passengers exceeds the max number of passengers
     * @param name of the vehicle
     * @param passengers number of passengers on the vehicle
     * @throws IllegalArgumentException if the number of passengers exceeds max allowed
     */
    public Lorry(String name, int passengers){
        super(passengers);
        try {

            if(checkPassengers()) {
                this.numberOfPassengers = passenger;
                this.vehicleName = name;
            }else throw new IllegalArgumentException("Number of passenger exceeds the max number: " + MAX_PASSENGERS);
        } catch (Exception e) {
            e.printStackTrace();
            super.vehiclePassengers = 0;
        }
    }

    /**
     *  To string method
     * @return the vehicle name
     */
    @Override
    public String toString() {

        return "Lorry: " +  vehicleName + " have " + super.vehiclePassengers + " Passengers";
    }

    /**
     * calculates the cost of the vehicle
     * @return the cost
     */
    @Override
    public int embarkCost(){
        embarkCost = 0;
        embarkCost = 300 + 20 * numberOfPassengers;


        return embarkCost;
    }

    /**
     *
     * @return the vehicle space
     */
    @Override
    public int embarkSpace() {
        return VEHICLE_SPACE;
    }

    /**
     * Check if the number of passengers in the vehicle exceeds the maximum number
     * @return boolean
     */
    @Override
    protected boolean checkPassengers() {
        if(super.vehiclePassengers <= MAX_PASSENGERS){
            return true;
        }else return false;

    }

    /**
     * Check if a vehicle has room to embark
     * @param totalVehicles current total vehicle space
     * @return boolean
     */
    @Override
    protected boolean hasRoom(int totalVehicles) {
        super.currentVehicleSpace = totalVehicles;
        if(currentVehicleSpace < super.MAX_VEHICLESPACE){
            return true;
        }else return false;

    }
}
