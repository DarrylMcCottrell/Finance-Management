import java.util.List;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.*;

// In the driver file I am doing a test creating a list of accounts the main problem I'm having is the buying crypto function
//not really working i'm not sure if it's manually due to trying to buy the crypto or because it's due to the buyCrypto function itself,
//specifically the pricepershare portion.
public class Driver {

	public static void main(String[] args) {
		List<Account> l = new ArrayList<Account>();

		Account a1 = new Checking("Darryl", "McCottrell", "1717 Birch Road, Kenosha, WI 53140", 1, 1230.00);
		Account a2 = new Equity("Linda", "Johnson", "710 Olson Street, Woodstock, IL 60098", 2);
		Account a3 = new Checking("Preston", "Bell", "967 Gulf Course Road, Crystal Lake, IL 60102", 3, 199.72);

		a1.MakeDeposit(178.32);
		//a2.buyCrypto("DogeCoin", "Doge", 460);
		a3.MakeWithdrawal(23.25);

		l.add(a1);
		l.add(a2);
		l.add(a3);

		Collections.sort(l, Driver.CompareBalance);

		Driver d = new Driver();

		d.generateReport(l);
	}

// Creates file and writes account information to file
	void generateReport(List<Account> a) {
		Report r = new Report();
		r.GenerateFile();
		r.WriteToFile(a);
	}

	// Compares balances of accounts
	public static Comparator<Account> CompareBalance = new Comparator<Account>() {
		@Override
		public int compare(Account a1, Account a2) {
			int retVal = 0;

			if (a1.getValue() < a2.getValue()) {
				retVal = -1;
			} else if (a1.getValue() > a2.getValue()) {
					retVal = 1;
			}

			return retVal;
		}
	};
};