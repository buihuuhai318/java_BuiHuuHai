import javax.script.ScriptContext;

public class Calculator {
    private double firstOperand;
    private char operator;
    private double secondOperand;

    private double result;

    public Calculator(double firstOperand, char operator, double secondOperand) {
        this.firstOperand = firstOperand;
        this.operator = operator;
        this.secondOperand = secondOperand;
    }

    public Calculator() {
    }

    public double getFirstOperand() {
        return firstOperand;
    }

    public void setFirstOperand(double firstOperand) {
        this.firstOperand = firstOperand;
    }

    public char getOperator() {
        return operator;
    }

    public void setOperator(char operator) {
        this.operator = operator;
    }

    public double getSecondOperand() {
        return secondOperand;
    }

    public void setSecondOperand(double secondOperand) {
        this.secondOperand = secondOperand;
    }

    public double getResult() {
        switch (this.operator) {
            case '+': {
                return firstOperand + secondOperand;
            }
            case '-': {
                return firstOperand - secondOperand;
            }
            case '*': {
                return firstOperand * secondOperand;
            }
            case '/': {
                if (secondOperand != 0) {
                    return firstOperand / secondOperand;
                } else {
                    throw new RuntimeException("can't divide by zero");
                }
            }
        }
        return result;
    }
}
