import java.util.ArrayList;
import java.util.Scanner;
public class Main {
	public static Scanner sc=new Scanner (System.in);
	public static int N=sc.nextInt();
	public static int[][] line=new int[N][4];
	public static ArrayList<ArrayList<Integer>> gr=new ArrayList<ArrayList<Integer>>();
	public static int[] group=new int[N];
	public static int gg=N;
	
	public static int Find(int a) {
		if(a==group[a]) {
			return a;
		}
		else {
			return group[a]=Find(group[a]);
		}
	}
	public static void Union(int a, int b) {
		a=Find(a); b=Find(b);// 각각의 루트로 연산
		
		if(a!=b) {
			gg--;
			for(int j=0; j<gr.get(b).size(); j++) {
				gr.get(a).add(gr.get(b).get(j));
				group[gr.get(b).get(j)]=a;
			}
			gr.get(b).clear();
		
		}
	}
	public static int Area(int x1, int y1, int x2, int y2, int x3, int y3 ) {
		long sum=0;
		sum=((x1*y2)-(x2*y1)+(x2*y3)-(x3*y2)+(x3*y1)-(x1*y3));
		if(sum>0) return 1;
		else if(sum==0) return 0;
		else return -1;
	}
	
	public static void isconnect(int x1, int y1, int x2, int y2, int x3, int y3, int x4, int y4, int i, int j) {
		int a1=Area(x1, y1, x2, y2, x3, y3), a2=Area(x1, y1, x2, y2, x4, y4);
		int b1=Area(x3, y3, x4, y4, x1, y1), b2=Area(x3, y3, x4, y4, x2, y2);
		if(a1*a2==0&&b1*b2==0){
			if(Math.max(x1, x2)<Math.min(x3, x4)) {return;}
			if(Math.max(x3, x4)<Math.min(x1, x2)) {return;}
			if(Math.max(y1, y2)<Math.min(y3, y4)) {return;}
			if(Math.max(y3, y4)<Math.min(y1, y2)) {return;}
			else {Union(i, j);}
		}
		else if(a1*a2<=0&&b1*b2<=0) {
			 Union(i, j);
		}
	}
	
	public static void main(String[] args) {
		
		for(int i=0; i<N; i++) {
			gr.add(new ArrayList<Integer>());
			gr.get(i).add(i);
			line[i][0]=sc.nextInt();
			line[i][1]=sc.nextInt();
			line[i][2]=sc.nextInt();
			line[i][3]=sc.nextInt();
			group[i]=i; 
		}
		for(int i=0; i<N; i++) {
			for(int j=i+1; j<N; j++) {
				int x1=line[i][0], y1=line[i][1], x2=line[i][2], y2=line[i][3];
				int xx1=line[j][0], yy1=line[j][1], xx2=line[j][2], yy2=line[j][3];
				isconnect(x1, y1, x2, y2, xx1, yy1, xx2, yy2, i, j);
			}
		}
		
		int Max=0;
		for(int i=0; i<N; i++) {
			
			if(Max<=gr.get(i).size()) {Max=gr.get(i).size();}
		}
		System.out.println(gg);
		System.out.println(Max);
	}
}