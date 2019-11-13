public abstract class Employee {
    private final String name;
    private final double baseSalary;
    private static int count = 0;
    private int ID;
    private double bonus;

    public Employee(String name, double baseSalary) {
        this.name = name;
        this.baseSalary = baseSalary;
        this.ID = ++count;
        this.bonus = 0;
    }

    public double getBaseSalary() {
        return this.baseSalary;
    }

    public String getName() {
        return this.name;
    }

    public int getEmployeeID() {
        return this.ID;
    }

    public void giveBonus(double bonusAmount) {
        this.bonus = bonusAmount;
    }

    public boolean equals(Employee other) {
        if (this.ID == other.ID) {
            return true;
        } else {
            return false;
        }
    }
    public String toString() {
        return this.ID + " " + this.name;
    }

    public abstract String employeeStatus(); // return a String representation of that Employee's current status.
}