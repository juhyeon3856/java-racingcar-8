package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RacingCarGame implements GameDriver {

    private List<Car> cars;
    private int rumTime;

    RacingCarGame(InputDTO input) {
        cars = input.carNames.stream().map(Car::new).collect(Collectors.toList());
        rumTime = input.runTime;
    }

    public void run() {
        System.out.println("실행 결과");
        for (int i = 0; i < rumTime; i++) {
            round();
            roundResult();
        }
        endResult();
    }

    private void round() {
        for (Car car : cars) {
            int rand = Randoms.pickNumberInRange(0, 9);
            if (rand >= 4) {
                car.move(1);
            }
        }
    }

    private void roundResult() {
        for (Car car : cars) {
            System.out.println(car);
        }
        System.out.println();
    }

    private void endResult() {
        StringBuilder result = new StringBuilder("최종 우승자 : ");
        int maxDistance = findMaxDistance();
        List<Car> winners = findWinners(maxDistance);
        for (Car car : winners) {
            result.append(car.name).append(", ");
        }
        System.out.println(result.substring(0, result.length() - 2));
    }

    private int findMaxDistance() {
        int maxDistance = -1;
        for (Car car : cars) {
            maxDistance = Math.max(maxDistance, car.distance);
        }
        return maxDistance;
    }

    private List<Car> findWinners(int maxDistance) {
        List<Car> winners = new ArrayList<>();
        for (Car car : cars) {
            if (maxDistance == car.distance) {
                winners.add(car);
            }
        }
        return winners;
    }


}
