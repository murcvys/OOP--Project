public class Medicine extends Product {

    private String dosage;       
    private String expiryDate;   

   
    public Medicine(String productType, String productName, int quantity, double price, String dosage,
			String expiryDate) {
		super(productType, productName, quantity, price);
		this.dosage = dosage;
		this.expiryDate = expiryDate;
	}

    @Override
    public void display() {
        System.out.printf("%-15s %-20s %-10.2f %-10d Dosage: %-17s Expired Date: %-15s%n",
                "Medicine",
                productName,
                price,
                quantity,
                dosage,
                expiryDate
        );
    }


    public String getDosage() {
        return dosage;
    }

    public String getExpiryDate() {
        return expiryDate;
    }
}

