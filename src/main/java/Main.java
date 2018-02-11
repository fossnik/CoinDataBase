import com.google.gson.Gson;

/**
 * Important Documentation
 * https://coinexchangeio.github.io
 * https://github.com/google/gson
 */

public class Main {

	public static void main(String[] args) throws Exception {

		String apiReturn = GetMarkets.queryEndpoint();

		GetMarkets[] getMarketsResults = new Gson().fromJson(apiReturn, GetMarkets[].class);

		for (GetMarkets g : getMarketsResults)
			System.out.println(g.getMarketAssetName());
	}
}