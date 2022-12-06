import java.util.Objects;

public class ProductType implements Comparable{
    private String type;
    private String name;
    private Double unitPrice;
    private Integer onlineShop;
    private Integer physicalStore;
    private Integer promotion;

    public ProductType(String type, String name, Double unitPrice, Integer onlineShop, Integer physicalStore, Integer promotion) {
        this.type = type;
        this.name = name;
        this.unitPrice = unitPrice;
        this.onlineShop = onlineShop;
        this.physicalStore = physicalStore;
        this.promotion = promotion;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductType that = (ProductType) o;
        return Objects.equals(type, that.type) && Objects.equals(name, that.name) && Objects.equals(unitPrice, that.unitPrice) && Objects.equals(onlineShop, that.onlineShop) && Objects.equals(physicalStore, that.physicalStore) && Objects.equals(promotion, that.promotion);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, name, unitPrice, onlineShop, physicalStore, promotion);
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(Double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public Integer getOnlineShop() {
        return onlineShop;
    }

    public void setOnlineShop(Integer onlineShop) {
        this.onlineShop = onlineShop;
    }

    public Integer getPhysicalStore() {
        return physicalStore;
    }

    public void setPhysicalStore(Integer physicalStore) {
        this.physicalStore = physicalStore;
    }

    public Integer getPromotion() {
        return promotion;
    }

    public void setPromotion(Integer promotion) {
        this.promotion = promotion;
    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }
}
