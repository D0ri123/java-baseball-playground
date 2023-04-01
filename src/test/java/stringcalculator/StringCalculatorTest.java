package ch01;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.Test;

public class StringCalculatorTest {
  private StringCalculator calc = new StringCalculator();


  @Test
  void 올바른_입력을_했을_경우() {
    assertRight(10, "2 + 3 * 4 / 2");
    assertRight(9, "4 + 2 * 3 / 2");
  }

  @Test
  void 올바른_입력을_하지_않은_경우1_배열의_길이가_짝수() {
    assertValidation("2 + 3 *4");
  }

  @Test
  void 올바른_입력을_하지_않은_경우2_배열의_처음_또는_끝이_문자() {
    assertValidation("+ 3 - 2 * 4");
    assertValidation("+ 3 - 2 * 4 /");
    assertValidation("5 - 2 * 1 /");
  }

  @Test
  void 올바른_입력을_하지_않은_경우3_연속으로_숫자_또는_연산자() {
    assertValidation("+ + 3 - 2");
    assertValidation("3 + + 4 - 2");
    assertValidation("3 + + - 2");
  }

  @Test
  void 올바르지_않은_입력이_되었을_때의_계산결과() {
    assertRight(Integer.MIN_VALUE, "+ + 3 - 2");
  }


  private void assertRight(int expAnswer, String input) {
    String[] values = input.split(" ");
    int result = calc.calculate(values);
    assertEquals(expAnswer, result);
  }

  private void assertValidation(String input) {
    String[] values = input.split(" ");
    boolean result = calc.validateInput(values);
    assertFalse(result);
  }


}
