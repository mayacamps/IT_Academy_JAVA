package n2ex01;

public class Restaurant implements Comparable <Restaurant> {
    private String name;
    private int score;

    public Restaurant(String name, int score) {
        this.name = name;
        this.score = score;
    }

    public String getName() {
        return this.name;
    }

    public int getScore() {
        return this.score;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String toString(){
        return "Restaurant:\n" +
                "Name: " + this.name +", score: " + this.score;
    }

    @Override
    public int compareTo(Restaurant other) {
        int compName = this.getName().compareToIgnoreCase(other.getName());

        if (compName == 0){
            if (this.getScore() < other.getScore()){
                return 1;
            } else if (this.getScore() > other.getScore()){
                return -1;
            } else {
                return 0;
            }
        }
        return compName;
    }
}
