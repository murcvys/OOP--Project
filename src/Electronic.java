public class Electronic extends Product {

    private int warrantyMonths;

    
    public Electronic(String productType, String productName, int quantity, double price, int warrantyMonths) {
		super(productType, productName, quantity, price);
		this.warrantyMonths = warrantyMonths;
	}

	@Override
    public void display() {
		 System.out.printf("%-15s %-20s %-10.2f %-10d Warrany Month: %-25d%n",
		            "Electronic",          
		            productName,
		            price,
		            quantity,
		            warrantyMonths
		    );
    }

    public int getWarrantyMonths() {
        return warrantyMonths;
    }
}
