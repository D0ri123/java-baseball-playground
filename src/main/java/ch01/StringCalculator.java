package ch01;

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
    if(values.length % 2 == 0) {
      return false;
    }
    if(operator.contains(values[0]) ||
        operator.contains(values[values.length-1])) {
      return false;
    }

    for(int i=0; i<values.length-1; i++) {
      if(operator.contains(values[i]) && operator.contains(values[i+1])) {
        return false;
      }
    }

    return true;
  }
}
