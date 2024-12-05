
import java.io.BufferedReader;
import java.util.ArrayList;
import java.io.FileReader;
import java.io.IOException;

public class day_2 {

    public static ArrayList<int[]> list = new ArrayList<>();


    public static void read_file(String file) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(file));

        String line = reader.readLine();
        while(line != null) {
            String[] output = line.split("\s");
            
        }

        reader.close();
    }


    public static boolean row_increasing(int[] arr) {
        return arr[0] - arr[1] < 0;
    }


    public static int get_solution() {
        int counter = 0;
        for( int [] arr : list ) {
            if(row_increasing(arr) == true) {
                // arr.length - 2 ??
                for(int i = 0; i < arr.length - 2; i++) {
                   if(arr[i] - arr[i+1] > 0 && arr[i] - arr[i+1] < -3) {
                       break;
                   }
                }
                counter = counter + 1;
            } else {
                for(int i = 0; i < arr.length - 2; i++) {
                   if(arr[i] - arr[i+1] < 0 && arr[i] - arr[i+1] > -3) {
                        break;
                   }
                }
                counter = counter + 1;
            }
        }
        return counter;
    }


    public static void main(String[] args) throws IOException {
        System.out.println("hello");
        read_file("input.txt");
    }
}
