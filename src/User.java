import java.util.ArrayList;

public class User {
    private String username;
    private ArrayList<Product> shoppingCart;

    public User(String username) {
        this.username = username;
        this.shoppingCart = new ArrayList<>();
    }

    public String getUsername() {
        return username;
    }

    public void addProduct(Product product) {
        shoppingCart.add(product);
    }

    public Product findProductById(int productId) {
        for (Product product : shoppingCart) {
            if (product.getProductId() == productId) {
                return product;
            }
        }
        return null;
    }

    public void removeProduct(Product product) {
        shoppingCart.remove(product);
    }

    public void displayCart() {
        if (shoppingCart.isEmpty()) {
            System.out.println("No products in the cart.");
        } else {
            for (Product product : shoppingCart) {
                product.displayDetails();
            }
        }
    }
}