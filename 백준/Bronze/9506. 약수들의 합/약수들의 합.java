import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = "";
        while(true) {
            input = br.readLine();
            if (input.equals("-1")) { break; }
            int number = Integer.parseInt(input);
            ArrayList<Integer> nums = new ArrayList<>();

            int sum = 1;
            nums.add(1);
            for (int i=2; i<=Math.sqrt(number); i++) {
               if(number % i == 0) {
                   int rest = number/i;
                   sum += i;
                   nums.add(i);
                   if(i != rest) {
                       sum += (rest);
                       nums.add(rest);
                   }
               }
            }
            Collections.sort(nums);
            if(sum == number) {
                StringBuilder result = new StringBuilder(number + " =");
                for (int i = 0; i<nums.size(); i++)  {
                    int sub = nums.get(i);
                    result.append(" ").append(sub).append(" ");
                    if (i != nums.size()-1) { result.append("+"); }
                }
                System.out.println(result);
            } else {
                System.out.println(number + " is NOT perfect.");
            }
        }
    }
}