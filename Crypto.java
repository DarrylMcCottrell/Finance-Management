public class Crypto{
    
    double pricePerShare;
    int numSharesAtPurchasePrice;
	String name;
    String stockTicker;
     //made so Value class isn't static because static is stupid and makes things complicated

    //Initializes Crypto information
    Crypto(String n, String st){
        name = n;
        stockTicker = st;
    }

    //Retrieves current value of Crypto based off number of Crypto shares given
    

    //Prints Crypto informatoin
    @Override
    public String toString(){
        return "Name: " + name + ", Stock Ticker: " + stockTicker + ", Purchase Price: " + pricePerShare +
        ", # of Shares at Purchase Price: " + numSharesAtPurchasePrice;
    }

    
    
};