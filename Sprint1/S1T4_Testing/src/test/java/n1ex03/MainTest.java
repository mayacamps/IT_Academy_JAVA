package n1ex03;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {
    @Test
    public void testException(){
        assertThrows(ArrayIndexOutOfBoundsException.class, () ->{
            Main test = new Main();
            test.generatorArrayIndexOutOfBounds();
        } );
    }
}