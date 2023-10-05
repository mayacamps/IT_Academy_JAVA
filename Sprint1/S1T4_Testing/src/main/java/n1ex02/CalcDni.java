package n1ex02;

public class CalcDni {
    public static void main(String[] args) {
        char [] letters = {'T', 'R', 'W', 'A', 'G', 'M', 'Y', 'F', 'P', 'D', 'X', 'B', 'N', 'J', 'Z', 'S', 'Q', 'V', 'H', 'L', 'C', 'K', 'E'};
        System.out.println(letters[0]);
    }
    public static char getLetter(int numDni) {
        char dniLetter;
        if (numDni > 0 && numDni < 99999999){
            char [] letters = {'T', 'R', 'W', 'A', 'G', 'M', 'Y', 'F', 'P', 'D', 'X', 'B', 'N', 'J', 'Z', 'S', 'Q', 'V', 'H', 'L', 'C', 'K', 'E'};
            dniLetter = letters[numDni % 23];
        } else {
            throw new IllegalArgumentException();
        }
        return dniLetter;
    }
}
