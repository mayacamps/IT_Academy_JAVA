package n1ex02;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class CalcDniTest {

    @ParameterizedTest
    @CsvSource({"43569970,N", "37693810,F", "80077894,J", "44546536,K", "10996911,J", "60008789,H", "53188552,V", "49083038,A", "31939351,X", "40874612,R"})
    public void letterDni(int dni, char expectedLetter){
        char methodLetter = CalcDni.getLetter(dni);
        assertEquals(expectedLetter, methodLetter);
    }

}
