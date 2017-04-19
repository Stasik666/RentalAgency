package by.htp.myrentalagency.entity.accessories;

import by.htp.myrentalagency.entity.Category;

public class Protection extends Accessories{
	
	private double size;
	
	public Protection(String[] data){
		super(Category.valueOf(data[2]), data[4], Double.parseDouble(data[5]), Integer.parseInt(data[6]));
		size = Double.parseDouble(data[7]);
		setItemName(data[1]);
	}
	
	public Protection(Category category,String title, double price, int year,double size) {
		super(category,title, price, year);
		this.size = size;
		this.setItemName("Protection");
	}

	public double getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	@Override
	public String toString() {
		return super.toString() + ", Size=" + size;
	}
	 
}
