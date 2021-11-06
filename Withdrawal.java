public class Withdrawal extends Transaction{

    //Initializes Transaction information
    Withdrawal(double s){
        this.balance -= s;
        this.sum = s;
        this.type = "Withdrawal";
    }

    //Prints values of Withdrawal
    @Override
    public String toString(){
        return ("Withdrawal - Amount of: " + sum + "\n");
    }
};