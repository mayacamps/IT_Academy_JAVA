package n1ex01;

public class NoGenericMethods<T> {
    private String a;
    private String b;
    private String c;

    public NoGenericMethods(String a, String b, String c){
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public String geta() {
        return a;
    }

    public void seta(String a) {
        this.a = a;
    }

    public String getb() {
        return b;
    }

    public void setb(String b) {
        this.b = b;
    }

    public String getc() {
        return c;
    }

    public void setc(String c) {
        this.c = c;
    }

    @Override
    public String toString(){
        return "Object 1: " + a + "\n" +
                "Object 2: "  + b + "\n" +
                "Object 3: " + c + "\n";
    }
}
