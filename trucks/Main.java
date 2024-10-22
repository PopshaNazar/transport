package trucks;

class Tow {
    private int loadNr;
    private String regNr;

    public void addTow(int loadNr, String regNr) {
        this.loadNr = loadNr;
        this.regNr = regNr;
    }

    public String getTow() {
        String info = "info" + "load: " + loadNr + "\nreg: " + regNr;
        return info;
    }
}

public class Main {
    public static void main(String argv[]) {
        // Tow tow1 = new Tow();
        // System.out.println(tow1.getTow());

    }
}
