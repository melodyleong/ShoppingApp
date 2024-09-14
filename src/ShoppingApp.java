import java.util.Scanner;

public class ShoppingApp {
    private static User[] users = { new User("Alice"), new User("Bob"), new User("Charlie") };
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean running = true;

        while (running) {
            System.out.println("\n--- SHOPPING CART MANAGER ---");
            System.out.println("Select a user:");
            for (int i = 0; i < users.length; i++) {
                System.out.println((i + 1) + ". " + users[i].getUsername());
            }
            System.out.println((users.length + 1) + ". Exit");
            System.out.print("Choose an option: ");

            int userChoice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            if (userChoice == users.length + 1) {
                running = false;
                System.out.println("Exiting...");
            } else if (userChoice > 0 && userChoice <= users.length) {
                manageCart(users[userChoice - 1]);
            } else {
                System.out.println("Invalid choice. Please try again.");
            }
        }
    }
    // Manage shopping cart for the selected user
    public static void manageCart(User user) {
        boolean managingCart = true;

        while (managingCart) {
            System.out.println("\n--- MANAGING CART FOR: " + user.getUsername() + " ---");
            System.out.println("1. Add Product to Cart");
            System.out.println("2. View Cart");
            System.out.println("3. Update Product in Cart");
            System.out.println("4. Remove Product from Cart");
            System.out.println("5. Go Back");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    addProduct(user);
                    break;
                case 2:
                    user.displayCart();
                    break;
                case 3:
                    updateProduct(user);
                    break;
                case 4:
                    removeProduct(user);
                    break;
                case 5:
                    managingCart = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    // Add a product to the user's cart
    public static void addProduct(User user) {
        System.out.print("Enter Product ID: ");
        int productId = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        System.out.print("Enter Product Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Product Price: ");
        double price = scanner.nextDouble();
        scanner.nextLine(); // Consume newline
        System.out.print("Is this a discounted product? (y/n): ");
        String isDiscounted = scanner.nextLine();

        if (isDiscounted.equalsIgnoreCase("y")) {
            System.out.print("Enter Discount Rate (e.g., 0.1 for 10%): ");
            double discount = scanner.nextDouble();
            user.addProduct(new DiscountedProduct(productId, name, price, discount));
        } else {
            user.addProduct(new Product(productId, name, price));
        }
        System.out.println("Product added to cart successfully!");
    }

    // Update a product in the cart
    public static void updateProduct(User user) {
        System.out.print("Enter Product ID to update: ");
        int productId = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        Product productToUpdate = user.findProductById(productId);
        if (productToUpdate != null) {
            System.out.print("Enter new product name: ");
            String newName = scanner.nextLine();
            System.out.print("Enter new price: ");
            double newPrice = scanner.nextDouble();
            productToUpdate.updateDetails(newName, newPrice);
            System.out.println("Product updated successfully!");
        } else {
            System.out.println("Product not found.");
        }
    }

    // Remove a product from the cart
    public static void removeProduct(User user) {
        System.out.print("Enter Product ID to remove: ");
        int productId = scanner.nextInt();

        Product productToDelete = user.findProductById(productId);
        if (productToDelete != null) {
            user.removeProduct(productToDelete);
            System.out.println("Product removed from cart successfully!");
        } else {
            System.out.println("Product not found.");
        }
    }
}