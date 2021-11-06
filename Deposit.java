public class Deposit extends Transaction{
    
    //Initializes Transaction information
    Deposit(double s){
        this.balance += s;
        this.sum = s;
        this.type = "Deposit";
    }

    //Prints values of Deposit
    @Override
    public String toString(){
        return ("Deposit - Amount of: " + sum + "\n");
    }
};
