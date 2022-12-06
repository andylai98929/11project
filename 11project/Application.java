import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Application {
    public static void main(String[] args) {
        Comparator<Product> productRevenuComparator = new Comparator<Product>() {
            @Override
            public int compare(Product o1, Product o2) {
                if(o1.getRevenue()<o2.getRevenue()){
                    return -1;
                } else if (o1.getRevenue()>o2.getRevenue()) {
                    return 1;
                }else {
                    return 0;
                }
            }
        };
        ArrayList<Product> arrayList = new ArrayList<>();
        Collections.sort(arrayList,productRevenuComparator);
    }


}
