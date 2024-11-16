package weight;

import java.time.chrono.MinguoChronology;

abstract class Weight {
    private int capacity;

    public Weight(int capacity) {
        setCapacity(capacity);
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getCapacity() {
        return capacity;
    }

    public String toString() {
        return "Weight with capacity: " + capacity;
    }
}

class SimpleWeight extends Weight {
    public SimpleWeight(int capacity) {
        super(capacity);
    }

    public String toString() {
        return "SimpleWeight with capacity: " + getCapacity();
    }
}

class DoubleWeight {
    private SimpleWeight w1;
    private SimpleWeight w2;

    public DoubleWeight(SimpleWeight w1, SimpleWeight w2) {
        setDoubleWeight(w1, w2);
    }

    public void setDoubleWeight(SimpleWeight w1, SimpleWeight w2) {
        this.w1 = w1;
        this.w2 = w2;
    }

    public void setWeight1(int capacity) {
        w1.setCapacity(capacity);
    }

    public void setWeight2(int capacity) {
        w2.setCapacity(capacity);
    }

    public int getCapacity() {
        return w1.getCapacity() + w2.getCapacity();
    }

    public String toString() {
        return "DoubleWeight with total capacity: " + getCapacity();
    }

}

class MultipleWeight {
    private MultipleWeight mw1;
    private MultipleWeight mw2;
    private DoubleWeight dw1;
    private DoubleWeight dw2;
    private SimpleWeight w1;
    private SimpleWeight w2;

    public MultipleWeight(SimpleWeight w1, SimpleWeight w2) {
        DoubleWeight(w1, w2);
    }

    public MultipleWeight(DoubleWeight dw1, DoubleWeight dw2) {
        this.dw1 = dw1;
        this.dw2 = dw2;
    }

    public MultipleWeight(SimpleWeight w1, DoubleWeight dw2) {
        this.w1 = w1;
        this.dw2 = dw2;
    }

}

public class WeightClient {
    public static void main(String[] args) {
        SimpleWeight W1 = new SimpleWeight(12);
        SimpleWeight W2 = new SimpleWeight(13);
        DoubleWeight DW1 = new DoubleWeight(W1, W2);

        System.out.println(W1);
        System.out.println(W2);
        System.out.println(DW1);

    }
}
