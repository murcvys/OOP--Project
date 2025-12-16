public class Admin implements ViewProduct {

    private String adminId;
    private String adminName;
    private String password;

    public Admin(String adminId, String adminName, String password) {
        this.adminId = adminId;
        this.adminName = adminName;
        this.password = password;
    }

    public boolean login(String id, String pass) {
        return this.adminId.equals(id) && this.password.equals(pass);
    }

    public void addNewProduct(Inventory inv, Product p) {
        inv.addProduct(p);
    }

    public void editProduct(Inventory inv, String name, String newName, double newPrice) {
        inv.editProduct(name, newName, newPrice);
    }

    public void restockProduct(Product product, int amount) {
        product.setQuantity(product.getQuantity() + amount);
        System.out.println("Restocked " + product.getProductName() + " by " + amount);
    }

    public void sortProductsByName(Inventory inv) {
        inv.sortByName();
    }

    public void sortProductsByPrice(Inventory inv) {
        inv.sortByPrice();
    }

    public void sortProductsByQuantity(Inventory inv) {
        inv.sortByQuantity();
    }

    @Override
    public void viewProduct(Product product) {
        product.display();
    }

    public String getAdminName() {
        return adminName;
    }
}
