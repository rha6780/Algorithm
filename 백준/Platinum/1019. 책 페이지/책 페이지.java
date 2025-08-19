import java.io.*;
import java.util.*;

public class Main {

	public static int N, result;


	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		int [] result = new int[10];

		int ten = 10;
		int combo = 0;
		// i는 1부터, 10, 100 순서로 각 자리수와 같이 증가한다.
		for (int i=1; N!=0; i*=10) {
			// 나머지 값
			int rest = N%10;

			// 다음 자리수로 전환(몫)
			N /= 10;

			result[0] -= i;
			// 나머지 값을 기준으로 작은 경우, 몫의 개수 와 자리 카운트가 추가적으로 증가함.
			for (int j=0; j<rest; j++) {
				result[j] += (N+1)*i; 
			}
			result[rest] += (N*i) + 1 + combo;

			// 큰 경우, 추가적인 부분없이 앞자리 그대로 카운트 됨.
			for (int j=rest+1; j<=9; j++) {
				result[j] += (N*i);
			}
			combo += rest*i;
		}

		for (int i=0; i<10; i++) {
			System.out.print(result[i] + " ");
		}
	}

}
