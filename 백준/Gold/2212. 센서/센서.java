import java.util.*;
import java.io.*;
class range implements Comparable<range>{
	int si, ei, len;
	public range(int si, int ei, int len){
		this.si=si; this.ei=ei; this.len=len;
	}
	@Override
	public int compareTo(range o) {
		return o.len-this.len;
	}
}
public class Main {

	public static int[] sen=new int[10001];
	public static ArrayList<range> arr=new ArrayList<range>();
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(br.readLine());
		sen=new int[N];
		int K=Integer.parseInt(br.readLine());
		String t=br.readLine();
		StringTokenizer st=new StringTokenizer(t);
		int max=0; int min=1000000;
		for(int i=0; i<N; i++){
			sen[i]=Integer.parseInt(st.nextToken());
			if(max<sen[i]){max=sen[i];}
			if(min>sen[i]){min=sen[i];}
		}
		Arrays.sort(sen);
		for(int i=0; i<N-1; i++){
			int l=sen[i+1]-sen[i];
			arr.add(new range(i, i+1, l));
		}
		Collections.sort(arr);
		
		int sum=max-min;
		if(K<=N){
		for(int i=0; i<K-1; i++){
			sum-=arr.get(i).len;
		}}
		else{
			sum=0;
		}
		System.out.println(sum);
	}

}
