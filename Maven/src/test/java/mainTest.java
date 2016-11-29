import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class mainTest{

    @Test
    public void testGetMessage(){
        assertEquals("Hello World!!", new main().getMessage());
    }
}
