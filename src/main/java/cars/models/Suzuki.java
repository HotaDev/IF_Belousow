package cars.models;

import cars.Car;

public class Suzuki extends Car {

    private final String country = "Япония";

    public Suzuki (int ageRelease, String transmission, String model, String color, int power, int mileage) {
        super(ageRelease, transmission, model, color, power, mileage);
    }

    @Override
    public void getInfo() {
        super.getInfo();
        System.out.println("Производитель: " + country + ";");
    }
}
