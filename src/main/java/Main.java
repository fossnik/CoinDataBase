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
		URL url = new URL("https://www.coinexchange.io/api/v1/getmarkets");

		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod("GET");

		BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
		StringBuilder result = new StringBuilder();

		String line;
		while ((line = rd.readLine()) != null)
			result.append(line);

		rd.close();

		String chopped = result.substring(result.indexOf("[{"),result.indexOf("]}")+1);

		Gson gson = new Gson();

		GetMarketResult[] getMarketResults = gson.fromJson(chopped, GetMarketResult[].class);

		for (GetMarketResult g : getMarketResults)
			System.out.println(g.getMarketAssetName());
	}
}