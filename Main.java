public class Main {
    public static void main(String[] args) {
        TokenReverser reverser = new TokenReverser("Please can you reverse my words");
        reverser.reverse();
        reverser.reverse();
        reverser.reverse();
        String testResult = reverser.toString();


        System.out.println(testResult);
    }
}