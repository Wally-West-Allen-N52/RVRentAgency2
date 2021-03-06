package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import factory.ConnectionFactory;
import models.Promotion;

public class PromotionDao {
	
	public void save(Promotion promotion) {

		String sql = "INSERT INTO Promotion (Promotion, Price) VALUES (?, ?)";

		Connection conn = null;
		PreparedStatement pstm = null;

		try {
			conn = ConnectionFactory.createConnectionSQLServer();
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, promotion.getPromotion());
			pstm.setFloat(2, 5000);

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
	
	public void removeById(int PromotionID) {
		String sql = "DELETE FROM Promotion WHERE PromotionID = ?";

		Connection conn = null;
		PreparedStatement pstm = null;

		try {
			conn = ConnectionFactory.createConnectionSQLServer();
			pstm = conn.prepareStatement(sql);

			pstm.setInt(1, PromotionID);

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
	
	public void update(Promotion promotion) {
		String sql = "UPDATE Promotion SET Promotion = ?, Price = ? WHERE PromotionID = ?";

		Connection conn = null;
		PreparedStatement pstm = null;

		try {
			// Create a DB connection
			conn = ConnectionFactory.createConnectionSQLServer();
			// Class used to execute the query
			pstm = conn.prepareStatement(sql);

			// Add value at the first parameter
			pstm.setString(1, promotion.getPromotion());
			// Add values at second parameter
			pstm.setFloat(2, promotion.getPrice());
			// Add value at the third parameter
			pstm.setInt(3, promotion.getPromotionID());
		
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
	
public List<Promotion> getPromotions() {
		
		String sql = "select * from Promotion";
		
		List<Promotion> promotions = new ArrayList<Promotion>();

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
				Promotion promotion = new Promotion();	
				
				// ========================= Promotion Table =======================
				promotion.setPromotion(rset.getString("Promotion"));
				promotion.setPrice(rset.getFloat("Price"));
				
				promotions.add(promotion);
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
		return promotions;
	}
}
