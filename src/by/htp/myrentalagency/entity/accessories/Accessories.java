package by.htp.myrentalagency.entity.accessories;

import by.htp.myrentalagency.entity.Category;
import by.htp.myrentalagency.entity.Product;

public abstract class Accessories extends Product{
	
	
	
	
	public Accessories(Category category,String title, double price, int year) {
		super(category,title,price,year);
		this.setItemType("Accessories");
	}
	


	@Override
	public String toString() {
		return super.toString();
	}
	
}
