package racingcar;

public class Application {
    public static void main(String[] args) {
        InputDriver inputDriver = new RacingCarInput();
        InputDTO input = inputDriver.input();
        inputDriver.validate(input.carNames);

        GameDriver gameDriver = new RacingCarGame(input);
        gameDriver.run();
    }
}
