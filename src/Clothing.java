public class Clothing extends Product {

    private String size;

    public Clothing(String productType, String productName, int quantity, double price, String size) {
		super(productType, productName, quantity, price);
		this.size = size;
	}

	@Override
	public void display() {
	    System.out.printf("%-15s %-20s %-10.2f %-10d Size: %-15s%n",
	            "Clothing",
	            productName,
	            price,
	            quantity,
	            size
	    );
	}


    public String getSize() {
        return size;
    }
}
