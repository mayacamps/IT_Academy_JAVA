package n1ex03;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {
    @Test
    public void testException(){
        assertThrows(ArrayIndexOutOfBoundsException.class, () ->{
            Main test = new Main();
            int [] numbers = {1, 2, 3, 4};
            test.getElementFromArray(numbers, 5);
        } );
    }
}