class GetMarketResult {
	private int MarketID;
	private String MarketAssetName;
	private String MarketAssetCode;
	private int MarketAssetID;
	private String MarketAssetType;
	private String BaseCurrency;
	private String BaseCurrencyCode;
	private int BaseCurrencyID;
	private boolean Active;

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
