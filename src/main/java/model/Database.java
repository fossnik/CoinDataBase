package model;

import java.sql.*;

public class Database {

	private static String CONNECTION_STRING = null;

	private static final String TABLE_GETMARKETS = "getmarkets";
	private static final String COLUMN_GETMARKETS_ID = "_id";
	private static final String COLUMN_GETMARKETS_TIME = "time";
	private static final String COLUMN_GETMARKETS_MARKETASSETNAME = "MarketID";
	private static final String COLUMN_GETMARKETS_MARKETASSETCODE = "MarketAssetCode";
	private static final String COLUMN_GETMARKETS_MARKETASSETID = "MarketAssetID";
	private static final String COLUMN_GETMARKETS_MARKETASSETTYPE = "MarketAssetType";
	private static final String COLUMN_GETMARKETS_BASECURRENCY = "BaseCurrency";
	private static final String COLUMN_GETMARKETS_BASECURRENCYCODE = "BaseCurrencyCode";
	private static final String COLUMN_GETMARKETS_BASECURRENCYID = "BaseCurrencyID";
	private static final String COLUMN_GETMARKETS_ACTIVE = "Active";

	private static final String TABLE_GETMARKETSUMMARIES = "getMarketSummaries";
	private static final String COLUMN_GETMARKETSUMMARIES_ID = "_id";
	private static final String COLUMN_GETMARKETSUMMARIES_TIME = "time";
	private static final String COLUMN_GETMARKETSUMMARIES_MARKETID = "MarketID";
	private static final String COLUMN_GETMARKETSUMMARIES_LASTPRICE = "LastPrice";
	private static final String COLUMN_GETMARKETSUMMARIES_CHANGE = "Change";
	private static final String COLUMN_GETMARKETSUMMARIES_HighPrice = "HighPrice";
	private static final String COLUMN_GETMARKETSUMMARIES_LowPrice = "Volume";
	private static final String COLUMN_GETMARKETSUMMARIES_BTCVOLUME = "BtcVolume";
	private static final String COLUMN_GETMARKETSUMMARIES_TRADECOUNT = "BidPrice";
	private static final String COLUMN_GETMARKETSUMMARIES_ASKPRICE = "AskPrice";
	private static final String COLUMN_GETMARKETSUMMARIES_BUYORDERCOUNT = "BuyOrderCount";
	private static final String COLUMN_GETMARKETSUMMARIES_SELLORDERCOUNT = "SellOrderCount";

	private static final String CREATE_GETMARKETS_TABLE = "";
	private static final String CREATE_GETMARKETSUMMARIES_TABLE = "";

	private static final String APPEND_GETMARKETS = "INSERT INTO " + TABLE_GETMARKETS;
	private static final String APPEND_GETMARKETSUMMARIES = "INSERT INTO " + TABLE_GETMARKETSUMMARIES;

	private Connection conn;

	public Database(String path) {
		String DB_PATH = path;
		CONNECTION_STRING = "jdbc:sqlite:" + DB_PATH;
	}

	public boolean open() {
		try {
			conn = DriverManager.getConnection(CONNECTION_STRING);
			return true;
		} catch(SQLException e) {
			System.out.println("Couldn't connect to database: " + e.getMessage());
			return false;
		}
	}

	public boolean createDataBase() {
		try (Statement statement = conn.createStatement()) {
			statement.execute(CREATE_GETMARKETS_TABLE);
			statement.execute(CREATE_GETMARKETSUMMARIES_TABLE);
			return true;
		} catch (SQLException e) {
			System.out.println("Create Table Failed: " + e.getMessage());
			return false;
		}
	}

	public boolean appendGetMarkets(GetMarkets[] getMarkets) {
		try (Statement statement = conn.createStatement()) {
			for (GetMarkets g : getMarkets)
				statement.execute(APPEND_GETMARKETS);
			return true;
		} catch (SQLException e) {
			System.out.println("Create Table Failed: " + e.getMessage());
			return false;
		}
	}

	public boolean appendGetMarketSummaries(GetMarketSummaries[] getMarketSummaries) {
		try (Statement statement = conn.createStatement()) {
			for (GetMarketSummaries g : getMarketSummaries)
				statement.execute(APPEND_GETMARKETSUMMARIES);
			return true;
		} catch (SQLException e) {
			System.out.println("Create Table Failed: " + e.getMessage());
			return false;
		}
	}

	public void close() {
		try {
			if(conn != null) {
				conn.close();
			}
		} catch(SQLException e) {
			System.out.println("Couldn't close connection: " + e.getMessage());
		}
	}

}