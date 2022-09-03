import java.util.*;
public class Main {

	public static int[] par=new int[100001];
	public static int[] plain=new int[100001];
	public static int count=0;
	public static int find(int x) {
		if(par[x]==x) {return x;}
		else return par[x]=find(par[x]);
	}
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int G=sc.nextInt();
		int P=sc.nextInt();
		
		for(int j=0; j<=G; j++)par[j]=j;
		for(int i=0; i<P; i++) {
			plain[i]=sc.nextInt();
		}
		
		for(int i=0; i<P; i++) {
			int temp=find(plain[i]);
			if(temp==0) {break;}
			else {
				par[find(temp)]=find(temp-1);
				count++;
			}
		}
		System.out.println(count);
	}

}
