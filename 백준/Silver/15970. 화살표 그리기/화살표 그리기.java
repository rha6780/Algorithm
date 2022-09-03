import java.util.Scanner;
import java.util.Arrays;

class ArrowLoc implements Comparable<ArrowLoc>{
	int loc, col;
	ArrowLoc(int a,int b){
		loc=a; col=b;
	}

	public int compareTo(ArrowLoc p) {
		int res=0;
		res=this.col- p.col;
		if(res==0) {
			
			return (this.loc-p.loc);
		}
		else return res;
	}
}

public class Main{
	static int N;
	static ArrowLoc[] al;
	public static void showAll() {
		for(int i=0; i<N; i++) 
			System.out.println(al[i].loc+" "+al[i].col);
		
	}
	
	public static void addshort(ArrowLoc[] a) {
		int y=0, hap=0;
		if(a[0].col==a[1].col) hap+=a[1].loc-a[0].loc;
		for(int j=1; j<N-1;j++) {
			
			if((a[j].col==a[j+1].col)&&(a[j].col==a[j-1].col)) {
				if((a[j+1].loc-a[j].loc)<(a[j].loc-a[j-1].loc))
					y=a[j+1].loc-a[j].loc;
				else y=a[j].loc-a[j-1].loc;}
			else if((a[j].col==a[j+1].col)&&(a[j].col!=a[j-1].col)) {
				y=(a[j+1].loc-a[j].loc);
			}
			else if((a[j].col!=a[j+1].col)&&(a[j].col==a[j-1].col)) {
				y=a[j].loc-a[j-1].loc;}
			
			hap+=y;
			}
		if(a[N-1].col==a[N-2].col) hap+=(a[N-1].loc-a[N-2].loc);
		System.out.print(hap);
	}
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		N=sc.nextInt();
		al=new ArrowLoc[N];
		for(int j=0; j<N; j++) {
			int t1=sc.nextInt();
			int t2=sc.nextInt();
			al[j]=new ArrowLoc(t1,t2);
		}
	sc.close();
	Arrays.sort(al);
	addshort(al);
	

	}

}