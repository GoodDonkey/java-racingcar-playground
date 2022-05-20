package domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class CarLocationTest {
    
    @Test
    @DisplayName("위치값을 얻을 수 있는가?")
    void test1() {
        CarLocation carLocation = new CarLocation();
        assertThatNoException().isThrownBy(carLocation::getLocation);
    }
    
    @Test
    @DisplayName("확률적으로 위치값을 변경할 수 있는가?")
    void test2() {
        CarLocation carLocation = new CarLocation();
        int prev = carLocation.getLocation();
        int post = carLocation.getLocation();
        
        while (!carLocation.changeLocation()) {
            assertThat(prev).isEqualTo(post);
        }
        
        post = carLocation.getLocation();
        assertThat(prev).isNotEqualTo(post);
        
    }
    
    @Test
    @DisplayName("1회 변경에 성공하면 위치값이 1 올라가는가?")
    void test3() {
        CarLocation carLocation = new CarLocation();
        int prev = carLocation.getLocation();
        int post = carLocation.getLocation();
    
        while (!carLocation.changeLocation()) {
            assertThat(prev).isEqualTo(post);
        }
    
        post = carLocation.getLocation();
        assertThat(prev + 1).isEqualTo(post);
    }
    
    @Test
    @DisplayName("변경에 실패하는 경우도 있는가?")
    void test5() {
        //given
        CarLocation carLocation = new CarLocation();
        int prev = carLocation.getLocation();
        int post = carLocation.getLocation();
        
        // when: 차 위치를 바꾸는데에 실패하면 바로 탈출한다.
            // 실패했으므로 두 위치는 같아야한다.
        while (carLocation.changeLocation()) {
            prev = carLocation.getLocation();
            post = carLocation.getLocation();
        }
        // then
        assertThat(prev).isEqualTo(post);
    }
    
    @Test
    @DisplayName("처음 객체를 생성하면 위치값이 0인가?")
    void test4() {
        CarLocation carLocation = new CarLocation();
        assertThat(carLocation.getLocation()).isEqualTo(0);
    }
    
    @Test
    @DisplayName("위치를 비교할 수 있는가?")
    void test6() {
        CarLocation location1 = new CarLocation();
        CarLocation location2 = new CarLocation();
    
        while (!location2.changeLocation()) {
            assertThat(location2).isEqualTo(location1);
        }
        assertThat(location2).isGreaterThan(location1);
        assertThat(location1).isLessThan(location2);
    }
}