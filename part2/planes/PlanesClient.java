package planes;

class Plane {
    protected String planeID;
    protected int fuel;

    public Plane(String planeID, int fuel) {
        this.planeID = planeID;
        this.fuel = fuel;
    }

    public String getPlaneID() {
        return planeID;

    }

    public int getFuel() {
        return fuel;
    }

    public void takeOff() {
        System.out.println(getPlaneID() + " takeOff");
    }

    public void fly() {
        System.out.println(getPlaneID() + " flying");

    }
}

class AvionCalatori extends Plane {
    private int MaxPassengers;

    public AvionCalatori(String planeID, int fuel, int MaxPassengers) {
        super(planeID, fuel);
        this.MaxPassengers = MaxPassengers;
    }

    public int getMaxPassengers() {
        return MaxPassengers;
    }

    public void SuperSonic() {
        System.out.println(getPlaneID() + "SuperSonic activated, max passengers" + getMaxPassengers() + ": ");
    }

    public void SubSonic() {
        System.out.println(getPlaneID() + "SuperSonic deactivated");
    }
}

class AvionLupta extends Plane {
    public AvionLupta(String planeID, int fuel) {
        super(planeID, fuel);
    }

    public void launchMissile() {
        System.out.println(getPlaneID() + "Missile launch complete");
    }

    public void highSpeedGeometry() {
        System.out.println(getPlaneID() + "high speed geometry selected");
    }

    public void normalGeometry() {
        System.out.println(getPlaneID() + "normal geometry selected");
    }

    public void refuel() {
        System.out.println(getPlaneID() + "refuel completed");
    }

}

class PlanesClient {
    public static void main(String[] argv) {
        Plane C1 = new AvionCalatori("[AYSUAIGL]", 25, 100);
        Plane L1 = new AvionLupta("[LUPTA00000]", 2125);

        C1.takeOff();
        C1.fly();
        if (C1 instanceof AvionCalatori) {
            ((AvionCalatori) C1).SuperSonic();
            ((AvionCalatori) C1).SubSonic();
        }

        L1.takeOff();
        L1.fly();
        if (L1 instanceof AvionLupta) {
            ((AvionLupta) L1).highSpeedGeometry();
            ((AvionLupta) L1).normalGeometry();
            ((AvionLupta) L1).refuel();
        }
    }
}
