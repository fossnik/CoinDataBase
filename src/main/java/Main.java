import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.*;

/**
 * Important Documentation
 * https://coinexchangeio.github.io
 * https://github.com/google/gson
 */

public class Main {

	public static void main(String[] args) throws Exception
	{
//		URL url = new URL("https://www.coinexchange.io/api/v1/getmarkets");
//
//		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
//		conn.setRequestMethod("GET");
//
//		BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
//		StringBuilder result = new StringBuilder();
//
//		String line;
//		while ((line = rd.readLine()) != null)
//			result.append(line);
//
//		rd.close();

		String result = "{\"success\":\"1\",\"request\":\"\\/api\\/v1\\/getmarkets\",\"message\":\"\",\"result\":[{\"MarketID\":\"18\",\"MarketAssetName\":\"Litecoin\",\"MarketAssetCode\":\"LTC\",\"MarketAssetID\":\"2\",\"MarketAssetType\":\"currency\",\"BaseCurrency\":\"Bitcoin\",\"BaseCurrencyCode\":\"BTC\",\"BaseCurrencyID\":\"1\",\"Active\":true},{\"MarketID\":\"19\",\"MarketAssetName\":\"Unobtanium\",\"MarketAssetCode\":\"UNO\",\"MarketAssetID\":\"3\",\"MarketAssetType\":\"currency\",\"BaseCurrency\":\"Bitcoin\",\"BaseCurrencyCode\":\"BTC\",\"BaseCurrencyID\":\"1\",\"Active\":true},{\"MarketID\":\"20\",\"MarketAssetName\":\"Syscoin\",\"MarketAssetCode\":\"SYS\",\"MarketAssetID\":\"5\",\"MarketAssetType\":\"currency\",\"BaseCurrency\":\"Bitcoin\",\"BaseCurrencyCode\":\"BTC\",\"BaseCurrencyID\":\"1\",\"Active\":false},{\"MarketID\":\"21\",\"MarketAssetName\":\"Dogecoin\",\"MarketAssetCode\":\"DOGE\",\"MarketAssetID\":\"4\",\"MarketAssetType\":\"currency\",\"BaseCurrency\":\"Bitcoin\",\"BaseCurrencyCode\":\"BTC\",\"BaseCurrencyID\":\"1\",\"Active\":true},{\"MarketID\":\"22\",\"MarketAssetName\":\"Kobocoin\",\"MarketAssetCode\":\"KOBO\",\"MarketAssetID\":\"6\",\"MarketAssetType\":\"currency\",\"BaseCurrency\":\"Bitcoin\",\"BaseCurrencyCode\":\"BTC\",\"BaseCurrencyID\":\"1\",\"Active\":true},{\"MarketID\":\"23\",\"MarketAssetName\":\"Bitz\",\"MarketAssetCode\":\"BITZ\",\"MarketAssetID\":\"7\",\"MarketAssetType\":\"currency\",\"BaseCurrency\":\"Bitcoin\",\"BaseCurrencyCode\":\"BTC\",\"BaseCurrencyID\":\"1\",\"Active\":false},{\"MarketID\":\"24\",\"MarketAssetName\":\"Digitalcoin\",\"MarketAssetCode\":\"DGC\",\"MarketAssetID\":\"8\",\"MarketAssetType\":\"currency\",\"BaseCurrency\":\"Bitcoin\",\"BaseCurrencyCode\":\"BTC\",\"BaseCurrencyID\":\"1\",\"Active\":true},{\"MarketID\":\"25\",\"MarketAssetName\":\"Megacoin\",\"MarketAssetCode\":\"MEC\",\"MarketAssetID\":\"9\",\"MarketAssetType\":\"currency\",\"BaseCurrency\":\"Bitcoin\",\"BaseCurrencyCode\":\"BTC\",\"BaseCurrencyID\":\"1\",\"Active\":true},{\"MarketID\":\"26\",\"MarketAssetName\":\"Bigup\",\"MarketAssetCode\":\"BIGUP\",\"MarketAssetID\":\"10\",\"MarketAssetType\":\"currency\",\"BaseCurrency\":\"Bitcoin\",\"BaseCurrencyCode\":\"BTC\",\"BaseCurrencyID\":\"1\",\"Active\":true},{\"MarketID\":\"27\",\"MarketAssetName\":\"Memetic\",\"MarketAssetCode\":\"MEME\",\"MarketAssetID\":\"11\",\"MarketAssetType\":\"currency\",\"BaseCurrency\":\"Bitcoin\",\"BaseCurrencyCode\":\"BTC\",\"BaseCurrencyID\":\"1\",\"Active\":true},{\"MarketID\":\"28\",\"MarketAssetName\":\"Lootcoin\",\"MarketAssetCode\":\"LOOT\",\"MarketAssetID\":\"12\",\"MarketAssetType\":\"currency\",\"BaseCurrency\":\"Bitcoin\",\"BaseCurrencyCode\":\"BTC\",\"BaseCurrencyID\":\"1\",\"Active\":false},{\"MarketID\":\"29\",\"MarketAssetName\":\"FootyCash\",\"MarketAssetCode\":\"FOOT\",\"MarketAssetID\":\"13\",\"MarketAssetType\":\"currency\",\"BaseCurrency\":\"Bitcoin\",\"BaseCurrencyCode\":\"BTC\",\"BaseCurrencyID\":\"1\",\"Active\":false},{\"MarketID\":\"30\",\"MarketAssetName\":\"Procom\",\"MarketAssetCode\":\"PCM\",\"MarketAssetID\":\"14\",\"MarketAssetType\":\"currency\",\"BaseCurrency\":\"Bitcoin\",\"BaseCurrencyCode\":\"BTC\",\"BaseCurrencyID\":\"1\",\"Active\":false},{\"MarketID\":\"31\",\"MarketAssetName\":\"CzechoSlovak KORUNA\",\"MarketAssetCode\":\"KORUNA\",\"MarketAssetID\":\"15\",\"MarketAssetType\":\"currency\",\"BaseCurrency\":\"Bitcoin\",\"BaseCurrencyCode\":\"BTC\",\"BaseCurrencyID\":\"1\",\"Active\":true},{\"MarketID\":\"32\",\"MarketAssetName\":\"Revenu\",\"MarketAssetCode\":\"REV\",\"MarketAssetID\":\"16\",\"MarketAssetType\":\"currency\",\"BaseCurrency\":\"Bitcoin\",\"BaseCurrencyCode\":\"BTC\",\"BaseCurrencyID\":\"1\",\"Active\":false},{\"MarketID\":\"33\",\"MarketAssetName\":\"DOLLARCoin\",\"MarketAssetCode\":\"DOLLAR\",\"MarketAssetID\":\"17\",\"MarketAssetType\":\"currency\",\"BaseCurrency\":\"Bitcoin\",\"BaseCurrencyCode\":\"BTC\",\"BaseCurrencyID\":\"1\",\"Active\":false},{\"MarketID\":\"34\",\"MarketAssetName\":\"XxXCoin\",\"MarketAssetCode\":\"XXX\",\"MarketAssetID\":\"18\",\"MarketAssetType\":\"currency\",\"BaseCurrency\":\"Bitcoin\",\"BaseCurrencyCode\":\"BTC\",\"BaseCurrencyID\":\"1\",\"Active\":true},{\"MarketID\":\"35\",\"MarketAssetName\":\"DubaiCoin\",\"MarketAssetCode\":\"DBIC\",\"MarketAssetID\":\"19\",\"MarketAssetType\":\"currency\",\"BaseCurrency\":\"Bitcoin\",\"BaseCurrencyCode\":\"BTC\",\"BaseCurrencyID\":\"1\",\"Active\":true},{\"MarketID\":\"36\",\"MarketAssetName\":\"AntiLiteCoin\",\"MarketAssetCode\":\"ALTC\",\"MarketAssetID\":\"20\",\"MarketAssetType\":\"currency\",\"BaseCurrency\":\"Bitcoin\",\"BaseCurrencyCode\":\"BTC\",\"BaseCurrencyID\":\"1\",\"Active\":false},{\"MarketID\":\"37\",\"MarketAssetName\":\"Yocoin\",\"MarketAssetCode\":\"YOC\",\"MarketAssetID\":\"21\",\"MarketAssetType\":\"currency\",\"BaseCurrency\":\"Bitcoin\",\"BaseCurrencyCode\":\"BTC\",\"BaseCurrencyID\":\"1\",\"Active\":false}]}\n";
		result = result.substring(result.indexOf("[{"),result.indexOf("]}")+1);

		Gson gson = new Gson();

		GetMarketResult[] getMarketResults = gson.fromJson(result, GetMarketResult[].class);

		System.out.println(gson.toJson(getMarketResults));

	}
}