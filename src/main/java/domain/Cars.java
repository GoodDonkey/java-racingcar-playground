package domain;

import java.util.*;

public class Cars implements Iterable<Car> {
    
    private List<Car> cars = new ArrayList<>();
    
    public Cars(String names) {
        String[] split = names.split(",");
        for (int i = 0; i < split.length; i++) {
            cars.add(new Car(split[i]));
        }
    }
    
    protected Cars(String[] names, Integer[] locations) {
        if (names.length != locations.length) {
            throw new IllegalArgumentException("길이가 같아야합니다.");
        }
        for (int i = 0; i < names.length; i++) {
            cars.add(new Car(names[i], locations[i]));
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
    
    public CarNames fartherOnes() {
        CarNames carNames = new CarNames();
        cars.sort(Comparator.comparing(Car::getCarLocation).reversed());
        carNames.add(cars.get(0));
        for (int i = 1; i < cars.size(); i++) {
            if (cars.get(i).compareTo(cars.get(i - 1)) == 0) {
                carNames.add(cars.get(i));
                continue;
            }
            break;
        }
        
        return carNames;
    }
    
    @Override
    public Iterator<Car> iterator() {
        return cars.iterator();
    }
}
