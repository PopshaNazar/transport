package project;

class Member {
    private int Varsta;
    private String Nume;

    public Member(int Varsta, String Nume) {
        this.Varsta = Varsta;
        this.Nume = Nume;
    }
}

interface Risky {
    public double getRisk();
}

abstract class Project {
    protected Member manager;
    protected String nume;
    protected String obiectiv;
    protected long fond;

    public Project(Member manager, String nume, String obiectiv, long fond) {
        this.manager = manager;
        this.nume = nume;
        this.obiectiv = obiectiv;
        this.fond = fond;
    }

    abstract public void addMember(Member m);

    public long getFond() {
        return fond;
    }

}

class Militar extends Project implements Risky {
    private String deadLine;
    private static final int MAX_MEMBRI = 15;
    private String parola;
    private Member[] list = new Member[15];
    private int count = 0;

    public Militar(Member manager, String nume, String obiectiv, long fond, String deadLine, String parola) {
        super(manager, nume, obiectiv, fond);
        this.deadLine = deadLine;
        this.parola = parola;
    }

    public void addMember(Member m) {
        if (count < MAX_MEMBRI) {
            list[count] = m;
            count++;
        } else {
            System.out.println("FULL");
        }
    }

    public double getRisk() {
        return count / parola.length() / super.getFond();
    }
}

class OpenSource extends Project implements Risky {
    private String mailingList;
    private Member[] list = new Member[100];
    private int count = 0;

    public OpenSource(Member manager, String nume, String obiectiv, long fond, String mailingList) {
        super(manager, nume, obiectiv, fond);
        this.mailingList = mailingList;
    }

    public void addMember(Member m) {
        list[count] = m;
        count++;
    }

    public double getRisk() {
        return count / super.getFond();
    }
}

class Client {
    public static void main(String args[]) {
        Member p1 = new Member(19, "Adi");
        Member p2 = new Member(18, "nazar");

        Militar M1 = new Militar(p1, "M_1", "obiectiv_M1", -13, "DeadLine_M1", "Parola_M1");
        M1.addMember(p2);
    }
}
