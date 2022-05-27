package application;

import exceptions.IllegalCarNameException;
import exceptions.IllegalTrialException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class InputViewTest {
    
    @Test
    @DisplayName("정상 테스트")
    void test0() {
        //given
        String input = "eeee,eeeef,sdf\n";
        String input2 = "5";
    
        // when
        setTwoSystemInputStream(input, input2);
    
    
        // then
        InputView inputView = new InputView();
        assertThatNoException().isThrownBy(inputView::askCarName);
        assertThatNoException().isThrownBy(inputView::askTrial);
    }
    
    @Test
    @DisplayName("자동차 이름: , 로 분리가능한 인풋을 받는가?")
    void test1() {
        //given
        String input = "eeee,eeeef,sdf,,!\n";
        String input2 = "5";
        
        // when
        setTwoSystemInputStream(input, input2);
    
        // then
        InputView inputView = new InputView();
        assertThatThrownBy(inputView::askCarName).isInstanceOf(IllegalCarNameException.class);
    }
    
    @Test
    @DisplayName("같은이름을 검증하는지 테스트")
    void test4() {
        //given
        String input = "eeee,eeee,sdf\n";
        String input2 = "5";
    
        // when
        setTwoSystemInputStream(input, input2);
    
        // then
        InputView inputView = new InputView();
        assertThatThrownBy(inputView::askCarName).isInstanceOf(IllegalCarNameException.class);
    }
    
    private void setTwoSystemInputStream(String input, String input2) {
        ByteArrayInputStream inputStream = new ByteArrayInputStream(input.getBytes(StandardCharsets.UTF_8));
        ByteArrayInputStream inputStream2 = new ByteArrayInputStream(input2.getBytes(StandardCharsets.UTF_8));
        List<InputStream> streams = Arrays.asList(inputStream, inputStream2);
        
        InputStream sequenceInputStream = new SequenceInputStream(Collections.enumeration(streams));
        
        System.setIn(sequenceInputStream);
    }
    
    @Test
    @DisplayName("게임 횟수 검증을 하는가?: 5 초과 검증")
    void test2() {
        // given
        String input = "eeee,eeeef,sdf\n";
        String input2 = "6";
    
        // when
        setTwoSystemInputStream(input, input2);
    
        // then
        InputView inputView = new InputView();
        assertThatNoException().isThrownBy(inputView::askCarName);
        assertThatThrownBy(inputView::askTrial).isInstanceOf(IllegalTrialException.class);
    }
    
    @Test
    @DisplayName("자동차 이름이 5 초과하는 경우를 검증하는가?")
    void test3() {
        // given
        String input = "eeee,eeeeㄹㅇㄹㄴㅇㅁㄹzf,sdf\n";
        String input2 = "5";
    
        // when
        setTwoSystemInputStream(input, input2);
    
        // then
        InputView inputView = new InputView();
        assertThatThrownBy(inputView::askCarName).isInstanceOf(IllegalCarNameException.class);
    }
}