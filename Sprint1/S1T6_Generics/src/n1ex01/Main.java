package n1ex01;

public class Main {
    public static void main(String[] args) {
        String lang1 = "italian";
        String lang2 = "german";
        String lang3 = "spanish";
        NoGenericMethods<String> langNoGenerics1 = new NoGenericMethods<>(lang1, lang2, lang3);
        NoGenericMethods<String> langNoGenerics2 = new NoGenericMethods<>(lang3, lang1, lang2);
        NoGenericMethods<String> langNoGenerics3 = new NoGenericMethods<>(lang2, lang3, lang1);

        System.out.println(langNoGenerics1);
        System.out.println(langNoGenerics2);
        System.out.println(langNoGenerics3);

    }
}
