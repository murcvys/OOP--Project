public abstract class Product {
    protected String productType;
    protected String productName;
    protected int quantity;
    protected double price;

    public Product(String productType, String productName, int quantity, double price) {
        this.productType = productType;
        this.productName = productName;
        this.quantity = quantity;
        this.price = price;
    }

    public String getProductType() {
        return productType;
    }

    public String getProductName() {
        return productName;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void display() {
        System.out.println(toString());
    }

    @Override
    public String toString() {
        return "[" + productType + "] " + productName + 
                " | Qty: " + quantity + 
                " | Price: $" + price;
    }
}
