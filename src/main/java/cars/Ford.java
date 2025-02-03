package cars;

public class Ford extends Car {

    public String country = "США";

    public Ford (int ageRelease, String transmission, String model, String color, int power, int mileage) {
        super(ageRelease, transmission, model, color, power, mileage);
    }

    @Override
    public void getInfo() {
        super.getInfo();
        System.out.println("Производитель: " + country + ";");
    }
}
