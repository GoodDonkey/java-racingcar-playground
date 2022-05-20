package domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

class CarTest {
    
    @Test
    @DisplayName("CarName 을 얻을 수 있는가?")
    void test1() {
        Car car = new Car("nooo");
        assertThat(car.getCarName()).isInstanceOf(CarName.class);
    }
    
    @Test
    @DisplayName("CarLocation을 얻을 수 있는가?")
    void test2() {
        Car car = new Car("haha");
        assertThat(car.getCarLocation()).isInstanceOf(CarLocation.class);
    }
    
    @Test
    @DisplayName("한 자동차를 움직이면 위치가 달라지는가?")
    void test3() {
        Car car = new Car("hihi");
        CarLocation prev = car.getCarLocation();
        System.out.println("prev = " + prev);
        while (!car.move()) {
            assertThat(car.getCarLocation()).isEqualByComparingTo(prev);
        }
        System.out.println("prev = " + prev);
        System.out.println("car.getCarLocation() = " + car.getCarLocation());
        // prev 에 주소값을 참조값을 저장하면 move한 후에 prev도 바뀐다.
        // 따라서 CarLocation을 immutable 하게 만들거나
        // getter 가 복사본을 반환하게 만들거나
        // getter를 없애고 다른 메서드로 구현해야함
        assertThat(car.getCarLocation()).isGreaterThan(prev);
    }
}