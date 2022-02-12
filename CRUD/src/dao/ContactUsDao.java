package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import factory.ConnectionFactory;
import models.ContactUs;

public class ContactUsDao {

	public void save(ContactUs contactUs) {

		String sql = "INSERT INTO ContactUs (Email, Phone, NewMessage) VALUES (?, ?, ?)";

		Connection conn = null;
		PreparedStatement pstm = null;

		try {
			conn = ConnectionFactory.createConnectionSQLServer();
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, contactUs.getEmail());
			pstm.setString(2, contactUs.getPhone());
			pstm.setString(3, contactUs.getNewMessage());

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
	
	public void removeById(int ContactID) {
		String sql = "DELETE FROM ContactUS WHERE ContactID = ?";

		Connection conn = null;
		PreparedStatement pstm = null;

		try {
			conn = ConnectionFactory.createConnectionSQLServer();
			pstm = conn.prepareStatement(sql);

			pstm.setInt(1, ContactID);

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
	
	public void update(ContactUs contactUs) {
		String sql = "UPDATE ContactUS SET Email = ?, Phone = ?, NewMessage = ? WHERE ContactID = ?";

		Connection conn = null;
		PreparedStatement pstm = null;

		try {
			// Create a DB connection
			conn = ConnectionFactory.createConnectionSQLServer();
			// Class used to execute the query
			pstm = conn.prepareStatement(sql);
			// Add value at the first parameter
			pstm.setString(1, contactUs.getEmail());
			// Add value at the second parameter
			pstm.setString(2, contactUs.getPhone());
			// Add value at third parameter
			pstm.setString(3, contactUs.getNewMessage());
			// Add value at fourth parameter
			pstm.setInt(4, contactUs.getContactID());
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
	
public List<ContactUs> getContactUs() {
		
		String sql = "select * from ContactUs";
		
		List<ContactUs> contactUs = new ArrayList<ContactUs>();

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
				ContactUs contact = new ContactUs();	
				
				// ========================= ContactUs Table =======================
				contact.setEmail(rset.getString("Email"));
				contact.setPhone(rset.getString("Phone"));
				contact.setNewMessage(rset.getString("NewMessage"));
				
				contactUs.add(contact);
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
		return contactUs;
	}
}
