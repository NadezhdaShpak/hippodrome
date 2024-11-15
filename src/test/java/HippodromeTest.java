import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.*;


import java.util.ArrayList;
import java.util.List;


class HippodromeTest {
    @Test
    void throwExceptionIfListIsNull() {
        assertThrows(IllegalArgumentException.class, () -> new Hippodrome(null));
    }

    @Test
    void showMessageIfListIsNull() {
        IllegalArgumentException exception =
                assertThrows(IllegalArgumentException.class, () -> new Hippodrome(null));
        assertEquals("Horses cannot be null.", exception.getMessage());
    }

    @Test
    void throwExceptionIfListIsEmpty() {
        List<Horse> emptyList = new ArrayList<>();
        assertThrows(IllegalArgumentException.class, () -> new Hippodrome(emptyList));
    }

    @Test
    void showMessageIfListIsEmpty() {
        List<Horse> emptyList = new ArrayList<>();
        IllegalArgumentException exception =
                assertThrows(IllegalArgumentException.class, () -> new Hippodrome(emptyList));
        assertEquals("Horses cannot be empty.", exception.getMessage());
    }

    @Test
    void getHorses() {
        final List<Horse> horses = new ArrayList<>();
        for (int i = 1; i < 31; i++) {
            horses.add(new Horse("test" + i, 3.0 * i));
        }
        Hippodrome hippodrome = new Hippodrome(horses);
        assertThat(horses, is(hippodrome.getHorses()));
    }

    @Test
    void checkMove() {
        List<Horse> horses = new ArrayList<>();
        Horse horse = Mockito.mock(Horse.class);
        for (int i = 0; i < 50; i++) {
            horses.add(horse);
        }
        Hippodrome hippodrome = new Hippodrome(horses);
        hippodrome.move();
        Mockito.verify(horse, Mockito.times(50)).move();
    }

    @Test
    void checkGetWinner() {
        List<Horse> horses = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            horses.add(new Horse("test" + i, 1, i));
        }
        Hippodrome hippodrome = new Hippodrome(horses);
        assertEquals(9, hippodrome.getWinner().getDistance());
    }
}