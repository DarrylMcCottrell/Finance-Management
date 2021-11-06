import java.util.ArrayList;
import java.lang.StringBuilder;

public class Equity extends Account {
    ArrayList<RealTimeFeed> Cryptos = new ArrayList<RealTimeFeed>();
    int totalValue;


    //Initializes basic account information
    Equity(String fn, String ln, String ma, int an){
        this.setFirstName(fn);
        this.setLastName(ln);
        this.setMailingAdress(ma);
        this.setAccountNum(an);
    }

    //Writes Equity Account information to HTML
    @Override
    String GenerateHTML() {
        StringBuilder b = new StringBuilder();

        b.append(super.GenerateHTML());

        for(RealTimeFeed s : Cryptos){
            b.append("<p> " + s.toString() + " \n </p>");
        }

        b.append("<p> Total Value of Equity Account: " + totalValue + "\n </p>");

        return b.toString();   
    }

    /*
    Changes Equity information based off Crypto price
    read in from Cryptos.txt in RealTimeFeed class and 
    adds to Cryptos (transactions) list
    */
    @Override
    void buyCrypto(String n, String ts, int ns){
       RealTimeFeed s = new RealTimeFeed(n, ts);
        s.pricePerShare = s.FindCryptoPrice(ts, 1);
        s.numSharesAtPurchasePrice = ns;
        totalValue += s.FindCryptoPrice(ts, ns);
        Cryptos.add(s);
    }

    //returns Equity balance
    @Override
    double getValue(){
        return totalValue;
    }
};