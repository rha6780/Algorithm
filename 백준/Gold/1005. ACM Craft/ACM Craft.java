import java.util.*;
public class Main {
	
	public static boolean[] visit=new boolean[2020];
	public static int[] time=new int[2020];
	public static int[] step=new int[2020];
	public static int[] siz=new int[2020];
	public static ArrayList<ArrayList<Integer>> arr=new ArrayList<ArrayList<Integer>>();
	public static int result=0;
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int T=sc.nextInt();
		for(int i=0; i<T; i++){
			int N=sc.nextInt(); int K=sc.nextInt();
			visit=new boolean[N+1];
			time=new int[N+1];
			siz=new int[N+1];
			step=new int[N+1];
			arr=new ArrayList<ArrayList<Integer>>();
			arr.add(new ArrayList<Integer>());
			for(int j=1; j<=N; j++){
				time[j]=sc.nextInt();
				arr.add(new ArrayList<Integer>());
			}
			for(int j=0; j<K; j++){
				int a=sc.nextInt();
				int b=sc.nextInt();
				arr.get(a).add(b); siz[b]++;
			}
			int W=sc.nextInt();
			Queue<Integer> que=new LinkedList<Integer>();
			for(int h=1; h<=N; h++){if(siz[h]==0){que.add(h);step[h]=time[h];}}
			while(!que.isEmpty()){
				int t=que.remove();
				for(int k=0; k<arr.get(t).size(); k++){
					int l=arr.get(t).get(k); siz[l]--;
					if(step[l]<step[t]){step[l]=step[t];}
					if(siz[l]==0){que.add(l);step[l]=step[l]+time[l];
					//System.out.println(l+" "+t+" "+step[l]);
					}
				}
			}
			System.out.println(step[W]);
			
		}
		
		
	}

}
