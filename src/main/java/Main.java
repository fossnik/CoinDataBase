import com.google.gson.Gson;
import model.GetMarketSummaries;
import model.GetMarkets;

/**
 * Important Documentation
 * https://coinexchangeio.github.io/slate
 * https://github.com/google/gson
 */

public class Main {

	public static void main(String[] args) throws Exception {

		String apiReturn = GetMarkets.queryEndpoint();
		GetMarkets[] getMarkets = new Gson().fromJson(apiReturn, GetMarkets[].class);

		System.out.println("Demonstrating model.GetMarkets endpoint deserialization.");
		for (GetMarkets g : getMarkets)
			System.out.println(g.getMarketAssetName());


		apiReturn = GetMarketSummaries.queryEndpoint();
		GetMarketSummaries[] getMarketSummaries = new Gson().fromJson(apiReturn, GetMarketSummaries[].class);

		System.out.println("\n\nDemonstrating model.GetMarketSummaries endpoint deserialization.");
		for (GetMarketSummaries g : getMarketSummaries)
			System.out.println("mID: " + g.getMarketID() + "\t" + "Volume: " + g.getVolume());
	}
}