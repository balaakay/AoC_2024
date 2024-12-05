import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.io.FileReader;
import java.io.IOException;


public class Main{
    

    public static ArrayList<Integer> list0 = new ArrayList<>();
    public static ArrayList<Integer> list1 = new ArrayList<>();
    public static HashMap<Integer, Integer> dict = new HashMap<>();

    public static int find_difference() {
        int difference_sum = 0;

        for(int i = 0; i < list0.size(); i++) {
            int current_diff = Math.abs(list0.get(i) - list1.get(i));

            difference_sum = difference_sum + current_diff;
        }
        return difference_sum;
    }



    public static void read_file(String file) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));

            String line = reader.readLine();
            while(line != null) {
                String[] output = line.split("\s{3}");
                int place0 = Integer.parseInt(output[0]);
                int place1 = Integer.parseInt(output[1]);

                list0.add(place0);
                list1.add(place1);

                if(dict.containsKey(place1)) {
                    int current_value = dict.get(place1);
                    dict.replace(place1,current_value + 1);
                } else {
                    dict.put(place1, 1);
                }

                line = reader.readLine();
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return;
    }



    public static int walk_arraylist() {
        int solution = 0;
        for(int i = 0; i < list0.size(); i++) {
            if(dict.containsKey(list0.get(i))) {
                solution = solution + (list0.get(i) * dict.get(list0.get(i)));
            }
        }
        return solution;
    }


    public static void main(String[] args) throws IOException {
        read_file("input.txt");
        // Needed to solve part 1
        list0.sort(null);
        list1.sort(null);
        //System.out.println(find_difference());

        // Needed to solve part 2
        System.out.println(walk_arraylist());
    }
}
