import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

//  This class contains methods to extracts useful data from the raw imported arrays.

public class Sales_data_extractor {

    public Sales_data_extractor() {
    }
    

    //  Cleans raw data arrays and returns an array with required columns only.
    public String[][] clean_data(String[][] raw_data){
        int product_name_index= -1000;
        int unit_price_index=-1000;

        String product_name = "Product Name";
        String unit_price = "Unit Price";

        for (int row=0; row < 1; row++){
            for (int column=0; column < raw_data[0].length; column++){
                if (raw_data[0][column].equals(product_name)){
                    product_name_index = column;
                }if (raw_data[0][column].equals(unit_price)) {
                    unit_price_index=column;
                }
            }
        }

        int number_of_columns = raw_data[0].length;
        int number_of_rows = raw_data.length;
        ArrayList<ArrayList<String>> resultList = new ArrayList<ArrayList<String>>();

        for (int i=0; i<number_of_rows;i++){
            resultList.add(new ArrayList<String>());
            for (int j=0; j<number_of_columns;j++){
                
                if (j!=unit_price_index&&j!=product_name_index){
                    resultList.get(i).add(raw_data[i][j]);
                }
            }
        }
        String[][] resultArray = resultList.stream().map(u -> u.toArray(new String[0])).toArray(String[][]::new);
        return resultArray;
    }
        // String[][] clean_data = new String[raw_data.length-1][4];
    
        // for(int row = 0, curr_row = 0; row < raw_data.length; row++){
        //     if(row != 0){
        //         for(int column = 0, curr_column = 0; column < raw_data[row].length; column++){
        //             if(column != 1 && column != 2){
        //                 clean_data[curr_row][curr_column] = raw_data[row][column];
        //                 curr_column++;
        //             }
        //         }
        //         curr_row++;
        //     }
        // }
        // return clean_data;
    



    //  This method loop through arrays and returns an array of unique product types. 
    public String[] populate_product_type_set(String[][] clean_data){
        HashSet<String> product_types_set = new HashSet<String>();
        for(int row = 1; row<clean_data.length; row++){
            String product_type = clean_data[row][0];
            if(product_types_set.contains(product_type)){
            }else{
                product_types_set.add(product_type);
            }
        }
        String[] product_types_arr = product_types_set.toArray(new String[product_types_set.size()]);
        return product_types_arr;
    }
}