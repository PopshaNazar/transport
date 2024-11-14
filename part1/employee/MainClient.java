package part1.employee;

class Firm {
    private String nameFirm;

    private static int MaxEmp = 30;
    private Employee[] empList;
    private int count = 0;

    public Firm(String nameFirm, int budget) {
        this.nameFirm = nameFirm;
        this.empList = new Employee[MaxEmp];
    }

    public boolean addEmp(Employee emp) {
        if (count < MaxEmp) {
            for (int i = 0; i < count; i++) {
                if (empList[i].equals(emp)) {
                    System.out.println("he is already employed");
                    return false;
                }
            }
            empList[count] = emp;
            System.out.println("employed :)");
            count++;
            return true;
        } else {
            return false;
        }
    }

    public String employers() {
        StringBuilder result = new StringBuilder();
        result.append(this.nameFirm);
        for (int i = 0; i < count; i++) {
            result.append(" " + (i + 1) + ":" + "(" + empList[i].getName() + "salary: " + empList[i].getSalary() + ")");
        }
        return result.toString();
    }

}

class Employee {
    private int salary;
    private String name;

    public Employee(String name, int salary) {
        this.name = name;
        this.salary = salary;
    }

    public int getSalary() {
        return salary;
    }

    public String getName() {
        return name;
    }
}

public class MainClient {
    public static void main(String[] args) {

        Firm firm = new Firm("firm1", 3000);

        Employee emp1 = new Employee("Alin", 1000);
        Employee emp2 = new Employee("Alin", 1000);

        Employee emp3 = new Employee("Alsdsn", 10230);

        firm.addEmp(emp1);
        firm.addEmp(emp2);
        firm.addEmp(emp3);

        System.out.println(firm.employers());
    }
}
