public class Main {
    public static void main(String[] args) {
        /*
        TokenReverser reverser = new TokenReverser("Please can you reverse my words");
        reverser.reverse();
        reverser.reverse();
        reverser.reverse();
        String testResult = reverser.toString();


        System.out.println(testResult);

         */

        PostfixExpression postfix = new PostfixExpression("3 chsg abs 3 +");

        System.out.println(postfix.getPostfixValue());

       // infixExpression infix = new infixExpression(" ( 5 * 5 )");
       // System.out.println(infix.getInfixPostfix());

    }

}