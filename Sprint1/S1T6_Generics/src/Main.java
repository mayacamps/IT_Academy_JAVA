public class Main {
    public static void main(String[] args) {
        String lang1 = "italian";
        String lang2 = "german";
        String lang3 = "spanish";
        NoGenericMethods<String> langGenerics1 = new NoGenericMethods<>(lang1, lang2, lang3);
        NoGenericMethods<String> langGenerics2 = new NoGenericMethods<>(lang3, lang1, lang2);

        System.out.println(langGenerics1);
        System.out.println(langGenerics2);

    }
}
