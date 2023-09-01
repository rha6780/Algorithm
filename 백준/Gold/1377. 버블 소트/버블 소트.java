import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Num implements Comparable<Num>{
    int value;
    int index;

    Num(int value, int index) {
        this.value = value;
        this.index = index;
    }

    @Override
    public int compareTo(Num o) {
        return value - o.value;
    }

}

public class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        Num[] nums = new Num[N];
        
        int max = 0;

        for (int i = 0; i < N; i++) {
            int tmp = Integer.parseInt(br.readLine());
            nums[i] = new Num(tmp, i);
        }
        Arrays.sort(nums);

        for(int i=0; i<N; i++) {
            max = Math.max(max, nums[i].index - i);
        }
        
        System.out.println(max+1);
	}
}
