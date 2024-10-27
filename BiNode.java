import java.util.Stack;

public class BiNode {
    private String expression;
    private BiNode postfixValue;

    public BiNode(String expression) {

        this.expression = expression;
        this.postfixValue = this.postfixToTree();
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

    public BiNode getPostfixValue() {
        return this.postfixValue;
    }

    public BiNode postfixToTree() {
        Stack<BiNode> stack = new Stack<>();
        String[] expressionElements = this.expression.split(" ");

        //split this.expression and save check elements one by one
        for (int i = 0; i < expressionElements.length; i++) {


        }

        //return last element of stack as final value of postfix expression
        return stack.pop();
    }
}
