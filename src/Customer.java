public class Customer {

    protected String customerId;
    protected String custmerName;
    protected double balance;

    public Customer(String customerId, String custmerName, double balance) {
        this.customerId = customerId;
        this.custmerName = custmerName;
        this.balance = balance;
    }

    public String getCustomerId() {
        return customerId;
    }

    public String getCustmerName() {
        return custmerName;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    // ================= SORT & VIEW FUNCTIONS =================

    public void viewAllProducts(Inventory inventory) {
        inventory.viewAllProducts();
    }

    public void sortProductsByName(Inventory inventory) {
        inventory.sortByName();
    }

    public void sortProductsByPrice(Inventory inventory) {
        inventory.sortByPrice();
    }

    public void sortProductsByQuantity(Inventory inventory) {
        inventory.sortByQuantity();
    }

    // =========================================================

    public void buyProduct(Product product, int amount) {

        if (amount <= 0) {
            System.out.println("Invalid quantity!");
            return;
        }

        if (product.getQuantity() < amount) {
            System.out.println("Not enough stock! Available: " + product.getQuantity());
            return;
        }

        double totalPrice = product.getPrice() * amount;

        if (balance < totalPrice) {
            System.out.println("Your balance is not enough!");
            return;
        }

        balance -= totalPrice;
        product.setQuantity(product.getQuantity() - amount);

        System.out.println("Successfully purchased " + amount + " pcs of " + product.getProductName());
        System.out.println("Remaining balance: $" + balance);
    }

    public void topUp(double amount) {
        balance += amount;
        System.out.println("Successfully topped up $" + amount);
        System.out.println("Current balance : $" + balance);
    }
}
