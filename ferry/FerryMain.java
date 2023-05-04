package ferry;
/**
 * @author Roger Hägerbaum
 * @version 1.0
 * roger.hagerbaum@lerniastudent.se
 */

import java.util.Arrays;

public class FerryMain {

    /**
     * Main class to demonstrate and test the ferry
     *
     * @param args
     */
    public static void main(String[] args) {
        TransportFerry testFerry = new TransportFerry();

        System.out.println(testFerry.countMoney());

        Passenger testPassenger = new Passenger();
        Passenger testPassenger2 = new Passenger();

        Car testCar = new Car(" Car 1", 4);
        Car testCar2 = new Car("Car 2", 3);

        Lorry testLorry1 = new Lorry("Lorry 1", 2);

        Bus testBuss = new Bus("Bus 1", 15);

        Bicycle testBicycle = new Bicycle("Bicycle 1", 1);


        testFerry.embark(testPassenger);
        testFerry.embark(testPassenger2);

        System.out.println(testFerry.hasRoomFor(testPassenger));

        testFerry.embark(testCar);
        testFerry.embark(testCar2);
        testFerry.embark(testCar2);

        testFerry.embark(testLorry1);

        testFerry.embark(testBuss);

        testFerry.embark(testBicycle);

        System.out.println(testFerry.hasSpaceFor(testBuss));

        System.out.println(Arrays.toString(testFerry.getAllVehicles()));

        System.out.println(testFerry.countMoney());

        testFerry.disembark();

        System.out.println(testFerry.countMoney());

    }
}