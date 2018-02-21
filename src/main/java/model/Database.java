package model;

import java.sql.*;

public class Database {

	private static String DB_PATH = null;
	private static String CONNECTION_STRING = null;

	public static final String TABLE_GETMARKETS = "getmarkets";
	public static final String COLUMN_GETMARKETS_ID = "_id";
	public static final String COLUMN_GETMARKETS_TIME = "time";
	public static final String COLUMN_GETMARKETS_MARKETASSETNAME = "MarketID";
	public static final String COLUMN_GETMARKETS_MARKETASSETCODE = "MarketAssetCode";
	public static final String COLUMN_GETMARKETS_MARKETASSETID = "MarketAssetID";
	public static final String COLUMN_GETMARKETS_MARKETASSETTYPE = "MarketAssetType";
	public static final String COLUMN_GETMARKETS_BASECURRENCY = "BaseCurrency";
	public static final String COLUMN_GETMARKETS_BASECURRENCYCODE = "BaseCurrencyCode";
	public static final String COLUMN_GETMARKETS_BASECURRENCYID = "BaseCurrencyID";
	public static final String COLUMN_GETMARKETS_ACTIVE = "Active";

	public static final String TABLE_GETMARKETSUMMARIES = "getMarketSummaries";
	public static final String COLUMN_GETMARKETSUMMARIES_ID = "_id";
	public static final String COLUMN_GETMARKETSUMMARIES_TIME = "time";
	public static final String COLUMN_GETMARKETSUMMARIES_MARKETID = "MarketID";
	public static final String COLUMN_GETMARKETSUMMARIES_LASTPRICE = "LastPrice";
	public static final String COLUMN_GETMARKETSUMMARIES_CHANGE = "Change";
	public static final String COLUMN_GETMARKETSUMMARIES_HighPrice = "HighPrice";
	public static final String COLUMN_GETMARKETSUMMARIES_LowPrice = "Volume";
	public static final String COLUMN_GETMARKETSUMMARIES_BTCVOLUME = "BtcVolume";
	public static final String COLUMN_GETMARKETSUMMARIES_TRADECOUNT = "BidPrice";
	public static final String COLUMN_GETMARKETSUMMARIES_ASKPRICE = "AskPrice";
	public static final String COLUMN_GETMARKETSUMMARIES_BUYORDERCOUNT = "BuyOrderCount";
	public static final String COLUMN_GETMARKETSUMMARIES_SELLORDERCOUNT = "SellOrderCount";

	public static final String CREATE_GETMARKETS_TABLE = "";
	public static final String CREATE_GETMARKETSUMMARIES_TABLE = "";

	public static final String APPEND_GETMARKETS = "INSERT INTO " + TABLE_GETMARKETS;
	public static final String APPEND_GETMARKETSUMMARIES = "INSERT INTO " + TABLE_GETMARKETSUMMARIES;

	private Connection conn;

	public Database(String path) {
		DB_PATH = path;
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