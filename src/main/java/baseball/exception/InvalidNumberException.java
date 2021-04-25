package baseball.exception;

import baseball.domain.BaseballNumber;

public class InvalidNumberException extends BaseballException {
    public InvalidNumberException(String message) {
        super(message);
    }
}
