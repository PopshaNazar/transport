package train;

abstract class Wagon {
    private int nrPassengers;
    private int nrPackages;
    private String type;

    public Wagon(int nrPassengers, int nrPackages, String type) {
        this.nrPassengers = nrPassengers;
        this.nrPackages = nrPackages;
        this.type = type;

    }
}

class WagonTypeA extends Wagon {
    public WagonTypeA() {
        super(40, 300, "WagonTypeA");
    }

    public void OpenCloseDoors() {
        System.out.println("Door open... \n...\nDoor close");
    }
}

class WagonTypeB extends Wagon {
    public WagonTypeB() {
        super(50, 400, "WagonTypeB");
    }

    public void OpenCloseDoors() {
        System.out.println("Door open... \n...\nDoor close");
    }

    public void LockWindows() {
        System.out.println("Lock windows");
    }
}

class WagonCargo extends Wagon {
    public WagonCargo() {
        super(0, 400, "WagonCargo");
    }

    public void OpenCloseDoors() {
        System.out.println("Door open... \n...\nDoor close");
    }
}

class Train {
    private static int max = 15;
    private int counter = 0;
    private Wagon list[];

    public void addWagon(Wagon wagon) {
        if (max < 15) {
            list[counter] = wagon;
            counter++;
        }
    }

}

class TrainClient {
    public static void main(String[] args) {
        Wagon w1 = new WagonTypeA();
    }
}