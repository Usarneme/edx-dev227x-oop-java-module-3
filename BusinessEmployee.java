import java.text.NumberFormat;

public abstract class BusinessEmployee extends Employee {
    private double bonusBudget;

    // default constructor for a non-manager business employee
    public BusinessEmployee(String name) {
        super(name, 50000);
        this.bonusBudget = 0;
    }

    // default constructor for the business manager/lead employee
    public BusinessEmployee(String name, double baseSalary) {
        super(name, baseSalary);
        this.bonusBudget = 0;
    }

    // establish a running tally of the remaining bonusBudget for the team this employee supports.
    // How that budget is determined will depend on which type of Business Employee it is
    public double getBonusBudget() {
        return this.bonusBudget;
    }

    public void setBonusBudget(double bonusBudget) {
        this.bonusBudget = bonusBudget;
    }

    // return a String representation of this BusinessEmployee
    // includes their ID, name and the size of their currently managed budget.
    // Example: "1 Kasey with a budget of 22500.0"
    public String employeeStatus() {
        NumberFormat formatter = NumberFormat.getCurrencyInstance();
        return this.getEmployeeID() + " " + this.getName() + " with a budget of " + formatter.format(this.getBonusBudget());
    }
}
