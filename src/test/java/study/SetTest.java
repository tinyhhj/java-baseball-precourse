package study;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class SetTest {
    private Set<Integer> numbers;

    @BeforeEach
    void setUp() {
        numbers = new HashSet<>();
        numbers.add(1);
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
    }

    @Test
    public void size테스트() {
        assertThat(numbers)
                .hasSize(3)
                .contains(1,2,3)
                .containsExactly(1,2,3);
    }

    @ParameterizedTest
    @ValueSource(ints={1,2,3})
    public void contains테스트(int input) {
        assertThat(numbers.contains(input)).isTrue();
    }

    @ParameterizedTest
    @CsvSource(value = {"1:true", "2:true", "3:true","4:false","5:false","6:false"},delimiter = ':')
    public void 실패케이스도함께_contains테스트(int input,boolean exptectedResult) {
        assertThat(numbers.contains(input)).isEqualTo(exptectedResult);
    }

}
