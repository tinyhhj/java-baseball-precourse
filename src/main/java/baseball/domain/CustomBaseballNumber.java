package baseball.domain;

import baseball.exception.InvalidNumberException;

import java.util.HashSet;
import java.util.Set;

public class CustomBaseballNumber extends BaseballNumber {
    public CustomBaseballNumber(Integer... numbers) {
        super(numbers);
        validateBaseballNumber();
    }

    public void validateBaseballNumber() {
        validateDuplicate();
        validateNumberRange();
    }

    public void validateDuplicate() {
        Set<Integer> numberSet = new HashSet<>(getNumbers());

        if (getBallCount() != numberSet.size()) {
            throw new InvalidNumberException(String.format("number should be different and size: %d",getBallCount()));
        }
    }

    public void validateNumberRange() {
        for (int number : getNumbers()) {
            isValidRange(number);
        }
    }

    public boolean isValidRange(int number) {
        if (number <= BALL_MAX_VALUE && number >= BALL_MIN_VALUE) {
            return true;
        }
        throw new InvalidNumberException(String.format("number should be %d <= number <= %d", BALL_MIN_VALUE,BALL_MAX_VALUE));
    }

}
