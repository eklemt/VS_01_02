import org.junit.Test;

import static org.junit.Assert.*;

public class TokenReverserTest {

    @Test
    public void testTokenReverser() {
        String testInput = "How are you";
        TokenReverser reverser = new TokenReverser(testInput);
        reverser.reverseWordOrder();

        assertEquals("you are How", reverser.toString());
    }

    @Test
    public void testReverse() {
        String testInput = "This method modifies a word order similar to multiplying with (-1)";
        TokenReverser reverser = new TokenReverser(testInput);
        reverser.reverse();
        reverser.reverse();
        assertEquals("This method modifies a word order similar to multiplying with (-1)", reverser.toString());


        //call reverse once
        //assertEquals on second call
        //assertEquals("you are How", this.reverserTest.reverseWordOrder("How are you"));
    }


}
