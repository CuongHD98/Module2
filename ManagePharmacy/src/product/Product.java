package product;

public class Product {
    private static int countIDProduct = 1;
    private int id;
    private String name;
    private String typeMedicine;
    private int quantity;
    private int expiry;
    private String productsUse;
    private float price;

    public Product(String name, String typeMedicine, int quantity, int expiry, String productsUse, float price) {
        this.id = countIDProduct++;
        this.name = name;
        this.typeMedicine = typeMedicine;
        this.quantity = quantity;
        this.expiry = expiry;
        this.productsUse = productsUse;
        this.price = price;
    }

    public static int getCountIDProduct() {
        return countIDProduct;
    }

    public static void setCountIDProduct(int countIDProduct) {
        Product.countIDProduct = countIDProduct;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTypeMedicine() {
        return typeMedicine;
    }

    public void setTypeMedicine(String typeMedicine) {
        this.typeMedicine = typeMedicine;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getExpiry() {
        return expiry;
    }

    public void setExpiry(int expiry) {
        this.expiry = expiry;
    }

    public String getProductsUse() {
        return productsUse;
    }

    public void setProductsUse(String productsUse) {
        this.productsUse = productsUse;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", typeMedicine='" + typeMedicine + '\'' +
                ", quantity=" + quantity +
                ", expiry=" + expiry +
                ", productsUse='" + productsUse + '\'' +
                ", price=" + price +
                '}';
    }
}
