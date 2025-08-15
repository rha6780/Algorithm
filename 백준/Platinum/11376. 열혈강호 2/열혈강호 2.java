import java.util.ArrayList;
import java.util.Scanner;
public class Main {
	public static Scanner sc=new Scanner(System.in);
	public static int N=sc.nextInt();
	public static int M=sc.nextInt();
	public static int[] todo=new int[2002];
	public static boolean[] visit=new boolean[2002];
	public static ArrayList<ArrayList<Integer>> go=new ArrayList<ArrayList<Integer>>();
		
	public static boolean DFS(int x){
		for(int i=0; i<go.get(x).size(); i++){
		int t=go.get(x).get(i);
		if(visit[t]) continue;
		visit[t]=true;
		if(todo[t]==0||DFS(todo[t])){todo[t]=x; return true;}
		}
		return false;
	}
	
	public static void main(String[] args) {
		for(int i=0; i<=N*2+1; i++){
			go.add(new ArrayList<Integer>());
		}
		for(int i=1; i<=N*2; i+=2){
			int a=sc.nextInt();
			for(int j=0; j<a; j++){
				int b=sc.nextInt();
				go.get(i).add(b);
				go.get(i+1).add(b);
				}
		}
		int count=0;
		
		for(int y=0; y<=N*2+1; y++){
			visit=new boolean[2002];
			if(DFS(y)){count++;}
		}
		System.out.println(count);
	}

}