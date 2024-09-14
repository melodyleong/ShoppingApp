public class DiscountedProduct extends Product {
    private double discount;

    public DiscountedProduct(int productId, String name, double price, double discount) {
        super(productId, name, price);
        this.discount = discount;
    }

    @Override
    public void displayDetails() {
        super.displayDetails();  // Call parent method
        System.out.println("Discount: " + discount * 100 + "%, Discounted Price: $" + (getPrice() * (1 - discount)));
    }

    public double getDiscount() {
        return discount;
    }

    public double getPrice() {
        return super.getPrice();
    }
}