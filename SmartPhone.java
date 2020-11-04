package practice;

public class SmartPhone {

	private String manufacturer;
	private String model;
	private String opModel;
	private int Memory; // memory will be in GigaBytes
	private double price;
	
	String phoneStr;

	public SmartPhone(String manufacturer, String model, String opModel, int Memory, double price) {
		this.manufacturer = manufacturer;
		this.model = model;
		this.opModel = opModel;
		this.Memory = Memory;
		this.price = price;
	}
	
	public String getManufacturer() {
		return manufacturer;
	}
	
	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}
	
	public String getModel() {
		return model;
	}
	
	public void setModel(String model) {
		this.model = model;
	}
	
	public String getOpModel() {
		return opModel;
	}
	
	public void setOpModel(String opModel) {
		this.opModel = opModel;
	}
	
	public int getMemory() {
		return Memory;
	}
	
	public void setMemory(int memory) {
		Memory = memory;
	}
	
	public double getPrice() {
		return price;
	}
	
	public void setPrice(double price) {
		this.price = price;
	}
	
	public String ToString() {
		/*String phoneStr = manufacturer + "\n " + model + "\n" + opModel + "\n" + Memory + "GB\n" + price; */
		phoneStr = phoneStr +"brand: " + manufacturer + "\n";
		phoneStr = phoneStr +"model: " + model + "\n";
		phoneStr = phoneStr +"opModel: " + opModel + "\n";
		phoneStr = phoneStr +"Memory: " + Memory + "GB\n";
		phoneStr = phoneStr +"price: " + price + "\n";
		
		return phoneStr;
	}

}
	
	