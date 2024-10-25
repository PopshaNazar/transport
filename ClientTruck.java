
class Cargo {
    private int totalBoxes;
    private String ID;
    private static int startingBoxes = 10;

    public Cargo(String ID, int totalBoxes) {
        this.ID = ID;
        this.totalBoxes = totalBoxes;
    }

    public Cargo(String ID) {
        this.ID = ID;
        this.totalBoxes = 1 + startingBoxes;
        startingBoxes = this.totalBoxes;
    }

    public String getID() {
        return ID;
    }

    public int getBoxes() {
        return totalBoxes;
    }

    public String toString() {
        return "R(" + ID + ", " + totalBoxes + ")";
    }
}

class Truck {
    private static int truckCapacity = 5;
    private int truckSize;
    private Cargo[] cargoList;

    public Truck() {
        this.cargoList = new Cargo[truckCapacity];
        this.truckSize = 0;
    }

    public boolean addCargo(int totalBoxes, String ID) {
        if (truckSize < truckCapacity) {
            cargoList[truckSize++] = new Cargo(ID, totalBoxes);
            return true;
        }
        return false;
    }

    public boolean addCargo(Cargo cargo) {
        if (truckSize < truckCapacity) {
            cargoList[truckSize++] = cargo;
            return true;
        }
        return false;
    }

    public Cargo removeCargo(String ID) {
        for (int i = 0; i < truckSize; i++) {
            if (cargoList[i].getID().equals(ID)) {
                Cargo removedCargo = cargoList[i];
                for (int j = i; j < truckSize - 1; j++) {
                    cargoList[j] = cargoList[j + 1];
                }
                cargoList[--truckSize] = null;
                return removedCargo;
            }
        }
        return null;
    }

    public int getTotalBoxes() {
        int total = 0;
        for (int i = 0; i < truckSize; i++) {
            total = total + cargoList[i].getBoxes();
        }
        return total;
    }

    public boolean equalSize(Truck truck) {
        if (this.getTotalBoxes() == truck.getTotalBoxes()) {
            return true;
        }
        return false;
    }

    public String toString() {
        String result = "T";
        for (int i = 0; i < truckSize; i++) {
            result = result + " -> " + cargoList[i].toString();
        }
        return result;
    }
}

public class ClientTruck {
    public static void main(String[] args) {
        Truck truck1 = new Truck();
        System.out.print("1st truck: ");
        truck1.addCargo(20, "TM 76 WWG");
        truck1.addCargo(15, "TM 43 PMN");
        truck1.addCargo(25, "TM 21 DRS");
        System.out.println(truck1);
        Cargo removedCargo1 = truck1.removeCargo("TM 76 WWG");
        System.out.print("1st truck (after removing \"TM 76 WWG\"): ");
        System.out.println(truck1);

        Truck truck2 = new Truck();
        System.out.print("2nd truck: ");
        truck2.addCargo(25, "BH 48 WWG");
        truck2.addCargo(15, "BH 79 PMN");
        truck2.addCargo(20, "BH 13 DRS");
        System.out.println(truck2);
        Cargo removedCargo2 = truck2.removeCargo("BH 13 DRS");
        System.out.print("2nd truck (after removing \"BH 13 DRS\"): ");
        System.out.println(truck2);

        if (truck1.equalSize(truck2)) {
            System.out.println("The trucks have equal storage capacity.");
        } else {
            System.out.println("The trucks do not have equal storage capacity.");
        }
    }
}