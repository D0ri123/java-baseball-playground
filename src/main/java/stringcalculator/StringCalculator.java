package stringcalculator;

import java.util.Set;

public class StringCalculator {
  private final Set<String> operator = Set.of("+", "*", "-", "/");

  public int calculate(String[] values) {
    if(!validateInput(values)) {
      return Integer.MIN_VALUE;
    }

    int result = Integer.parseInt(values[0]);
    for(int i=1; i<values.length; i=i+2) {
      switch(values[i]) {
        case "+":
          result += Integer.parseInt(values[i+1]);
          break;
        case "-":
          result -= Integer.parseInt(values[i+1]);
          break;
        case "*":
          result *= Integer.parseInt(values[i+1]);
          break;
        case "/":
          result /= Integer.parseInt(values[i+1]);
          break;
      }
    }
    return result;
  }

  public boolean validateInput(String[] values) {
    if(!lengthMeter(values.length) || !formatMeter(values[0], values[values.length-1])
        || !sequenceMeter(values)) {
      return false;
    }
    return true;
  }

  private boolean lengthMeter(int length) {
    return length % 2 != 0;
  }

  private boolean formatMeter(String val1, String val2) {
    return (!operator.contains(val1) && !operator.contains(val2));
  }

  private boolean sequenceMeter(String[] values) {
    for(int i=0; i<values.length-1; i++) {
      if(operator.contains(values[i]) && operator.contains(values[i+1])) {
        return false;
      }
    }
    return true;
  }
}
