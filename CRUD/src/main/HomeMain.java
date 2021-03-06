package main;

import dao.HomeDao;
import models.Home;

public class HomeMain {

	public static void main(String[] args) {
		
		HomeDao  homeDao = new HomeDao();
		
		// ============================= Save method ==============================
//		Home home = new Home();
//		home.setClientName("Sparamus");
//		home.setHomeID(1);
//		home.setDestinationID(1);
//		home.setPromotionID(1);
//		home.setContactID(1);
//		
//		homeDao.save(home);
		
		// ============================= Remove method ==================================
//		homeDao.removeById(2);
		
		// ============================= update method =================================
//		Home home1 = new Home();
//		home1.setHomeID(1);
//		home1.setClientName("Nathalie Linda do Wallace");
//		
//		homeDao.update(home1);
		
		// ======================= Return list =======================================
		
		for (Home h : homeDao.getHomes()) {
			System.out.println("Client name: " + h.getClientName()
			+ "\nTake here: " + h.getDestination().getTakeHere() + "Deliver there: " + h.getDestination().getDeliverThere()
			+ "\nPromotion: " + h.getPromotion().getPromotion() + "Price $" + h.getPromotion().getPrice()
			+ "\nEmail: " + h.getContact().getEmail() + "Phone: " + h.getContact().getPhone() + "New message: " + h.getContact().getNewMessage());
		}
	}

}
