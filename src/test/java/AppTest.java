import org.junit.*;
import static org.junit.Assert.*;

public class AppTest {

    @Test
    public void ifYourMethodReturs_Strin() {
        String test = "Hi";
        assertEquals(test, App.yourMethodName("Hello"));
    }
}
