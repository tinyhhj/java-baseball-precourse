package baseball.domain;

import java.util.*;

public class BaseballNumber {
    protected static final int BALL_MAX_VALUE = 9;
    protected static final int BALL_MIN_VALUE = 1;
    private int ballCount;
    private Integer[] numbers;

    public BaseballNumber(int ballCount) {
        this.ballCount = ballCount;
        numbers = generateNumbers(ballCount);
    }

    protected BaseballNumber(Integer... numbers) {
        this.ballCount = numbers.length;
        this.numbers = numbers;
    }

    protected Integer[] generateNumbers(int ballCount) {
        Integer[] numbers = new Integer[ballCount];
        Random randomGenerator = new Random();
        Set<Integer> randomNumbers = new HashSet<>();

        while (randomNumbers.size() < numbers.length) {
            int randomNumberBall = randomGenerator.nextInt(BALL_MAX_VALUE)+BALL_MIN_VALUE;
            numbers[randomNumbers.size()] = randomNumberBall;
            randomNumbers.add(randomNumberBall);
        }
        return numbers;
    }

    public static BaseballNumber generate(int ballCount) {
        return new BaseballNumber(ballCount);
    }

    public List<Integer> getNumbers() {
        return Arrays.asList(numbers);
    }

    public int getBallCount() {
        return ballCount;
    }
}
