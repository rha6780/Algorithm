import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.*;
public class Main {

	public static int N=0, M=0;
	public static ArrayList<Integer> arr=new ArrayList<Integer>();
	public static int[] visit;
	public static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void DP(int l, int a) throws IOException {
		if(l==M) {
			for(int i=0; i<arr.size(); i++) {
				bw.write(arr.get(i)+" ");
			}
			bw.write("\n");
			bw.flush();
			return;
		}
		
		for(int i=1; i<=N; i++) {
			if(i>=a) {
			arr.add(i);
			DP(l+1,i);
			arr.remove(arr.size()-1);}
		}
	}
	public static void main(String[] args) throws IOException {
		Scanner sc=new Scanner(System.in);
		N=sc.nextInt(); M=sc.nextInt();
		visit=new int[N+1];
		DP(0,0);

	}

}
