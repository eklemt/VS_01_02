import java.util.Stack;

/**
 * Beschreiben Sie hier die Klasse infixExpression.
 *
 * @author (Ihr Name)
 * @version (eine Versionsnummer oder ein Datum)
 */
public class infixExpression
{

    private String s;
    private String expression;
    private String infixPostfix;




    public infixExpression(String expression)
    {
        this.expression = expression;
        this.infixPostfix = this.convert();

    }


    private String convert(){
        int a = 0;
        Stack<String> stack = new Stack<String>();
        String[] expressionElements = this.expression.split(" ");

        for (int i = 0; i < expressionElements.length; i++){
            try {
                double check = Double.parseDouble(expressionElements[i]);
                String number = Double.toString(check);
                if (a < 1){
                    infixPostfix = number;
                    a++;
                }
                else{
                    infixPostfix += " " + number;
                }
            } catch (NumberFormatException e){
                String operand = expressionElements[i];

                switch(operand){
                    case "(":
                        break;
                    case ")":
                        infixPostfix += " " + stack.pop();
                        break;
                    case "+":
                        stack.push(operand);
                        break;
                    case "/":
                        stack.push(operand);
                        break;
                    case "-":
                        stack.push(operand);
                        break;
                    case "*":
                        stack.push(operand);
                        break;

                }
            }
        }return infixPostfix;



    }

    public String getInfixPostfix(){
        return this.infixPostfix;
    }



}
