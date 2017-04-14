package by.htp.myrentalagency.entity.accessories;

import by.htp.myrentalagency.entity.Category;

public class Glasses extends Accessories{
	
	private String type;
	
	public Glasses(String[] data){
		super(Category.valueOf(data[2]), data[4], Double.parseDouble(data[5]), Integer.parseInt(data[6]));
		type = data[3];
	}
	
	public Glasses(Category category,String title, double price, int year,String type) {
		super(category,title, price, year);
		this.type = type;
		this.setItemName("Glasses");
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return super.toString() +", Type=" + type;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		return result;
	}
}
	
	

