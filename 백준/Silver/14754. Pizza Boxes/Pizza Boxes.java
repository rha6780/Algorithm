import java.util.*;
import java.io.*;
import java.math.BigInteger;

public class Main {

	static String[][] boxs = new String[1002][1002];
	static int[][] check = new int [1002][1002];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		BigInteger sum = BigInteger.ZERO;
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		for(int i=0; i<n ;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<m; j++) {
				boxs[i][j] = st.nextToken();
				BigInteger a = new BigInteger(boxs[i][j]);
				sum = sum.add(a);
			}
		}
		
		//System.out.println(sum);
		
		for(int i=0; i<n; i++) {
			int max = -1; int x=0; int y=0;
			for(int j=0; j<m; j++) {
				int num = Integer.parseInt(boxs[i][j]);
				if(max < num) {
					max = num;
					x=i; y=j;
				}
			}
			check[x][y] = 1;
		}
		
		for(int i=0; i<m; i++) {
			int max = -1; int x=0; int y=0;
			for(int j=0; j<n; j++) {
				int num = Integer.parseInt(boxs[j][i]);
				if(max < num) {
					max = num;
					x=i; y=j;
				}
			}
			check[y][x] = 1;
		}
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<m ;j++) {
				if(check[i][j]==1) {
					BigInteger a = new BigInteger(boxs[i][j]);
					sum = sum.add(a.negate());
				}
			}
		}
		
		System.out.println(sum);
	}

}
