package domain;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Cars implements Iterable<Car> {
    
    private List<Car> cars = new ArrayList<>();
    
    public Cars(String names) {
        String[] split = names.split(",");
        for (int i = 0; i < split.length; i++) {
            cars.add(new Car(split[i]));
        }
    }
    
    public int size() {
        return cars.size();
    }
    
    public CarLocation getCarLocationOf(Integer index) {
        return cars.get(index).getCarLocation();
    }
    
    public void moveAll() {
        // car.move() 결과는 모두 함께 적용받아야 하므로
        // 복사해서 한번에 넣는 방법을 쓴다. (실패 원자성 보장?)
        // 쓰레드 세이프하지는 않다.
        ArrayList<Car> carsTemp = new ArrayList<>();
        
        for (Car car : cars) {
            carsTemp.add(new Car(car));
        }
        
        for (Car car : carsTemp) {
            car.move();
        }
        
        this.cars = carsTemp;
    }
    
    @Override
    public Iterator<Car> iterator() {
        return cars.iterator();
    }
}
