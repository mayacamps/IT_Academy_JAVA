package n1ex01;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class MonthsTest {
    Months year = new Months();
    @Test
    public void sizeList() {
        assertEquals(12, year.getMonths().size());
    }

    @Test
    public void notNullList(){
        assertNotNull(year);
    }

    @Test
    public void augMonth(){
        assertEquals("Aug", year.getMonths().get(7));
    }
}