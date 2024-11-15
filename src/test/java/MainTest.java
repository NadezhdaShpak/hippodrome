import org.junit.jupiter.api.*;

class MainTest {

    @Test
    @Timeout(value = 22)
    @Disabled
    void mainTest() throws Exception {
        Main.main(null);
    }
}