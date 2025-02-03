package cars;

public class Lada extends Car {

    public String country = "Россия";

    public Lada (int ageRelease, String transmission, String model, String color, int power, int mileage) {
        super(ageRelease, transmission, model, color, power, mileage);
    }

    @Override
    public void getInfo() {
        super.getInfo();
        System.out.println("Производитель: " + country + ";");
    }
}
