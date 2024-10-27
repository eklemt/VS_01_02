import java.util.Stack;

public class TokenReverser {
    private String s;

    public TokenReverser(String s) {
        this.s = s;
    }

    @Override
    public String toString() {
        return s;
    }

    public void reverseWordOrder() {
        String[] tempWordStorage = this.s.split(" ");
        String reversedOrder = "";

        for (int i = 0; i < tempWordStorage.length; i++) {
            if (i == tempWordStorage.length - 1)
                reversedOrder = tempWordStorage[i] + reversedOrder;
            else
                reversedOrder = " " + tempWordStorage[i] + reversedOrder;
        }
        this.s =  reversedOrder;

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
