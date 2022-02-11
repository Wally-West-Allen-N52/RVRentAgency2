package models;

public class Home {
	private int HomeID;
	private String ClientName;
	
	private int DestinationID;
	private Destination destination;
	private int PromotionID;
	private Promotion promotion;
	private int ContactID;
	private ContactUs contact;
	public int getHomeID() {
		return HomeID;
	}
	public void setHomeID(int homeID) {
		HomeID = homeID;
	}
	public String getClientName() {
		return ClientName;
	}
	public void setClientName(String clientName) {
		ClientName = clientName;
	}
	public int getDestinationID() {
		return DestinationID;
	}
	public void setDestinationID(int destinationID) {
		DestinationID = destinationID;
	}
	public Destination getDestination() {
		return destination;
	}
	public void setDestination(Destination destination) {
		this.destination = destination;
	}
	public int getPromotionID() {
		return PromotionID;
	}
	public void setPromotionID(int promotionID) {
		PromotionID = promotionID;
	}
	public Promotion getPromotion() {
		return promotion;
	}
	public void setPromotion(Promotion promotion) {
		this.promotion = promotion;
	}
	public int getContactID() {
		return ContactID;
	}
	public void setContactID(int contactID) {
		ContactID = contactID;
	}
	public ContactUs getContact() {
		return contact;
	}
	public void setContact(ContactUs contact) {
		this.contact = contact;
	}
	
}
