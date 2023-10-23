package n3ex01;

public class Student {
    private String name, course;
    private int age;
    private float score;

    public Student(String name, String course, int age, float score) {
        this.name = name;
        this.course = course;
        this.age = age;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public float getScore() {
        return score;
    }

    public void setScore(float score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "Student name: '" + name + '\'' +
                "\ncourse: '" + course + '\'' +
                "\nage: " + age +
                "\nscore: " + score + "\n";
    }
}
