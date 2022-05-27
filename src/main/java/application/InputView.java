package application;

import exceptions.IllegalCarNameException;
import exceptions.IllegalTrialException;

import java.util.Arrays;
import java.util.Scanner;

public class InputView {
    
    Scanner scanner = new Scanner(System.in);
    
    public String askTrial() {
        System.out.println("시도할 횟수는 몇번인가요?");
        String trial = scanner.nextLine();
        assertTrial(trial);
        return trial;
    }
    
    private void assertTrial(String trial) {
        if (Integer.parseInt(trial) > 5 || Integer.parseInt(trial) <= 0) {
            System.out.println(IllegalTrialException.message);
            throw new IllegalTrialException();
        }
    }
    
    public String askCarName() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        String carNameString = scanner.nextLine();
        assertCarNameString(carNameString);
        return carNameString;
    }
    
    private void assertCarNameString(String carNameString) {
        String[] split = carNameString.split(",");
        if (Arrays.asList(split).contains("")) {
            System.out.println(IllegalCarNameException.message);
            throw new IllegalCarNameException();
        }
        if (Arrays.stream(split)
                .anyMatch(name -> name.length() > 5)) {
            System.out.println(IllegalCarNameException.message);
            throw new IllegalCarNameException();
        }
    }
}
