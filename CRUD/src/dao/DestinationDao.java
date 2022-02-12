package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import factory.ConnectionFactory;
import models.Destination;

public class DestinationDao {

	public void save(Destination destination) {

		String sql = "INSERT INTO Destination (TakeHere, DeliverThere) VALUES (?, ?)";

		Connection conn = null;
		PreparedStatement pstm = null;

		try {
			conn = ConnectionFactory.createConnectionSQLServer();
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, destination.getTakeHere());
			pstm.setString(2, destination.getDeliverThere());

			pstm.execute();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstm != null) {
					pstm.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void removeById(int DestinationID) {
		String sql = "DELETE FROM Destination WHERE DestinationID = ?";

		Connection conn = null;
		PreparedStatement pstm = null;

		try {
			conn = ConnectionFactory.createConnectionSQLServer();
			pstm = conn.prepareStatement(sql);

			pstm.setInt(1, DestinationID);

			pstm.execute();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstm != null) {
					pstm.close();
				}
				if (conn != null) {
					conn.close();
				}

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void update(Destination destination) {
		String sql = "UPDATE Destination SET TakeHere = ?, DeliverThere = ? WHERE DestinationID = ?";

		Connection conn = null;
		PreparedStatement pstm = null;

		try {
			// Create a DB connection
			conn = ConnectionFactory.createConnectionSQLServer();
			// Class used to execute the query
			pstm = conn.prepareStatement(sql);
			// Add value at the first parameter
			pstm.setString(1, destination.getTakeHere());
			// Add value at the second parameter
			pstm.setString(2, destination.getDeliverThere());
			// Add value at the third parameter
			pstm.setInt(3, destination.getDestinationID());
			// Execute the SQL to insert data
			pstm.execute();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// Close the connections
			try {
				if (conn != null) {
					conn.close();
				}

				if (pstm != null) {
					pstm.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
public List<Destination> getDestinations() {
		
		String sql = "select * from Destination";
		
		List<Destination> destinations = new ArrayList<Destination>();

		Connection conn = null;
		PreparedStatement pstm = null;

		// This get data in the DB
		ResultSet rset = null;

		try {
			conn = ConnectionFactory.createConnectionSQLServer();
			pstm = conn.prepareStatement(sql);
			rset = pstm.executeQuery();

			// While you have in DB do
			while (rset.next()) {
				Destination destination = new Destination();	
				
				// ========================= Destination Table =======================
				destination.setDestinationID(rset.getInt("DestinationID"));
				destination.setTakeHere(rset.getString("TakeHere"));
				destination.setDeliverThere(rset.getString("DeliverThere"));
				
				destinations.add(destination);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {

				if (conn != null) {
					conn.close();
				}
				if (pstm != null) {
					pstm.close();
				}
				if (rset != null) {
					rset.close();
				}

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return destinations;
	}
}
