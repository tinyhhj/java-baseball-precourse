package baseball.domain;

import java.util.*;

public class BaseballNumber {
    private static final int BALL_MAX_VALUE = 9;
    private static final int BALL_MIN_VALUE = 1;

    private final Integer[] numbers;

    protected BaseballNumber(int ballCount) {
        numbers = new Integer[ballCount];
        generateNumbers();
    }

    private void generateNumbers() {
        Random randomGenerator = new Random();
        Set<Integer> randomNumbers = new HashSet<>();

        while (randomNumbers.size() < numbers.length) {
            int randomNumberBall = randomGenerator.nextInt(BALL_MAX_VALUE)+BALL_MIN_VALUE;
            numbers[randomNumbers.size()] = randomNumberBall;
            randomNumbers.add(randomNumberBall);
        }
    }

    public static BaseballNumber generate(int ballCount) {
        return new BaseballNumber(ballCount);
    }

    public int size() {
        return numbers.length;
    }

    public List<Integer> getNumbers() {
        return Arrays.asList(numbers);
    }
}
