package domain;

import java.util.Comparator;

public class Car implements Comparable<Car> {
    private final CarName carName;
    private CarLocation carLocation;
    
    public Car(String name) {
        this.carName = new CarName(name);
        this.carLocation = new CarLocation();
    }
    
    public Car(Car other) {
        this.carName = new CarName(other.carName);
        this.carLocation = new CarLocation(other.carLocation);
    }
    
    protected Car(String name, Integer location) {
        this.carName = new CarName(name);
        this.carLocation = new CarLocation(location);
    }
    
    public CarName getCarName() {
        return carName;
    }
    
    public CarLocation getCarLocation() {
        return new CarLocation(carLocation);
    }
    
    public boolean move() {
        if (carLocation.changeLocation()) {
            return true;
        }
        return false;
    }
    
    @Override
    public String toString() {
        return carName.toString();
    }
    
    @Override
    public int compareTo(Car o) {
        return this.carLocation.compareTo(o.carLocation);
    }
}
