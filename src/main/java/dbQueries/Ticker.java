package dbQueries;

public class Ticker {

	int MarketAssetID;
	int MarketAssetCode;
	double LastPrice;

	public List<Artist> queryArtists() {
		Statement statement = null;
		ResultSet results = null;

		try {
			statement = conn.createStatement();
			results = statement.executeQuery("SELECT * FROM" + TABLE_ALBUMS);

			List<Artist> artists = new ArrayList<>();
			while(results.next()) {
				Artist artist = new Artist();
			}
		} catch(SQLException e) {
			System.out.println("Query failed\n" + e.getMessage());
		} finally {
			try {
				if (statement != null)
					statement.close();
			} catch (SQLException e) {

			}
		}
	}
}
