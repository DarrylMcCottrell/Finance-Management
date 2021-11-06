import java.util.ArrayList;
import java.lang.StringBuilder;

public class Checking extends Account{
    ArrayList<Transaction> transactions = new ArrayList<Transaction>();
    double balance;

    /*
    Initializes basic account information
    Adds deposit to transaction list
    */
    Checking(String fn, String ln, String ma, int an, double deposit){
        this.setFirstName(fn);
        this.setLastName(ln);
        this.setMailingAdress(ma);
        this.setAccountNum(an);
        balance += deposit;
        Transaction t = new Deposit(deposit);
        transactions.add(t);
    }

    /*
    Adds Withdrawal to Transaction list
    Changes balance accordingly
    */
    @Override
    void MakeWithdrawal(double amount){
        Transaction t = new Withdrawal(amount);
        transactions.add(t);
        balance -= amount;
    }

    /*
    Adds Deposit to Transaction list
    Changes balance accordingly
    */
    @Override
    void MakeDeposit(double amount){
        Transaction t = new Deposit(amount);
        transactions.add(t);
        balance += amount;
    }

    /*
    Creates String of Checking Account information
    for HTML file
    */
    @Override
    String GenerateHTML(){
        StringBuilder b = new StringBuilder();
        
        b.append(super.GenerateHTML());

        for(Transaction t : transactions){
            b.append("<p>" + t.toString() + "\n </p");
        }

        return b.toString();
    } 

    //Returns balance of Checking account
    @Override
    double getValue(){
        return balance;
    }
};