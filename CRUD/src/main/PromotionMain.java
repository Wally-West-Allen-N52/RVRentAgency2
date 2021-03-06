package main;

import dao.PromotionDao;
import models.Promotion;

public class PromotionMain {

	public static void main(String[] args) {
		PromotionDao promotionDao = new PromotionDao();
		
		// ========================= Save method =============================
//		Promotion promotion = new Promotion();
//		promotion.setPromotion("Sem promo??o Legal");
//		promotion.setPrice(5.000f);
//		
//		promotionDao.save(promotion);
		
		// ========================== Remove method =========================
//		promotionDao.removeById(2);
		
		// =========================== update method ========================
//		Promotion promotion1 = new Promotion();
//		promotion1.setPromotionID(3);
//		promotion1.setPromotion("Chegou a pascoa do natal");
//		promotion1.setPrice(700);
//		promotionDao.update(promotion1);
		
		for(Promotion p : promotionDao.getPromotions()) {
			System.out.println("Promotion: " + p.getPromotion()
					+ "Price $" + p.getPrice());
		}
	}

}
