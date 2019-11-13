import java.util.ArrayList;

public class BusinessLead extends BusinessEmployee {
    private int headCount;
    private int numDirectReports;
    private ArrayList<Accountant> directReports;

    // create a new BusinessLead that is a Manager.
    BusinessLead(String name) {
        // The BusinessLead's base salary should be twice that of an Accountant.
        super(name, 50000 * 2);
        // They should start with a head count of 10 and 0 direct reports.
        this.headCount = 10;
        this.numDirectReports = 0;
        this.directReports = new ArrayList<Accountant>();
    }

    private boolean hasHeadCount() {
        return this.headCount > this.numDirectReports;
    }

    // Add this employee to BusinessLead's list of direct reports.
    // If the employee is successfully added to the BusinessLead's direct reports true should be returned, false otherwise.
    public boolean addReport(Accountant e, TechnicalLead supportTeam) {
        if (this.hasHeadCount()) {
            this.directReports.add(e);
            // Each time an Accountant is added, the BusinessLead's bonus budget should be increased by 1.1 times that new employee's base salary.
            this.setBonusBudget(this.getBonusBudget() + (e.getBaseSalary() * 1.1));
            // That Accountant's team they are supporting should be updated to reflect the reference to the TechnicalLead given.
            e.supportTeam(supportTeam);
            return true;
        } else {
            return false;
        }
    }

    // check if the bonus amount requested would fit in current BusinessLead's budget.
    public boolean requestBonus(Employee e, double bonus) {
        for (Accountant report : this.directReports) {
            double availableBudget = report.getBonusBudget();
            if (availableBudget > bonus) {
                // If it is, that employee should get that bonus
                e.giveBonus(bonus);
                // the BusinessLeader's budget should be deducted
                report.setBonusBudget(report.getBonusBudget() - bonus);
                // and true should be returned
                return true;
            }
        } // False should be returned otherwise
        return false;
    }

    public boolean approveBonus(Employee e, double bonus) {
        // look through the Accountants the BusinessLead manages,
        for (Accountant report : this.directReports) {
            // if any of the Accountants are supporting the TechnicalLead that is the manager of the Employee passed in

            // then the Accountant's budget should be consulted to see if the bonus could be afforded.
            // If the team can afford the bonus it should be rewarded and true returned, false otherwise
            double availableBudget = report.getBonusBudget();
            if (availableBudget > bonus) {
                // If it is, that employee should get that bonus
                e.giveBonus(bonus);
                // the BusinessLeader's budget should be deducted
                report.setBonusBudget(report.getBonusBudget() - bonus);
                // and true should be returned
                return true;
            }
        } // False should be returned otherwise
        return false;
    }

    public String getTeamStatus() {
        if (this.numDirectReports == 0) {
            return this.employeeStatus() + " and has no direct reports yet.";
        } else {
            StringBuilder holder = new StringBuilder(this.employeeStatus() + " and is managing: \n");
            for(Employee report : this.directReports) {
                holder.append(report.employeeStatus());
            }
            return holder.toString();
        }
    }
}