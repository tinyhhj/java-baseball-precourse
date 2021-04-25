package baseball.domain;

import baseball.exception.InvalidNumberException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CustomBaseballNumberTest {
    @Test
    @DisplayName("직접 입력한 숫자로 Baseball 생성 테스트")
    public void createBaseballNumber() {
        Integer[] numbers = new Integer[]{ 1,2,3};
        CustomBaseballNumber customNumbers = new CustomBaseballNumber(numbers);

        assertThat(customNumbers.getNumbers())
                .hasSize(numbers.length)
                .contains(numbers);

        Integer[] longNumbers = new Integer[]{1,2,3,4,5,6,7,8,9};
        CustomBaseballNumber longCustomNumbers = new CustomBaseballNumber(longNumbers);

        assertThat(longCustomNumbers.getNumbers())
                .hasSize(longNumbers.length)
                .contains(longNumbers);
    }

    @Test
    @DisplayName("입력한 숫자가 숫자 범위를 초과했을 경우 테스트")
    public void createBaseballWithExceedNumberRange() {
        Integer[] numbers = new Integer[]{10,1,6,7};

        assertThatThrownBy(()->new CustomBaseballNumber(numbers))
                .isInstanceOf(InvalidNumberException.class)
                .hasMessageMatching("number should be \\d+ <= number <= \\d+");
    }

    @Test
    @DisplayName("입력한 숫자가 중복숫자를 포함할 경우 테스트")
    public void createBaseballWithDuplicate() {
        Integer[] numbers = new Integer[]{1,1,6,7};

        assertThatThrownBy(()->new CustomBaseballNumber(numbers))
                .isInstanceOf(InvalidNumberException.class)
                .hasMessageMatching("number should be different and size: \\d+");
    }


}
