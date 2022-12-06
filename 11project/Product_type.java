import java.text.DecimalFormat;

// The "Product_type" class defines product types. Besides the "get" and "set" methods,  
// it also has a "calculate_total_sales" method to calculated of total sales volume.

public class Product_type {

    DecimalFormat df = new DecimalFormat("0.00");
    private String name;
    private Double online, physical, promotion;


    public Product_type(String name, double o, double phy, double promo) {
        this.online = 0.0;
        this.physical = 0.0;
        this.promotion = 0.0;
    }


    public void set_name(String pname){
        this.name = pname;
    }


    public void set_online_sales(String o){
        this.online = Double.parseDouble(o);
    }


    public void set_physical_sales(String phy){
        this.physical = Double.parseDouble(phy);
    }


    public void set_promotion_sales(String promo){
        this.promotion = Double.parseDouble(promo);
    }


    public String get_product_name(){
        return this.name;
    }


    public String get_online_sales(){
        return String.valueOf(df.format(this.online));
    }


    public String get_physical_sales(){
        return String.valueOf(df.format(this.physical));
    }


    public String get_promotion_sales(){
        return String.valueOf(df.format(this.promotion));
    }


    public String calculate_total_sales(){
        return String.valueOf(df.format(this.online + this.physical + this.promotion));
    }


    public void add_online_sales(String o){
        this.online = Double.parseDouble(o) + this.online;
    }


    public void add_physical_sales(String phy){
        this.physical = Double.parseDouble(phy) + this.physical;
    }


    public void add_promotion_sales(String promo){
        this.promotion = Double.parseDouble(promo) + this.promotion;
    }


}