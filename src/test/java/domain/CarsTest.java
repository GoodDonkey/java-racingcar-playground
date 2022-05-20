package domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class CarsTest {
    
    @ParameterizedTest
    @DisplayName("주어진 이름 개수에 따라 Car 를 가지는가")
    @CsvSource(value = {"donk,annie,tutu:3", "donk,annie,tutu,qq,ww,ee,rr:7"}, delimiter = ':')
    void test1(String names, int number) {
        Cars cars = new Cars(names);
        assertThat(cars.size()).isEqualTo(number);
    }
    
    @ParameterizedTest
    @DisplayName("자동차들의 상태를 한번에 바꿀 수 있는가?")
    @CsvSource(value = "donk,annie,tutu:3", delimiter = ':')
    void test2(String names, int number) {
        Cars cars = new Cars(names);
        CarLocation[] prevLocations = new CarLocation[cars.size()];
        for (int i = 0; i < cars.size(); i++) {
            prevLocations[i] = cars.getCarLocationOf(i);
        }
        cars.moveAll();
        // 바뀔 수도 있고 안바뀔 수도 있는데 확률적으로 테스트해도 되나?
        CarLocation[] postLocations = new CarLocation[cars.size()];
        for (int i = 0; i < cars.size(); i++) {
            postLocations[i] = cars.getCarLocationOf(i);
        }
        System.out.println(Arrays.toString(prevLocations));
        System.out.println(Arrays.toString(postLocations));
        
        for (int i = 0; i < cars.size(); i++) {
            System.out.println("prevLocations = " + prevLocations[i]);
            System.out.println("postLocations[i] = " + postLocations[i]);
        }
        // assert 코드 보류
    }

}