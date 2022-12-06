import java.util.Objects;

public class SalesChannel implements Comparable{
    private int onlineShop;
    private int physicalStore;
    private int promotion;

    public SalesChannel(Integer onlineShop, Integer physicalStore, Integer promotion) {
        this.onlineShop = onlineShop;
        this.physicalStore = physicalStore;
        this.promotion = promotion;
    }

    public int totalQuantity (){
        return this.getOnlineShop()+this.getPhysicalStore()+getPromotion();
    }

    @Override
    public String toString() {
        return "SalesChannel{" +
                "onlineShop=" + onlineShop +
                ", physicalStore=" + physicalStore +
                ", promotion=" + promotion +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SalesChannel that = (SalesChannel) o;
        return Objects.equals(onlineShop, that.onlineShop) && Objects.equals(physicalStore, that.physicalStore) && Objects.equals(promotion, that.promotion);
    }

    @Override
    public int hashCode() {
        return Objects.hash(onlineShop, physicalStore, promotion);
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
