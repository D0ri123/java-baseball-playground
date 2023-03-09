package study;

import java.util.HashSet;
import java.util.Set;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

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
  @DisplayName("Set의 크기를 검증한다")
  void size() {
    int size = numbers.size();
    assertThat(size).isEqualTo(3);
  }

  @ParameterizedTest
  @ValueSource(ints = {1,2,3})
  @DisplayName("Set에 숫자들이 있는지 검증한다.")
  void sameNumbers(int number) {
    assertThat(numbers.contains(number)).isTrue();
  }

  @ParameterizedTest
  @CsvSource(value = {"1:4", "2:5", "3:5"}, delimiter = ':')
  @DisplayName("Set에 숫자들이 제대로 있지 않을 때, false를 반환하는지 검증한다.")
  void isFalse(String actual, String fake) {
    assertThat(numbers.contains(Integer.parseInt(actual))).isTrue();
    assertThat(numbers.contains(Integer.parseInt(fake))).isFalse();
  }

}
