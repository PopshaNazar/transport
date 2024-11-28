package weight;

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

class ComplexWeight {
    private Weight[] weights;

    public ComplexWeight(Weight[] weights) {
        this.weights = weights;
    }

    public int getSize() {
        int totalSize = 0;
        for (int i = 0; i < weights.length; i++) {
            totalSize += weights[i].getCapacity();
        }
        return totalSize;
    }
}
// private MultipleWeight mw1;
// private MultipleWeight mw2;
// private DoubleWeight dw1;
// private DoubleWeight dw2;
// private SimpleWeight w1;
// private SimpleWeight w2;

// public MultipleWeight(SimpleWeight w1, SimpleWeight w2) {
// this.w1 = w1;
// this.w2 = w2;
// }
// public MultipleWeight(DoubleWeight dw1, DoubleWeight dw2) {
// this.dw1 = dw1;
// this.dw2 = dw2;
// }
// public MultipleWeight(MultipleWeight mw1, MultipleWeight mw2) {
// this.mw1 = mw1;
// this.mw2 = mw2;
// }
// public MultipleWeight(SimpleWeight w1, DoubleWeight dw2) {
// this.w1 = w1;
// this.dw2 = dw2;
// }
// public MultipleWeight(SimpleWeight w1, MultipleWeight mw2) {
// this.w1 = w1;
// this.mw2 = mw2;
// }
class Gym {
    private Weight[] weights;
    private int nrWeights;

    public Gym(int maxWeights) {
        this.weights = new Weight[maxWeights];
        this.nrWeights = 0;
    }

    public void addWeight(Weight weight) {
        if (nrWeights < weights.length) {
            weights[nrWeights] = weight;
            nrWeights++;
        }
    }

    public double averageSize() {
        int totalCapacity = 0;
        for (int i = 0; i < nrWeights; i++) {
            totalCapacity += weights[i].getCapacity();
        }
        return (double) totalCapacity / nrWeights;
    }
}

public class WeightClient {
    public static void main(String[] args) {
        SimpleWeight W1 = new SimpleWeight(12);
        SimpleWeight W2 = new SimpleWeight(13);
        DoubleWeight DW1 = new DoubleWeight(W1, W2);
        Gym gym = new Gym(10);
        System.out.println(W1);
        System.out.println(W2);
        System.out.println(DW1);
        gym.addWeight(W1);
        gym.addWeight(W2);
        System.out.println("gym: " + gym.averageSize());

    }
}
