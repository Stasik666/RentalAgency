package by.htp.myrentalagency.entity;

public abstract class Product {
	
	private static int itemCount;
	
	private final int id;
	private String title;
	private double price;
	private int year;
	private Category category;
	private  String itemType;
	private  String itemName;
	
	public Product(Category category, String title, double price, int year){
		id=++itemCount;
		this.category = category;
		this.title = title;
		this.price = price;
		this.year = year;
	}
	
	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getItemType() {
		return itemType;
	}

	public void setItemType(String itemType) {
		this.itemType = itemType;
	}

	public static int getItemCount() {
		return itemCount;
	}

	public static void setItemCount(int itemCount) {
		Product.itemCount = itemCount;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public int getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Id=" + id + ", ItemName=" + itemName + ", Category=" + category + ", ItemType=" + itemType + ", Title=" + title + ", Price=" + price + ", Year=" + year + ", ";
	}
	
}