package n3ex01;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        students.add(new Student("Lucas", "PHP", 23, 5.7f));
        students.add(new Student("Maria", "JAVA", 34, 9.2f));
        students.add(new Student("Francesc", "Data Science", 29, 4.8f));
        students.add(new Student("George", "React", 27, 2.3f));
        students.add(new Student("Lucia", "Angular", 31, 8.3f));
        students.add(new Student("Ariadna", "JAVA", 24, 7.7f));
        students.add(new Student("Jesus", "PHP", 48, 7));
        students.add(new Student("Alicia", "Data Science", 19, 3.7f));
        students.add(new Student("Antonio", "React", 20, 4));
        students.add(new Student("James", "JAVA", 17, 3));

        System.out.println("\nName and age of all students: ");
        students.forEach(l -> System.out.println("Name: " + l.getName() + ",\t Age: " + l.getAge()));

        System.out.println("\nList of all students whose name starts with 'A': " );
        List<Student> nameStartsWithA = students.stream()
                .filter(s -> s.getName().toLowerCase().startsWith("a"))
                .toList();
        nameStartsWithA.forEach(System.out::println);

        System.out.println("\nStudents with score equal or higher to 5: ");
        students.stream()
                .filter(s -> s.getScore() >= 5)
                .forEach(System.out::println);

        System.out.println("\nStudents with score equal or higher to 5 (NOT PHP): ");
        students.stream()
                .filter(s -> s.getScore() >= 5 && !s.getCourse().equalsIgnoreCase("PHP"))
                .forEach(System.out::println);

        System.out.println("\nJAVA students of legal age: ");
        students.stream()
                .filter(s -> s.getCourse().equalsIgnoreCase("JAVA") && s.getAge() >= 18)
                .forEach(System.out::println);
    }
}
