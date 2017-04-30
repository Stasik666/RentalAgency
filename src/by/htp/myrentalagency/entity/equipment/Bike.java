package by.htp.myrentalagency.entity.equipment;

import by.htp.myrentalagency.entity.Category;


public class Bike extends Equipment{
	
	private String type;
	
	public Bike(String[] data){
		
		super(Category.BICYCLING,data[4], Double.parseDouble(data[5]), Integer.parseInt(data[6]),
				Double.parseDouble(data[7]),data[8]);
		type = data[7];
		setItemName(data[1]);
	}
	
	public Bike(String title, double price, int year,
			double weight, String color, String type) {
		super(Category.BICYCLING, title, price, year,weight,color);
		this.type = type;
		this.setItemName("Bike");
	}
	
	public Bike() {
		super();
		this.setItemName("Bike");
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
    @Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Bike other = (Bike) obj;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return  super.toString() + ", Type=" + type;
	}
	
}
