public class Food extends Product {

    private String expiryDate;

    public Food(String productType, String productName, int quantity, double price, String expiryDate) {
		super(productType, productName, quantity, price);
		this.expiryDate = expiryDate;
	}

    @Override
    public void display() {
        System.out.printf("%-15s %-20s %-10.2f %-10d Expired Date: %-25s%n",
                "Food",
                productName,
                price,
                quantity,
                expiryDate
        );
    }


    public String getExpiryDate() {
        return expiryDate;
    }
}
