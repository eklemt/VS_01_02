import java.util.Stack;

public class PostfixExpression {
    private String expression;
    private Double postfixValue;

    public PostfixExpression(String expression) {

        this.expression = expression;
        this.postfixValue = this.evaluate();
    }

    private Double evaluate() {
        Stack<Double> stack = new Stack<>();
        String[] expressionElements = this.expression.split(" ");
        String[] uniOperand = {"abs", "exp", "chsg"};

        //split this.expression and save check elements one by one
        for (int i = 0; i < expressionElements.length; i++) {
            //check if element is an integer
            try {
                //if parseInt does not throw an error, it is a number and should be pushed to the stack
                double number = Double.parseDouble(expressionElements[i]);
                stack.push(number);
            } catch (NumberFormatException e) {
                String operand = expressionElements[i];
                boolean isUniOperand = false;

                //check if uni-operator or not
                for(int j = 0; j < uniOperand.length; j++) {
                    if (operand.equals(uniOperand[j])) {
                        isUniOperand = true;
                    }
                }


                if(isUniOperand) {
                    //get last two elements from stack and apply operand
                    Double firstNumber = stack.pop();

                    switch (operand) {
                        case "abs":
                            stack.push(Math.abs(firstNumber));
                            break;
                        case "exp":
                            stack.push(Math.exp(firstNumber));
                            break;
                        case "chsg":
                            stack.push(firstNumber * (-1));
                            break;
                    }
                } else {
                    //get last two elements from stack and apply operand
                    Double firstNumber = stack.pop();
                    Double secondNumber = stack.pop();

                    switch (operand) {
                        case "+":
                            stack.push(firstNumber + secondNumber);
                            break;
                        case "-":
                            stack.push(secondNumber - firstNumber);
                            break;
                        case "*":
                            stack.push(firstNumber * secondNumber);
                            break;
                        case "/":
                            stack.push(secondNumber / firstNumber);
                            break;
                        case "^":
                            stack.push(Math.pow(secondNumber, firstNumber));
                            break;
                        default:
                            System.out.println("Invalid operator: " + operand);
                            break;
                    }
                }

            }

        }

        if (stack.size() != 1) {
            throw new IllegalArgumentException("Invalid postfix expression.");
        }

        //return last element of stack as final value of postfix expression
        return stack.pop();
    }

    public Double getPostfixValue() {
        return this.postfixValue;
    }



}
