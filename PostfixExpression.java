import java.util.Stack;

public class PostfixExpression {
    private String s;
    private String expression;
    private Double postfixValue;

    public PostfixExpression(String expression) {

        this.expression = expression;
        this.postfixValue = this.evaluate();
    }

    private Double evaluate() {
        Stack<Double> stack = new Stack<>();
        String[] expressionElements = this.expression.split(" ");

        //split this.expression and save check elements one by one
        for (int i = 0; i < expressionElements.length; i++) {
            //check if element is an integer
            try {
                //if parseInt does not throw an error, it is a number and should be pushed to the stack
                double number = Double.parseDouble(expressionElements[i]);
                stack.push(number);
            } catch (NumberFormatException e) {
                String operand = expressionElements[i];
                //get last two elements from stack and apply operand
                Double firstNumber = stack.pop();
                Double secondNumber = stack.pop();

                switch (operand) {
                    case "+":
                        stack.push(firstNumber + secondNumber);
                        break;
                    case "-":
                        stack.push(firstNumber - secondNumber);
                        break;
                    case "*":
                        stack.push(firstNumber * secondNumber);
                        break;
                    case "/":
                        stack.push(firstNumber / secondNumber);
                        break;
                }
            }

        }

        //return last element of stack as final value of postfix expression
        return stack.pop();
    }

    public Double getPostfixValue() {
        return this.postfixValue;
    }

    @Override
    public String toString() {
        return s;
    }

    public void reverse() {
        // Split the string into words
        String[] words = s.split(" ");
        Stack<String> stack = new Stack<>();
        String reversedOrder = "";

        // Push each word onto the stack
        for (int i = 0; i < words.length; i++) {
            stack.push(words[i]);
        }

        while (!stack.isEmpty()) {
            if(stack.size() > 1) {
                reversedOrder += stack.pop() + " ";
            } else {
                reversedOrder += stack.pop();
            }
        }

        this.s = reversedOrder;
    }
}
