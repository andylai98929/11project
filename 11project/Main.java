import java.io.*;
import java.util.Scanner;
import java.text.DecimalFormat;
// import java.util.Formatter;

public class Main{
    
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        System.out.println("Please input file location.  Example: C:\\Users\\haha\\Desktop\\jj.csv");
        String file_location = sc.nextLine(); 
        File file_path = new File(file_location);
        sc.close();

        DecimalFormat df = new DecimalFormat("0.00");
        Double online_total = 0.0;
        Double physical_total = 0.0;
        Double promotion_total = 0.0;
        
        // Imports .csv files as arrays.
        Sales_data_parser dp = new Sales_data_parser();
        String[][] raw_data = dp.parse_data(file_path);
        
        // Extract an array with required columns only from the previous "raw" array.
        Sales_data_extractor de = new Sales_data_extractor();
        String[][] cleaned_data = de.clean_data(raw_data);
        // Get an array with unique prodecut types.
        String[] product_types_arr = de.populate_product_type_set(cleaned_data);


        System.out.printf("%30.30s", cleaned_data[0][0]);

        for (int i = 1; i<cleaned_data[0].length;i++) {
            System.out.printf("%15.15s", cleaned_data[0][i]);
        }
        System.out.printf("%15.15s", "Total");

        System.out.println();

        // Loop through the unique product type array to generate Product_type object,
        // then use "get" methods of Product_type object to construct output lines.
        for(int pt_num = 0; pt_num < product_types_arr.length; pt_num++){
            Product_type pt = new Product_type("Rockets", 0.0, 0.0, 0.0);
            String pn = product_types_arr[pt_num];
            // For each unique product type, loop through the rows of the imported data.
            for(int row = 1; row < cleaned_data.length-1 ; row++){
                String curr_r_pn = cleaned_data[row][0];
                // Check if the product type of the current row (Line 21) matches the current unique product type (Line 23).
                if(pn.equals(curr_r_pn)){
                    for(int column = 0; column < cleaned_data[row].length; column++){
                        switch (column) {
                            case 0:
                                pt.set_name(cleaned_data[row][column]);
                            break;
                            case 1:
                                pt.add_online_sales(cleaned_data[row][column]);
                            break;
                            case 2:
                                pt.add_physical_sales(cleaned_data[row][column]);
                            break;
                            case 3:
                                pt.add_promotion_sales(cleaned_data[row][column]);
                            break;
                        }
                    }
                }
            }
            //  Cumulate the sales by sales type. 
            online_total = online_total + Double.parseDouble(pt.get_online_sales());
            physical_total = online_total + Double.parseDouble(pt.get_physical_sales());
            promotion_total = online_total + Double.parseDouble(pt.get_promotion_sales());

            System.out.printf("%15.15s %15.15s %15.15s %15.15s %15.15s", pt.get_product_name(), pt.get_online_sales(), pt.get_physical_sales(), pt.get_promotion_sales(), pt.calculate_total_sales());
            System.out.println();
        }
        System.out.printf("%15.15s %15.15s %15.15s %15.15s %15.15s", " ", df.format(online_total), df.format(physical_total), df.format(promotion_total), " ");
    }


    public static void print_arr(String[][] test_arr){
        for(int i=0;i<test_arr.length;i++){
            for(int j=0;j<test_arr[i].length;j++){
                System.out.print(test_arr[i][j]);
                System.out.print("  ");
            }
            System.out.println();
        }
    }


}