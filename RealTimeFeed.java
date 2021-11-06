import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class RealTimeFeed {
    private Map<String, Double> keyValues;
    private String filePath;

	double pricePerShare;
    int numSharesAtPurchasePrice;
	String name;
    String stockTicker;
     //made so Value class isn't static because static is stupid and makes things complicated

    //Initializes Crypto information
    RealTimeFeed(String n, String st){
        name = n;
        stockTicker = st;
    }
    

    //Prints Crypto informatoin
    @Override
    public String toString(){
        return "Name: " + name + ", Stock Ticker: " + stockTicker + ", Purchase Price: " + pricePerShare +
        ", # of Shares at Purchase Price: " + numSharesAtPurchasePrice;
    }

    

    public RealTimeFeed(String filePath) {
		
        setFilePath(filePath);
        keyValues = new HashMap<String, Double>();
        readFile();
    }
	
    public void readFile() {
        File file = new File(filePath);
        Scanner sc;
        try {
            sc = new Scanner(file);
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                int spacePosition = line.indexOf(" ");
                String name = line.substring(0, spacePosition);
                String value = line.substring(spacePosition + 1, line.length());
                keyValues.put(name, Double.parseDouble(value));
            }
            sc.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
	
	double FindCryptoPrice(String ts, int numShares){
        return numShares * getCurrentValue(ts);
    }

    public double getCurrentValue(String symbolName) {
        return keyValues.get(symbolName);
    }

    public Map<String, Double> getKeyValues() {
        return keyValues;
    }

    public void setKeyValues(Map<String, Double> keyValues) {
        this.keyValues = keyValues;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }
	
	

}