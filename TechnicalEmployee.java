public abstract class TechnicalEmployee extends Employee {
    private int numberOfCheckIns;
    private boolean isManager;

    // default constructor for non-management employees, all have same base salary
    public TechnicalEmployee(String name) {
        super(name, 75000);
        this.numberOfCheckIns = 0;
        this.isManager = false;
    }

    // default constructor for managers, have a modified base salary
    public TechnicalEmployee(String name, double baseSalary) {
        super(name, baseSalary);
        this.numberOfCheckIns = 0;
        this.isManager = true;
    }

    public int getNumberOfCheckIns() {
        return this.numberOfCheckIns;
    }

    public void addNewCheckIn() {
        this.numberOfCheckIns++;
    }

    public boolean isManager() {
        return this.isManager;
    }

    // return a String representation of this TechnicalEmployee
    // include their ID, name and how many successful check ins they have had.
    // Example: "1 Kasey has 10 successful check ins"
    public String employeeStatus() {
        return this.getEmployeeID() + " " + this.getName() + " has " + this.getNumberOfCheckIns() + " successful check-ins";
    }
}
