import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
        int[] nums = new int[N];
        int[] upNums = new int[N+1];
        int[] downNums = new int[N+1];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
            downNums[i]=upNums[i] =1;
        }


        // 중간까지 증가하는 수열
        for(int i=0; i<N; i++) {
            for(int j=i+1; j<N; j++) {
                if(nums[i] < nums[j]){
                    if(upNums[j] < upNums[i]+1) {
                        upNums[j] = upNums[i] +1;
                    }
                }
            }
        }
		
        // 중간까지 감소하는 수열
        for(int i=N-1; i>=0; i--) {
            for(int j=i-1; j>=0; j--) {
                if(nums[i] < nums[j]){
                    if(downNums[j] < downNums[i]+1) {
                        downNums[j] = downNums[i] +1;
                    }
                }
            }
        }

        int max = 0;
        for(int i=0; i<N; i++) {
            max = Math.max(max, upNums[i]+downNums[i]-1);
        }
        System.out.println(max);
	}

}