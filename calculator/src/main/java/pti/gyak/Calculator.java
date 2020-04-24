package pti.gyak;

import java.util.Collections;
import java.util.List;

public class Calculator {
    public static final String SEPARATOR = " ";

    protected Number result = 0;
    protected String expression = "";
    protected List<String> history = Collections.emptyList();

    private Operation lastOperation;

    public Calculator enter(Number number) {
        if (number != null && lastOperation != null) {
            switch(lastOperation) {
                case ADD:
                    result = result.doubleValue() + number.doubleValue();
                    break;
                case SUBSTRACT:
                    result = result.doubleValue() - number.doubleValue();
                    break;
                case MULTIPLY:
                    result = result.doubleValue() * number.doubleValue();
                    break;
                case DIVIDE:
                    if (number.doubleValue() != 0) {
                        result = result.doubleValue() / number.doubleValue();
                    }
                    else if (result.doubleValue() > 0) {
                        result = Double.POSITIVE_INFINITY;
                    }
                    else {
                        result = Double.NEGATIVE_INFINITY;
                    }
                    break;
                case REMAINDER:
                    result = result.doubleValue() % number.doubleValue();
                    break;
                case POWER:
                    result = Math.pow(result.doubleValue(), number.doubleValue());
                    break;
                default:
                    break;
            }
            expression = expression + SEPARATOR + lastOperation + SEPARATOR + number;
            lastOperation = null;
        } else {
            if (!expression.isEmpty()) {
                history.add(expression + " = " + resultString());
            }
            result = number;
            expression = "" + number;
        }
        return this;
    }

    public Calculator enter(Operation operation) {
        if (operation != null) {
            if (operation == Operation.ADD || operation == Operation.SUBSTRACT || operation == Operation.MULTIPLY
                    || operation == Operation.DIVIDE || operation == Operation.REMAINDER || operation == Operation.POWER) {
                lastOperation = operation;
            } else if (operation == Operation.SQRT) {
                result = Math.sqrt(result.doubleValue());
                expression = operation + "(" + expression + ")";
                lastOperation = null;
            } else if (operation == Operation.CLEAR) {
                result = 0;
                expression = "";
                lastOperation = null;
            }
            return this;
        }
        return this;
    }

    public String getHistory() {
        StringBuilder s = new StringBuilder();
        if (history.isEmpty())
          for (String h: history) {
             s.append(h).append("\n");
          }

        s.append(expression).append(" = ").append(resultString());
        return s.toString();
    }

    private String resultString() {
        return result.doubleValue() % 1 == 0 ? "" + result.intValue() : result.toString();
    }
}