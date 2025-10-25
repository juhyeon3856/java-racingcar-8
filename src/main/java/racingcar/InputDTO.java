package racingcar;

import java.util.List;

public class InputDTO {
    List<String> carNames;
    int runTime;

    public InputDTO(List<String> carNames, int runTime) {
        this.carNames = carNames;
        this.runTime = runTime;
    }
}
