public class GetMarketResult {
	private int MarketID;
	private String MarketAssetName;
	private String MarketAssetCode;
	private int MarketAssetID;
	private String MarketAssetType;
	private String BaseCurrency;
	private String BaseCurrencyCode;
	private int BaseCurrencyID;
	private boolean Active;

	public GetMarketResult(int marketID, String marketAssetName, String marketAssetCode, int marketAssetID, String marketAssetType, String baseCurrency, String baseCurrencyCode, int baseCurrencyID, boolean active) {
		MarketID = marketID;
		MarketAssetName = marketAssetName;
		MarketAssetCode = marketAssetCode;
		MarketAssetID = marketAssetID;
		MarketAssetType = marketAssetType;
		BaseCurrency = baseCurrency;
		BaseCurrencyCode = baseCurrencyCode;
		BaseCurrencyID = baseCurrencyID;
		Active = active;
	}
}
