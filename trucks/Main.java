package trucks;

class Cargo {
    private String ID;
    private int totalBoxes;
    private static int startingBoxes = 10;

    public Cargo(String ID, int totalBoxes) {
        this.ID = ID;
        this.totalBoxes = totalBoxes;
    }

    public Cargo(String ID) {
        this.ID = ID;
        if (totalBoxes == 0) {
            this.totalBoxes = startingBoxes;
            totalBoxes = startingBoxes;

        } else {
            this.totalBoxes = startingBoxes + 1;
            startingBoxes = this.totalBoxes;
        }
    }

    public String getID() {
        return ID;
    }

    public int getTotalBoxes() {
        return totalBoxes;
    }

    public String toString() {
        return "R(" + ID + "), totalBoxes: " + totalBoxes;
    }
}

class Truck {
    private static int MaxCargo = 5;
    private int countCargo;
    private Cargo[] cargoList;

    public Truck() {
        this.cargoList = new Cargo[MaxCargo];
        countCargo = 0;
    }

    public boolean addCargo(int totalBoxes, String ID) {
        if (countCargo < MaxCargo) {
            cargoList[countCargo++] = new Cargo(ID, totalBoxes);
            return true;
        }
        return false;
    }

    public boolean addCargo(String ID) {
        if (countCargo < MaxCargo) {
            cargoList[countCargo++] = new Cargo(ID);
            return true;
        }
        return false;
    }

    public String toString() {
        String result = "T";
        for (int i = 0; i < countCargo; i++) {
            result = result + ": " + cargoList[i].toString();
        }
        return result;
    }
}

public class Main {
    public static void main(String args[]) {
        Truck truck1 = new Truck();
        System.out.print("1st truck: ");
        truck1.addCargo(20, "TM 76 WWG");
        truck1.addCargo("TM 777 AO");
        System.out.println(truck1);
    }
}
