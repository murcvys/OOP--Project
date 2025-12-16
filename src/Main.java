import java.util.Scanner;

public class Main {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        Inventory inventory = new Inventory();

        // Load default products
        loadDefaultProducts(inventory);

        // Default Admin
        Admin admin = new Admin("A001", "SuperAdmin", "12345");

        // Default Customer
        Customer customer = new Customer("C001", "John Doe", 50.0);

        while (true) {
        	System.out.println(
      			  "╔ ╗       ╔ ╗     ╔═╗                            ╔═╗\r\n"
      	 		+ "║ ║  ╔ ╗  ║ ║     ║ ║   ╔ ═╗        ╔ ╗╔ ╗       ║ ║\r\n"
      	 		+ " ║ ╚╝   ╚╝ ║ ╔══╗ ║ ║   ║╔ ╝ ╔══ ╗  ║ ╚╝ ║  ╔══╗ ║ ║\r\n"
      	 		+ "  ║  ╔═╗  ║  ║╩═╝ ║ ╚═╗ ║╚ ╗ ║║║ ║  ║╔╗╔╗║  ║╩═╝ ╚ ╝\r\n"
      	 		+ "   ╚╝   ╚╝   ╚══╝ ╚══ ╝ ╚ ═╝ ╚ ══╝  ╚╝╚╝╚╝  ╚══╝  O\r\n"
      	 		);
            System.out.println("1. Admin");
            System.out.println("2. Customer");
            System.out.println("3. Exit");
            System.out.print("Choose: ");

            int menu = sc.nextInt();
            sc.nextLine();

            switch (menu) {
                case 1:
                    adminLoginMenu(admin, inventory);
                    break;
                case 2:
                    customerMenu(customer, inventory);
                    break;
                case 3:
                    System.out.println("Goodbye!");
                    return;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }

    // -----------------------------------------
    //             ADMIN LOGIN & MENU
    // -----------------------------------------
    public static void adminLoginMenu(Admin admin, Inventory inventory) {

        System.out.print("Enter Admin ID: ");
        String id = sc.nextLine();
        System.out.print("Enter Password: ");
        String pass = sc.nextLine();

        if (!admin.login(id, pass)) {
            System.out.println("Incorrect login!");
            return;
        }

        System.out.println("\nWelcome Admin " + admin.getAdminName());

        while (true) {
            System.out.println("\n=== ADMIN MENU ===");
            System.out.println("1. View All Products");
            System.out.println("2. Add Product");
            System.out.println("3. Edit Product");
            System.out.println("4. Search by Type");
            System.out.println("5. Restock Product");
            System.out.println("6. Delete Product");
            System.out.println("7. Logout");
            System.out.print("Choose: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    sortMenu(inventory);
                    inventory.viewAllProducts();
                    break;

                case 2:
                    addProductMenu(admin, inventory);
                    break;

                case 3:
                    System.out.print("Enter product name to edit: ");
                    String oldName = sc.nextLine();

                    System.out.print("New name: ");
                    String newName = sc.nextLine();

                    System.out.print("New price: ");
                    double newPrice = sc.nextDouble();
                    sc.nextLine();

                    admin.editProduct(inventory, oldName, newName, newPrice);
                    break;

                case 4:
                    System.out.print("Enter type (Food/Electronic/Clothing/Medicine): ");
                    String type = sc.nextLine();
                    inventory.searchByType(type);
                    break;

                case 5:
                    System.out.print("Enter product name to restock: ");
                    String rName = sc.nextLine();

                    Product rp = inventory.findProduct(rName);

                    if (rp == null) {
                        System.out.println("Product not found!");
                    } else {
                        System.out.print("Amount to add: ");
                        int amount = sc.nextInt();
                        sc.nextLine();
                        admin.restockProduct(rp, amount);
                    }
                    break;
                   
                case 6:
                	System.out.print("Enter product name to delete: ");
                    String delName = sc.nextLine();

                    boolean deleted = inventory.deleteProduct(delName);

                    if (deleted) {
                        System.out.println("Product deleted successfully.");
                    } else {
                        System.out.println("Product not found.");
                    }
                    break;
                	
                case 7:
                    return;

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }

    // -----------------------------------------
    //         ADMIN - ADD PRODUCT MENU
    // -----------------------------------------
    public static void addProductMenu(Admin admin, Inventory inv) {

        System.out.println("\n== ADD PRODUCT ==");
        System.out.println("1. Food");
        System.out.println("2. Electronic");
        System.out.println("3. Clothing");
        System.out.println("4. Medicine");
        System.out.print("Choose type: ");

        int type = sc.nextInt();
        sc.nextLine();

        System.out.print("Product name: ");
        String name = sc.nextLine();

        System.out.print("Price: ");
        double price = sc.nextDouble();
        sc.nextLine();

        System.out.print("Quantity: ");
        int qty = sc.nextInt();
        sc.nextLine();

        Product p = null;

        switch (type) {
            case 1:
                System.out.print("Expiry Date: ");
                String exp = sc.nextLine();
                p = new Food("Food", name, qty, price, exp);
                break;

            case 2:
                System.out.print("Warranty (months): ");
                int w = sc.nextInt();
                sc.nextLine();
                p = new Electronic("Electronic", name, qty, price, w);
                break;

            case 3:
                System.out.print("Size (S/M/L/XL): ");
                String size = sc.nextLine();
                p = new Clothing("Clothing", name, qty, price, size);
                break;

            case 4:
                System.out.print("Dosage info: ");
                String dose = sc.nextLine();
                System.out.print("Expiry Date: ");
                String exp2 = sc.nextLine();
                p = new Medicine("Medicine", name, qty, price, dose, exp2);
                break;

            default:
                System.out.println("Invalid type!");
                return;
        }

        admin.addNewProduct(inv, p);
        System.out.println("Product added!");
    }

    // -----------------------------------------
    //             CUSTOMER MENU
    // -----------------------------------------
    public static void customerMenu(Customer cust, Inventory inv) {

        while (true) {
            System.out.println("\n=== CUSTOMER MENU ===");
            System.out.println("Your balance: $" + cust.getBalance());
            System.out.println("1. View All Products");
            System.out.println("2. Buy Product");
            System.out.println("3. Top Up");
            System.out.println("4. Back");
            System.out.print("Choose: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    sortMenu(inv);
                    inv.viewAllProducts();
                    break;

                case 2:
                    System.out.print("Enter product name: ");
                    String pname = sc.nextLine();

                    Product p = inv.findProduct(pname);

                    if (p == null) {
                        System.out.println("Product not found.");
                        break;
                    }

                    System.out.print("Enter amount to buy: ");
                    int amount = sc.nextInt();
                    sc.nextLine();

                    double totalPrice = p.getPrice() * amount;
                    System.out.println("Total price = $" + totalPrice);

                    System.out.print("Confirm purchase (Y/N): ");
                    String confirm = sc.nextLine();

                    if (confirm.equalsIgnoreCase("Y")) {
                        cust.buyProduct(p, amount);
                    } else {
                        System.out.println("Purchase cancelled.");
                    }
                    break;

                case 3:
                    System.out.print("Amount to top up: ");
                    double amt = sc.nextDouble();
                    sc.nextLine();
                    cust.topUp(amt);
                    break;

                case 4:
                    return;

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }

    // -----------------------------------------
    //             SORT MENU (SHARED)
    // -----------------------------------------
    public static void sortMenu(Inventory inventory) {

        System.out.println("\n--- Sort Products ---");
        System.out.println("1. Sort by Name (A-Z)");
        System.out.println("2. Sort by Price (Low to High)");
        System.out.println("3. Sort by Quantity (Low to High)");
        System.out.println("4. No Sorting");
        System.out.print("Choose: ");

        int sortChoice = sc.nextInt();
        sc.nextLine();

        switch (sortChoice) {
            case 1:
                inventory.sortByName();
                break;
            case 2:
                inventory.sortByPrice();
                break;
            case 3:
                inventory.sortByQuantity();
                break;
            case 4:
                break;
            default:
                System.out.println("Invalid sort option.");
        }
    }

    // -----------------------------------------
    //         LOAD DEFAULT PRODUCTS
    // -----------------------------------------
    public static void loadDefaultProducts(Inventory inv) {

        inv.addProduct(new Food("Food", "Apple", 50, 1.5, "2025-05-10"));
        inv.addProduct(new Food("Food", "Instant Noodles", 120, 0.8, "2026-01-01"));

        inv.addProduct(new Clothing("Clothing", "White T-Shirt", 40, 10.0, "M"));
        inv.addProduct(new Clothing("Clothing", "Black Hoodie", 25, 25.0, "L"));

        inv.addProduct(new Electronic("Electronic", "Bluetooth Speaker", 20, 35.0, 12));
        inv.addProduct(new Electronic("Electronic", "Laptop Charger", 15, 25.0, 6));

        inv.addProduct(new Medicine("Medicine", "Paracetamol", 100, 2.5, "500mg", "2026-12-31"));
        inv.addProduct(new Medicine("Medicine", "Vitamin C", 80, 5.0, "1000mg", "2027-03-15"));
    }
}
