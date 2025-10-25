package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.HashSet;
import java.util.List;

public class RacingCarInput implements InputDriver {

    private final String Q1 = "경주할 자동차의 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private final String Q2 = "시도할 횟수는 몇 회인가요?";

    public InputDTO input() {
        System.out.println(Q1);
        String inputNames = Console.readLine();
        List<String> carNames = List.of(inputNames.split(","));

        System.out.println(Q2);
        int time = Integer.parseInt(Console.readLine());

        return new InputDTO(carNames, time);
    }

    public void validate(List<String> carNames) throws IllegalArgumentException {
        if (carNames.isEmpty()) {
            throw new IllegalArgumentException();
        }
        for (String carName : carNames) {
            if (carName.isEmpty() || carName.length() > 5) {
                throw new IllegalArgumentException();
            }
        }
        // 중복값이 있으면
        if (carNames.size() != new HashSet<>(carNames).size()) {
            throw new IllegalArgumentException();
        }
    }


}
