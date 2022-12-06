import java.io.*;
import java.util.Scanner;

// The "Sales_data_parser" class imports .csv files to Java as 2D arrays without modifications of the data.  

public class Sales_data_parser {

    public Sales_data_parser() {

    }

    public int row_counter(File path){
        try(Scanner sc = new Scanner(path)){
            int row_counter = 0;
            while(sc.hasNextLine()){
                String a = sc.nextLine(); //infinite loop if the next line is not consumed
                row_counter++;
            }
            sc.close();
            return row_counter;
        }catch(FileNotFoundException e){
            System.out.println(e);
            return 0;
        }
    }

    public String[][] parse_data(File path){
        int num_of_row = row_counter(path);
        try(Scanner sc = new Scanner(path)){
            sc.useDelimiter("\n");
            String[][] raw_data = new String[num_of_row][6];
            for(int row = 0; row < num_of_row && sc.hasNext(); row++){
                String[] line = sc.nextLine().split(",");
                for(int column = 0; column < 6; column++){
                    String a = line[column];
                    raw_data[row][column] = a;
                    }
                }
            return raw_data;
        }catch(FileNotFoundException e){
            System.out.println(e);
            return null;
        }
    }
    
}
