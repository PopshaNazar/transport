package phones;

import java.util.Random;
import java.util.Scanner;

class Phone {
    private String name;
    private String[] callList;
    private int count;
    private static int MAX_CALLS = 100;

    public Phone(String name) {
        this.name = name;
        this.callList = new String[100];
        this.count = 0;
    }

    public boolean makeCall(Phone otherPhone) {
        if (count < MAX_CALLS) {
            otherPhone.callList[otherPhone.count] = this.name;
            otherPhone.count++;
            return true;
        }
        return false;
    }

    public int getCallCount(String name) {
        int counter = 0;
        for (int i = 0; i < count; i++) {
            if (callList[i].equals(name)) {
                counter++;
            }
        }
        return counter;
    }

    public String toString() {
        String result = name + " was called by: ";
        for (int i = 0; i < count; i++) {
            result = result + callList[i];
            if (i < count - 1) {
                result = result + ", ";
            }
        }
        return result;
    }
}

public class MainClient {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        // read/creating
        System.out.print("Owners number: ");
        int N = scan.nextInt();
        scan.nextLine();
        Phone[] phones = new Phone[N];
        for (int i = 0; i < N; i++) {
            System.out.print("Owner's(" + i + ") name: ");
            String name = scan.nextLine();
            phones[i] = new Phone(name);
        }

        // calling
        Random random = new Random();
        System.out.print("nummber of calls: ");
        int NrCalls = scan.nextInt();
        for (int i = 0; i < NrCalls; i++) {
            int x = random.nextInt(NrCalls);
            int y = random.nextInt(NrCalls);
            if (x == y) {
                // call fail
                i--;
            } else {
                phones[x].makeCall(phones[y]);
            }

        }
        System.out.print("Enter an owner name to check call count: ");
        scan.nextLine();
        String searchName = scan.nextLine();

        for (int i = 0; i < NrCalls; i++) {
            System.out.println(phones[i]);
            System.out.println("Number of calls from " + ": " + phones[i].getCallCount(searchName));
        }

    }
}
