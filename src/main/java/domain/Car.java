package domain;

public class Car {
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
}
