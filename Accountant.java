import java.util.ArrayList;

public class Accountant extends BusinessEmployee {
    private TechnicalLead supportTeam;

    // start with a bonus budget of 0 and no team they are officially supporting
    // note: bonus budget is set to 0 in the parent BusinessEmployee constructors
    Accountant(String name) {
        super(name);
        this.supportTeam = null;
    }

    // return a reference to the TechnicalLead that this Accountant is currently supporting.
    // If they have not been assigned a TechnicalLead null should be returned
    private TechnicalLead getTeamSupported() {
        return this.supportTeam;
    }

    // allow a reference to a TechnicalLead to be passed in and saved.
    public void supportTeam(TechnicalLead lead) {
        this.supportTeam = lead;
        // Once this happens the Accountant's bonus budget should be updated to be
        // the total of each SoftwareEngineer's base salary that reports to that TechnicalLead plus 10%.
        ArrayList<SoftwareEngineer> currentDirectReports = lead.getDirectReports();
        for(SoftwareEngineer report : currentDirectReports) {
            this.setBonusBudget(this.getBonusBudget() + (report.getBaseSalary() * 1.1));
        }
        // Designate this Accountant as the one assigned to the TechnicalLead
        lead.setMyAccountant(this);
    }

    // take in a suggested bonus amount and check if there is still enough room in the budget.
    public boolean approveBonus(double bonus) {
        // If the accountant is not supporting any team false should be returned.
        if (this.supportTeam == null) {
            return false;
        } else {
            // If the bonus is greater than the remaining budget, false should be returned, otherwise true.
            return this.getBonusBudget() > bonus;
        }
    }

    // return a String representation of this Accountant that includes their ID, name, the size of
    // their currently managed budget and the name of the TechnicalLead they are currently supporting.
    // Example: "1 Kasey with a budget of 22500.0 is supporting Satya Nadella"
    public String employeeStatus() {
        return super.employeeStatus() + " is supporting " + this.getTeamSupported().getName();
    }
}
