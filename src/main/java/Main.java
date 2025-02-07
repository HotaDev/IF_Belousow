import cars.*;
import cars.models.*;

import java.util.ArrayList;
import java.util.List;

public class Main {
    //it`s develop origin
    public static void main(String[] argv) {
        Toyota camry = new Toyota(2008, "Автомат", "Camry", "Белый", 200, 1000);
        Toyota hilux = new Toyota(2015, "Механика", "Hilux", "Черный", 150, 5000);
        Lada vesta = new Lada(2017, "Автомат", "Vesta", "Красный", 100, 100);
        Lada niva = new Lada(2002, "Механика", "Niva", "Зеленый", 80, 10000);
        Ford focus = new Ford(2005, "Механика", "Focus", "Желтый", 95, 14000);
        Ford transit = new Ford(2018, "Механика", "Transit", "Зеленый", 100, 20000);
        Opel astra = new Opel(2022, "Автомат", "Astra", "Желтый", 110, 9000);
        Opel zafira = new Opel(2017, "Автомат", "Zafira", "Розовый", 120, 10);
        Suzuki vitara = new Suzuki(2007, "Автомат", "Vitara", "Золотой", 150, 100000);
        Suzuki jimny = new Suzuki(2000, "Механика", "Jimny", "Белый", 110, 50000);

        List<Car> carList = new ArrayList<>();

        carList.add(camry);
        carList.add(hilux);
        carList.add(vesta);
        carList.add(niva);
        carList.add(focus);
        carList.add(transit);
        carList.add(astra);
        carList.add(zafira);
        carList.add(vitara);
        carList.add(jimny);

        for (Car c : carList) {
            c.changeColor();
            c.getCar2006();
            c.checkTechServ();
        }
    }
}
