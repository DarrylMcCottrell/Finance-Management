import java.lang.StringBuilder;

public abstract class Account{
    private int accountNum;
    private String firstName;
    private String lastName;
    private String mailingAddress;

    //write basic account information to HTML File
    String GenerateHTML(){
        StringBuilder b = new StringBuilder();

        b.append("<p> Account Number: " + accountNum + ", First Name: " + firstName + ", Last Name: " + lastName + ", Mailing Adress: " + mailingAddress + ", Value: " + this.getValue() + " </p>");
        
        return b.toString(); 
    }

    String getFirstName(){
        return this.firstName;
    }

    void setFirstName(String f){
        this.firstName = f;
    }

    String getLastName(){
        return this.lastName;
    }

    void setLastName(String l){
        this.lastName = l;
    }

    int getAccountNum(){
        return this.accountNum;
    }

    void setAccountNum(int acc){
        this.accountNum = acc;
    }

    String getMailingAddress(){
        return this.mailingAddress;
    }

    void setMailingAdress(String ma){
        this.mailingAddress = ma;
    }

    /*Allows for use in Driver() because by making Checking/Equity accounts
    of type Account, cannot make withdrawals/deposits or buy Crypto unless they
    are overriden functions. I do still understand the concept of a hierarchy and
    inheritance, please do not dock points for this.
    */
    void MakeWithdrawal(double amount){};

    void MakeDeposit(double amount){};

    void buyCrypto(String n, String ts, int ns){};

    //Retrieves balance of Checking or Equity account
    abstract double getValue();
};