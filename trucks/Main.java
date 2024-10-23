package trucks;

class Truck {
    private static int maxTows = 5;
    private Tow[] tows = new Tow[maxTows];
    private int towsNr = 0;

    public boolean addTow(int loadNr, String regNr) {
        if (towsNr < maxTows) {
            tows[towsNr] = new Tow(loadNr, regNr);
            towsNr++;
            return true;
        }
        return false;
    }

    public boolean addTow(String regNr) {
        if (towsNr < maxTows) {
            tows[towsNr] = Tow;

            towsNr++;
            return true;
        }
        return false;
    }
}

class Tow {
    private int loadNr;
    private String regNr;

    private static int lastLoadNr = 0;

    public void addTow(int loadNr, String regNr) {
        this.loadNr = loadNr;
        this.regNr = regNr;
        lastLoadNr = loadNr;
    }

    public void addTow(String regNr) {
        this.regNr = regNr;
        if (lastLoadNr == 0) {
            this.loadNr = 10;
        } else {
            this.loadNr = lastLoadNr + 1;
        }
        lastLoadNr = this.loadNr;

    }

    public String getTow() {
        String info = "info:\n" + "load: " + loadNr + "\nreg: " + regNr;
        return info;
    }
}

public class Main {
    public static void main(String args[]) {
        Truck[] tow = new Truck[5];
        //Tow tow1 = new Tow();
        //tow1.addTow(12, "TM777S");
        //System.out.println(tow1.getTow());
        for (int i = 0; i < tow.length; i++) {
            
    }
}
