import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static int N=0, M=0;
	public static ArrayList<Integer> arr=new ArrayList<Integer>();
	public static int[] visit;
	public static int[] num;
	public static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void DP(int l,int a) throws IOException {
		if(l==M) {
			for(int i=0; i<arr.size(); i++) {
				bw.write(arr.get(i)+" ");
			}
			bw.write("\n");
			bw.flush();
			return;
		}
		for(int i=0; i<N; i++) {
			if(a<=num[i]) {
			arr.add(num[i]);
			DP(l+1,num[i]);
			
			arr.remove(arr.size()-1);
			}
		}
	}
	public static void main(String[] args) throws IOException {
		Scanner sc=new Scanner(System.in);
		N=sc.nextInt(); M=sc.nextInt();
		visit=new int[N+1];
		num=new int[N];
		for(int i=0; i<N; i++) {
			num[i]=sc.nextInt();
		}
		Arrays.sort(num);

		DP(0,0);

	}

}
