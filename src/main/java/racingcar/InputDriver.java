package racingcar;

import java.util.List;

public interface InputDriver {

    InputDTO input();

    void validate(List<String> carNames);


}
