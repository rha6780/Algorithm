import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
public class Main {
	public static Scanner sc=new Scanner(System.in);
	public static int N=sc.nextInt();
	public static char[][] apart=new char[N][N];
	public static boolean[][] visit=new boolean[N][N];
	public static int[] count=new int[314];
	public static int uu=0, T=0;
	public static Queue<Integer> quei=new LinkedList<Integer>();
	public static Queue<Integer> quej=new LinkedList<Integer>();
	
	public static void counting(int ii, int jj) {
		visit[ii][jj]=true;
		quei.add(ii);
		quej.add(jj); count[uu]++;
		while(!quei.isEmpty()&&!quej.isEmpty()) {
			int i=quei.poll();
			int j=quej.poll();
		if(i+1<N &&visit[i+1][j]==false&&apart[i+1][j]=='1') {count[uu]++; quei.add(i+1); quej.add(j); visit[i+1][j]=true;}
		if(i-1>=0 &&visit[i-1][j]==false&&apart[i-1][j]=='1') {count[uu]++; quei.add(i-1); quej.add(j);visit[i-1][j]=true;}
		if(j+1<N &&visit[i][j+1]==false&&apart[i][j+1]=='1') {count[uu]++; quei.add(i); quej.add(j+1);visit[i][j+1]=true;}
		if(j-1>=0 &&visit[i][j-1]==false&&apart[i][j-1]=='1') {count[uu]++; quei.add(i); quej.add(j-1);visit[i][j-1]=true;}
		}
		uu++; T++;
	}
	public static void main(String[] args) {
		
		for(int i=0; i<N; i++) {
			String st=sc.next();
			apart[i]=st.toCharArray();
		}
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(apart[i][j]=='0')visit[i][j]=true;
				else if(visit[i][j]!=true) {
					counting(i,j);
				}
			}
		}
		Arrays.sort(count);
		System.out.println(T);
		for(int h=314-T; h<314; h++) {
			System.out.println(count[h]);
		}

	}

}