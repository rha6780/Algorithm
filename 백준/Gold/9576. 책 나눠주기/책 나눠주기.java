import java.util.*;
public class Main {

	public static ArrayList<ArrayList<Integer>> mapping;
	public static int ans;
	public static int[]Mmatching;
	public static boolean[]visited;
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int T=sc.nextInt();
		for(int u=0; u<T; u++){
			int M=sc.nextInt(); //책의 최대 갯수
			int N=sc.nextInt(); // 사람수
			
		
		mapping=new ArrayList<ArrayList<Integer>>();
		for(int i=0; i<=N+1; i++){mapping.add(new ArrayList<Integer>());}
		for(int i=1; i<=N; i++){
			int a=sc.nextInt(); int b=sc.nextInt();
			for(int h=a; h<=b; h++){
				mapping.get(i).add(h);
			}
		}
		ans=0;
		Mmatching=new int[M+2];
		visited=new boolean[N+2];
		for(int i=1; i<=N; i++){
			Arrays.fill(visited, false);
			if(matching(i))ans++;
		}
		System.out.println(ans);
		
		}
		sc.close();
	}
	public static boolean matching(int i){
		visited[i]=true;
		for(int k=0; k<mapping.get(i).size(); k++){
			int j=mapping.get(i).get(k);//j: i가 읽을 책 
			if(Mmatching[j]==0||(!visited[Mmatching[j]]&&matching(Mmatching[j]))){
				Mmatching[j]=i;
				return true;
			}
		}
		return false;
	}

}
