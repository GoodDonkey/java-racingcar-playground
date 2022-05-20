package domain;

import java.util.Random;

public class CarLocation implements Comparable<CarLocation>{
    private Integer location = 0;
    
    public CarLocation() {
    }
    
    public boolean changeLocation() {
        Random random = new Random();
        int number = random.nextInt(9);
        if (number >= 4) {
            location++;
            return true;
        }
        return false;
    }
    
    public int getLocation() {
        return location;
    }
    
    @Override
    public int compareTo(CarLocation o) {
        return this.location.compareTo(o.location);
    }
}
