package n3ex01;

public class Smartphone implements Phone{
    private String brand, model;
    public Smartphone(String brand, String model){
        this.brand = brand;
        this.model = model;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    @Override
    public void ring() {
        System.out.println("You are calling someone.");
    }

    public void takePhotos(){
        System.out.println("You are taking a photo.");
    }
}
