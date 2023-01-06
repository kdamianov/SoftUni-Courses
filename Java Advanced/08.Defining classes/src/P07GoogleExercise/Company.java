package P07GoogleExercise;

public class Company {
    private String companyName;
    private String companyDepartment;
    private double companySalary;

    public Company(String companyName, String companyDepartment, double companySalary) {
        this.companyName = companyName;
        this.companyDepartment = companyDepartment;
        this.companySalary = companySalary;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCompanyDepartment() {
        return companyDepartment;
    }

    public void setCompanyDepartment(String companyDepartment) {
        this.companyDepartment = companyDepartment;
    }

    public double getCompanySalary() {
        return companySalary;
    }

    public void setCompanySalary(double companySalary) {
        this.companySalary = companySalary;
    }

    @Override
    public String toString() {
        //Company:
        //	{companyName} {companyDepartment} {salary}
        return String.format("%s %s %.2f%n",companyName, companyDepartment, companySalary);
    }
}
