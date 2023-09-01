import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] nums = new int[N];

        for(int i=0; i<N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }
		
        int cnt=1;
		int[] LIS = new int[N+1];
        int[] result = new int[N];
        
        
		LIS[0]=nums[0];
        
		for(int i=0; i<N; i++) {
			if(LIS[cnt-1]<nums[i]) { //증가하는 경우
				LIS[cnt] = nums[i];
                result[i] = cnt;
				cnt++;
			}
			else { // 이전 보다 작은 경우 들어갈 수 있는 값을 찾는다.
				int l = 0;
				int r = cnt;
				while(l<=r) {
					int mid = (l+r)/2;
					if(LIS[mid]<nums[i]) {
						l = mid+1;
					}
					else {
						r = mid-1;
					}
				}
				
				LIS[l] = nums[i];
                result[i] = l;
			}
		}

        
        System.out.println(cnt);
        int[] answer = new int[cnt];
        for(int i=N-1; i>=0; i--) {
            if(result[i] == cnt-1) {
                answer[cnt-1] = nums[i];
                cnt--;
            }
        }
        for(int i: answer) {
            sb.append(i + " ");
        }

        System.out.println(sb);
	}

}