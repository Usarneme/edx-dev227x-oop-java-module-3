public class SoftwareEngineer extends TechnicalEmployee {
    private boolean hasAccessToCode;

    public SoftwareEngineer(String name) {
        super(name);
        this.hasAccessToCode = false;
    }

    public boolean getCodeAccess() {
        return this.hasAccessToCode;
    }

    public void setCodeAccess(boolean access) {
        this.hasAccessToCode = access;
    }

    public int getSuccessfulCheckIns() {
        return this.getNumberOfCheckIns();
    }

    public boolean checkInCode() {
        if (this.hasAccessToCode) {
            this.addNewCheckIn();
            return true;
        } else {
            return false;
        }
    }
}
