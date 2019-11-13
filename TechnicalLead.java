import java.util.ArrayList;

public class TechnicalLead extends TechnicalEmployee {
    private int headCount;
    private int numDirectReports;
    private ArrayList<SoftwareEngineer> directReports;

    // TechnicalLead's base salary = 1.3 times that of a TechnicalEmployee.
    // TechnicalLead's should have a default head count of 4 and default direct reports of 0.
    TechnicalLead(String name) {
        super(name, 75000*1.3);
        this.directReports = new ArrayList<SoftwareEngineer>();
        this.headCount = 4;
        this.numDirectReports = 0;
    }

    // return true if the number of direct reports this manager has is less than their headcount.
    public boolean hasHeadCount() {
        return this.headCount < this.numDirectReports;
    }

    // If the TechnicalLead has head count left should add this employee to their list of direct reports.
    // If the employee is successfully added to the TechnicalLead's direct reports true should be returned, otherwise false
    public boolean addReport(SoftwareEngineer e) {
        if (this.headCount > this.numDirectReports) {
            this.directReports.add(e);
            return true;
        } else {
            return false;
        }
    }

    // If the employee passed in does report to this manager and if their code access is currently set to "true".
    // If both those things are true, true is returned, otherwise false is returned
    public boolean approveCheckIn(SoftwareEngineer e) {
        if (this.directReports.contains(e)) {
            return e.getCodeAccess();
        } else {
            return false; // e does not report to this lead
        }
    }

    public ArrayList<SoftwareEngineer> getDirectReports() {
        return this.directReports;
    }

    // check if the bonus amount requested would be approved by the BusinessLead supporting this TechnicalLead.
    // If it is, that employee should get that bonus and true should be returned. False should be returned otherwise
    public boolean requestBonus(Employee e, double bonus) {
        return false; // TODO
    }

    // return a String that gives insight into this Manager and all their direct reports.
    // return a string that is a combination of the TechnicalLead's employee status
    // followed by each of their direct employee's status on subsequent lines.
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
