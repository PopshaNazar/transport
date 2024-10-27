package phones;

import java.util.Scanner;

class Phone {
    private String name;

    public Phone(String name) {
        this.name = name;

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

    }
}
