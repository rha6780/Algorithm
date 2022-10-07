import java.util.ArrayList;
import java.util.Scanner;
public class Main {

	public static ArrayList<ArrayList<Integer>> tr=new ArrayList <ArrayList<Integer>>();
	public static Scanner sc=new Scanner(System.in);
	public static	int N=sc.nextInt();
	public static	int count=0;
	public static int root=0;
	public static int delete=0;
	
	public static void ff(int t) {
		mm(t);
		if(tr.get(t).size()!=0&&t!=delete)
		for(int i=0; i<tr.get(t).size(); i++) {
			ff(tr.get(t).get(i)); 
		}
	}
	public static void mm(int i) {
		if(i==delete) {return;}
		if((tr.get(i).contains(delete)==true)&&tr.get(i).size()==1) {count++; return;}
		if(tr.get(i).size()==0) {count++; return;}
		return;
	}
		
	public static void main(String[] args) {
		
		for(int j=0; j<N; j++) {tr.add(new ArrayList<Integer>());}
		for(int i=0; i<N; i++) {
			int g=sc.nextInt();
			if(g>=0) {
			tr.get(g).add(i);
			}
			else {
				root=i;
			}
		}
		delete=sc.nextInt();
		if(delete==root) {
			count=0;
		}
		else {ff(root);}
		System.out.println(count);
		}
}
