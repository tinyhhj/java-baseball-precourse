package study;


import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class StringTest {
    @Test
    public void 스플릿_테스트() {
        String input = "1,2";
        String[] numbers = input.split(",");
        assertThat(numbers)
                .hasSize(2)
                .contains("1","2")
                .containsExactly(new String[]{"1","2"});
        input = "1";
        numbers = input.split(",");
        assertThat(numbers)
                .hasSize(1)
                .contains("1")
                .containsExactly(new String[]{"1"});
    }

    private String removeBracket(String input) {
        String removedBracket = input;
        if( Character.compare(input.charAt(0), '(') == 0) {
            removedBracket = removedBracket.substring(1);
        }
        if( Character.compare(input.charAt(input.length()-1),')') ==0 ) {
            removedBracket = removedBracket.substring(0,removedBracket.length()-1);
        }
        return removedBracket;

    }
    @Test
    public void 괄호를제거하고_스플릿_테스트() {
        String input = "(1,2)";
        //괄호 체크
        String removedBracket = removeBracket(input);
        assertThat(removedBracket.split(","))
                .hasSize(2)
                .contains("1","2")
                .containsExactly(new String[]{"1","2"});

        input = "(1,2";
        removedBracket = removeBracket(input);
        assertThat(removedBracket.split(","))
                .hasSize(2)
                .contains("1","2")
                .containsExactly(new String[]{"1","2"});
        input = "3,4)";
        removedBracket = removeBracket(input);
        assertThat(removedBracket.split(","))
                .hasSize(2)
                .contains("3","4")
                .containsExactly(new String[]{"3","4"});

    }
    @Test
    @DisplayName("charAt으로_특정위치문자_가져오기")
    public void charAt으로_특정위치문자_가져오기() {
        String input = "abc";
        char[] expected = input.toCharArray();
        for( int i = 0 ; i < input.length(); i++) {
            char curChar = input.charAt(i);
            char expectChar = expected[i];
            assertThat(curChar).isEqualTo(expectChar);
        }

        assertThatThrownBy(()->{
            input.charAt(3);
        }).isInstanceOf(IndexOutOfBoundsException.class)
                .hasMessage("String index out of range: 3");
        assertThatExceptionOfType(IndexOutOfBoundsException.class)
                .isThrownBy(()->{
                    input.charAt(3);
                }).withMessageMatching("String index out of range: \\d+");
    }

}
