package racingcar;

public class Car {
    String name;
    int distance;

    Car(String name) {
        this.name = name;
        this.distance = 0;
    }

    public void move(int moveDistance) {
        distance += moveDistance;
    }

    @Override
    public String toString() {
        String result = name + " : ";
        for (int i = 0; i < distance; i++) {
            result += "-";
        }
        return result;
    }
}
