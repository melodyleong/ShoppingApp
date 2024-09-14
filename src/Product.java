public class Product implements Displayable {
    private int productId;
    private String name;
    private double price;

    public Product(int productId, String name, double price) {
        this.productId = productId;
        this.name = name;
        this.price = price;
    }

    @Override
    public void displayDetails() {
        System.out.println("Product ID: " + productId + ", Name: " + name + ", Price: $" + price);
    }

    public void updateDetails(String newName, double newPrice) {
        this.name = newName;
        this.price = newPrice;
    }

    public int getProductId() {
        return productId;
    }

    public double getPrice() {
        return price;
    }
}