package main;

import dao.ContactUsDao;
import models.ContactUs;

public class ContactUsMain {

	public static void main(String[] args) {
		ContactUsDao contactUsDao = new ContactUsDao();
		
		// ==================== Save method ===========================
		
//		ContactUs contactUs = new ContactUs();
//		contactUs.setEmail("garbagetotally@gmail.com");
//		contactUs.setPhone("No phone");
//		contactUs.setNewMessage("Second teste message");
//		
//		contactUsDao.save(contactUs);
		
		// =================== Remove method ================================
		
//		contactUsDao.removeById(3);
		
		// ======================== Update method ===========================
		
//		ContactUs contactUs1 = new ContactUs();
//		contactUs1.setContactID(4);
//		contactUs1.setEmail("caramurusoftware@contato.com.ca");
//		contactUs1.setPhone("555-5555-555");
//		contactUs1.setNewMessage("Dot let me down");
//		
//		contactUsDao.update(contactUs1);
		
		for(ContactUs c : contactUsDao.getContactUs()) {
			System.out.println("Emai: " + c.getEmail()
			+ "\nPhone number: " + c.getPhone()
			+ "\nNew Message: " + c.getNewMessage());
		}
	}
}
