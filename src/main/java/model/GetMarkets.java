package model;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Date;

public class GetMarkets {
	private Date time = new Date();
	private int MarketID;
	private String MarketAssetName;
	private String MarketAssetCode;
	private int MarketAssetID;
	private String MarketAssetType;
	private String BaseCurrency;
	private String BaseCurrencyCode;
	private int BaseCurrencyID;
	private boolean Active;

	public static String queryEndpoint() throws Exception {

		URL url = new URL("https://www.coinexchange.io/api/v1/getmarkets");

		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod("GET");

		BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
		StringBuilder result = new StringBuilder();

		String line;
		while ((line = rd.readLine()) != null)
			result.append(line);

		rd.close();

		return result.substring(result.indexOf("[{"),result.indexOf("]}")+1);
	}

	public Date getTime() {
		return time;
	}

	public int getMarketID() {
		return MarketID;
	}

	public String getMarketAssetName() {
		return MarketAssetName;
	}

	public String getMarketAssetCode() {
		return MarketAssetCode;
	}

	public int getMarketAssetID() {
		return MarketAssetID;
	}

	public String getMarketAssetType() {
		return MarketAssetType;
	}

	public String getBaseCurrency() {
		return BaseCurrency;
	}

	public String getBaseCurrencyCode() {
		return BaseCurrencyCode;
	}

	public int getBaseCurrencyID() {
		return BaseCurrencyID;
	}

	public boolean isActive() {
		return Active;
	}
}
