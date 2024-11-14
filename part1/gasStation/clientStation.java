package part1.gasStation;

class gasStation {
    private int Fuel;
    private static int Max_cars = 10;
    private int count = 0;
    private Car[] carlist;

    public gasStation(int Fuel) {
        this.Fuel = Fuel;
        this.carlist = new Car[Max_cars];
    }

    public boolean feedCars(Car car) {
        if (Fuel >= car.getFuel()) {
            Fuel -= car.getFuel();
            return true;
        } else {
            if (count < Max_cars) {
                carlist[count] = car;
                count++;
                return true;
            } else {
                return false;
            }
        }
    }

    public void feedStation(int newFuel) {
        this.Fuel += newFuel;
        for (int i = 0; i < count; i++) {
            if (Fuel >= carlist[i].getFuel()) {
                feedCars(carlist[i]);
                count--;
            }
        }
    }

    public String queue() {
        StringBuilder result = new StringBuilder();
        result.append(" gasStation");
        for (int i = 0; i < count; i++) {
            result.append("--(ID: " + carlist[i].getID() + ", fuel:" + carlist[i].getFuel() + ") ");
        }

        return result.toString();
    }
}

class Car {
    private int fuel;
    private String ID;

    public Car(String ID, int fuel) {
        this.ID = ID;
        this.fuel = fuel;
    }

    public String getID() {
        return ID;
    }

    public int getFuel() {
        return fuel;
    }
}

public class clientStation {
    public static void main(String[] args) {
        gasStation station = new gasStation(20);

        Car car1 = new Car("nr12345", 5);
        Car car2 = new Car("nr912", 15);
        Car car3 = new Car("nr12345", 10);
        Car car4 = new Car("nr912", 15);

        station.feedCars(car1);
        station.feedCars(car2);
        station.feedCars(car3);
        station.feedCars(car4);

        System.out.println(station.queue());

        station.feedStation(10);
        System.out.println(station.queue());

    }
}
