package application;

import domain.*;

public class ResultView {
    
    public static void printWinner(Cars cars) {
        CarNames carNames = cars.fartherOnes();
        int index = 0;
        for (CarName carName : carNames) {
            if (index > 0) System.out.print(", ");
            System.out.print(carName);
            index++;
        }
        System.out.print("가 최종 우승하였습니다.");
    }
    
    public static void printLocations(Cars cars) {
        for (Car car : cars) {
            printLocation(car);
        }
        System.out.println();
    }
    
    private static void printLocation(Car car) {
        System.out.print(car + " : ");
        
        CarLocation location = car.getCarLocation();
        for (int i = 0; i < location.getLocation(); i++) {
            System.out.print("-");
        }
        
        System.out.println();
    }
}
