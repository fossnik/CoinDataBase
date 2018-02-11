import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class GetMarketSummaries {
	private int MarketID;
	private double LastPrice;
	private double Change;
	private double HighPrice;
	private double LowPrice;
	private double Volume;
	private double BTCVolume;
	private int TradeCount;
	private double BidPrice;
	private double AskPrice;
	private int BuyOrderCount;
	private int SellOrderCount;

	public static String queryEndpoint() throws Exception {

		URL url = new URL("https://www.coinexchange.io/api/v1/getmarketsummaries");

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

	public int getMarketID() {
		return MarketID;
	}

	public double getLastPrice() {
		return LastPrice;
	}

	public double getChange() {
		return Change;
	}

	public double getHighPrice() {
		return HighPrice;
	}

	public double getLowPrice() {
		return LowPrice;
	}

	public double getVolume() {
		return Volume;
	}

	public double getBTCVolume() {
		return BTCVolume;
	}

	public int getTradeCount() {
		return TradeCount;
	}

	public double getBidPrice() {
		return BidPrice;
	}

	public double getAskPrice() {
		return AskPrice;
	}

	public int getBuyOrderCount() {
		return BuyOrderCount;
	}

	public int getSellOrderCount() {
		return SellOrderCount;
	}
}
