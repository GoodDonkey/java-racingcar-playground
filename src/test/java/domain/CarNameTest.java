package domain;

import exceptions.IllegalCarNameException;
import org.assertj.core.api.Assertions.*;
import org.assertj.core.api.NotThrownAssert;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class CarNameTest {
    
    @ParameterizedTest
    @DisplayName("이름길이를 구할 수 있는가?")
    @CsvSource(value = {"f:1", "aefw:4", "5345:4"}, delimiter = ':')
    void test1(String name, int length) {
        CarName carName = new CarName(name);
        assertThat(carName.length()).isEqualTo(length);
    }
    
    @Test
    @DisplayName("이름이 5글자 이하라는 것을 체크하는가?")
    void test2() {
        assertThatThrownBy(() -> new CarName("qweraf")).isInstanceOf(IllegalCarNameException.class);
        assertThatThrownBy(() -> new CarName("자동차입니다")).isInstanceOf(IllegalCarNameException.class);
        assertThatNoException().isThrownBy(() -> new CarName("자동차입니"));
    }
}