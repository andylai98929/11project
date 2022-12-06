import java.util.Objects;

public class Product implements Comparable{
    private String name;
    private double unitPrice;
    private double revenue;
    private int totalQuantity;

    private SalesChannel salesChannel;

    public Product(String name, double unitPrice) {
        this.name = name;
        this.unitPrice = unitPrice;
    }

    public int addTotalQuantity(int quantity){
        int newQuant = this.totalQuantity+quantity;
        this.setTotalQuantity(newQuant);
        return newQuant;
    }

    public void setTotalQuantity(int totalQuantity) {
        this.totalQuantity = totalQuantity;
    }

    public double getRevenue(SalesChannel salesChannel){
        int quantity = salesChannel.totalQuantity();
        this.setRevenue(quantity*unitPrice);
        return this.revenue;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public void setRevenue(double revenue) {
        this.revenue = revenue;
    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }

    public double getRevenue() {
        return revenue;
    }

    public int getTotalQuantity() {
        return totalQuantity;
    }

    public SalesChannel getSalesChannel() {
        return salesChannel;
    }

    public void setSalesChannel(SalesChannel salesChannel) {
        this.salesChannel = salesChannel;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Double.compare(product.unitPrice, unitPrice) == 0 && Double.compare(product.revenue, revenue) == 0 && totalQuantity == product.totalQuantity && Objects.equals(name, product.name) && Objects.equals(salesChannel, product.salesChannel);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, unitPrice, revenue, totalQuantity, salesChannel);
    }
}
