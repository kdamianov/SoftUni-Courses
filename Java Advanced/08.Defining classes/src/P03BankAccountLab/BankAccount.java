package P03BankAccountLab;

public class BankAccount {

    private static int nextId = 1;
    private static double interestRate = 0.02;

    private int id;
    private double balance;

    public BankAccount() {
        this.id = nextId;
        nextId ++;
    }

    public int getId() {
        return id;
    }

    public static void setInterestRate(double interestRate) {
        BankAccount.interestRate = interestRate;
        //реферираме директно през класа, тк е static полето, а не с this. !!!
    }
    public double getInterest (int years) {
        return balance * years * interestRate;
    }
    public void deposit (double amount) {
        balance += amount;
    }
}
