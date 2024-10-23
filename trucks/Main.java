package trucks;

class Tow {
    public int loadNr;
    public String regNr;

    public void addTow(int loadNr, String regNr) {
        this.loadNr = loadNr;
        this.regNr = regNr;
    }

    public String getTow() {
        String info = "info:\n" + "load: " + loadNr + "\nreg: " + regNr;
        return info;
    }
}

public class Main {
    public static void main(String argv[]) {
        Tow tow1 = new Tow();
        tow1.addTow(12, "TM777S");
        System.out.println(tow1.getTow());

    }
}
