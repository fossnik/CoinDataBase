import com.google.gson.Gson;
import model.Database;
import model.GetMarketSummaries;
import model.GetMarkets;

/**
 * Important Documentation
 * https://coinexchangeio.github.io/slate
 * https://github.com/google/gson
 */

public class Main {

	public static void main(String[] args) throws Exception {

		Database d = new Database("/home/seth/IdeaProjects/finTech/CoinExchange-logger/ce.db");

		System.out.println("Attempting to Open Existing Database...");
		if (! d.open()) {
			System.out.println("No Existing Database - Creating");
			d.createDataBase();
		}

		String apiReturn = GetMarkets.queryEndpoint();
		GetMarkets[] getMarkets = new Gson().fromJson(apiReturn, GetMarkets[].class);

		System.out.println("Demonstrating model.GetMarkets endpoint deserialization.");
		for (GetMarkets g : getMarkets)
			System.out.println(g.getMarketAssetName());

		System.out.println("Attempting to insert getMarkets API Result into Database");
		d.appendGetMarkets(getMarkets);


		apiReturn = GetMarketSummaries.queryEndpoint();
		GetMarketSummaries[] getMarketSummaries = new Gson().fromJson(apiReturn, GetMarketSummaries[].class);

		System.out.println("\n\nDemonstrating model.GetMarketSummaries endpoint deserialization.");
		for (GetMarketSummaries g : getMarketSummaries)
			System.out.println("mID: " + g.getMarketID() + "\t" + "Volume: " + g.getVolume());

		System.out.println("Attempting to insert getMarketSummaries API Result into Database");
		d.appendGetMarketSummaries(getMarketSummaries);
	}
}