package application;

import domain.Cars;

public class Game {
    
    private Cars cars;
    private Integer trial;
    
    public Game() {
    }
    
    public void startGame() {
        InputView inputView = new InputView();
        String carName = inputView.askCarName();
        this.trial = Integer.parseInt(inputView.askTrial());
        this.cars = new Cars(carName);
    }
    
    public void startRacing() {
        for (int i = 0; i < trial; i++) {
            cars.moveAll();
            ResultView.printLocations(cars);
        }
    }
    
    public void printResult() {
        ResultView.printWinner(cars);
    }
}
