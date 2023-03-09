package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringTest {
    @Test
    void replace() {
        String actual = "abc".replace("b", "d");
        assertThat(actual).isEqualTo("adc");
    }

    @Test
    void spliterator() {
        String ex1 = "1,2";
        assertThat(ex1.split(",")).containsExactly("1", "2");

        String ex2 = "1";
        assertThat(ex2.split(",")).containsExactly("1");
    }

    @Test
    void subString() {
        String problem = "(1,2)";
        int length = problem.length();
        assertThat(problem.substring(1,length-1)).isEqualTo("1,2");
    }

    @Test
    void charAt() {
        String actual = "abc";
        assertThat(actual.charAt(1)).isEqualTo('b');
    }

    @Test
    @DisplayName("인덱스보다 큰 값을 찾으면 예외가 발생한다.")
    void charAtException() {
        assertThatThrownBy(() -> {
            String actual = "abc";
            actual.charAt(3);
        }).isInstanceOf(StringIndexOutOfBoundsException.class);
    }


}
