package part1.drawing;

class Figure {
    private String name;
    private int area;

    public Figure(String name, int area) {
        this.name = name;
        this.area = area;
    }

    public String toString() {
        return "(name: " + name + ", area:" + area + ") ".toString();
    }
}

class Drawing {
    private String Name;
    private Figure[] figureList;
    private static int MAX_FIGURES = 1024;
    private int count;

    public Drawing(String Name) {
        this.Name = Name;
        figureList = new Figure[MAX_FIGURES];
        count = 0;
    }

    public boolean addFigure(Figure fig) {
        if (count <= MAX_FIGURES) {
            for (int i = 0; i < count; i++) {
                if (fig.equals(figureList[i]) == true) {
                    System.out.println("almost exist");
                    return false;
                }
            }
        } else {
            System.out.println("--");
            return false;
        }
        figureList[count] = fig;
        count++;
        System.out.println("+figure");
        return true;
    }

    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append("Draw name: " + this.Name);
        for (int i = 0; i < count; i++) {
            result.append(figureList[i].toString());
        }
        return result.toString();
    }
}

public class ClientMain {
    public static void main(String[] argv) {
        Drawing drawing = new Drawing("Mamaia");
        Figure fig1 = new Figure("romb", 123);
        Figure fig2 = new Figure("idk", 1113);
        drawing.addFigure(fig1);
        drawing.addFigure(fig1);
        drawing.addFigure(fig2);

        System.out.println(drawing.toString());

    }
}
