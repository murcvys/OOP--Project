import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Inventory {

    private List<Product> products;

    // constructor
    public Inventory() {
        products = new ArrayList<>();
    }

    public void addProduct(Product p) {
        products.add(p);
    }

    public boolean editProduct(String productName, String newName, double newPrice) {
        for (Product p : products) {
            if (p.getProductName().equalsIgnoreCase(productName)) {
                p.setProductName(newName);
                p.setPrice(newPrice);
                return true;
            }
        }
        return false;
    }

    public void viewAllProducts() {
        if (products.isEmpty()) {
            System.out.println("Inventory is empty.");
            return;
        }

        System.out.println("\n=============================================================================================================");
        System.out.printf("%-15s %-20s %-10s %-10s %-25s %-15s%n",
                "Type", "Name", "Price", "Qty", "Detail1", "Detail2");
        System.out.println("=============================================================================================================");

        for (Product p : products) {
            p.display();
        }
    }

    // ================= SORT FUNCTIONS =================

    // Sort A–Z by product name
    public void sortByName() {
        products.sort(Comparator.comparing(Product::getProductName, String.CASE_INSENSITIVE_ORDER));
    }

    // Sort by price (low → high)
    public void sortByPrice() {
        products.sort(Comparator.comparingDouble(Product::getPrice));
    }

    // Sort by quantity (low → high)
    public void sortByQuantity() {
        products.sort(Comparator.comparingInt(Product::getQuantity));
    }

    // ==================================================

    public void searchByType(String type) {
        System.out.println("--- Search Result (type: " + type + ") ---");

        boolean found = false;
        for (Product p : products) {
            if (p.getProductType().equalsIgnoreCase(type)) {
                p.display();
                found = true;
            }
        }

        if (!found) {
            System.out.println("No products found for type: " + type);
        }
    }

    public Product findProduct(String name) {
        for (Product p : products) {
            if (p.getProductName().equalsIgnoreCase(name)) {
                return p;
            }
        }
        return null;
    }

    // Optional: expose list safely
    public List<Product> getProducts() {
        return products;
    }
    
    public boolean deleteProduct(String productName) {
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getProductName().equalsIgnoreCase(productName)) {
                products.remove(i);
                return true;
            }
        }
        return false;
    }
}
