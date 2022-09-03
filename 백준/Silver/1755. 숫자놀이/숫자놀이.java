import java.util.*;
import java.io.*;
class Num implements Comparable<Num>{
	int n; String name;
	public Num(int n, String name) {
		this.n=n; this.name=name;
	}
	@Override
	public int compareTo(Num o) {
		return name.compareTo(o.name);
	}
	
	
}
public class Main {

	public static String[] dict= {"zero", "one", "two", "three", "four", "five", "six","seven","eight","nine"};
	public static int[] num=new int[1000];
	public static ArrayList<Num> numdict=new ArrayList<Num>();
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String t=br.readLine();
		StringTokenizer st=new StringTokenizer(t);
		int a=Integer.parseInt(st.nextToken());
		int b=Integer.parseInt(st.nextToken());
		num=new int[b-a+1];
		int ind=0;
		for(int i=a; i<=b; i++) {
			num[ind]=i;
			if(i>9) {
				int tt=i/10;
				int rr=i%10;
				numdict.add(new Num(i,dict[tt]+" "+dict[rr]));
			}
			else {
				numdict.add(new Num(i,dict[i]));
			}
			ind++;
		}
		Collections.sort(numdict);
		int count=1;
		for(int i=0; i<numdict.size(); i++) {
			if(count==10) {System.out.println(numdict.get(i).n); count=1;}
			else {System.out.print(numdict.get(i).n+" "); count++;}
		}

	}

}
