package cars;

public abstract class Car {
    public int ageRelease;
    public String transmission;
    public String model;
    public String color;
    public int power;
    public int mileage;

    public Car(int ageRelease, String transmission, String model, String color, int power, int mileage) {
        this.ageRelease = ageRelease;
        this.transmission = transmission;
        this.model = model;
        this.color = color;
        this.power = power;
        this.mileage = mileage;
    }

    public void changeColor(String color) {
        this.color = color;
    }

    public void getInfo() {
        System.out.println("Год выпуска: " + ageRelease + ";");
        System.out.println("Коробка передач: " + transmission + ";");
        System.out.println("Модель: " + model + ";");
        System.out.println("Цвет: " + color + ";");
        System.out.println("Мощность(л.с.): " + power + ";");
        System.out.println("Пробег (км): " + mileage + ";");
    }

    public void getCar2006() {
        if (this.ageRelease < 2007) {
            System.out.println("Модель: " + this.model + " устарела");
        } else {
            this.getInfo();
        }
        System.out.println("####################");
    }
    public void changeColor() {
        if (this.color.equals("Зеленый")) {
            this.color = "Красный";
            System.out.println("Модель: " + this.model + " стала красной");
        } else {
            System.out.println("Модель: " + this.model + " не зеленая, перекраска не нужна");
        }
        System.out.println("####################");
    }

    public void checkTechServ() {
        if (this.mileage > 10000) {
            System.out.println("Модель: " + this.model + " нужно пройти ТО");
        } else {
            System.out.println("Модель: " + this.model + " еще свежая, ТО не нужно проходить");
        }
        System.out.println("/////////////////");
    }


}
