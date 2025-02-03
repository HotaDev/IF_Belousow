package cars;

public class Toyota extends Car {

    public String country = "Япония";

    public Toyota (int ageRelease, String transmission, String model, String color, int power, int mileage) {
        super(ageRelease, transmission, model, color, power, mileage);
    }

    @Override
    public void getInfo() {
        super.getInfo();
        System.out.println("Производитель: " + country + ";");
    }
}
