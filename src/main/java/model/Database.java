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

//	private static final String TABLE_GETMARKETSUMMARIES = "getMarketSummaries";
//	private static final String COLUMN_GETMARKETSUMMARIES_ID = "_id";
//	private static final String COLUMN_GETMARKETSUMMARIES_TIME = "time";
//	private static final String COLUMN_GETMARKETSUMMARIES_MARKETID = "MarketID";
//	private static final String COLUMN_GETMARKETSUMMARIES_LASTPRICE = "LastPrice";
//	private static final String COLUMN_GETMARKETSUMMARIES_CHANGE = "Change";
//	private static final String COLUMN_GETMARKETSUMMARIES_HighPrice = "HighPrice";
//	private static final String COLUMN_GETMARKETSUMMARIES_LowPrice = "Volume";
//	private static final String COLUMN_GETMARKETSUMMARIES_BTCVOLUME = "BtcVolume";
//	private static final String COLUMN_GETMARKETSUMMARIES_TRADECOUNT = "BidPrice";
//	private static final String COLUMN_GETMARKETSUMMARIES_ASKPRICE = "AskPrice";
//	private static final String COLUMN_GETMARKETSUMMARIES_BUYORDERCOUNT = "BuyOrderCount";
//	private static final String COLUMN_GETMARKETSUMMARIES_SELLORDERCOUNT = "SellOrderCount";

	private static final String CREATE_GETMARKETS_TABLE =
			"CREATE TABLE " + TABLE_GETMARKETS + '(' +
					COLUMN_GETMARKETS_ID + " int," +
					COLUMN_GETMARKETS_TIME + "String, " +
					COLUMN_GETMARKETS_MARKETASSETNAME + "String, " +
					COLUMN_GETMARKETS_MARKETASSETCODE + "String, " +
					COLUMN_GETMARKETS_MARKETASSETID + " int," +
					COLUMN_GETMARKETS_MARKETASSETTYPE + "String, " +
					COLUMN_GETMARKETS_BASECURRENCY + "String, " +
					COLUMN_GETMARKETS_BASECURRENCYCODE + "String, " +
					COLUMN_GETMARKETS_BASECURRENCYID + " int," +
					COLUMN_GETMARKETS_ACTIVE + " boolean" +
					");";

//	private static final String CREATE_GETMARKETSUMMARIES_TABLE = "";

	private Connection conn;

	public Database(String DB_PATH) {
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
			for (GetMarkets g : getMarkets) {
				String append = "INSERT INTO " + TABLE_GETMARKETS;

				append += '(' +
						COLUMN_GETMARKETS_ID + ',' +
						COLUMN_GETMARKETS_TIME + ',' +
						COLUMN_GETMARKETS_MARKETASSETNAME + ',' +
						COLUMN_GETMARKETS_MARKETASSETCODE + ',' +
						COLUMN_GETMARKETS_MARKETASSETID + ',' +
						COLUMN_GETMARKETS_MARKETASSETTYPE + ',' +
						COLUMN_GETMARKETS_BASECURRENCY + ',' +
						COLUMN_GETMARKETS_BASECURRENCYCODE + ',' +
						COLUMN_GETMARKETS_BASECURRENCYID + ',' +
						COLUMN_GETMARKETS_ACTIVE +
				')';

				append += " VALUES(" +
						g.getMarketID() + ',' +
						g.getTime() + ',' +
						g.getMarketAssetName() + ',' +
						g.getMarketAssetCode() + ',' +
						g.getMarketAssetID() + ',' +
						g.getMarketAssetType() + ',' +
						g.getBaseCurrency() + ',' +
						g.getBaseCurrencyCode() + ',' +
						g.getBaseCurrencyID() + ',' +
						g.isActive() +
				");";

				statement.execute(append);
			}
			return true;
		} catch (SQLException e) {
			System.out.println("Insert data Failed: " + e.getMessage());
			return false;
		}
	}

	public boolean appendGetMarketSummaries(GetMarketSummaries[] getMarketSummaries) {
		throw new UnsupportedOperationException("Not Yet Implemented");
//		try (Statement statement = conn.createStatement()) {
//			for (GetMarketSummaries g : getMarketSummaries)
//				statement.execute(APPEND_GETMARKETSUMMARIES);
//			return true;
//		} catch (SQLException e) {
//			System.out.println("Create Table Failed: " + e.getMessage());
//			return false;
//		}
	}

	public void close() {
		try {
			if(conn != null)
				conn.close();
		} catch(SQLException e) {
			System.out.println("Couldn't close connection: " + e.getMessage());
		}
	}

}