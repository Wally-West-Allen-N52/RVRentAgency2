package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import factory.ConnectionFactory;
import models.ContactUs;
import models.Destination;
import models.Home;
import models.Promotion;

public class HomeDao {

	public void save(Home home) {

		String sql = "INSERT INTO Home (ClientName, fkDestinationID, fkPromotionID, fkContactID) VALUES (?, ?, ?, ?)";

		Connection conn = null;
		PreparedStatement pstm = null;

		try {
			conn = ConnectionFactory.createConnectionSQLServer();
			pstm = conn.prepareStatement(sql);

			pstm.setString(1, home.getClientName());
			pstm.setInt(2, home.getDestinationID());
			pstm.setInt(3, home.getPromotionID());
			pstm.setInt(4, home.getContactID());

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
	
	public void removeById(int HomeID) {
		String sql = "DELETE FROM Home WHERE HomeID = ?";

		Connection conn = null;
		PreparedStatement pstm = null;

		try {
			conn = ConnectionFactory.createConnectionSQLServer();
			pstm = conn.prepareStatement(sql);

			pstm.setInt(1, HomeID);

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
	
	public void update(Home home) {
		String sql = "UPDATE Home SET ClientName = ? WHERE HomeID = ?";

		Connection conn = null;
		PreparedStatement pstm = null;

		try {
			// Create a DB connection
			conn = ConnectionFactory.createConnectionSQLServer();
			// Class used to execute the query
			pstm = conn.prepareStatement(sql);
			
			// Add value at the first parameter
			pstm.setString(1, home.getClientName());
			// Add value at the second parameter
			pstm.setInt(2, home.getHomeID());
		
		
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
	
	public List<Home> getHomes() {
		
		String sql = "select h.HomeID, h.ClientName, \r\n"
				+ "d.DestinationID, d.TakeHere, d.DeliverThere,\r\n"
				+ "p.PromotionID, p.Promotion, p.Price,\r\n"
				+ "c.ContactID, c.Email, c.Phone, c.NewMessage\r\n"
				+ "from Home as h\r\n"
				+ "inner join Destination as d on h.fkDestinationID = d.DestinationID\r\n"
				+ "inner join Promotion as p on h.fkPromotionID = p.PromotionID\r\n"
				+ "inner join ContactUs as c on h.fkContactID = c.ContactID";
		
		List<Home> homes = new ArrayList<Home>();

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
				Home home = new Home();
				Destination destination = new Destination();
				Promotion promotion = new Promotion();
				ContactUs contactUs = new ContactUs();
				
				// ========================= Home table ========================
				// get data from DB and put it on the list
				home.setHomeID(rset.getInt("HomeID"));
				home.setClientName(rset.getString("ClientName"));
				
				// ========================= Destination Table =======================
				destination.setDestinationID(rset.getInt("DestinationID"));
				destination.setTakeHere(rset.getString("TakeHere"));
				destination.setDeliverThere(rset.getString("DeliverThere"));
				
				// ========================= Promotion table =========================
				promotion.setPromotionID(rset.getInt("PromotionID"));
				promotion.setPromotion(rset.getString("Promotion"));
				promotion.setPrice(rset.getFloat("Price"));
				
				// ========================= ContactUs table =========================
				contactUs.setContactID(rset.getInt("ContactID"));
				contactUs.setEmail(rset.getString("Email"));
				contactUs.setPhone(rset.getString("Phone"));
				contactUs.setNewMessage(rset.getString("NewMessage"));
				
				home.setDestination(destination);
				home.setPromotion(promotion);
				home.setContact(contactUs);
				
				homes.add(home);
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
		return homes;
	}
}
