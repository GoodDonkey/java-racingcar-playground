package domain;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CarNames implements Iterable<CarName> {
    
    private List<CarName> carNames = new ArrayList<>();
    
    public void add(CarName carName) {
        carNames.add(carName);
    }
    
    public void add(Car car) {
        carNames.add(car.getCarName());
    }
    
    @Override
    public Iterator<CarName> iterator() {
        return carNames.iterator();
    }
    
    public int size() {
        return carNames.size();
    }
}
